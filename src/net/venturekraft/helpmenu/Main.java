package net.venturekraft.helpmenu;

import net.venturekraft.VentureKraftAPI.MenuBuilder.MenuListener;
import net.venturekraft.VentureKraftAPI.Processes;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main extends JavaPlugin
{

    //Main Instance
    private static Main mainInstance;

    @Override
    public void onEnable()
    {

        //Commands
        Objects.requireNonNull(getCommand("help")).setExecutor(new HelpCommand());

        //Events
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);

        //File Initialisation
        try
        {
            initiateFiles();
        }
        catch (IOException e)
        {
            System.out.println(Processes.color("&cCould NOT create .yml Files."));
        }

        //Main Instance
        mainInstance = this;
    }

    //Main Instance
    public static Main getMain() { return mainInstance; }

    //File Initialisation
    private YamlConfiguration modifyStaffFile;
    private YamlConfiguration modifyCommandsFile;
    private YamlConfiguration modifyServerSettingsFile;
    private YamlConfiguration modifyServerInfoFile;
    private YamlConfiguration modifyOtherInfoFile;
    private YamlConfiguration modifyRanksFile;

    public YamlConfiguration getStaffFile() { return modifyStaffFile; }
    public YamlConfiguration getCommandsFile() { return modifyCommandsFile; }
    public YamlConfiguration getServerSettingsFile() { return modifyServerSettingsFile; }
    public YamlConfiguration getServerInfoFile() { return modifyServerInfoFile; }
    public YamlConfiguration getOtherInfoFile() { return modifyOtherInfoFile; }
    public YamlConfiguration getRanksFile() { return modifyRanksFile; }

    public void initiateFiles () throws IOException
    {
        File staffFile = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("HelpMenu")).getDataFolder(), "staff.yml");
        File commandsFile = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("HelpMenu")).getDataFolder(), "commands.yml");
        File serverSettingsFile = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("HelpMenu")).getDataFolder(), "serverSettings.yml");
        File serverInfoFile = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("HelpMenu")).getDataFolder(), "serverInfo.yml");
        File otherInfoFile = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("HelpMenu")).getDataFolder(), "otherInfo.yml");
        File ranksFile = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("HelpMenu")).getDataFolder(), "ranks.yml");

        if (!staffFile.exists() || !commandsFile.exists() || !serverSettingsFile.exists() || !serverInfoFile.exists() || !otherInfoFile.exists() || !ranksFile.exists())
        {
            staffFile.createNewFile();
            commandsFile.createNewFile();
            serverSettingsFile.createNewFile();
            serverInfoFile.createNewFile();
            otherInfoFile.createNewFile();
            ranksFile.createNewFile();
        }

        modifyStaffFile  = YamlConfiguration.loadConfiguration(staffFile);
        modifyCommandsFile = YamlConfiguration.loadConfiguration(commandsFile);
        modifyServerSettingsFile = YamlConfiguration.loadConfiguration(serverSettingsFile);
        modifyServerInfoFile = YamlConfiguration.loadConfiguration(serverInfoFile);
        modifyOtherInfoFile = YamlConfiguration.loadConfiguration(otherInfoFile);
        modifyRanksFile = YamlConfiguration.loadConfiguration(ranksFile);
    }

}
