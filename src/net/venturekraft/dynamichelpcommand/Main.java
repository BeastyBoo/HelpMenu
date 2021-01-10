package net.venturekraft.dynamichelpcommand;

import net.venturekraft.dynamichelpcommand.MenuBuilder.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin
{

    //Instances
    private static Main mainInstance;

    @Override
    public void onEnable()
    {
        //Commands
        Objects.requireNonNull(getCommand("help")).setExecutor(new HelpCommand());

        //Events
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
    }

}
