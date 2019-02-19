package de.iisys.smartgrids.libecb1.demo;

import de.iisys.smartgrids.libecb1.ECB1v1;
import de.iisys.smartgrids.libecb1.api.ECB1Api;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerAuthentication;

/**
 * Class to connect to the host and to get and change the authentication of the
 * charging controller.<br><br>
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
 * Get the current authentication method of the charging controller with the
 * given id.<br>
 * Perform a HTTP {@code GET} request with a given {@link ECB1Api} object
 * representing the API call to do.<br>
  */
public class ECB1v1ChargeControllerAuthenticationDemo {

    public static void main(String[] args) throws InterruptedException {
        ECB1v1 eCB1v1 = ECB1v1.getECB1v1("ladepunkt1.hof-university.de");

        // get charge controller authentication 1
        ChargeControllerAuthentication originalChargeControllerAuthentication = eCB1v1.getChargeControllerAuthentication(1);
        System.out.println(originalChargeControllerAuthentication);

        /* WARNING - DID CRASH THE CHARGING POINT! DO NOT SET AUTHENTICATION!
        
        // change the charge controller authentication to RFID
        ChargeControllerAuthentication chargeControllerAuthentication = eCB1v1.setChargeControllerAuthentication(1, ChargeControllerAuthentication.Authentication.RFID);
        System.out.println(chargeControllerAuthentication);

        // get charge controller authentication 1
        chargeControllerAuthentication = eCB1v1.getChargeControllerAuthentication(1);
        System.out.println(chargeControllerAuthentication);

        // change the charge controller authentication to before
        chargeControllerAuthentication = eCB1v1.setChargeControllerAuthentication(1, originalChargeControllerAuthentication.getAuthentication());
        System.out.println(chargeControllerAuthentication);

        // get charge controller authentication 1
        chargeControllerAuthentication = eCB1v1.getChargeControllerAuthentication(1);
        System.out.println(chargeControllerAuthentication);
         */
        // get charge controller authentication 2
        ChargeControllerAuthentication chargeControllerAuthentication = eCB1v1.getChargeControllerAuthentication(2);
        System.out.println(chargeControllerAuthentication);
    }

}
