package pl.lderecki.gusapiconsumer.configuration;

import lombok.Getter;

@Getter
public class EnvironmentVariablesLoader {

    private static EnvironmentVariablesLoader instance;
    private final String apiKey;

    private EnvironmentVariablesLoader() {
        apiKey = System.getenv("API_KEY");
    }

    public static EnvironmentVariablesLoader getInstance() {
        if (instance == null)
            instance = new EnvironmentVariablesLoader();

        return instance;
    }
}
