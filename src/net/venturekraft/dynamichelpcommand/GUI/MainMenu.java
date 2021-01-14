package net.venturekraft.dynamichelpcommand.GUI;

import net.venturekraft.dynamichelpcommand.Main;
import net.venturekraft.dynamichelpcommand.API.MenuBuilder.Menu;
import net.venturekraft.dynamichelpcommand.API.MenuBuilder.MenuButton;
import net.venturekraft.dynamichelpcommand.API.Processes;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainMenu extends Menu
{

    public MainMenu(Player player)
    {
        //Menu initialisation.
        super(ChatColor.YELLOW + "Help Menu", 3);

        Processes processes = new Processes();

        //Buttons
        registerButton(new MenuButton(new ItemStack(processes.buildSkull
                (processes.color("&eProfile"),
                Collections.singletonList(processes.color("&6Information about you.")),
                player.getUniqueId(),
                1)
            )).setWhenClicked(clicked -> new Profile(player).open(player)), 10);

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&cStaff"),
                Collections.singletonList(processes.color("&6All the current Staff members.")),
                        Material.GOLD_BLOCK,
                        1)
            )).setWhenClicked(clicked -> new Staff(player).open(player)), 11);

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&9Commands"),
                        Collections.singletonList(processes.color("&6Commands you can execute.")),
                        Material.DIAMOND_BLOCK,
                        1)
        )).setWhenClicked(clicked -> new Commands(player).open(player)), 12);

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&eOther Info"),
                        Collections.singletonList(processes.color("&6Other useful information.")),
                        Material.EMERALD_BLOCK,
                        1)
        )).setWhenClicked(clicked -> new OtherInfo(player).open(player)), 13);

        List<String> serverSettings = Main.getMain().getServerSettingsFile().getStringList("ServerSettings");
        List<String> serverSettingsFinal = new ArrayList<>();

        for(String s : serverSettings)
        {
            serverSettingsFinal.add(processes.color(s));
        }

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&fServer Settings"),
                        serverSettingsFinal,
                        Material.COMMAND_BLOCK,
                        1)
        )), 15);

        List<String> serverInfo = Main.getMain().getServerInfoFile().getStringList("ServerInfo");
        List<String> serverInfoFinal = new ArrayList<>();

        for(String s : serverInfo)
        {
            serverInfoFinal.add(processes.color(s));
        }

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&fServer Info"),
                        serverInfoFinal,
                        Material.REPEATING_COMMAND_BLOCK,
                        1)
        )), 16);
    }

}
