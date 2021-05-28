package com.findbook.demo.security.config;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaypalConfig {
    @Value("${paypal.client.id}")
    private String clientId;
    @Value("${paypal.client.secret}")
    private String clientSecret;
    @Value("${paypal.client.mode}")
    private String mode;

    @Bean
    public Map<String, String> paypalSdkConfig() {
        Map<String, String> configMap = new HashMap<String, String>();
        configMap.put("mode", mode);
        return configMap;
    }

    //Esto viene desde "paypal"
    @Bean
    public OAuthTokenCredential oAuthTokenCredential() {
        return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
    }

    //Viene de paypal
    @SneakyThrows
    @Bean
    public APIContext apiContext() {
        APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
        context.setConfigurationMap(paypalSdkConfig());
        return apiContext();
    }
}
