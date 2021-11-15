package com.zakpruitt.wowbot.entities;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.util.ArrayList;

public class Item {

    private double itemId;
    private String itemName;
    private String itemClass;
    private String itemSubclass;
    private String inventoryType;
    private String quality;
    private String binding;
    private double minimumDamage;
    private double maximumDamage;
    private String damageString;
    private String damageClass;
    private double dps;
    private String dpsString;
    private double attackSpeed;
    private String attackSpeedString;
    private ArrayList<String> stats;
    private ArrayList<String> spells;
    private int levelRequirement;
    private String levelRequirementString;
    private int durability;
    private String durabilityString;
    private Color color;
    private String thumbnail;

    public Item() {

    }

    public void determineColor() {
        switch (this.quality) {
            case "Poor":
                color = Color.decode("#9d9d9d");
                break;
            case "Common":
                color = Color.decode("#ffffff");
                break;
            case "Uncommon":
                color = Color.decode("#1eff00");
                break;
            case "Rare":
                color = Color.decode("#0070dd");
                break;
            case "Epic":
                color = Color.decode("#a335ee");
                break;
            case "Legendary":
                color = Color.decode("#ff8000");
                break;
        }
    }

    public double getItemId() {
        return itemId;
    }

    public void setItemId(double itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

    public String getItemSubclass() {
        return itemSubclass;
    }

    public void setItemSubclass(String itemSubclass) {
        this.itemSubclass = itemSubclass;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public double getMinimumDamage() {
        return minimumDamage;
    }

    public void setMinimumDamage(double minimumDamage) {
        this.minimumDamage = minimumDamage;
    }

    public double getMaximumDamage() {
        return maximumDamage;
    }

    public void setMaximumDamage(double maximumDamage) {
        this.maximumDamage = maximumDamage;
    }

    public String getDamageString() {
        return damageString;
    }

    public void setDamageString(String damageString) {
        this.damageString = damageString;
    }

    public String getDamageClass() {
        return damageClass;
    }

    public void setDamageClass(String damageClass) {
        this.damageClass = damageClass;
    }

    public double getDps() {
        return dps;
    }

    public void setDps(double dps) {
        this.dps = dps;
    }

    public String getDpsString() {
        return dpsString;
    }

    public void setDpsString(String dpsString) {
        this.dpsString = dpsString;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public String getAttackSpeedString() {
        return attackSpeedString;
    }

    public void setAttackSpeedString(String attackSpeedString) {
        this.attackSpeedString = attackSpeedString;
    }

    public ArrayList<String> getStats() {
        return stats;
    }

    public void setStats(ArrayList<String> stats) {
        this.stats = stats;
    }

    public ArrayList<String> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<String> spells) {
        this.spells = spells;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    public String getLevelRequirementString() {
        return levelRequirementString;
    }

    public void setLevelRequirementString(String levelRequirementString) {
        this.levelRequirementString = levelRequirementString;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getDurabilityString() {
        return durabilityString;
    }

    public void setDurabilityString(String durabilityString) {
        this.durabilityString = durabilityString;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
