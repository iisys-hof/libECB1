package de.iisys.smartgrids.libecb1;

import de.iisys.smartgrids.libecb1.api.v1.AllState;
import de.iisys.smartgrids.libecb1.api.v1.ChargeController;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerAction;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerAuthentication;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerConfig;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerMainSupplyMaxCurrent;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerMode;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerModeEcoPowerOffset;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerModeEcoStartStop;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerModeEcoStartStopDelay;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerModeManualAmpere;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllerRCM;
import de.iisys.smartgrids.libecb1.api.v1.ChargeControllers;
import de.iisys.smartgrids.libecb1.api.v1.MeasuringPoint;
import de.iisys.smartgrids.libecb1.api.v1.MeasuringPoints;
import de.iisys.smartgrids.libecb1.api.v1.MeterConfig;
import de.iisys.smartgrids.libecb1.api.v1.PVMode;
import de.iisys.smartgrids.libecb1.api.v1.RFIDTag;
import de.iisys.smartgrids.libecb1.api.v1.RFIDTagConfig;
import de.iisys.smartgrids.libecb1.api.v1.RFIDTagsConfig;
import de.iisys.smartgrids.libecb1.api.v1.RFIDTags;

/**
 * Class for eCB1 API v1.<br>
 * <br>
 * Call {@link #getECB1v1(String)} or {@link #getECB1v1(String, int)} for
 * creating an object.
  */
public class ECB1v1 extends ECB1 {

    /**
     * Initializes eCB1 API v1 with the given host. Uses port {@code 80} as
     * default.
     *
     * @param host the host to connect to
     * @see #ECB1v1(String, int)
     */
    protected ECB1v1(String host) {
        this(host, 80);
    }

    /**
     * Initializes eCB1 API v1 with the given host and port. Defaults to path
     * {@code /api/v1}.
     *
     * @param host the host to connect to
     * @param port the port to connect to
     */
    protected ECB1v1(String host, int port) {
        super(ECB1Config.build()
                .setHost(host)
                .setPort(port)
                .setPath("/api/v1"));
    }

    /**
     * Creates a new {@link ECB1v1} object with the given host.
     *
     * @param host the host to connect to
     * @return the {@link ECB1v1} object for further usage
     */
    public static ECB1v1 getECB1v1(String host) {
        return new ECB1v1(host);
    }

    /**
     * Creates a new {@link ECB1v1} object with the given host and port.
     *
     * @param host the host to connect to
     * @param port the port to connect to
     * @return the {@link ECB1v1} object for further usage
     */
    public static ECB1v1 getECB1v1(String host, int port) {
        return new ECB1v1(host, port);
    }

    /**
     * Get the complete current state of the eCB1 charger.
     *
     * @return an {@link AllState} response
     * @see AllState
     */
    public AllState getAllState() {
        return get(new AllState());
    }

    /**
     * Get the current authentication method of the charging controller with the
     * given id.
     *
     * @param id the id of the charging controller
     * @return an {@link ChargeControllerAuthentication} response
     * @see ChargeControllerAuthentication
     */
    public ChargeControllerAuthentication getChargeControllerAuthentication(int id) {
        return get(new ChargeControllerAuthentication(id));
    }

    /**
     * Set the authentication method of the charging controller with the given
     * id.
     *
     * @param id the id of the charging controller
     * @param authentication the
     * {@link ChargeControllerAuthentication.Authentication} to set
     * @return an {@link ChargeControllerAuthentication} response
     * @see ChargeControllerAuthentication
     */
    public ChargeControllerAuthentication setChargeControllerAuthentication(int id, ChargeControllerAuthentication.Authentication authentication) {
        return post(new ChargeControllerAuthentication(id, authentication));
    }

    /**
     * Update the authentication method of the charging controller with the
     * given id.
     *
     * @param id the id of the charging controller
     * @param authentication the
     * {@link ChargeControllerAuthentication.Authentication} to set
     * @return an {@link ChargeControllerAuthentication} response
     * @see ChargeControllerAuthentication
     */
    public ChargeControllerAuthentication updateChargeControllerAuthentication(int id, ChargeControllerAuthentication.Authentication authentication) {
        return put(new ChargeControllerAuthentication(id, authentication));
    }

