package de.iisys.smartgrids.libecb1.api.v1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Charging controller settings.
  */
public class ChargeControllerConfig {

    /**
     * Enumeration, which consists of vendors.<br>
     * Used as a filter to get the current state of the charging controllers of
     * the eCB1 charging points.
     */
    @XmlEnum
    public enum Vendor {
        @XmlEnumValue("ABL Sursum")
        ABL_SURSUM,
        @XmlEnumValue("Phoenix Contact")
        PHOENIX_CONTACT,
        @XmlEnumValue("eCHARGE")
        E_CHARGE,
    }

    /**
     * Enumeration, which consists of charging controller types.<br>
     * Used as a filter to get the current state of the charging controllers of
     * the eCB1 charging points.
     */
    @XmlEnum
    public enum Type {
        @XmlEnumValue("EVCC")
        EVCC,
        @XmlEnumValue("EVCC eth")
        EVCC_ETH,
        @XmlEnumValue("eCB1 remote EVCC")
        ECB1_REMOTE_EVCC,
        @XmlEnumValue("measuring point as simulated EVCC")
        MEASURING_POINT_AS_SIMULATED_EVCC,
    }

    /**
     * The id of the charging controller.<br>
     * Mandatory variable for XML.
     */
    @XmlElement(name = "id", required = true)
    private int id;

    /**
     * Reference to {@link Vendor}.<br>
     * Name of the vendor. Needed for purposes of filtering.
     */
    @XmlElement(name = "vendor")
    private Vendor vendor;

    /**
     * Reference to {@link Type}.<br>
     * The type of the charging controller. Needed for purposes of
     * filtering.<br>
     * Mandatory variable for XML.
     */
    @XmlElement(name = "type", required = true)
    private Type type;

    /**
     * The charging controller name.
     */
    @XmlElement(name = "name")
    private String name;

    /**
     * The charging controller version.
     */
    @XmlElement(name = "version")
    private String version;

    /**
     * The charging controller bus id.
     */
    @XmlElement(name = "busid")
    private int busId;

    /**
     * The charging controller ip address.
     */
    @XmlElement(name = "ipaddress")
    private String ipAddress;

    /**
     * The minimum ampere for the charging controller.
     */
    @XmlElement(name = "evminamp")
    private double evMinAmp;

    /**
     * The supply line maximum ampere for the charging controller.
     */
    @XmlElement(name = "supplylinemaxamp")
    private double supplyLineMaxAmp;

    /**
     * The ampere for the manual mode of the charging controller.
     */
    @XmlElement(name = "manualmodeamp")
    private double manualModeAmp;

    /**
     * The id of the mode of the charging controller.
     */
    @XmlElement(name = "modeid")
    private int modeId;

    /**
     * The current pulse-width modulation of the charging controller.
     */
    @XmlElement(name = "currentpwmamp")
    private double currentPWMAmp;

    /**
     * The state id of the charging controller.
     */
    @XmlElement(name = "stateid")
    private int stateId;

    /**
     * The state of the charging controller.
     */
    @XmlElement(name = "state")
    private String state;

    /**
     * Default constructor.
     */
    public ChargeControllerConfig() {
    }

    public int getId() {
        return id;
    }

    /**
     * Get the vendor for the charging point. Needed for purposes of filtering.
     *
     * @return {@link #vendor}
     */
    public Vendor getVendor() {
        return vendor;
    }

    /**
     * Get the type for the charging point. Needed for purposes of filtering.
     *
     * @return {@link #type}
     */
    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public int getBusId() {
        return busId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public double getEvMinAmp() {
        return evMinAmp;
    }

    public double getSupplyLineMaxAmp() {
        return supplyLineMaxAmp;
    }

    public double getManualModeAmp() {
        return manualModeAmp;
    }

    public int getModeId() {
        return modeId;
    }

    public double getCurrentPWMAmp() {
        return currentPWMAmp;
    }

    public int getStateId() {
        return stateId;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "ChargeControllerConfig{" + "id=" + id + ", vendor=" + vendor + ", type=" + type + ", name=" + name + ", version=" + version + ", busId=" + busId + ", ipAddress=" + ipAddress + ", evMinAmp=" + evMinAmp + ", supplyLineMaxAmp=" + supplyLineMaxAmp + ", manualModeAmp=" + manualModeAmp + ", modeId=" + modeId + ", currentPWMAmp=" + currentPWMAmp + ", stateId=" + stateId + ", state=" + state + '}';
    }

}
