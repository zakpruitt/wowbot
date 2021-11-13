package com.zakpruitt.wowbot.Listeners.Implementations;

import com.zakpruitt.wowbot.Listeners.RateListener;
import com.zakpruitt.wowbot.Services.MessagingService;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RateListenerImplementation implements RateListener {

    @Autowired
    MessagingService messagingService;

    private final static Pattern pattern = Pattern.compile("!rate (\\w+)");

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().startsWith("!rate")) {
            Matcher matcher = pattern.matcher(messageCreateEvent.getMessageContent());
            if (matcher.matches()) {
                int rating = (int) Math.floor(Math.random() * 100) + 1;

                final String message = messageCreateEvent.getMessageAuthor().getDisplayName() +
                        " is " +
                        rating +
                        "% " +
                        matcher.group(1);

                messagingService.sendMessage(
                        messageCreateEvent.getMessageAuthor(),
                        "Rate Calculator",
                        message,
                        "Rate again?",
                        "https://render.worldofwarcraft.com/classic-us/icons/56/inv_sword_39.jpg",
                        messageCreateEvent.getChannel()
                );
            } else {
                messagingService.sendMessage(
                        messageCreateEvent.getMessageAuthor(),
                        "Rate Calculator",
                        "Are you trying to use the '!rate' command? Please use the syntax '!rate [word]'." +
                                " React with a :thumbsup: to remove this message.",
                        null,
                        null,
                        messageCreateEvent.getChannel(),
                        true
                );
            }
        }
    }
}
