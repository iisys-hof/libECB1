package de.iisys.smartgrids.libecb1.api.v1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Meter data.
  */
public class MeterConfig {

    /**
     * Enumeration, which consists of functions.<br>
     * Used as a filter to get the current data of all measuring points.
     */
    @XmlEnum
    public enum Function {
        @XmlEnumValue("main")
        MAIN,
        @XmlEnumValue("socket")
        SOCKET,
        @XmlEnumValue("heater")
        HEATER,
    }

    /**
     * Enumeration, which consists of vendors.<br>
     * Used as a filter to get the current data of all measuring points.
     */
    @XmlEnum
    public enum Vendor {
        @XmlEnumValue("eCHARGE")
        E_CHARGE,
        @XmlEnumValue("B-Control")
        B_CONTROL,
        @XmlEnumValue("IME")
        IME,
        @XmlEnumValue("Phoenix Contact")
        PHOENIX_CONTACT,
        @XmlEnumValue("SMA")
        SMA,
    }

    /**
     * Enumeration, which consists of types.<br>
     * Used as a filter to get the current data of all measuring points.
     */
    @XmlEnum
    public enum Type {
        @XmlEnumValue("eCB1 intern")
        ECB1_INTERN,
        @XmlEnumValue("eCB1 extern")
        ECB1_EXTERN,
        @XmlEnumValue("Energymeter")
        ENERGYMETER,
        @XmlEnumValue("EnergyManager")
        ENERGYMANAGER,
        @XmlEnumValue("EEM-350-D-MCB")
        EEM_350_D_MCB,
    }

    /**
     * The id of the charging controller.<br>
     * Mandatory variable for XML.
     */
    @XmlElement(name = "id", required = true)
    private int id;

    /**
     * Used as a filter to get the current data of all measuring points.
     */
    @XmlElement(name = "vendor")
    private Vendor vendor;

    /**
     * Used as a filter to get the current data of all measuring points. <br>
     * Mandatory variable for XML.
     */
    @XmlElement(name = "type", required = true)
    private Type type;

    /**
     * Used as a filter to get the current data of all measuring points. <br>
     * Mandatory variable for XML.
     */
    @XmlElement(name = "function", required = true)
    private Function function;

    /**
     * The meter data name.
     */
    @XmlElement(name = "name")
    private String name;

    /**
     * The meter data serial number.
     */
    @XmlElement(name = "serial")
    private int serial;

    /**
     * Meter data ip address.
     */
    @XmlElement(name = "ipaddress")
    private String ipAddress;

    /**
     * Reference to {@link MeterStatus}.<br>
     */
    @XmlElement(name = "data")
    private MeterStatus data;

    /**
     * Default constructor.
     */
    public MeterConfig() {
    }

    public int getId() {
        return id;
    }

    /**
     * get the {@link Vendor}.
     *
     * @return {@link #vendor}
     * @see #vendor
     */
    public Vendor getVendor() {
        return vendor;
    }

    /**
     * get the {@link Type}.
     *
     * @return {@link #type}
     * @see #type
     */
    public Type getType() {
        return type;
    }

    /**
     * get the {@link Function}.
     *
     * @return {@link #function}
     * @see #function
     */
    public Function getFunction() {
        return function;
    }

    public String getName() {
        return name;
    }

