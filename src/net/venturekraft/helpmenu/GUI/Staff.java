package net.venturekraft.helpmenu.GUI;

import net.venturekraft.VentureKraftAPI.MenuBuilder.Menu;
import net.venturekraft.VentureKraftAPI.MenuBuilder.MenuButton;
import net.venturekraft.VentureKraftAPI.Processes;
import net.venturekraft.helpmenu.Main;
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

        //Buttons
        String[] getStaff = Main.getMain().getStaffFile().getKeys(true).toArray(new String[0]);

        for (String s : getStaff)
        {

            String[] staffMember = Main.getMain().getStaffFile().getStringList(s).toArray(new String[0]);

            registerButton(new MenuButton(new ItemStack(Processes.buildSkull(
                    (Processes.color(staffMember[0])),
                            Collections.singletonList(Processes.color(staffMember[1])),
                            UUID.fromString(s),
                            1)
            )), Integer.parseInt(staffMember[2]));

        }

        registerButton(new MenuButton(new ItemStack(Processes.buildItem
                (Processes.color("&eBack"),
                        null,
                        Material.REDSTONE,
                        1)
        )).setWhenClicked(clicked -> new MainMenu(player).open(player)), 35);
    }

}
