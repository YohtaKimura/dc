package dc1_4;

public class DigitalClock {
       public static void main(String[] args) {
        new DigitalClockCanvas("DC");
    }

       protected static DigitalClockConfiguration getConfiguration() {
        return new ConfigurationPreferences();
    }
}
