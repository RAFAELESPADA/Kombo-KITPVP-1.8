package net.wavemc.pvp.inventory.listener;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Dye;

import java.util.Collections;
import java.util.List;

public class ItemUtils {

    public static ItemStack getCocoa() {

        Dye d = new Dye();
        ItemStack lapis;
        d.setColor(DyeColor.BROWN);
        lapis = d.toItemStack();
        lapis.setAmount(64);
        ItemStack cocoa = lapis;
        return cocoa;
    }

    public static ItemStack getCocoa2() {

        Dye d = new Dye();
        ItemStack lapis;
        d.setColor(DyeColor.BROWN);
        lapis = d.toItemStack();
        lapis.setAmount(1);
        ItemStack cocoa = lapis;
        return cocoa;
    }

    public static ItemStack getCustomItemStack(Material material, String name, String lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        if (lore != null) {
            List<String> l = Collections.singletonList(lore);
            itemMeta.setLore(l);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getCustomItemStack(Material material, String name, List<String> lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack editItemStack(ItemStack itemStack, String name, List<String> lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getPlayerSkull(String name) {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM);
        return itemStack;
    }

}