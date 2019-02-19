package de.iisys.smartgrids.libecb1.demo;

import de.iisys.smartgrids.libecb1.ECB1v1;
import de.iisys.smartgrids.libecb1.api.v1.ChargeController;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerConfig;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllers;

/**
 * Class to connect to the host and to get the current state of the charging
 * points.<br><br>
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
 * Get the current state of the charging controllers of the eCB1 charging
 * points.<br>
 * Get the current state of the charging controllers of the eCB1 charging
 * points, filtered by the given {@link ChargeControllerConfig.Vendor} and
 * {@link ChargeControllerConfig.Type}.<br>
 * Perform a HTTP {@code GET} request with a given {@link ECB1Api} object
 * representing the API call to do.<br>
  */
public class ECB1v1ChargeControllersDemo {

    public static void main(String[] args) {
        ECB1v1 eCB1v1 = ECB1v1.getECB1v1("ladepunkt1.hof-university.de");

        // get all charge controllers
        ChargeControllers chargeControllers = eCB1v1.getChargeControllers();
        System.out.println(chargeControllers);

        // get only the eCharge controllers
        chargeControllers = eCB1v1.getChargeControllers(ChargeControllerConfig.Vendor.E_CHARGE, null);
        System.out.println(chargeControllers);

        // get only the charge controller of a certain type
        chargeControllers = eCB1v1.getChargeControllers(ChargeControllerConfig.Vendor.ABL_SURSUM, ChargeControllerConfig.Type.EVCC);
        System.out.println(chargeControllers);

        // get charge controller by id 1
        ChargeController chargeController1 = eCB1v1.getChargeController(1);
        System.out.println(chargeController1);

        // get charge controller by id 2        
        ChargeController chargeController2 = eCB1v1.getChargeController(2);
        System.out.println(chargeController2);
    }

}
