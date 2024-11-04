package configurations;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrowserOptions {
    private Map<String, BrowserArguments> options = new HashMap<>();
    private Logger logger = LoggerFactory.getLogger(BrowserOptions.class);

    @JsonAnyGetter
    public Map<String, BrowserArguments> getOptions() {
        return options;
    }

    @JsonAnySetter
    public void setOptions(String key, BrowserArguments value) {
        options.put(key, value);
    }

    public static class BrowserArguments {
        private List<String> arguments;

        // Getter and Setter
        public List<String> getArguments() {
            return arguments;
        }

        public void setArguments(List<String> arguments) {
            this.arguments = arguments;
        }
    }
}