    /**
     * Get the list of RFID Tags.
     *
     * @return an {@link RFIDTags} response
     * @see RFIDTags
     */
    public RFIDTags getRFIDTags() {
        return get(new RFIDTags());
    }

    /**
     * Get the list of RFID Tags filtered by the given
     * {@link RFIDTagConfig.Type}.
     *
     * @param type the {@link RFIDTagConfig.Type} to filter by, can be null for
     * everything
     * @return an {@link RFIDTags} response
     * @see RFIDTags
     */
    public RFIDTags getRFIDTags(RFIDTagsConfig.Type type) {
        return get(new RFIDTags(type));
    }

    /**
     * Add an RFID Tag.
     *
     * @param uid the id of the RFID Tag
     * @param type the {@link RFIDTagConfig.Type} of the RFID Tag
     * @param description the description
     * @param created the date-time of creation
     * @param modified the date-time of last modification
     * @return an {@link RFIDTagsConfig} response
     * @see RFIDTagsConfig
     */
    public RFIDTagsConfig addRFIDTag(String uid, RFIDTagsConfig.Type type, String description, String created, String modified) {
        return post(new RFIDTagsConfig(uid, type, description, created, modified));
    }

    /**
     * Update an RFID Tag.
     *
     * @param uid the id of the RFID Tag
     * @param type the {@link RFIDTagConfig.Type} of the RFID Tag
     * @param description the description
     * @param modified the date-time of modification
     * @return an {@link RFIDTagsConfig} response
     * @see RFIDTagsConfig
     */
    public RFIDTagsConfig updateRFIDTag(String uid, RFIDTagsConfig.Type type, String description, String modified) {
        return put(new RFIDTagsConfig(uid, type, description, null, modified));
    }

    /**
     * Delete an RFID Tag.
     *
     * @param uid the id of the RFID Tag
     * @return an {@link RFIDTagConfig} response
     * @see RFIDTagConfig
     */
    public RFIDTagConfig deleteRFIDTag(String uid) {
        return delete(new RFIDTagConfig(uid, null, null, null, null));
    }

    /**
     * Get the RFID Tag by the given id.
     *
     * @param id the id of the RFID Tag
     * @return an {@link RFIDTag} response
     * @see RFIDTag
     */
    public RFIDTag getRFIDTag(int id) {
        return get(new RFIDTag(id));
    }

    /**
     * Update an RFID Tag by the given id.
     *
     * @param uid the id of the RFID Tag
     * @param type the {@link RFIDTagConfig.Type} of the RFID Tag
     * @param description the description
     * @param modified the date-time of modification
     * @return an {@link RFIDTagConfig} response
     * @see RFIDTagConfig
     */
    public RFIDTagConfig setRFIDTag(String uid, RFIDTagConfig.Type type, String description, String modified) {
        return post(new RFIDTagConfig(uid, type, description, null, modified));
    }

    /**
     * Get the current maximum current in ampere on the main supply.
     *
     * @return an {@link ChargeControllerMainSupplyMaxCurrent} response
     * @see ChargeControllerMainSupplyMaxCurrent
     */
    public ChargeControllerMainSupplyMaxCurrent getChargeControllerMainSupplyMaxCurrent() {
        return get(new ChargeControllerMainSupplyMaxCurrent());
    }

    /**
     * Set the current maximum current in ampere on the main supply.
     *
     * @param maxCurrent the maximum current to set
     * @return an {@link ChargeControllerMainSupplyMaxCurrent} response
     * @see ChargeControllerMainSupplyMaxCurrent
     */
    public ChargeControllerMainSupplyMaxCurrent setChargeControllerMainSupplyMaxCurrent(int maxCurrent) {
        return post(new ChargeControllerMainSupplyMaxCurrent(maxCurrent));
    }

