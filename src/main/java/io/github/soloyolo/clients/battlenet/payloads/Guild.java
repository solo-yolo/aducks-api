package io.github.soloyolo.clients.battlenet.payloads;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class Guild {

    String name;
    int memberCount;
    int achievementPoints;
    long createdTimestamp;
    NameType faction;
    Realm realm;
    Crest crest;

}
