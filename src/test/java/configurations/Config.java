package configurations;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private Map<String, Environment> env = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Environment> getEnv() {
        return env;
    }

    @JsonAnySetter
    public void setEnv(String key, Environment value) {
        env.put(key, value);
    }

    public static class Environment {
        @JsonProperty("browser")
        private String browser;

        @JsonProperty("email")
        private String email;

        @JsonProperty("path_linux")
        private String pathLinux;

        @JsonProperty("path_windows")
        private String pathWindows;

        public String getBrowser(){
            return this.browser;
        }

        public void setBrowser(String browser){
            this.browser = browser;
        }

        public String getEmail(){
            return this.email;
        }

        public void setEmail(String email){
            this.email = email;
        }

        public String getPathLinux(){
            return this.pathLinux;
        }

        public void setPathLinux(String pathLinux){
            this.pathLinux = pathLinux;
        }

        public String getPathWindows(){
            return this.pathWindows;
        }

        public void setPathWindows(String pathWindows) {
            this.pathWindows = pathWindows;
        }
    }
}
