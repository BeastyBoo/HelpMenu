package net.venturekraft.dynamichelpcommand.GUI;

import net.venturekraft.dynamichelpcommand.Main;
import net.venturekraft.dynamichelpcommand.MenuBuilder.Menu;
import net.venturekraft.dynamichelpcommand.MenuBuilder.MenuButton;
import net.venturekraft.dynamichelpcommand.Processes;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.UUID;

public class StaffMenu extends Menu
{

    public StaffMenu()
    {
        //Menu Initialisation
        super(ChatColor.RED + "Staff", 4);

        Processes processes = new Processes();

        String[] test = Main.getMain().getStaffFile().getKeys(true).toArray(new String[0]);

        //Buttons
        for (String s : test)
        {

            String[] member = Main.getMain().getStaffFile().getStringList(s).toArray(new String[0]);

            registerButton(new MenuButton(new ItemStack(processes.buildSkull(
                    (processes.color(member[0])),
                            Collections.singletonList(processes.color(member[1])),
                            UUID.fromString(s),
                            1)
            )), Integer.parseInt(member[2]));

        }
    }

}
