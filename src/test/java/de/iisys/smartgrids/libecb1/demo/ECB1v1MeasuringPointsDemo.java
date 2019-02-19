package de.iisys.smartgrids.libecb1.demo;

import de.iisys.smartgrids.libecb1.ECB1v1;
import de.iisys.smartgrids.libecb1.api.v1.MeasuringPoint;
import de.iisys.smartgrids.libecb1.api.v1.MeasuringPoints;

/**
 * Class to connect to the host and to get the current data of all measuring
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
 * Get the current data of all measuring points.<br>
 * Perform a HTTP {@code GET} request with a given {@link ECB1Api} object
 * representing the API call to do.<br>
  */
public class ECB1v1MeasuringPointsDemo {

    public static void main(String[] args) {
        ECB1v1 eCB1v1 = ECB1v1.getECB1v1("ladepunkt1.hof-university.de");

        // get all measuring points
        MeasuringPoints measuringPoints = eCB1v1.getMeasuringPoints();
        System.out.println(measuringPoints);

        // get measuring point 1
        MeasuringPoint measuringPoint1 = eCB1v1.getMeasuringPoint(1);
        System.out.println(measuringPoint1);

        // get measuring point 2
        MeasuringPoint measuringPoint2 = eCB1v1.getMeasuringPoint(2);
        System.out.println(measuringPoint2);
    }

}
