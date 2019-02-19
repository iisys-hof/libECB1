package de.iisys.smartgrids.libecb1.api.v1;

import javax.xml.bind.annotation.XmlElement;

/**
 * RFID status.
  */
public class RFIDStatus {

    /**
     * The RFID tag.
     */
    @XmlElement(name = "tag")
    private String tag;

    /**
     * Default constructor.
     */
    public RFIDStatus() {
    }

    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "RFIDStatus{" + "tag=" + tag + '}';
    }

}
