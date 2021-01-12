package net.venturekraft.dynamichelpcommand.GUI;

import net.venturekraft.dynamichelpcommand.MenuBuilder.Menu;
import net.venturekraft.dynamichelpcommand.MenuBuilder.MenuButton;
import net.venturekraft.dynamichelpcommand.Processes;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

public class MainMenu extends Menu
{

    public MainMenu(Player player)
    {
        //Menu initialisation.
        super(ChatColor.GOLD + "Help Menu", 3);

        Processes processes = new Processes();

        Menu staffMenu = new StaffMenu();

        //Buttons
        registerButton(new MenuButton(new ItemStack(processes.buildSkull
                (processes.color("&fProfile"),
                Collections.singletonList(processes.color("&6Information about you.")),
                player.getUniqueId(),
                1)
            )).setWhenClicked(clicked -> clicked.sendMessage("te")), 10);

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&cStaff"),
                Collections.singletonList(processes.color("&6All the current VentureKraft Staff members.")),
                        Material.GOLD_BLOCK,
                        1)
            )).setWhenClicked(clicked -> staffMenu.open(player)), 11);

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&9Commands"),
                        Collections.singletonList(processes.color("&6Commands you can execute.")),
                        Material.DIAMOND_BLOCK,
                        1)
        )).setWhenClicked(clicked -> clicked.sendMessage("You clicked a button!")), 12);

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&fRanks"),
                        Collections.singletonList(processes.color("&6Information about the server Ranks.")),
                        Material.EMERALD_BLOCK,
                        1)
        )).setWhenClicked(clicked -> clicked.sendMessage("You clicked a button!")), 15);

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&fServer Settings"),
                        Collections.singletonList(processes.color("&6The current server settings.")),
                        Material.COMMAND_BLOCK,
                        1)
        )), 15);

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&fServer Info"),
                        Collections.singletonList(processes.color("&6Server running on 1.16.4")),
                        Material.REPEATING_COMMAND_BLOCK,
                        1)
        )), 16);
    }

}
