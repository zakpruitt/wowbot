package com.zakpruitt.wowbot.Services.Implementations;

import com.zakpruitt.wowbot.Services.ItemService;
import com.zakpruitt.wowbot.Utilities.JSONParserUtility;
import com.zakpruitt.wowbot.entities.Item;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Iterator;

@Component
public class ItemServiceImplementation implements ItemService {

    @Autowired
    private Environment env;

    @Override
    public Item getItem(String search) {
        return buildItem(search);
    }

    private Item buildItem(String search) {
        String blizzToken = env.getProperty("BLIZZ_TOKEN");
        Item item = new Item();

        search = URLEncoder.encode(search);
        String searchURL = String.format("https://us.api.blizzard.com/data/wow/search/item?namespace=static-us&name.en_US=%1$s&orderby=id&_page=1&access_token=%2$s", search, blizzToken);
        JSONObject searchJSON = JSONParserUtility.ParseJSON(searchURL);
        int itemId = searchJSON
                .getJSONArray("results")
                .getJSONObject(0)
                .getJSONObject("data")
                .getInt("id");

        String itemURL = String.format("https://us.api.blizzard.com/data/wow/item/%1$s?namespace=static-classic-us&locale=en_US&access_token=%2$s", itemId, blizzToken);
        JSONObject itemJSON = JSONParserUtility.ParseJSON(itemURL);


        String mediaURL = String.format("https://us.api.blizzard.com/data/wow/media/item/%1$s?namespace=static-classic-us&locale=en_US&access_token=%2$s", itemId, blizzToken);
        JSONObject mediaJSON = JSONParserUtility.ParseJSON(mediaURL);
        String thumbnail = mediaJSON
                .getJSONArray("assets")
                .getJSONObject(0)
                .getString("value");

        item.setItemId(itemJSON.getInt("id"));
        item.setItemName(itemJSON.getString("name"));
        item.setQuality(itemJSON.getJSONObject("quality").getString("name"));
        item.setItemClass(itemJSON.getJSONObject("item_class").getString("name"));
        item.setItemSubclass(itemJSON.getJSONObject("item_subclass").getString("name"));
        item.setInventoryType(itemJSON.getJSONObject("inventory_type").getString("name"));
        itemJSON = itemJSON.getJSONObject("preview_item");
        item.setBinding(itemJSON.getJSONObject("binding").getString("name"));
        item.setMinimumDamage(itemJSON.getJSONObject("weapon").getJSONObject("damage").getInt("min_value"));
        item.setMaximumDamage(itemJSON.getJSONObject("weapon").getJSONObject("damage").getInt("max_value"));
        item.setDamageString(itemJSON.getJSONObject("weapon").getJSONObject("damage").getString("display_string"));
        item.setAttackSpeedString(itemJSON.getJSONObject("weapon").getJSONObject("attack_speed").getString("display_string"));
        item.setDpsString(itemJSON.getJSONObject("weapon").getJSONObject("dps").getString("display_string"));
        item.setThumbnail(thumbnail);
        item.determineColor();
//        System.out.println(itemJSON.getJSONObject("weapon").getJSONArray("additional_damage").getString(2));
//        System.out.println(itemJSON.getInt("required_level"));
//        System.out.println(itemJSON.getInt("required_level"));
//        System.out.println(itemJSON.getInt("required_level"));
        return item;
    }
}
