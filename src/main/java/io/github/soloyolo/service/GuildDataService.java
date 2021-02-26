package io.github.soloyolo.service;

import io.github.soloyolo.clients.battlenet.BattlenetClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GuildDataService {

    private static final String NAMESPACE = "profile-eu";

    private final BattlenetClient api;
    private final String guildName;
    private final String realmSlug;

    public Object getGuildData() {
        return api.getGuildInfo(realmSlug, guildName, NAMESPACE);
    }

}
