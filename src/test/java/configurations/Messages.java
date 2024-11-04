package configurations;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;
import java.util.Map;

public class Messages {
    private Map<String, String> messages = new HashMap<>();

    @JsonAnyGetter
    public Map<String, String> getMessages() {
        return messages;
    }

    @JsonAnySetter
    public void setMessages(String key, String value) {
        messages.put(key, value);
    }
}
