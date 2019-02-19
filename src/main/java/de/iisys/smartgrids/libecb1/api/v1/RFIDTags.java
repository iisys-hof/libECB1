package de.iisys.smartgrids.libecb1.api.v1;

import de.iisys.smartgrids.libecb1.api.ECB1Api;
import de.iisys.smartgrids.libecb1.api.v1.RFIDTagsConfig.Type;
import java.util.Arrays;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Returns list of RFID Tags.
  */
@Path("/rfidtags")
@XmlRootElement
public class RFIDTags implements ECB1Api {

    /**
     * Reference to {@link Type}.<br>
     * Contains RFID types.
     */
    @QueryParam("type")
    private Type type;

    /**
     * List of {@link RFIDTagsConfig}
     */
    @XmlElement(name = "tags")
    private RFIDTagsConfig[] tags;

    /**
     * Default constructor.
     */
    public RFIDTags() {
    }

    /**
     * Initializes {@link #type} of {@link RFIDTags} with the given RFID type.
     *
     * @param type the RFID type
     */
    public RFIDTags(Type type) {
        this.type = type;
    }

    /**
     * Get {@link RFIDTagsConfig} list.
     *
     * @return {@link #tags}
     * @see #tags
     */
    public RFIDTagsConfig[] getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "RFIDTags{" + "tags=" + Arrays.toString(tags) + '}';
    }

}
