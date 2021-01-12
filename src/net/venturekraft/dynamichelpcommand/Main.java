package net.venturekraft.dynamichelpcommand;

import net.venturekraft.dynamichelpcommand.MenuBuilder.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main extends JavaPlugin
{

    //Instances
    private final Processes processes = new Processes();

    //File Initialisation
    private File staffFile;
    private YamlConfiguration modifyStaffFile;

    //Main Instance
    private static Main mainInstance;

    @Override
    public void onEnable()
    {
        //Commands
        Objects.requireNonNull(getCommand("help")).setExecutor(new HelpCommand());

        //Events
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);

        //Config Access
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();

        //File Initialisation
        try
        {
            initiateFiles();
        }
        catch (IOException e)
        {
            System.out.println(processes.color("Could NOT create .yml File."));
        }

        //Main Instance
        mainInstance = this;
    }

    //File Initialisation
    public File getFile() { return staffFile; }
    public YamlConfiguration getStaffFile() { return modifyStaffFile; }

    public void initiateFiles () throws IOException
    {
        staffFile = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("DynamicHelpCommand")).getDataFolder(), "staff.yml");

        if (!staffFile.exists())
        {
            staffFile.createNewFile();
        }

        modifyStaffFile  = YamlConfiguration.loadConfiguration(staffFile );
    }

    //Save .yml File.
    public void saveStaffFile()
    {
        try
        {
            this.getStaffFile().save(this.getFile());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //Main Instance
    public static Main getMain() { return mainInstance; }

}
