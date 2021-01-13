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

public class Ranks extends Menu
{

    public Ranks()
    {
        //Menu initialisation
        super(ChatColor.DARK_PURPLE + "Ranks", 3);

        Processes processes = new Processes();

        //Buttons
        String[] getButtons = Main.getMain().getRanksFile().getKeys(true).toArray(new String[0]);

        for(String b : getButtons)
        {
            List<String> rankLore = Main.getMain().getRanksFile().getStringList(b);
            List<String> rankLoreFinal = new ArrayList<>();

            int i = 0;
            for (String r : rankLore)
            {
                rankLoreFinal.add(processes.color(r));
                i++;
            }

            rankLoreFinal.remove(i - 1);
            rankLoreFinal.remove(1);
            rankLoreFinal.remove(0);

            registerButton(new MenuButton(new ItemStack(processes.buildItem
                    (processes.color(rankLore.get(0)),
                            rankLoreFinal,
                            Material.valueOf(rankLore.get(1)),
                            1)
            )), Integer.parseInt(Main.getMain().getRanksFile().getStringList(b).get(i - 1)));
        }
    }

}