    /**
     * Update the current maximum current in ampere on the main supply.
     *
     * @param maxCurrent the maximum current to set
     * @return an {@link ChargeControllerMainSupplyMaxCurrent} response
     * @see ChargeControllerMainSupplyMaxCurrent
     */
    public ChargeControllerMainSupplyMaxCurrent updateChargeControllerMainSupplyMaxCurrent(int maxCurrent) {
        return put(new ChargeControllerMainSupplyMaxCurrent(maxCurrent));
    }

    /**
     * Get the current power offset in watt for control of eco mode.
     *
     * @return an {@link ChargeControllerModeEcoPowerOffset} response
     * @see ChargeControllerModeEcoPowerOffset
     */
    public ChargeControllerModeEcoPowerOffset getChargeControllerModeEcoPowerOffset() {
        return get(new ChargeControllerModeEcoPowerOffset());
    }

    /**
     * Set the current power offset in watt for control of eco mode.
     *
     * @param powerOffset the power offset to set
     * @return an {@link ChargeControllerModeEcoPowerOffset} response
     * @see ChargeControllerModeEcoPowerOffset
     */
    public ChargeControllerModeEcoPowerOffset setChargeControllerModeEcoPowerOffset(int powerOffset) {
        return post(new ChargeControllerModeEcoPowerOffset(powerOffset));
    }

    /**
     * Update the current power offset in watt for control of eco mode.
     *
     * @param powerOffset the power offset to set
     * @return an {@link ChargeControllerModeEcoPowerOffset} response
     * @see ChargeControllerModeEcoPowerOffset
     */
    public ChargeControllerModeEcoPowerOffset updateChargeControllerModeEcoPowerOffset(int powerOffset) {
        return put(new ChargeControllerModeEcoPowerOffset(powerOffset));
    }

    /**
     * Get the current state of the charging controllers of the eCB1 charging
     * points.
     *
     * @return an {@link ChargeControllers} response
     * @see ChargeControllers
     */
    public ChargeControllers getChargeControllers() {
        return get(new ChargeControllers());
    }

    /**
     * Get the current state of the charging controllers of the eCB1 charging
     * points, filtered by the given {@link ChargeControllerConfig.Vendor} and
     * {@link ChargeControllerConfig.Type}.
     *
     * @param vendor the vendor to filter by, can be null for everything
     * @param type the type to filter by, can be null for everything
     * @return an {@link ChargeControllers} response
     * @see ChargeControllers
     */
    public ChargeControllers getChargeControllers(ChargeControllerConfig.Vendor vendor, ChargeControllerConfig.Type type) {
        return get(new ChargeControllers(vendor, type));
    }

    /**
     * Get the current state of the charging controller with the given id.
     *
     * @param id the id of the charging controller
     * @return an {@link ChargeController} response
     * @see ChargeController
     */
    public ChargeController getChargeController(int id) {
        return get(new ChargeController(id));
    }

    /**
     * Get the current charging mode of the charging controller with the given
     * id.
     *
     * @param id the id of the charging controller
     * @return an {@link ChargeControllerMode} response
     * @see ChargeControllerMode
     */
    public ChargeControllerMode getChargeControllerMode(int id) {
        return get(new ChargeControllerMode(id));
    }

    /**
     * Set the charging mode of the charging controller with the given id.
     *
     * @param id the id of the charging controller
     * @param mode the {@link ChargeControllerMode.Mode} to set
     * @return an {@link ChargeControllerMode} response
     * @see ChargeControllerMode
     */
    public ChargeControllerMode setChargeControllerMode(int id, ChargeControllerMode.Mode mode) {
        return post(new ChargeControllerMode(id, mode));
    }

    /**
     * Update the charging mode of the charging controller with the given id.
     *
     * @param id the id of the charging controller
     * @param mode the {@link ChargeControllerMode.Mode} to set
     * @return an {@link ChargeControllerMode} response
     * @see ChargeControllerMode
     */
    public ChargeControllerMode updateChargeControllerMode(int id, ChargeControllerMode.Mode mode) {
        return put(new ChargeControllerMode(id, mode));
    }

