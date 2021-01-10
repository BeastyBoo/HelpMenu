package net.venturekraft.dynamichelpcommand.GUI;

import net.venturekraft.dynamichelpcommand.MenuBuilder.Menu;
import net.venturekraft.dynamichelpcommand.MenuBuilder.MenuButton;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MainMenu extends Menu
{

    public MainMenu()
    {
        //Menu initialisation.
        super("Help Menu", 1);

        //Button Actions
        registerButton(new MenuButton(new ItemStack(Material.DIAMOND_PICKAXE)).setWhenClicked(clicked -> clicked.sendMessage("You clicked a button!")), 1);
    }

}
