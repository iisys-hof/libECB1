package de.iisys.smartgrids.libecb1.api.v1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import java.util.Arrays;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlElement;

/**
 * Returns current state of the eCB1 System including connected Devices.
  */
@Path("/all")
public class AllState implements ECB1Api {

    /**
     * Reference to {@link SystemConfig}.<br>
     * Contains System configurations.
     */
    @XmlElement(name = "system")
    private SystemConfig system;

    /**
     * Reference to {@link NetworkConfig}.<br>
     * Contains Network configurations.
     */
    @XmlElement(name = "network")
    private NetworkConfig network;

    /**
     * Array reference to {@link MeterConfig}.<br>
     * Contains Meter data list.
     */
    @XmlElement(name = "meters")
    private MeterConfig[] meters;

    /**
     * Array reference to {@link ChargeControllerConfig}.<br>
     * Contains charging controller settings.
     */
    @XmlElement(name = "chargecontrols")
    private ChargeControllerConfig[] chargeControls;

    /**
     * Array reference to {@link RFIDConfig}.<br>
     * Contains RFID controller configurations.
     */
    @XmlElement(name = "rfid")
    private RFIDConfig[] rfid;

    /**
     * Default constructor.
     */
    public AllState() {
    }

    /**
     * get the current {@link SystemConfig}.
     *
     * @return {@link #system}
     * @see #system
     */
    public SystemConfig getSystem() {
        return system;
    }

    /**
     * get the current {@link NetworkConfig}.
     *
     * @return {@link #network}
     * @see #network
     */
    public NetworkConfig getNetwork() {
        return network;
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

    /**
     * get an array of {@link ChargeControllerConfig} objects.
     *
     * @return {@link #chargeControls}
     * @see #chargeControls
     */
    public ChargeControllerConfig[] getChargeControls() {
        return chargeControls;
    }

    /**
     * get an array of {@link RFIDConfig} objects.
     *
     * @return {@link #rfid}
     * @see #rfid
     */
    public RFIDConfig[] getRfid() {
        return rfid;
    }

    @Override
    public String toString() {
        return "AllState{" + "system=" + system + ", network=" + network + ", meters=" + Arrays.toString(meters) + ", chargeControls=" + Arrays.toString(chargeControls) + ", rfid=" + Arrays.toString(rfid) + '}';
    }

}
