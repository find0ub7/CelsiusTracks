package br.com.ifood.challenge.celsiustracks.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "openweathermap")
public class OpenWeatherMapProperties {
    private String appId;
}
