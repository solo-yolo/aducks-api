package io.github.soloyolo.service;

import io.github.soloyolo.clients.battlenet.BattlenetClient;
import io.github.soloyolo.clients.battlenet.MediaClient;
import io.github.soloyolo.clients.battlenet.payloads.Crest;
import io.github.soloyolo.clients.battlenet.payloads.Guild;
import io.github.soloyolo.clients.battlenet.payloads.Rgba;
import io.github.soloyolo.dto.GuildInfo;
import io.github.soloyolo.mappers.GuildInfoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GuildDataService {

    private static final String NAMESPACE = "profile-eu";

    private final BattlenetClient api;
    private final MediaClient mediaClient;
    private final String guildName;
    private final String realmSlug;

    static String toString(Rgba rgba) {
        return String.format("rgba(%d,%d,%d,%.2f)", rgba.getR(), rgba.getG(), rgba.getB(), rgba.getA());
    }

    public GuildInfo getGuildData() {
        Guild guildInfo = api.getGuildInfo(realmSlug, guildName, NAMESPACE);
        mediaClient.getMedia("https://eu.api.blizzard.com/data/wow/media/guild-crest/border/3?namespace=static-9.0.2_36532-eu",
                "image");

        GuildInfo info = GuildInfoMapper.INSTANCE.convert(guildInfo);

        Crest crest = guildInfo.getCrest();
        if (crest != null) {
            info.setCrest(io.github.soloyolo.dto.Crest.builder()
                    .backgroundColor(toString(crest.getBackground().getColor().getRgba()))
                    .emblemColor(toString(crest.getEmblem().getColor().getRgba()))
                    .borderColor(toString(crest.getBorder().getColor().getRgba()))
                    .emblem(mediaClient.getMedia(crest.getEmblem().getMedia().getKey().getHref(), "image"))
                    .border(mediaClient.getMedia(crest.getBorder().getMedia().getKey().getHref(), "image"))
                    .build());
        }

        return info;
    }

}
