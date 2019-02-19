package de.iisys.smartgrids.libecb1.api.v1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import de.iisys.smartgrids.libecb1.api.v1.MeterConfig.Function;
import de.iisys.smartgrids.libecb1.api.v1.MeterConfig.Type;
import de.iisys.smartgrids.libecb1.api.v1.MeterConfig.Vendor;
import java.util.Arrays;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Returns list of measuring points.
  */
@Path("/meters")
@XmlRootElement
public class MeasuringPoints implements ECB1Api {

    /**
     * Used as a filter to get the current state of the charging controllers of
     * the eCB1 charging points.
     */
    @QueryParam("vendor")
    private Vendor vendor;

    /**
     * Used as a filter to get the current state of the charging controllers of
     * the eCB1 charging points.
     */
    @QueryParam("type")
    private Type type;

    /**
     * Used as a filter to get the current state of the charging controllers of
     * the eCB1 charging points.
     */
    @QueryParam("function")
    private Function function;

    /**
     * Array reference to {@link MeterConfig}.<br>
     * Contains Meter data.
     */
    @XmlElement(name = "meters")
    private MeterConfig[] meters;

    /**
     * Default constructor
     */
    public MeasuringPoints() {
    }

    /**
     * Initializes {@link #vendor}, {@link #type} and {@link #function} of
     * {@link MeasuringPoints} with the given parameters vendor, type and
     * function.
     *
     * @param vendor used as a filter to get the current state of the charging
     * controllers of the eCB1 charging points.
     * @param type used as a filter to get the current state of the charging
     * controllers of the eCB1 charging points.
     * @param function used as a filter to get the current state of the charging
     * controllers of the eCB1 charging points.
     */
    public MeasuringPoints(Vendor vendor, Type type, Function function) {
        this.vendor = vendor;
        this.type = type;
        this.function = function;
    }

    /**
     * get a list of {@link MeterConfig}.
     *
     * @return {@link #meters}
     * @see #meters
     */
    public MeterConfig[] getMeters() {
        return meters;
    }

    @Override
    public String toString() {
        return "MeasuringPoints{" + "meters=" + Arrays.toString(meters) + '}';
    }

}
