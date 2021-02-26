package io.github.soloyolo.clients.battlenet.payloads;

import java.util.List;
import lombok.Data;

@Data
public class MediaResponse {

    int id;
    List<Asset> assets;
}
