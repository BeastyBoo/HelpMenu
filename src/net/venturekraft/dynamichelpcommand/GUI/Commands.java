package net.venturekraft.dynamichelpcommand.GUI;

import net.venturekraft.dynamichelpcommand.Main;
import net.venturekraft.dynamichelpcommand.MenuBuilder.Menu;
import net.venturekraft.dynamichelpcommand.MenuBuilder.MenuButton;
import net.venturekraft.dynamichelpcommand.Processes;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Commands extends Menu
{

    public Commands()
    {
        //Menu initialisation
        super(ChatColor.BLUE + "Commands", 1);

        Processes processes = new Processes();

        //Buttons
        String[] getButtons = Main.getMain().getCommandsFile().getKeys(true).toArray(new String[0]);

        for(String b : getButtons)
        {
            List<String> commandsLore = Main.getMain().getCommandsFile().getStringList(b);
            List<String> commandsLoreFinal = new ArrayList<>();

            int i = 0;
            for (String r : commandsLore)
            {
                commandsLoreFinal.add(processes.color(r));
                i++;
            }

            commandsLoreFinal.remove(i - 1);
            commandsLoreFinal.remove(1);
            commandsLoreFinal.remove(0);

            registerButton(new MenuButton(new ItemStack(processes.buildItem
                    (processes.color(commandsLore.get(0)),
                            commandsLoreFinal,
                            Material.valueOf(commandsLore.get(1)),
                            1)
            )), Integer.parseInt(Main.getMain().getCommandsFile().getStringList(b).get(i - 1)));
        }

    }

}
