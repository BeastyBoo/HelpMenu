package net.venturekraft.dynamichelpcommand;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Objects;

public class Processes
{

    /**
     * For use of Colorcodes in any String.
     * @param string String to add color to. Add the code at the start.
     * @return
     */
    public String color (String string)
    {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    /**
     * To create ItemStacks.
     * @param name Item name.
     * @param lore Item lore.
     * @param material Item material.
     * @param quantity Item quantity.
     * @return
     */
    public ItemStack buildItem(String name, List<String> lore, Material material, int quantity)
    {
        ItemStack item = new ItemStack(material, quantity);
        ItemMeta itemMeta = item.getItemMeta();
        Objects.requireNonNull(itemMeta).setDisplayName(color(name));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);

        return item;
    }

}
