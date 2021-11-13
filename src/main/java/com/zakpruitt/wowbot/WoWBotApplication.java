package com.zakpruitt.wowbot;

import com.zakpruitt.wowbot.Listeners.ItemListener;
import com.zakpruitt.wowbot.Listeners.PingListener;
import com.zakpruitt.wowbot.Listeners.RaceListener;
import com.zakpruitt.wowbot.Listeners.RateListener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class WoWBotApplication {

	@Autowired
	private Environment env;

	@Autowired
	PingListener pingListener;
	@Autowired
	RateListener rateListener;
	@Autowired
	RaceListener raceListener;
	@Autowired
	ItemListener itemListener;

	public static void main(String[] args) {
		SpringApplication.run(WoWBotApplication.class, args);
	}

	@Bean
	@ConfigurationProperties(value = "discord-api")
	public DiscordApi discordApi() {
		String token = env.getProperty("TOKEN");
		DiscordApi api = new DiscordApiBuilder().setToken(token)
				.setAllNonPrivilegedIntents()
				.login()
				.join();

		api.addMessageCreateListener(pingListener);
		api.addMessageCreateListener(rateListener);
		api.addMessageCreateListener(raceListener);
		api.addMessageCreateListener(itemListener);

		return api;
	}
}
