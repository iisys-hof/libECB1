package de.iisys.smartgrids.libecb1.demo;

import de.iisys.smartgrids.libecb1.ECB1v1;
import de.iisys.smartgrids.libecb1.api.ECB1Api;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerModeEcoPowerOffset;

/**
 * Class to connect to the host and to get, set and check the current power
 * offset in watt for controll of eco mode.<br><br>
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
 * Gets the current power offset in watt for controll of eco mode.<br>
 * Set the current power offset in watt for control of eco mode.<br>
 * Update the current power offset in watt for control of eco mode.<br>
 * Perform a HTTP {@code GET} request with a given {@link ECB1Api} object
 * representing the API call to do.<br>
  */
public class ECB1v1ChargeControllerModeEcoPowerOffsetDemo {

    public static void main(String[] args) throws InterruptedException {
        ECB1v1 eCB1v1 = ECB1v1.getECB1v1("ladepunkt1.hof-university.de");

        // get the current eco mode power offset
        ChargeControllerModeEcoPowerOffset originalChargeControllerModeEcoPowerOffset = eCB1v1.getChargeControllerModeEcoPowerOffset();
        System.out.println(originalChargeControllerModeEcoPowerOffset);

        // set the current eco mode power offset to 100 watt
        ChargeControllerModeEcoPowerOffset chargeControllerModeEcoPowerOffset = eCB1v1.setChargeControllerModeEcoPowerOffset(100);
        System.out.println(chargeControllerModeEcoPowerOffset);

        // reread the current eco mode power offset, should be 100 watt
        chargeControllerModeEcoPowerOffset = eCB1v1.getChargeControllerModeEcoPowerOffset();
        System.out.println(chargeControllerModeEcoPowerOffset);

        // reset the current eco mode power offset to original value
        chargeControllerModeEcoPowerOffset = eCB1v1.setChargeControllerModeEcoPowerOffset(originalChargeControllerModeEcoPowerOffset.getPowerOffset());
        System.out.println(chargeControllerModeEcoPowerOffset);

        // reread the current eco mode power offset, should be back to original value
        chargeControllerModeEcoPowerOffset = eCB1v1.getChargeControllerModeEcoPowerOffset();
        System.out.println(chargeControllerModeEcoPowerOffset);
    }

}
