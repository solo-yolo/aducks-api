package io.github.soloyolo.clients.battlenet;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.soloyolo.clients.battlenet.payloads.Asset;
import io.github.soloyolo.clients.battlenet.payloads.MediaResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MediaClient {

    private final AccessTokenStore tokenStore;
    private final ObjectMapper mapper;
    private final HttpClient client = HttpClient.newHttpClient();

    @SneakyThrows
    public String getMedia(String key, String type) {
        HttpRequest request = HttpRequest.newBuilder(new URI(key))
                .header("Authorization", "Bearer " + tokenStore.token())
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        MediaResponse mediaResponse = mapper.readValue(response.body(), MediaResponse.class);
        return mediaResponse.getAssets().stream()
                .filter(a -> a.getKey().equals(type))
                .findFirst()
                .map(Asset::getValue)
                .orElse("n/a");

    }

}
