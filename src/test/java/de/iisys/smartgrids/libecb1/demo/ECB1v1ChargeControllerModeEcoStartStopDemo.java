package de.iisys.smartgrids.libecb1.demo;

import de.iisys.smartgrids.libecb1.ECB1v1;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerModeEcoStartStop;

/**
 * Class to connect to the host and to get whether charging mode eco automatic
 * charging start and stop is enabled (AI-mode) at the charging controller. It
 * can also be set and reseted.
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
 * Gets whether charging mode eco automatic charging start and stop is enabled
 * (AI-mode) at the charging controller with the given id.<br>
 * Set automatic start and stop at charging controller with given id.<br>
 * Perform a HTTP {@code GET} request with a given {@link ECB1Api} object
 * representing the API call to do.<br>
  */
public class ECB1v1ChargeControllerModeEcoStartStopDemo {

    public static void main(String[] args) throws InterruptedException {
        ECB1v1 eCB1v1 = ECB1v1.getECB1v1("ladepunkt1.hof-university.de");

        // get the current eco mode power offset
        ChargeControllerModeEcoStartStop originalChargeControllerModeEcoStartStop = eCB1v1.getChargeControllerModeEcoStartStop(1);
        System.out.println(originalChargeControllerModeEcoStartStop);

        // set the current eco mode power offset to 100 watt
        ChargeControllerModeEcoStartStop chargeControllerModeEcoStartStop = eCB1v1.setChargeControllerModeEcoStartStop(1, true);
        System.out.println(chargeControllerModeEcoStartStop);

        // reread the current eco mode power offset, should be 100 watt
        chargeControllerModeEcoStartStop = eCB1v1.getChargeControllerModeEcoStartStop(1);
        System.out.println(chargeControllerModeEcoStartStop);

        // reset the current eco mode power offset to original value
        chargeControllerModeEcoStartStop = eCB1v1.setChargeControllerModeEcoStartStop(1, originalChargeControllerModeEcoStartStop.isAutoStartStop());
        System.out.println(chargeControllerModeEcoStartStop);

        // reread the current eco mode power offset, should be back to original value
        chargeControllerModeEcoStartStop = eCB1v1.getChargeControllerModeEcoStartStop(1);
        System.out.println(chargeControllerModeEcoStartStop);
    }

}
