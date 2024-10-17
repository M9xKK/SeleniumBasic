package base;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestData {
    private Settings settings;
    @JsonProperty("user_settings")
    private UserSettings userSettings;
    private Messages messages;
    private Logger logger = LoggerFactory.getLogger(TestData.class);


    public Settings getSettings() {
        logger.info("Settings loaded!");
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
        logger.info("Settings changed!");
    }

    public UserSettings getUserSettings() {
        logger.info("User settings loaded!");
        return userSettings;
    }

    public void setUserSettings(UserSettings userSettings) {
        logger.info("User settings saved!");
        this.userSettings = userSettings;
    }

    public Messages getMessages() {
        logger.info("Message collected " + messages + " from configuration file");
        return messages;
    }

    public void setMessages(Messages messages) {
        logger.info("Message changed to: " + messages + " !");
        this.messages = messages;
    }

    public static class Settings {
        private String browser;

        public String getBrowser() {
            return browser;
        }

        public void setBrowser(String browser) {
            this.browser = browser;
        }
    }

    public static class UserSettings {
        private String email;
        private String path;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path){
            this.path = path;
        }
    }

    public static class Messages {
        private String numerical_short;
        private String numerical_long;
        private String string_short;
        private String string_long_one_line;
        private String string_long_multiple_lines;

        public String getNumerical_short() {
            return numerical_short;
        }

        public void setNumerical_short(String numerical_short) {
            this.numerical_short = numerical_short;
        }

        public String getNumerical_long() {
            return numerical_long;
        }

        public void setNumerical_long(String numerical_long) {
            this.numerical_long = numerical_long;
        }

        public String getString_short() {
            return string_short;
        }

        public void setString_short(String string_short) {
            this.string_short = string_short;
        }

        public String getString_long_one_line() {
            return string_long_one_line;
        }

        public void setString_long_one_line(String string_long_one_line) {
            this.string_long_one_line = string_long_one_line;
        }

        public String getString_long_multiple_lines() {
            return string_long_multiple_lines;
        }

        public void setString_long_multiple_lines(String string_long_multiple_lines) {
            this.string_long_multiple_lines = string_long_multiple_lines;
        }
    }
}
