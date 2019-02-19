package de.iisys.smartgrids.libecb1.api.v1;

import javax.xml.bind.annotation.XmlElement;

/**
 * Network configuration.
  */
public class NetworkConfig {

    /**
     * The hostname of the network.
     */
    @XmlElement(name = "hostname")
    private String hostname;

    /**
     * The ip address of the network.
     */
    @XmlElement(name = "ipaddress")
    private String ipAddress;

    /**
     * The broadcast of the network.
     */
    @XmlElement(name = "broadcast")
    private String broadcast;

    /**
     * The netmask of the network.
     */
    @XmlElement(name = "netmask")
    private String netmask;

    /**
     * The gateway of the network.
     */
    @XmlElement(name = "gateway")
    private String gateway;

    /**
     * Default constructor.
     */
    public NetworkConfig() {
    }

    public String getHostname() {
        return hostname;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public String getNetmask() {
        return netmask;
    }

    public String getGateway() {
        return gateway;
    }

    @Override
    public String toString() {
        return "NetworkConfig{" + "hostname=" + hostname + ", ipAddress=" + ipAddress + ", broadcast=" + broadcast + ", netmask=" + netmask + ", gateway=" + gateway + '}';
    }

}
