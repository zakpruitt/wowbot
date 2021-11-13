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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;

@Component
public class ItemServiceImplementation implements ItemService {

    @Autowired
    private Environment env;

    @Override
    public Item getItem(String search) {
        buildItem(search);
        return null;
    }

    private Item buildItem(String search) {
        String blizzToken = env.getProperty("BLIZZ_TOKEN");
        String searchURL = String.format("https://us.api.blizzard.com/data/wow/search/item?namespace=static-us&name.en_US=%1$s&orderby=id&_page=1&access_token=%2$s", search, blizzToken);
        Item item = new Item();
        JSONObject itemJSON = JSONParserUtility.ParseJSON(searchURL);
        JSONArray itemArray = itemJSON.getJSONArray("preview_item");

        for (int i = 0; i < itemArray.length(); i++) {
            System.out.println(itemArray.getJSONObject(i));
        }

        return new Item();
    }
}
