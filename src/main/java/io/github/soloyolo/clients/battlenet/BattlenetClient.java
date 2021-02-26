package io.github.soloyolo.clients.battlenet;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "battlenet-client", url = "${clients.battlenet-client.url}", configuration = BattlenetClient.Config.class)
public interface BattlenetClient {

    @GetMapping("/data/wow/guild/{realm}/{name}")
    Object getGuildInfo(
            @PathVariable("realm") String realm, @PathVariable("name") String name, @RequestHeader("Battlenet-Namespace") String namespace);


    class Config {

        @Bean
        RequestInterceptor authRequestInterceptor(AccessTokenStore tokenStore) {
            return template -> template.header("Authorization", "Bearer " + tokenStore.token());
        }

        @Bean
        RequestInterceptor localeRequestInterceptor() {
            return template -> template.query("locale", "ru_RU");
        }
    }

}
