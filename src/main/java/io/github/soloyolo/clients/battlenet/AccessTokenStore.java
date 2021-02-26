package io.github.soloyolo.clients.battlenet;


import io.github.soloyolo.clients.battlenet.OAuthClient.TokenResponse;
import java.time.Instant;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccessTokenStore {

    private final OAuthClient client;
    private Instant expiresAt = Instant.now();
    private String token;

    @PostConstruct
    void init() {
        token();
        log.info("successfully requested a token");
    }

    public String token() {
        if (Instant.now().isAfter(expiresAt)) {
            requestFreshToken();
        }
        return token;
    }

    void requestFreshToken() {
        TokenResponse response = client.token();
        token = response.getAccessToken();
        expiresAt = Instant.now().plusSeconds(response.getExpiresIn());
    }
}
