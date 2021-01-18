package net.venturekraft.helpmenu.GUI;

import net.venturekraft.VentureKraftAPI.MenuBuilder.Menu;
import net.venturekraft.VentureKraftAPI.MenuBuilder.MenuButton;
import net.venturekraft.VentureKraftAPI.Processes;
import net.venturekraft.helpmenu.HelpMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class OtherInfo extends Menu
{

    public OtherInfo(Player player)
    {
        //Menu initialisation
        super(ChatColor.YELLOW + "Other Info", 1);

        Menu ranks = new Ranks(player);

        //Buttons
        registerButton(new MenuButton(new ItemStack(Processes.buildItem
                (Processes.color("&5Ranks"),
                        Collections.singletonList(Processes.color("&6All the server ranks.")),
                        Material.EMERALD,
                        1)
        )).setWhenClicked(clicked -> ranks.open(player)), 0);

        List<String> websiteLink = HelpMenu.getMain().getOtherInfoFile().getStringList("Website");
        List<String> websiteLinkFinal = new ArrayList<>();

        for(String w : websiteLink)
        {
            websiteLinkFinal.add(Processes.color(w));
        }

        registerButton(new MenuButton(new ItemStack(Processes.buildItem
                (Processes.color("&9Website"),
                        websiteLinkFinal,
                        Material.PAPER,
                        1)
        )).setWhenClicked(clicked -> clicked.sendMessage(Objects.requireNonNull(HelpMenu.getMain().getOtherInfoFile().getString("WebsiteLink")))), 5);

        List<String> wikiLink = HelpMenu.getMain().getOtherInfoFile().getStringList("Wiki");
        List<String> wikiLinkFinal = new ArrayList<>();

        for(String w : wikiLink)
        {
            wikiLinkFinal.add(Processes.color(w));
        }

        registerButton(new MenuButton(new ItemStack(Processes.buildItem
                (Processes.color("&9Wiki"),
                        wikiLinkFinal,
                        Material.PAPER,
                        1)
        )).setWhenClicked(clicked -> clicked.sendMessage(Objects.requireNonNull(HelpMenu.getMain().getOtherInfoFile().getString("WikiLink")))), 6);

        registerButton(new MenuButton(new ItemStack(Processes.buildItem
                (Processes.color("&eBack"),
                        null,
                        Material.REDSTONE,
                        1)
        )).setWhenClicked(clicked -> new MainMenu(player).open(player)), 8);
    }

}
