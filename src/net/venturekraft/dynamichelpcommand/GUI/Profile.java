package net.venturekraft.dynamichelpcommand.GUI;

import net.venturekraft.dynamichelpcommand.MenuBuilder.Menu;
import net.venturekraft.dynamichelpcommand.MenuBuilder.MenuButton;
import net.venturekraft.dynamichelpcommand.Processes;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

public class Profile extends Menu
{

    public Profile(Player player)
    {
        //Menu Initialisation
        super(ChatColor.YELLOW + "Profile", 1);

        Processes processes = new Processes();

        //Buttons
        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&9Time Played"),
                        Collections.singletonList(processes.color("&f" + player.getStatistic(Statistic.PLAY_ONE_MINUTE) / (60 * 60 * 20) + " Hours")),
                        Material.CLOCK,
                        1)
        )), 0);

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&9Number Of Deaths"),
                        Collections.singletonList(processes.color("&f" + player.getStatistic(Statistic.DEATHS))),
                        Material.SKELETON_SKULL,
                        1)
        )), 1);

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&9Players Killed"),
                        Collections.singletonList(processes.color("&f" + player.getStatistic(Statistic.PLAYER_KILLS))),
                        Material.ARMOR_STAND,
                        1)
        )), 2);

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&9Mobs Killed"),
                        Collections.singletonList(processes.color("&f" + player.getStatistic(Statistic.MOB_KILLS))),
                        Material.ROTTEN_FLESH,
                        1)
        )), 3);
    }

}
