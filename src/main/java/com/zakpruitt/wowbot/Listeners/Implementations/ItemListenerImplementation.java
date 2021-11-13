package com.zakpruitt.wowbot.Listeners.Implementations;

import com.zakpruitt.wowbot.Listeners.ItemListener;
import com.zakpruitt.wowbot.Services.ItemService;
import com.zakpruitt.wowbot.Services.MessagingService;
import com.zakpruitt.wowbot.entities.Item;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ItemListenerImplementation implements ItemListener {

    @Autowired
    MessagingService messagingService;
    @Autowired
    ItemService itemService;

    private final static Pattern pattern = Pattern.compile("!item (\\w+)");

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().startsWith("!item")) {
            Matcher matcher = pattern.matcher(messageCreateEvent.getMessageContent());
            if (matcher.matches()) {
                Item item = itemService.getItem(matcher.group(1));


                messagingService.sendMessage(
                        messageCreateEvent.getMessageAuthor(),
                        "item test",
                        "bruh",
                        "Rate again?",
                        "https://render.worldofwarcraft.com/classic-us/icons/56/inv_sword_39.jpg",
                        messageCreateEvent.getChannel()
                );
            } else {
            }
        }
    }
}