    public int getSerial() {
        return serial;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * get the current {@link MeterStatus}.
     *
     * @return {@link #data}
     * @see #data
     */
    public MeterStatus getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MeterConfig{" + "id=" + id + ", vendor=" + vendor + ", type=" + type + ", function=" + function + ", name=" + name + ", serial=" + serial + ", ipAddress=" + ipAddress + ", data=" + data + '}';
    }

    /**
     * Concrete adaption of OBIS names to variables. A bug in the underlying
     * library implementation requires to add "xml:" in front of each OBIS name
     * that has a ':' within. The problem lies within the namespace parser that
     * recognizes a namespace because of the ':' within a regular OBIS name. By
     * preceding each OBIS name with "xml:", the namespace parser is satisfied
     * and ignores the namespace, so that the OBIS name itself is fully taken.
     * "xml:1-0:1.4.0" is interpreted as "1-0:1.4.0" this way and so, the
     * mapping works flawless.
     */
    public static class MeterStatus {

        /**
         * The current load.
         */
        @XmlElement(name = "lgwb")
        private double currentLoad;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 1 - active energy consuming(+)<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:1.4.0")
        private double activePowerConsuming;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 1 - active energy consumed(+)<br>
         * Type of measurement: 8 - time integral 1<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:1.8.0")
        private double activeEnergyConsumed;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 2 - active power producing (-)<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:2.4.0")
        private double activePowerProducing;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 2 - active energy produced (-)<br>
         * Type of measurement: 8 - time integral 1<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:2.8.0")
        private double activeEnergyProduced;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 13 - power factor<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:13.4.0")
        private double powerFactor;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 21 - active power consuming phase 1<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:21.4.0")
        private double activePowerConsumingPhase1;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 21 - active power consumed phase 1<br>
         * Type of measurement: 8 - time integral 1<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:21.8.0")
        private double activeEnergyConsumedPhase1;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 22 - active power producing phase 1<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:22.4.0")
        private double activePowerProducingPhase1;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 22 - active energy produced phase 1<br>
         * Type of measurement: 8 - time integral 1<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:22.8.0")
        private double activeEnergyProducedPhase1;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 31 - current phase 1<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:31.4.0")
        private double currentPhase1;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 32 - voltage phase 1<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:32.4.0")
        private double voltagePhase1;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 33 - power factor phase 1<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:33.4.0")
        private double powerFactorPhase1;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 41 - active power consuming phase 2<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:41.4.0")
        private double activePowerConsumingPhase2;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 41 - active energy consumed phase 2<br>
         * Type of measurement: 8 - time integral 1<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:41.8.0")
        private double activeEnergyConsumedPhase2;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 42 - active power producing phase 2<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:42.4.0")
        private double activePowerProducingPhase2;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 42 - active power producing phase 2<br>
         * Type of measurement: 8 - time integral 1<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:42.8.0")
        private double activeEnergyProducedPhase2;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 51 - current phase 2<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:51.4.0")
        private double currentPhase2;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 52 - voltage phase 2<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:52.4.0")
        private double voltagePhase2;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 53 - power factor phase 2<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:53.4.0")
        private double powerFactorPhase2;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 61 - active power consuming phase 3<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:61.4.0")
        private double activePowerConsumingPhase3;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 61 - active energy consumed phase 3<br>
         * Type of measurement: 8 - time integral 1<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:61.8.0")
        private double activeEnergyConsumedPhase3;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 62 - active power producing phase 3<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:62.4.0")
        private double activePowerProducingPhase3;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 61 - active energy produced phase 3<br>
         * Type of measurement: 8 - time integral 1<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:62.8.0")
        private double activeEnergyProducedPhase3;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 71 - current phase 3<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:71.4.0")
        private double currentPhase3;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 72 - voltage phase 3<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:72.4.0")
        private double voltagePhase3;

        /**
         * Medium: 1 - electricity<br>
         * Channel: 0 - determined with preliminary calorific value<br>
         * Measurand: 73 - power factor phase 3<br>
         * Type of measurement: 4 - profile crowd in kW<br>
         * Tariff level: 0 - without pay scale
         */
        @XmlElement(name = "xml:1-0:73.4.0")
        private double powerFactorPhase3;

        /**
         * Default constructor.
         */
        public MeterStatus() {
        }

        public double getCurrentLoad() {
            return currentLoad;
        }

        public double getActivePowerConsuming() {
            return activePowerConsuming;
        }

        public double getActiveEnergyConsumed() {
            return activeEnergyConsumed;
        }

        public double getActivePowerProducing() {
            return activePowerProducing;
        }

        public double getActiveEnergyProduced() {
            return activeEnergyProduced;
        }

        public double getPowerFactor() {
            return powerFactor;
        }

        public double getActivePowerConsumingPhase1() {
            return activePowerConsumingPhase1;
        }

        public double getActiveEnergyConsumedPhase1() {
            return activeEnergyConsumedPhase1;
        }

        public double getActivePowerProducingPhase1() {
            return activePowerProducingPhase1;
        }

        public double getActiveEnergyProducedPhase1() {
            return activeEnergyProducedPhase1;
        }

        public double getCurrentPhase1() {
            return currentPhase1;
        }

        public double getVoltagePhase1() {
            return voltagePhase1;
        }

        public double getPowerFactorPhase1() {
            return powerFactorPhase1;
        }

        public double getActivePowerConsumingPhase2() {
            return activePowerConsumingPhase2;
        }

        public double getActiveEnergyConsumedPhase2() {
            return activeEnergyConsumedPhase2;
        }

        public double getActivePowerProducingPhase2() {
            return activePowerProducingPhase2;
        }

        public double getActiveEnergyProducedPhase2() {
            return activeEnergyProducedPhase2;
        }

        public double getCurrentPhase2() {
            return currentPhase2;
        }

        public double getVoltagePhase2() {
            return voltagePhase2;
        }

        public double getPowerFactorPhase2() {
            return powerFactorPhase2;
        }

        public double getActivePowerConsumingPhase3() {
            return activePowerConsumingPhase3;
        }

        public double getActiveEnergyConsumedPhase3() {
            return activeEnergyConsumedPhase3;
        }

        public double getActivePowerProducingPhase3() {
            return activePowerProducingPhase3;
        }

        public double getActiveEnergyProducedPhase3() {
            return activeEnergyProducedPhase3;
        }

        public double getCurrentPhase3() {
            return currentPhase3;
        }

        public double getVoltagePhase3() {
            return voltagePhase3;
        }

        public double getPowerFactorPhase3() {
            return powerFactorPhase3;
        }

        @Override
        public String toString() {
            return "MeterStatus{" + "currentLoad=" + currentLoad + ", activePowerConsuming=" + activePowerConsuming + ", activeEnergyConsumed=" + activeEnergyConsumed + ", activePowerProducing=" + activePowerProducing + ", activeEnergyProduced=" + activeEnergyProduced + ", powerFactor=" + powerFactor + ", activePowerConsumingPhase1=" + activePowerConsumingPhase1 + ", activeEnergyConsumedPhase1=" + activeEnergyConsumedPhase1 + ", activePowerProducingPhase1=" + activePowerProducingPhase1 + ", activeEnergyProducedPhase1=" + activeEnergyProducedPhase1 + ", currentPhase1=" + currentPhase1 + ", voltagePhase1=" + voltagePhase1 + ", powerFactorPhase1=" + powerFactorPhase1 + ", activePowerConsumingPhase2=" + activePowerConsumingPhase2 + ", activeEnergyConsumedPhase2=" + activeEnergyConsumedPhase2 + ", activePowerProducingPhase2=" + activePowerProducingPhase2 + ", activeEnergyProducedPhase2=" + activeEnergyProducedPhase2 + ", currentPhase2=" + currentPhase2 + ", voltagePhase2=" + voltagePhase2 + ", powerFactorPhase2=" + powerFactorPhase2 + ", activePowerConsumingPhase3=" + activePowerConsumingPhase3 + ", activeEnergyConsumedPhase3=" + activeEnergyConsumedPhase3 + ", activePowerProducingPhase3=" + activePowerProducingPhase3 + ", activeEnergyProducedPhase3=" + activeEnergyProducedPhase3 + ", currentPhase3=" + currentPhase3 + ", voltagePhase3=" + voltagePhase3 + ", powerFactorPhase3=" + powerFactorPhase3 + '}';
        }

    }

}
