package net.venturekraft.helpmenu.GUI;

import net.venturekraft.VentureKraftAPI.MenuBuilder.Menu;
import net.venturekraft.VentureKraftAPI.MenuBuilder.MenuButton;
import net.venturekraft.VentureKraftAPI.Processes;
import net.venturekraft.helpmenu.HelpMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Commands extends Menu
{

    public Commands(Player player)
    {
        //Menu initialisation
        super(ChatColor.BLUE + "Commands", 1);

        //Buttons
        String[] getButtons = HelpMenu.getMain().getCommandsFile().getKeys(true).toArray(new String[0]);

        for(String b : getButtons)
        {
            List<String> commandsLore = HelpMenu.getMain().getCommandsFile().getStringList(b);
            List<String> commandsLoreFinal = new ArrayList<>();

            int i = 0;
            for (String r : commandsLore)
            {
                commandsLoreFinal.add(Processes.color(r));
                i++;
            }

            commandsLoreFinal.remove(i - 1);
            commandsLoreFinal.remove(1);
            commandsLoreFinal.remove(0);

            registerButton(new MenuButton(new ItemStack(Processes.buildItem
                    (Processes.color(commandsLore.get(0)),
                            commandsLoreFinal,
                            Material.valueOf(commandsLore.get(1)),
                            1)
            )), Integer.parseInt(HelpMenu.getMain().getCommandsFile().getStringList(b).get(i - 1)));
        }

        registerButton(new MenuButton(new ItemStack(Processes.buildItem
                (Processes.color("&eBack"),
                        null,
                        Material.REDSTONE,
                        1)
        )).setWhenClicked(clicked -> new MainMenu(player).open(player)), 8);
    }

}
