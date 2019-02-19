package de.iisys.smartgrids.libecb1.demo;

import de.iisys.smartgrids.libecb1.ECB1v1;
import de.iisys.smartgrids.libecb1.api.ECB1Api;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerMode;

/**
 * Class to connect to the host and to get, set and check the current mode of
 * the charging controller.<br><br>
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
 * Gets the current charging mode of the charging controller with the given
 * id.<br>
 * Set the charging mode of the charging controller with the given id.<br>
 * Update the charging mode of the charging controller with the given id.<br>
 * Perform a HTTP {@code GET} request with a given {@link ECB1Api} object
 * representing the API call to do.<br>
  */
public class ECB1v1ChargeControllerModeDemo {

    public static void main(String[] args) throws InterruptedException {
        ECB1v1 eCB1v1 = ECB1v1.getECB1v1("ladepunkt1.hof-university.de");

        // get the current charge controller 1 mode setting
        ChargeControllerMode originalChargeControllerMode = eCB1v1.getChargeControllerMode(1);
        System.out.println(originalChargeControllerMode);

        // set the charge controller 1 to eco mode
        ChargeControllerMode chargeControllerMode = eCB1v1.setChargeControllerMode(1, ChargeControllerMode.Mode.ECO);
        System.out.println(chargeControllerMode);

        // apparently needs some time to adapt
        System.out.println("Waiting for 10 seconds to adapt ...");
        Thread.sleep(10000);

        // check if the charge controller is in eco mode now
        chargeControllerMode = eCB1v1.getChargeControllerMode(1);
        System.out.println(chargeControllerMode);

        // set back to original mode
        chargeControllerMode = eCB1v1.setChargeControllerMode(1, originalChargeControllerMode.getMode());
        System.out.println(chargeControllerMode);

        // apparently needs some time to adapt
        System.out.println("Waiting for 10 seconds to adapt ...");
        Thread.sleep(10000);

        // check if original mode was applied successfully
        chargeControllerMode = eCB1v1.getChargeControllerMode(1);
        System.out.println(chargeControllerMode);
    }

}
