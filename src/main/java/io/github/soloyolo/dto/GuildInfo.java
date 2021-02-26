package io.github.soloyolo.dto;

import lombok.Value;

@Value
public class GuildInfo {

    String name;
    String realm;
    String faction;

    int memberCount;
    int achievementPoints;
    long created;

}
