package io.github.soloyolo.clients.battlenet;


import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "battlenet-oauth",
        url = "${clients.battlenet-oauth.url}",
        configuration = OAuthClient.Config.class)
public interface OAuthClient {

    String GRANT_TYPE = "grant_type=client_credentials";

    default TokenResponse token() {
        return token(GRANT_TYPE);
    }

    @PostMapping(value = "/token", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    TokenResponse token(@RequestBody String body);


    @Data
    @JsonNaming(SnakeCaseStrategy.class)
    class TokenResponse {

        String accessToken;
        String tokenType;
        int expiresIn;
    }

    class Config {

        @Bean
        RequestInterceptor authInterceptor(
                @Value("${clients.battlenet-oauth.clientId}") String clientId,
                @Value("${clients.battlenet-oauth.clientSecret}") String clientSecret) {
            return new BasicAuthRequestInterceptor(clientId, clientSecret);
        }

    }
}
