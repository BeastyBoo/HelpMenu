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

public class Ranks extends Menu
{

    public Ranks(Player player)
    {
        //Menu initialisation
        super(ChatColor.DARK_PURPLE + "Ranks", 3);

        //Buttons
        String[] getButtons = HelpMenu.getMain().getRanksFile().getKeys(true).toArray(new String[0]);

        for(String b : getButtons)
        {
            List<String> rankLore = HelpMenu.getMain().getRanksFile().getStringList(b);
            List<String> rankLoreFinal = new ArrayList<>();

            int i = 0;
            for (String r : rankLore)
            {
                rankLoreFinal.add(Processes.color(r));
                i++;
            }

            rankLoreFinal.remove(i - 1);
            rankLoreFinal.remove(1);
            rankLoreFinal.remove(0);

            registerButton(new MenuButton(new ItemStack(Processes.buildItem
                    (Processes.color(rankLore.get(0)),
                            rankLoreFinal,
                            Material.valueOf(rankLore.get(1)),
                            1)
            )), Integer.parseInt(HelpMenu.getMain().getRanksFile().getStringList(b).get(i - 1)));
        }

        registerButton(new MenuButton(new ItemStack(Processes.buildItem
                (Processes.color("&eBack"),
                        null,
                        Material.REDSTONE,
                        1)
        )).setWhenClicked(clicked -> new OtherInfo(player).open(player)), 26);
    }

}
