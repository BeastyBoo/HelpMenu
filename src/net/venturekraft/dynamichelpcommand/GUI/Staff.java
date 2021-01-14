package net.venturekraft.dynamichelpcommand.GUI;

import net.venturekraft.dynamichelpcommand.Main;
import net.venturekraft.dynamichelpcommand.API.MenuBuilder.Menu;
import net.venturekraft.dynamichelpcommand.API.MenuBuilder.MenuButton;
import net.venturekraft.dynamichelpcommand.API.Processes;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.UUID;

public class Staff extends Menu
{

    public Staff(Player player)
    {
        //Menu Initialisation
        super(ChatColor.RED + "Staff", 4);

        Processes processes = new Processes();

        //Buttons
        String[] getStaff = Main.getMain().getStaffFile().getKeys(true).toArray(new String[0]);

        for (String s : getStaff)
        {

            String[] staffMember = Main.getMain().getStaffFile().getStringList(s).toArray(new String[0]);

            registerButton(new MenuButton(new ItemStack(processes.buildSkull(
                    (processes.color(staffMember[0])),
                            Collections.singletonList(processes.color(staffMember[1])),
                            UUID.fromString(s),
                            1)
            )), Integer.parseInt(staffMember[2]));

        }

        registerButton(new MenuButton(new ItemStack(processes.buildItem
                (processes.color("&eBack"),
                        null,
                        Material.REDSTONE,
                        1)
        )).setWhenClicked(clicked -> new MainMenu(player).open(player)), 35);
    }

}
