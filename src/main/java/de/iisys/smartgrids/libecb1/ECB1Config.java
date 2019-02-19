package de.iisys.smartgrids.libecb1;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Configuration;

/**
 * Configuration for URL and user authentication for eCB1.
  */
public class ECB1Config {

    /**
     * The scheme of the URL of the API, may be {@code HTTP} or {@code HTTPS}.
     */
    private String scheme;

    /**
     * The authentication information, needs to follow the format
     * {@code <username>:<password>}.
     */
    private String userInfo;

    /**
     * The hostname or ip-address to connect to.
     */
    private String host;

    /**
     * The port to connect to, normally is {@code 80} for {@code HTTP} or
     * {@code 443} for {@code HTTPS}.
     */
    private int port;

    /**
     * The base path of the API to append to the hostname.
     */
    private String path;

    /**
     * A {@link Configuration} used for the {@link #client} during
     * initialization.
     */
    private Configuration configuration;

    /**
     * The connection to the API.
     */
    private Client client;

    /**
     * Builds an {@link ECB1Config} with default parameters.<br>
     * <br> {@link #scheme} will be set to {@code http},<br> {@link #port} will
     * be set to {@code 80}<br>
     * and {@link #path} will be set to {@code /api}.<br>
     * <br>
     * The {@link #host} still needs to be set via {@link #setHost(String)}, the
     * {@link #userInfo}, too, if needed.
     *
     * @return an {@link ECB1Config} with default values.
     */
    public static ECB1Config build() {
        ECB1Config eCB1config = new ECB1Config();
        eCB1config.setScheme("http");
        eCB1config.setPort(80);
        eCB1config.setPath("/api");
        return eCB1config;
    }

    /**
     * Set the scheme for the URL to {@code http} or {@code https}.
     *
     * @param scheme to set for URL
     * @return current {@link ECB1Config} object
     * @see #scheme
     */
    public ECB1Config setScheme(String scheme) {
        this.scheme = scheme;
        return this;
    }

    /**
     * Get the current {@link #scheme} of the URL.
     *
     * @return the {@link #scheme}
     * @see #scheme
     */
    public String getScheme() {
        return scheme;
    }

    /**
     * Set the authentication information in format
     * {@code <username>:<password>}.
     *
     * @param userInfo to set for authentication
     * @return current {@link ECB1Config} object
     * @see #userInfo
     */
    public ECB1Config setUserInfo(String userInfo) {
        this.userInfo = userInfo;
        return this;
    }

    /**
     * Get the current user information.
     *
     * @return the {@link #userInfo}
     * @see #userInfo
     */
    public String getUserInfo() {
        return userInfo;
    }

    /**
     * Set the hostname to connect to.
     *
     * @param host to connect to
     * @return current {@link ECB1Config} object
     * @see #host
     */
    public ECB1Config setHost(String host) {
        this.host = host;
        return this;
    }

    /**
     * Get the current hostname.
     *
     * @return the {@link #host}
     * @see #host
     */
    public String getHost() {
        return host;
    }

    /**
     * Set the port to connect to.
     *
     * @param port to connect to
     * @return current {@link ECB1Config} object
     * @see #port
     */
    public ECB1Config setPort(int port) {
        this.port = port;
        return this;
    }

    /**
     * Get the current port.
     *
     * @return the {@link #port}
     * @see #port
     */
    public int getPort() {
        return port;
    }

    /**
     * Set the path that has to be added to the {@link #host}.
     *
     * @param path to add
     * @return current {@link ECB1Config} object
     * @see #path
     */
    public ECB1Config setPath(String path) {
        this.path = path;
        return this;
    }

    /**
     * Get the currernt path of the API.
     *
     * @return the {@link #path}
     * @see #path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets a {@link Configuration} for the client to use during
     * {@link #initialize()}.
     *
     * @param configuration to use
     * @return current {@link ECB1Config} object
     * @see #configuration
     */
    public ECB1Config setConfiguration(Configuration configuration) {
        this.configuration = configuration;
        return this;
    }

    /**
     * Get the current {@link Configuration} that was used during
     * {@link #initialize()} of the client.
     *
     * @return the {@link #configuration}
     * @see #configuration
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Sets the client to the given one, may be used in subclasses that override
     * {@link #initialize()}.
     *
     * @param client the {@link Client} to set
     * @see #client
     */
    protected void setClient(Client client) {
        this.client = client;
    }

    /**
     * When the client was created by calling {@link #initialize()}, it can be
     * used with this method, so this is the real connection to the API.
     *
     * @return the current {@link Client}
     * @see #client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Creates the client, based on the set {@link #configuration}.
     */
    public void initialize() {
        this.client = configuration != null ? ClientBuilder.newClient(configuration) : ClientBuilder.newClient();
    }

}
