package io.github.soloyolo.service;

import io.github.soloyolo.clients.battlenet.BattlenetClient;
import io.github.soloyolo.clients.battlenet.payloads.Guild;
import io.github.soloyolo.dto.GuildInfo;
import io.github.soloyolo.mappers.GuildInfoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GuildDataService {

    private static final String NAMESPACE = "profile-eu";

    private final BattlenetClient api;
    private final String guildName;
    private final String realmSlug;

    public GuildInfo getGuildData() {
        Guild guildInfo = api.getGuildInfo(realmSlug, guildName, NAMESPACE);
        return GuildInfoMapper.INSTANCE.convert(guildInfo);
    }

}
