package de.iisys.smartgrids.libecb1.demo;

import de.iisys.smartgrids.libecb1.ECB1v1;
import de.iisys.smartgrids.libecb1.api.v1.PVMode;

/**
 * Class to connect to the host.<br><br>
 *
 *
 * Creates a new {@link ECB1v1} object with the given host.<br>
 * Initializes eCB1 API v1 with the given host. Uses port {@code 80} as
 * default.<br>
 * Initializes eCB1 API v1 with the given host and port. Defaults to path
 * {@code /api/v1}.<br>
 * Creates an {@link ECB1} object by connecting to a given
 * {@link ECB1Config}.<br>
 * Creates the client, based on the set
 * {@link de.iisys.smartgrids.libecb1.ECB1Config#configuration}.<br>
 * Get the current PV charging mode.<br>
 * Set the PV charging mode to the given one.<br>
 * Update the PV charging mode to the given one.<br>
 * Perform a HTTP {@code GET} request with a given {@link ECB1Api} object
 * representing the API call to do.<br>
  */
public class ECB1v1PVModeDemo {

    public static void main(String[] args) {
        ECB1v1 eCB1v1 = ECB1v1.getECB1v1("ladepunkt1.hof-university.de");

        // get current pv charging mode setting
        PVMode originalPvMode = eCB1v1.getPVMode();
        System.out.println(originalPvMode);

        // set to eco mode
        PVMode pvMode = eCB1v1.setPVMode(PVMode.Mode.ECO);
        System.out.println(pvMode);

        // check if setting was made
        pvMode = eCB1v1.getPVMode();
        System.out.println(pvMode);

        // set back to original mode
        pvMode = eCB1v1.setPVMode(originalPvMode.getPVMode());
        System.out.println(pvMode);

        // check if original mode is applied again
        pvMode = eCB1v1.getPVMode();
        System.out.println(pvMode);
    }

}
