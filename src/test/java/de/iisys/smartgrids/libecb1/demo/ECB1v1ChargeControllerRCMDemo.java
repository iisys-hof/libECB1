package de.iisys.smartgrids.libecb1.demo;

import de.iisys.smartgrids.libecb1.ECB1v1;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerRCM;

/**
 * Class to connect to the host and to get, set and delte the Residual Current
 * Monitoring (RCM) module for the charging controller..<br><br>
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
 * Set the Residual Current Monitoring (RCM) module for the charging controller
 * with the given id.<br>
 * Get the Residual Current Monitoring (RCM) module for the charging controller
 * with the given id.<br>
 * Delete the Residual Current Monitoring (RCM) module for the charging
 * controller with the given id.<br>
 * Perform a HTTP {@code GET} request with a given {@link ECB1Api} object
 * representing the API call to do.<br>
  */
public class ECB1v1ChargeControllerRCMDemo {

    public static void main(String[] args) throws InterruptedException {
        ECB1v1 eCB1v1 = ECB1v1.getECB1v1("ladepunkt1.hof-university.de");

        //get the charge controller 1 Residual Current Monitoring (RCM) module  
        ChargeControllerRCM chargeControllerRCM = eCB1v1.getChargeControllerRCM(1);
        System.out.println(chargeControllerRCM);

        //set the charge controller 1 Residual Current Monitoring (RCM) module 
        chargeControllerRCM = eCB1v1.setChargeControllerRCM(1);
        System.out.println(chargeControllerRCM);

        //get the charge controller 1 Residual Current Monitoring (RCM) module
        chargeControllerRCM = eCB1v1.getChargeControllerRCM(1);
        System.out.println(chargeControllerRCM);

        //delete the charge controller 1 Residual Current Monitoring (RCM) module 
        chargeControllerRCM = eCB1v1.deleteChargeControllerRCM(1);
        System.out.println(chargeControllerRCM);

        //get the charge controller 1 Residual Current Monitoring (RCM) 
        chargeControllerRCM = eCB1v1.getChargeControllerRCM(1);
        System.out.println(chargeControllerRCM);
    }

}
