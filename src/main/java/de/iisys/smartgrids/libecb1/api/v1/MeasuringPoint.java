package de.iisys.smartgrids.libecb1.api.v1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Returns measuring point by id.
  */
@Path("/meters/{id}")
@XmlRootElement
public class MeasuringPoint implements ECB1Api {

    /**
     * The id of the charging controller.<br>
     * Needed as a path parameter for the RESTful Web Service.
     */
    @PathParam("id")
    private int id;

    /**
     * Reference to {@link MeterConfig}.<br>
     * Contains Meter data.
     */
    @XmlElement(name = "meter")
    private MeterConfig meter;

    /**
     * Default constructor
     */
    public MeasuringPoint() {
    }

    /**
     * Initializes {@link #id} of {@link MeasuringPoint} with the given id.
     *
     * @param id the id of the charge controller
     */
    public MeasuringPoint(int id) {
        this.id = id;
    }

    /**
     * get the {@link MeterConfig}.
     *
     * @return {@link #meters}
     * @see #meters
     */
    public MeterConfig getMeter() {
        return meter;
    }

    @Override
    public String toString() {
        return "MeasuringPoint{" + "meter=" + meter + '}';
    }

}
