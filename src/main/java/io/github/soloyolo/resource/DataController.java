package io.github.soloyolo.resource;

import io.github.soloyolo.service.GuildDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin //TODO: specify actual domains
public class DataController {

    private final GuildDataService guildDataService;

    @GetMapping("/guild/info")
    Object getGuildInfo() {
        return guildDataService.getGuildData();
    }
}
