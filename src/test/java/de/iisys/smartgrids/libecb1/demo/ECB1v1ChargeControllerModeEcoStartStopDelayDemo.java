package de.iisys.smartgrids.libecb1.demo;

import de.iisys.smartgrids.libecb1.ECB1v1;
import de.iisys.smartgrids.libecb1.api.ECB1Api;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerModeEcoStartStopDelay;

/**
 * Class to connect to the host and to get, set and reset the delay for
 * automatic charging start and stop at the charging controller.<br><br>
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
 * Gets the delay for automatic charging start and stop at the charging
 * controller with the given id.<br>
 * Set the delay for automatic charging start and stop at the charging
 * controller with the given id.<br>
 * Update the delay for automatic charging start and stop at the charging
 * controller with the given id.<br>
 * Perform a HTTP {@code GET} request with a given {@link ECB1Api} object
 * representing the API call to do.<br>
  */
public class ECB1v1ChargeControllerModeEcoStartStopDelayDemo {

    public static void main(String[] args) throws InterruptedException {
        ECB1v1 eCB1v1 = ECB1v1.getECB1v1("ladepunkt1.hof-university.de");

        // get the current eco mode power delay
        ChargeControllerModeEcoStartStopDelay originalChargeControllerModeEcoStartStopDelay = eCB1v1.getChargeControllerModeEcoStartStopDelay(1);
        System.out.println(originalChargeControllerModeEcoStartStopDelay);

        // set the current eco mode power delay to 100 seconds
        ChargeControllerModeEcoStartStopDelay chargeControllerModeEcoStartStopDelay = eCB1v1.setChargeControllerModeEcoStartStopDelay(1, 100);
        System.out.println(chargeControllerModeEcoStartStopDelay);

        // reread the current eco mode power delay, should be 10 seconds
        chargeControllerModeEcoStartStopDelay = eCB1v1.getChargeControllerModeEcoStartStopDelay(1);
        System.out.println(chargeControllerModeEcoStartStopDelay);

        // reset the current eco mode power delay to original value
        chargeControllerModeEcoStartStopDelay = eCB1v1.setChargeControllerModeEcoStartStopDelay(1, originalChargeControllerModeEcoStartStopDelay.getDelay());
        System.out.println(chargeControllerModeEcoStartStopDelay);

        // reread the current eco mode power delay, should be back to original value
        chargeControllerModeEcoStartStopDelay = eCB1v1.getChargeControllerModeEcoStartStopDelay(1);
        System.out.println(chargeControllerModeEcoStartStopDelay);
    }

}
