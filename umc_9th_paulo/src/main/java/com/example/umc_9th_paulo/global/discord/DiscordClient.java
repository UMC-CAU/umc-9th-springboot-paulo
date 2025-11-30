package com.example.umc_9th_paulo.global.discord;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "discord-client",
        url = "${DISCORD_WEBHOOK_URL}")
public interface DiscordClient {

    @PostMapping()
    void sendAlarm(@RequestBody DiscordMessage message);
}