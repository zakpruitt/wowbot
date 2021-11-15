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

    private final static Pattern pattern = Pattern.compile("!item (.+)");
    @Autowired
    MessagingService messagingService;
    @Autowired
    ItemService itemService;

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().startsWith("!item")) {
            Matcher matcher = pattern.matcher(messageCreateEvent.getMessageContent());
            if (matcher.matches()) {
                String itemSearch = matcher.group(0).replace("!item", "").trim();
                System.out.println(itemSearch + " <-- This is the search");
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
                            .setThumbnail("https://images.squarespace-cdn.com/content/v1/5b21b02fa2772c3cf363b577/1587614510776-2CLVW62M1WPES2XAPVPJ/premium-600.png?format=1500w")
                    );
                    ex.printStackTrace();
                }
            }
        }
    }
}