    /**
     * Get whether charging mode eco automatic charging start and stop is
     * enabled (AI-mode) at the charging controller with the given id.
     *
     * @param id the id of the charging controller
     * @return an {@link ChargeControllerModeEcoStartStop} response
     * @see ChargeControllerModeEcoStartStop
     */
    public ChargeControllerModeEcoStartStop getChargeControllerModeEcoStartStop(int id) {
        return get(new ChargeControllerModeEcoStartStop(id));
    }

    /**
     * Set automatic start and stop at charging controller with given id.
     *
     * @param id the id of the charging controller
     * @param autoStartStop the status of the automatic start and stop to set
     * @return an {@link ChargeControllerModeEcoStartStop} response
     * @see ChargeControllerModeEcoStartStop
     */
    public ChargeControllerModeEcoStartStop setChargeControllerModeEcoStartStop(int id, boolean autoStartStop) {
        return post(new ChargeControllerModeEcoStartStop(id, autoStartStop));
    }

    /**
     * Update automatic start and stop at charging controller with given id.
     *
     * @param id the id of the charging controller
     * @param autoStartStop the status of the automatic start and stop to set
     * @return an {@link ChargeControllerModeEcoStartStop} response
     * @see ChargeControllerModeEcoStartStop
     */
    public ChargeControllerModeEcoStartStop updateChargeControllerModeEcoStartStop(int id, boolean autoStartStop) {
        return put(new ChargeControllerModeEcoStartStop(id, autoStartStop));
    }

    /**
     * Get the delay for automatic charging start and stop at the charging
     * controller with the given id.
     *
     * @param id the id of the charging controller
     * @return an {@link ChargeControllerModeEcoStartStopDelay} response
     * @see ChargeControllerModeEcoStartStopDelay
     */
    public ChargeControllerModeEcoStartStopDelay getChargeControllerModeEcoStartStopDelay(int id) {
        return get(new ChargeControllerModeEcoStartStopDelay(id));
    }

    /**
     * Set the delay for automatic charging start and stop at the charging
     * controller with the given id.
     *
     * @param id the id of the charging controller
     * @param delay the delay to set in seconds
     * @return an {@link ChargeControllerModeEcoStartStopDelay} response
     * @see ChargeControllerModeEcoStartStopDelay
     */
    public ChargeControllerModeEcoStartStopDelay setChargeControllerModeEcoStartStopDelay(int id, double delay) {
        return post(new ChargeControllerModeEcoStartStopDelay(id, delay));
    }

    /**
     * Update the delay for automatic charging start and stop at the charging
     * controller with the given id.
     *
     * @param id the id of the charging controller
     * @param delay the delay to set in seconds
     * @return an {@link ChargeControllerModeEcoStartStopDelay} response
     * @see ChargeControllerModeEcoStartStopDelay
     */
    public ChargeControllerModeEcoStartStopDelay updateChargeControllerModeEcoStartStopDelay(int id, double delay) {
        return put(new ChargeControllerModeEcoStartStopDelay(id, delay));
    }

    /**
     * Get the current manual ampere setting of the charging controller with the
     * given id.
     *
     * @param id the id of the charging controller
     * @return an {@link ChargeControllerModeManualAmpere} response
     * @see ChargeControllerModeManualAmpere
     */
    public ChargeControllerModeManualAmpere getChargeControllerModeManualAmpere(int id) {
        return get(new ChargeControllerModeManualAmpere(id));
    }

    /**
     * Set the current manual ampere of the charging controller with the given
     * id.
     *
     * @param id the id of the charging controller
     * @param manualModeAmp the manual ampere to set
     * @return an {@link ChargeControllerModeManualAmpere} response
     * @see ChargeControllerModeManualAmpere
     */
    public ChargeControllerModeManualAmpere setChargeControllerModeManualAmpere(int id, double manualModeAmp) {
        return post(new ChargeControllerModeManualAmpere(id, manualModeAmp));
    }

