package com.zakpruitt.wowbot.Listeners.Implementations;

import com.zakpruitt.wowbot.Listeners.ItemListener;
import com.zakpruitt.wowbot.Services.ItemService;
import com.zakpruitt.wowbot.Services.MessagingService;
import com.zakpruitt.wowbot.entities.Item;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ItemListenerImplementation implements ItemListener {

    private final static Pattern pattern = Pattern.compile("!item (\\w+)");
    @Autowired
    MessagingService messagingService;
    @Autowired
    ItemService itemService;

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().startsWith("!item")) {
            Matcher matcher = pattern.matcher(messageCreateEvent.getMessageContent());
            if (matcher.matches()) {
                String itemSearch = matcher.group(1);
                try {
                    Item item = itemService.getItem(itemSearch);
                    messageCreateEvent.getChannel().sendMessage(new EmbedBuilder()
                            .setTitle(item.getItemName())
                            .setDescription(item.getBinding())
                            .addInlineField("💸 Quality:", item.getQuality())
                            .addInlineField("⚔ Wep. Type:", item.getItemSubclass())
                            .addInlineField("🎒 Inv. Type:", item.getInventoryType())
                            .addInlineField("🗡️ Damage:", item.getDamageString())
                            .addInlineField("⏩ Attack Speed:", item.getAttackSpeedString())
                            .addInlineField("🏹 DPS:", item.getDpsString())
                            .setThumbnail(item.getThumbnail())
                            .setColor(item.getColor())
                    );
                } catch (JSONException ex) {
                    messageCreateEvent.getChannel().sendMessage(new EmbedBuilder()
                            .setTitle("Error finding '" + itemSearch + "'!")
                            .setDescription("Sorry, I was unable to find the item you were looking for. " +
                                    "Try looking here: " +
                                    String.format("https://www.wowhead.com/search?q=%s", itemSearch))
                            .setColor(Color.red)
                    );
                    ex.printStackTrace();
                }
            }
        }
    }
}
