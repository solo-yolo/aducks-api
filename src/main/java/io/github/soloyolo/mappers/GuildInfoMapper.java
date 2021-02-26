package io.github.soloyolo.mappers;

import io.github.soloyolo.clients.battlenet.payloads.Guild;
import io.github.soloyolo.dto.GuildInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GuildInfoMapper {

    GuildInfoMapper INSTANCE = Mappers.getMapper(GuildInfoMapper.class);

    @Mapping(source = "faction.name", target = "faction")
    @Mapping(source = "realm.name", target = "realm")
    @Mapping(source = "createdTimestamp", target = "created")
    @Mapping(target = "crest", ignore = true)
    GuildInfo convert(Guild guild);

}
