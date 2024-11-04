package base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configurations.ApplicationConfig;

import java.io.File;

public class ConfigLoader {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            ApplicationConfig appConfig = mapper.readValue(new File("src/test/resources/configuration.yaml"), ApplicationConfig.class);

            // Możesz teraz uzyskać dostęp do wszystkich elementów konfiguracyjnych
            System.out.println(appConfig.getConfig().getEnv().get("dev").getEmail());
            System.out.println(appConfig.getBrowserOptions().getOptions().get("chrome").getArguments());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