    /**
     * Update the current manual ampere of the charging controller with the
     * given id.
     *
     * @param id id the id of the charging controller
     * @param manualModeAmp the manual ampere to set
     * @return an {@link ChargeControllerModeManualAmpere} response
     * @see ChargeControllerModeManualAmpere
     */
    public ChargeControllerModeManualAmpere updateChargeControllerModeManualAmpere(int id, double manualModeAmp) {
        return put(new ChargeControllerModeManualAmpere(id, manualModeAmp));
    }

    /**
     * Get the status if an Residual Current Monitoring (RCM) module is
     * configured at the charging controller with the given id.
     *
     * @param id the id of the charging controller
     * @return an {@link ChargeControllerRCM} response
     * @see ChargeControllerRCM
     */
    public ChargeControllerRCM deleteChargeControllerRCM(int id) {
        return delete(new ChargeControllerRCM(id));
    }

    /**
     * Set the Residual Current Monitoring (RCM) module for the charging
     * controller with the given id.
     *
     * @param id the id of the charging controller
     * @return an {@link ChargeControllerRCM} response
     * @see ChargeControllerRCM
     */
    public ChargeControllerRCM getChargeControllerRCM(int id) {
        return get(new ChargeControllerRCM(id));
    }

    /**
     * Delete the Residual Current Monitoring (RCM) module for the charging
     * controller with the given id.
     *
     * @param id the id of the charging controller
     * @return an {@link ChargeControllerRCM} response
     * @see ChargeControllerRCM
     */
    public ChargeControllerRCM setChargeControllerRCM(int id) {
        return post(new ChargeControllerRCM(id));
    }

    /**
     * Perform an action on the charging controller with the given id.
     *
     * @param id the id of the charging controller
     * @param action the {@link ChargeControllerAction.Action} to perform
     * @return an {@link ChargeControllerAction} response
     * @see ChargeControllerAction
     */
    public ChargeControllerAction setChargeControllerAction(int id, ChargeControllerAction.Action action) {
        return post(new ChargeControllerAction(id, action));
    }

    /**
     * Get the current data of all measuring points.
     *
     * @return an {@link MeasuringPoints} response
     * @see MeasuringPoints
     */
    public MeasuringPoints getMeasuringPoints() {
        return get(new MeasuringPoints());
    }

    /**
     * Get the current data of all measuring points, filtered by
     * {@link MeterConfig.Vendor}, {@link MeterConfig.Type} and
     * {@link MeterConfig.Function}.
     *
     * @param vendor the vendor to filter by, can be null for everything
     * @param type the type to filter by, can be null for everything
     * @param function the function to filter by, can be null for everything
     * @return an {@link MeasuringPoints} response
     * @see MeasuringPoints
     */
    public MeasuringPoints getMeasuringPoints(MeterConfig.Vendor vendor, MeterConfig.Type type, MeterConfig.Function function) {
        return get(new MeasuringPoints(vendor, type, function));
    }

    /**
     * Get the current data of the measuring point with the given id.
     *
     * @param id the id of the measuring point
     * @return an {@link MeasuringPoint} response
     * @see MeasuringPoint
     */
    public MeasuringPoint getMeasuringPoint(int id) {
        return get(new MeasuringPoint(id));
    }

    /**
     * Get the current PV charging mode.
     *
     * @return an {@link PVMode} response
     * @see PVMode
     */
    public PVMode getPVMode() {
        return get(new PVMode());
    }

    /**
     * Set the PV charging mode to the given one.
     *
     * @param pvMode the {@link PVMode.Mode} to set to
     * @return an {@link PVMode} response
     * @see PVMode
     */
    public PVMode setPVMode(PVMode.Mode pvMode) {
        return post(new PVMode(pvMode));
    }

    /**
     * Update the PV charging mode to the given one.
     *
     * @param pvMode the {@link PVMode.Mode} to set to
     * @return an {@link PVMode} response
     * @see PVMode
     */
    public PVMode updatePVMode(PVMode.Mode pvMode) {
        return put(new PVMode(pvMode));
    }

}
