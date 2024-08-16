package com.example.inbound.test.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Base64;
import java.util.Map;

@Service
public class OAuth2TokenService {

    private final RestTemplate restTemplate;

    public OAuth2TokenService() {
        this.restTemplate = new RestTemplate(getClientHttpRequestFactory());
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);
        return factory;
    }

    public String getAccessToken(String clientId, String clientSecret, String tokenUrl) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getBasicAuthHeader(clientId, clientSecret));
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(tokenUrl)
                .queryParam("grant_type", "client_credentials");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                builder.toUriString(), HttpMethod.POST, entity, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> body = response.getBody();
            if (body != null && body.containsKey("access_token")) {
                return body.get("access_token").toString();
            }
        }

        throw new RuntimeException("Failed to get access token");
    }

    private String getBasicAuthHeader(String clientId, String clientSecret) {
        String auth = clientId + ":" + clientSecret;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
        return "Basic " + new String(encodedAuth);
    }
}