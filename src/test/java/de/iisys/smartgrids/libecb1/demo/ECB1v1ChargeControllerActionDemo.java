package de.iisys.smartgrids.libecb1.demo;

import de.iisys.smartgrids.libecb1.ECB1v1;
import de.iisys.smartgrids.libecb1.api.ECB1Api;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerAction;

/**
 * Class to connect to the host and perfon actions on the charging controller.
 * <br><br>
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
 * Performs an action on the charging controller with the given id.<br>
 * Perform a HTTP {@code GET} request with a given {@link ECB1Api} object
 * representing the API call to do.<br>
  */
public class ECB1v1ChargeControllerActionDemo {

    public static void main(String[] args) throws InterruptedException {
        ECB1v1 eCB1v1 = ECB1v1.getECB1v1("ladepunkt1.hof-university.de");

        // stop the charging point 1
        ChargeControllerAction chargeControllerAction = eCB1v1.setChargeControllerAction(1, ChargeControllerAction.Action.STOP);
        System.out.println(chargeControllerAction);

        // apparently needs some time to adapt
        System.out.println("Waiting for 10 seconds to adapt ...");
        Thread.sleep(10000);

        // start the charging point 1
        chargeControllerAction = eCB1v1.setChargeControllerAction(1, ChargeControllerAction.Action.START);
        System.out.println(chargeControllerAction);
    }

}
