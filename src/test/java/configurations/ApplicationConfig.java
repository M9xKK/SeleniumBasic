package configurations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicationConfig {
    private Config config;
    private BrowserOptions browserOptions;
    private Messages messages;

    @JsonProperty("env")
    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    @JsonProperty("browser_options")
    public BrowserOptions getBrowserOptions() {
        return browserOptions;
    }

    public void setBrowserOptions(BrowserOptions browserOptions) {
        this.browserOptions = browserOptions;
    }

    @JsonProperty("messages")
    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }
}
