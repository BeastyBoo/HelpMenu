package net.venturekraft.dynamichelpcommand;

import net.venturekraft.VentureKraftAPI.MenuBuilder.Menu;
import net.venturekraft.dynamichelpcommand.GUI.MainMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor
{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {

        if (sender instanceof Player)
        {
            Player player = (Player) sender;

            Menu mainMenu = new MainMenu(player);
            mainMenu.open(player);
        }

        return false;
    }

}
