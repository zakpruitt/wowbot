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

    public Item() {

    }

    public Item(double itemId, String itemName, String itemClass, String itemSubclass, String inventoryType, String quality, String binding, double minimumDamage, double maximumDamage, String damageString, String damageClass, double dps, String dpsString, double attackSpeed, String attackSpeedString, ArrayList<String> stats, ArrayList<String> spells, int levelRequirement, String levelRequirementString, int durability, String durabilityString) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemClass = itemClass;
        this.itemSubclass = itemSubclass;
        this.inventoryType = inventoryType;
        this.quality = quality;
        this.binding = binding;
        this.minimumDamage = minimumDamage;
        this.maximumDamage = maximumDamage;
        this.damageString = damageString;
        this.damageClass = damageClass;
        this.dps = dps;
        this.dpsString = dpsString;
        this.attackSpeed = attackSpeed;
        this.attackSpeedString = attackSpeedString;
        this.stats = stats;
        this.spells = spells;
        this.levelRequirement = levelRequirement;
        this.levelRequirementString = levelRequirementString;
        this.durability = durability;
        this.durabilityString = durabilityString;
    }

    @PostConstruct
    void DetermineColor() {
        switch (this.quality) {

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
}
