package de.iisys.smartgrids.libecb1.demo;

import de.iisys.smartgrids.libecb1.ECB1v1;
import de.iisys.smartgrids.libecb1.api.ECB1Api;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerMainSupplyMaxCurrent;

/**
 * Class to connect to the host and to get the current maximum in ampere on the
 * main supply.<br><br>
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
 * Gets the current maximum current in ampere on the main supply.<br>
 * Perform a HTTP {@code GET} request with a given {@link ECB1Api} object
 * representing the API call to do.<br>
  */
public class ECB1v1ChargeControllerMainSupplyMaxCurrentDemo {

    public static void main(String[] args) throws InterruptedException {
        ECB1v1 eCB1v1 = ECB1v1.getECB1v1("ladepunkt1.hof-university.de");

        // get the current main supply max current
        ChargeControllerMainSupplyMaxCurrent chargeControllerMainSupplyMaxCurrent = eCB1v1.getChargeControllerMainSupplyMaxCurrent();
        System.out.println(chargeControllerMainSupplyMaxCurrent);
    }

}
