package de.iisys.smartgrids.libecb1.demo;

import de.iisys.smartgrids.libecb1.ECB1v1;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerModeManualAmpere;

/**
 * Class to connect to the host and to get, set and check the current manual
 * ampere setting of the charging controller.<br><br>
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
 * Get the current manual ampere setting of the charging controller with the
 * given id.<br>
 * Set the current manual ampere setting of the charging controller with the
 * given id.<br>
 * Update the current manual ampere of the charging controller with the given
 * id.<br>
 * Perform a HTTP {@code GET} request with a given {@link ECB1Api} object
 * representing the API call to do.<br>
  */
public class ECB1v1ChargeControllerModeManualAmpereDemo {

    public static void main(String[] args) throws InterruptedException {
        ECB1v1 eCB1v1 = ECB1v1.getECB1v1("ladepunkt1.hof-university.de");

        // get the current ampere setting of charger 1
        ChargeControllerModeManualAmpere originalChargeControllerModeManualAmpere = eCB1v1.getChargeControllerModeManualAmpere(1);
        System.out.println(originalChargeControllerModeManualAmpere);

        // set the current ampere to 10
        ChargeControllerModeManualAmpere chargeControllerModeManualAmpere = eCB1v1.setChargeControllerModeManualAmpere(1, 10);
        System.out.println(chargeControllerModeManualAmpere);

        // check if the setting was made
        chargeControllerModeManualAmpere = eCB1v1.getChargeControllerModeManualAmpere(1);
        System.out.println(chargeControllerModeManualAmpere);

        // set back to original ampere
        chargeControllerModeManualAmpere = eCB1v1.setChargeControllerModeManualAmpere(1, originalChargeControllerModeManualAmpere.getManualModeAmp());
        System.out.println(chargeControllerModeManualAmpere);

        // check original setting was put back
        chargeControllerModeManualAmpere = eCB1v1.getChargeControllerModeManualAmpere(1);
        System.out.println(chargeControllerModeManualAmpere);
    }

}
