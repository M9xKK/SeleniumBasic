package configurations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationConfig {
    private Config config;
    private BrowserOptions browserOptions;
    private Messages messages;
    private Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);


    @JsonProperty("env")
    public Config getConfig() {
        logger.info("environment configuration loaded");
        return config;
    }

    public void setConfig(Config config) {
        logger.info("environment configuration changed");
        this.config = config;
    }

    @JsonProperty("browser_options")
    public BrowserOptions getBrowserOptions() {
        logger.info("browser configuration loaded");
        return browserOptions;
    }

    public void setBrowserOptions(BrowserOptions browserOptions) {
        logger.info("browser configuration modified");
        this.browserOptions = browserOptions;
    }

    @JsonProperty("messages")
    public Messages getMessages() {
        logger.info("messages loaded");
        return messages;
    }

    public void setMessages(Messages messages) {
        logger.info("messages changed");
        this.messages = messages;
    }
}
