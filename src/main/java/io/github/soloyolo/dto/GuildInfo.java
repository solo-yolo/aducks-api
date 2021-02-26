package io.github.soloyolo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GuildInfo {

    String name;
    String realm;
    String faction;

    int memberCount;
    int achievementPoints;
    long created;

    Crest crest;

}
