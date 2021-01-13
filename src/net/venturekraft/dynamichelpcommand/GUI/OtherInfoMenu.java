package net.venturekraft.dynamichelpcommand.GUI;

import net.venturekraft.dynamichelpcommand.Main;
import net.venturekraft.dynamichelpcommand.MenuBuilder.Menu;
import net.venturekraft.dynamichelpcommand.MenuBuilder.MenuButton;
import net.venturekraft.dynamichelpcommand.Processes;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class OtherInfoMenu extends Menu
{

    public OtherInfoMenu(Player player)
    {
        //Menu initialisation
        super(ChatColor.YELLOW + "Other Info", 1);

        Menu ranks = new Ranks();

        Processes processes = new Processes();

        //Buttons
        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&5Ranks"),
                        Collections.singletonList(processes.color("&6All the server ranks.")),
                        Material.EMERALD,
                        1)
        )).setWhenClicked(clicked -> ranks.open(player)), 0);

        List<String> websiteLink = Main.getMain().getOtherInfoFile().getStringList("Website");
        List<String> websiteLinkFinal = new ArrayList<>();

        for(String w : websiteLink)
        {
            websiteLinkFinal.add(processes.color(w));
        }

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&9Website"),
                        websiteLinkFinal,
                        Material.PAPER,
                        1)
        )).setWhenClicked(clicked -> clicked.sendMessage(Objects.requireNonNull(Main.getMain().getOtherInfoFile().getString("WebsiteLink")))), 7);

        List<String> wikiLink = Main.getMain().getOtherInfoFile().getStringList("Wiki");
        List<String> wikiLinkFinal = new ArrayList<>();

        for(String w : wikiLink)
        {
            websiteLinkFinal.add(processes.color(w));
        }

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&9Wiki"),
                        wikiLinkFinal,
                        Material.PAPER,
                        1)
        )).setWhenClicked(clicked -> clicked.sendMessage(Objects.requireNonNull(Main.getMain().getOtherInfoFile().getString("WikiLink")))), 8);
    }

}
