package de.iisys.smartgrids.libecb1.api.v1;

import javax.xml.bind.annotation.XmlElement;

/**
 * RFID controller config.
  */
public class RFIDConfig {

    /**
     * The id of the charging controller.<br>
     * Mandatory variable for XML.
     */
    @XmlElement(name = "id", required = true)
    private int id;

    /**
     * The RFID busID.
     */
    @XmlElement(name = "busid")
    private int busId;

    /**
     * RFID vendor.
     */
    @XmlElement(name = "vendor")
    private String vendor;

    /**
     * The RFID type. Mandatory variable for XML.
     */
    @XmlElement(name = "type", required = true)
    private String type;

    /**
     * The RFID version.
     */
    @XmlElement(name = "version")
    private String version;

    /**
     * Reference to {@link RFIDStatus}.<br>
     * Contains the status of RFID.
     */
    @XmlElement(name = "data")
    private RFIDStatus data;

    /**
     * Default constructor.
     */
    public RFIDConfig() {
    }

    public int getId() {
        return id;
    }

    public int getBusId() {
        return busId;
    }

    public String getVendor() {
        return vendor;
    }

    public String getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }

    /**
     * get the current {@link RFIDStatus}.
     *
     * @return {@link #data}
     * @see #data
     */
    public RFIDStatus getData() {
        return data;
    }

    @Override
    public String toString() {
        return "RFIDConfig{" + "id=" + id + ", busId=" + busId + ", vendor=" + vendor + ", type=" + type + ", version=" + version + ", data=" + data + '}';
    }

}
