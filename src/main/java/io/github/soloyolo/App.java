package io.github.soloyolo;

import io.github.soloyolo.clients.battlenet.BattlenetClient;
import io.github.soloyolo.service.GuildDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args)
                .getBean(BattlenetClient.class)
                .getGuildInfo("howling-fjord", "аутята", "profile-eu");
    }

    @Bean
    GuildDataService guildDataService(BattlenetClient battlenetClient,
            @Value("${config.guild-name}") String guildName,
            @Value("${config.realm}") String realmSlug) {
        return new GuildDataService(battlenetClient, guildName, realmSlug);
    }

}
