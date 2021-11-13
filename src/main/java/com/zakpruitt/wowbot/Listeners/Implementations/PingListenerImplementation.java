package com.zakpruitt.wowbot.Listeners.Implementations;

import com.zakpruitt.wowbot.Listeners.PingListener;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

@Component
public class PingListenerImplementation implements PingListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().equals("!ping")) {
            messageCreateEvent.getChannel().sendMessage("Pong!");
        }
    }
}
