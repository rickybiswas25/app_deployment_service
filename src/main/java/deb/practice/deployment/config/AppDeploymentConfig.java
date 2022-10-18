package deb.practice.deployment.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app.config")
public class AppDeploymentConfig {
    private String welComeMessageFormat;

    public String getWelComeMessageFormat() {
        return welComeMessageFormat;
    }

    public void setWelComeMessageFormat(String welComeMessageFormat) {
        this.welComeMessageFormat = welComeMessageFormat;
    }
}
