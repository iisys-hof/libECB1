package de.iisys.smartgrids.libecb1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.function.BiConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Base class for eCB1 communication.<br>
 * <br>
 * Connects to an eCB1 API via it's given {@link ECB1Config} and offers methods
 * for API method invocation.<br>
 * Works with JSON per default, but can be changed to XML by overriding
 * {@link #prepare(ECB1Api)} method.<br>
 * <br>
 * The implementing class is supposed to offer methods calling the
 * {@link #get(ECB1Api)}, {@link #post(ECB1Api)}, {@link #put(ECB1Api)} and
 * {@link #delete(ECB1Api)} methods in this class for calling the eCB1 API.<br>
 * <br>
 * All Entities are obliged to implement the {@link ECB1Api} interface for
 * working with this base implementation.<br>
 * <br>
 * Makes heavy use of <a href="https://jersey.java.net/">Jersey</a>, so look for
 * <a href="https://jersey.java.net/documentation/latest/">latest Jersey
 * documentation</a> when something is not clear.
  */
public abstract class ECB1 {

    /**
     * The current {@link ECB1Config} that was used for connecting to the API.
     */
    private ECB1Config eCB1config;

    /**
     * Creates an {@link ECB1} object by connecting to a given
     * {@link ECB1Config}.
     *
     * @param eCB1config the eCB1 to connect to
     */
    protected ECB1(ECB1Config eCB1config) {
        this.eCB1config = eCB1config;
        this.eCB1config.initialize();
    }

    /**
     * Prepares a request towards the eCB1 API connected to.<br>
     * For preparation, the {@link ECB1Api} entity representing the API call
     * needs to be given.<br>
     * Uses {@link MediaType#APPLICATION_JSON_TYPE} by default.
     *
     * @param eCB1api representing the API call to do
     * @return a prepared request for using any HTTP-method on it
     * @throws URISyntaxException if the prepared URL to the API call is invalid
     */
    protected Builder prepare(ECB1Api eCB1api) throws URISyntaxException {
        return prepare(eCB1api, MediaType.APPLICATION_JSON_TYPE);
    }

    /**
     * Prepares a request towards the eCB1 API connected to.<br>
     * For preparation, the {@link ECB1Api} entity representing the API call and
     * the {@link MediaType} for the accepted response need to be given.
     *
     * @param eCB1api representing the API call to do
     * @param requestType the accepted response {@link MediaType}
     * @return a prepared request for using any HTTP-method on it
     * @throws URISyntaxException if the prepared URL to the API call is invalid
     */
    protected Builder prepare(ECB1Api eCB1api, MediaType requestType) throws URISyntaxException {
        return eCB1config.getClient()
                .target(queryParams(UriBuilder.fromPath(eCB1config.getPath())
                        .scheme(eCB1config.getScheme())
                        .userInfo(eCB1config.getUserInfo())
                        .host(eCB1config.getHost())
                        .port(eCB1config.getPort())
                        .path(fillPath(eCB1api)), eCB1api))
                .request(requestType);
    }

    /**
     * Injects {@link QueryParam} field values of the given {@link ECB1Api}
     * object into the given {@link UriBuilder}.
     *
     * @param uriBuilder to inject the {@link QueryParam} field values into
     * @param eCB1api the object to analyse
     * @return the uriBuilder given, but with injected {@link QueryParam} field
     * values.
     */
    protected UriBuilder queryParams(UriBuilder uriBuilder, ECB1Api eCB1api) {
        walkFields(eCB1api, QueryParam.class, (annotation, value) -> {
            if (value != null) {
                uriBuilder.queryParam(annotation.value(), value);
            }
        });

        return uriBuilder;
    }

    /**
     * Resolves {@link PathParam} templates with the field values of the given
     * {@link ECB1Api} object for the path defined there.
     *
     * @param eCB1api the object to analyse
     * @return a path with all template values resolved by their field values
     */
    protected String fillPath(ECB1Api eCB1api) {
        UriBuilder uriBuilder = UriBuilder.fromResource(eCB1api.getClass());

        walkFields(eCB1api, PathParam.class, (annotation, value) -> {
            if (value != null) {
                uriBuilder.resolveTemplate(annotation.value(), value);
            }
        });

        return uriBuilder.toTemplate();
    }

    /**
     * Creates an {@link Entity} defining a form that is filled by all
     * {@link FormParam} field values of the given {@link ECB1Api} object.
     *
     * @param eCB1api the object to analyse
     * @return the {@link Entity} defining the form
     */
    protected Entity createFormEntity(ECB1Api eCB1api) {
        MultivaluedMap<String, String> formMap = new MultivaluedHashMap<>();

        walkFields(eCB1api, FormParam.class, (annotation, value) -> {
            if (value != null) {
                formMap.add(annotation.value(), value.toString());
            }
        });

        return Entity.form(formMap);
    }

    /**
     * Use reflection to visit all declared fields of a given object while
     * searching for a given annotation T.<br>
     * Calls a given consumer for each field that has the given annotation T
     * present, with the concrete annotation and the value of the field.
     *
     * @param <T> the annotation type
     * @param object the object of which the fields shall be reflected
     * @param clazz the annotation class to search for field presence
     * @param consumer the consumer to call for each field found
     */
    protected <T extends Annotation> void walkFields(Object object, Class<? extends T> clazz, BiConsumer<T, Object> consumer) {
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(clazz)) {
                try {
                    T annotation = field.getAnnotation(clazz);
                    Object value = resolveValue(field, object);
                    consumer.accept(annotation, value);
                } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException ex) {
                    Logger.getLogger(ECB1.class.getName()).log(Level.SEVERE, "Could not walk field.", ex);
                }
            }
        }
    }

    /**
     * Returns the value of a given field for a given object and resolves
     * {@link XmlEnum} fields automatically.
     *
     * @param field to resolve
     * @param object to use during resolve process
     * @return the value of the field, as enum constant if {@link XmlEnum} is
     * present
     * @throws IllegalAccessException see {@link Field#get(Object)}
     * @throws IllegalArgumentException see {@link Field#get(Object)}
     * @throws NoSuchFieldException see {@link Class#getField(String)}
     * @throws SecurityException see {@link Class#getField(String)}
     */
    protected Object resolveValue(Field field, Object object) throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException, SecurityException {
        Object value = null;
        if (field.getType().isEnum() && field.getType().isAnnotationPresent(XmlEnum.class)) {
            for (Object enumConstant : field.getType().getEnumConstants()) {
                Field enumField = enumConstant.getClass().getField(enumConstant.toString());
                Object currentValue = field.get(object);
                if (currentValue != null && currentValue.equals(enumConstant) && enumField.isAnnotationPresent(XmlEnumValue.class)) {
                    value = enumField.getAnnotation(XmlEnumValue.class).value();
                    break;
                }
            }
        } else {
            value = field.get(object);
        }
        return value;
    }

    /**
     * Parses a given {@link Response} for a given {@link ECB1Api} template and
     * fills the information received with the response into the template object
     * and returns it.<br>
     * Returns {@code null} and outputs a {@link String} with the original
     * content if the {@link Response} is not of status
     * {@link Response.Status#OK}.<br>
     * Returns {@code null} if there was no {@link ECB1Api} template object
     * given.
     *
     * @param <A> the {@link ECB1Api} type
     * @param eCB1api the template object
     * @param response the response with the information to fill into the
     * template object
     * @return the object with the information filled, or {@code null} if not
     * possible
     */
    protected <A extends ECB1Api> A processResponse(A eCB1api, Response response) {
        if (!response.getStatusInfo().equals(Response.Status.OK)) {
            String result = response.readEntity(String.class);
            response.close();
            Logger.getLogger(ECB1.class.getName()).log(Level.SEVERE, "{0} -> {1}", new Object[]{response.getStatusInfo().getReasonPhrase(), result});
            return null;
        } else if (eCB1api != null) {
            A result = (A) response.readEntity(eCB1api.getClass());
            response.close();
            return result;
        } else {
            response.close();
            return null;
        }
    }

    /**
     * Perform a HTTP {@code GET} request with a given {@link ECB1Api} object
     * representing the API call to do.
     *
     * @param <A> the {@link ECB1Api} type
     * @param eCB1api the object representing the API call to do
     * @return an object of the same type as the given {@code eCB1api} object
     * with the response filled, or {@code null} if something went wrong
     */
    protected <A extends ECB1Api> A get(A eCB1api) {
        try {
            return processResponse(eCB1api, prepare(eCB1api).get());
        } catch (URISyntaxException ex) {
            Logger.getLogger(ECB1.class.getName()).log(Level.SEVERE, "Invalid GET URI.", ex);
        }

        return null;
    }

    /**
     * Perform a HTTP {@code POST} request with a given {@link ECB1Api} object
     * representing the API call to do, with given information to post.
     *
     * @param <A> the {@link ECB1Api} type
     * @param eCB1api the object representing the API call to do, with given
     * information to post
     * @return an object of the same type as the given {@code eCB1api} object
     * with the response filled, or {@code null} if something went wrong
     */
    protected <A extends ECB1Api> A post(A eCB1api) {
        try {
            return processResponse(eCB1api, prepare(eCB1api).post(createFormEntity(eCB1api)));
        } catch (URISyntaxException ex) {
            Logger.getLogger(ECB1.class.getName()).log(Level.SEVERE, "Invalid POST URI.", ex);
        }

        return null;
    }

    /**
     * Perform a HTTP {@code PUT} request with a given {@link ECB1Api} object
     * representing the API call to do, with given information to put.
     *
     * @param <A> the {@link ECB1Api} type
     * @param eCB1api the object representing the API call to do, with given
     * information to put
     * @return an object of the same type as the given {@code eCB1api} object
     * with the response filled, or {@code null} if something went wrong
     */
    protected <A extends ECB1Api> A put(A eCB1api) {
        try {
            return processResponse(eCB1api, prepare(eCB1api).put(createFormEntity(eCB1api)));
        } catch (URISyntaxException ex) {
            Logger.getLogger(ECB1.class.getName()).log(Level.SEVERE, "Invalid PUT URI.", ex);
        }

        return null;
    }

    /**
     * Perform a HTTP {@code DELETE} request with a given {@link ECB1Api} object
     * representing the API call to do.
     *
     * @param <A> the {@link ECB1Api} type
     * @param eCB1api the object representing the API call to do
     * @return an object of the same type as the given {@code eCB1api} object
     * with the response filled, or {@code null} if something went wrong
     */
    protected <A extends ECB1Api> A delete(A eCB1api) {
        try {
            return processResponse(eCB1api, prepare(eCB1api).delete());
        } catch (URISyntaxException ex) {
            Logger.getLogger(ECB1.class.getName()).log(Level.SEVERE, "Invalid DELETE URI.", ex);
        }

        return null;
    }

}
