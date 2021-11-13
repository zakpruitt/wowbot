package com.zakpruitt.wowbot.Listeners.Implementations;

import com.zakpruitt.wowbot.Listeners.RaceListener;
import com.zakpruitt.wowbot.Services.MessagingService;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class RaceListenerImplementation implements RaceListener {

    private static boolean active = false;

    @Autowired
    private MessagingService messagingService;

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().equals("!race")) {
            AtomicBoolean active = new AtomicBoolean(false);
            if (!active.get()) {
                active.set(true);
                messagingService.sendMessage(
                        messageCreateEvent.getMessageAuthor(),
                        "The race begins!",
                        "Be the first to **react** to this message to win!",
                        null,
                        "https://i.imgur.com/AOQDM5w.jpeg",
                        messageCreateEvent.getChannel()
                ).thenAccept(message -> {
                    message.addReactionAddListener(listener -> {
                        if (active.get()) {
                            message.edit(new EmbedBuilder()
                                    .setAuthor(messageCreateEvent.getMessageAuthor())
                                    .setTitle("The race ends!")
                                    .setDescription("Congrats to **" + listener.getUser().get().getName() + "** for winning the race!")
                                    .setFooter(null)
                                    .setThumbnail("https://i.imgur.com/AOQDM5w.jpeg"));
                            active.set(false);
                        }
                    }).removeAfter(3, TimeUnit.MINUTES); // this will remove the reaction add listener in 3mins. you can change it or remove it, I recommed keeping it there for like 30 mins or an hour if you really need it.
                });
            }
        }
    }
}
