package de.iisys.smartgrids.libecb1.api.v1;

import javax.xml.bind.annotation.XmlElement;

/**
 * System configuration.
  */
public class SystemConfig {

    /**
     * System serial number.
     */
    @XmlElement(name = "serial")
    private int serial;

    /**
     * System operating system component.
     */
    @XmlElement(name = "os_component")
    private int osComponent;

    /**
     * System operating system version.
     */
    @XmlElement(name = "os_version")
    private String osVersion;

    /**
     * System RFID type.
     */
    @XmlElement(name = "type")
    private int type;

    /**
     * System RFID name of the type.
     */
    @XmlElement(name = "typename")
    private String typeName;

    /**
     * Company.
     */
    @XmlElement(name = "company")
    private String company;

    /**
     * Lang.
     */
    @XmlElement(name = "lang")
    private String lang;

    /**
     * Location.
     */
    @XmlElement(name = "location")
    private String location;

    /**
     * Zone name.
     */
    @XmlElement(name = "zonename")
    private String zoneName;

    /**
     * Universal time coordinated local time.
     */
    @XmlElement(name = "utclocaltime")
    private String utcLocalTime;

    /**
     * Default constructor.
     */
    public SystemConfig() {
    }

    public int getSerial() {
        return serial;
    }

    public int getOsComponent() {
        return osComponent;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public int getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getCompany() {
        return company;
    }

    public String getLang() {
        return lang;
    }

    public String getLocation() {
        return location;
    }

    public String getZoneName() {
        return zoneName;
    }

    public String getUtcLocalTime() {
        return utcLocalTime;
    }

    @Override
    public String toString() {
        return "SystemConfig{" + "serial=" + serial + ", osComponent=" + osComponent + ", osVersion=" + osVersion + ", type=" + type + ", typeName=" + typeName + ", company=" + company + ", lang=" + lang + ", location=" + location + ", zoneName=" + zoneName + ", utcLocalTime=" + utcLocalTime + '}';
    }

}
