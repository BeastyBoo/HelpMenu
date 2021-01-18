package net.venturekraft.helpmenu;

import net.venturekraft.VentureKraftAPI.MenuBuilder.MenuListener;
import net.venturekraft.VentureKraftAPI.Processes;
import net.venturekraft.helpmenu.domain.FileObject;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class HelpMenu extends JavaPlugin
{

    //Main Instance
    private static HelpMenu helpMenuInstance;

    private FileObject staffFile;
    private FileObject commandsFile;
    private FileObject serverSettingsFile;
    private FileObject serverInfoFile;
    private FileObject otherInfoFile;
    private FileObject ranksFile;

    private void initiateFiles(){
        staffFile = new FileObject(this,"staff");
        commandsFile = new FileObject(this,"commands");
        serverSettingsFile = new FileObject(this,"serverSettings");
        serverInfoFile = new FileObject(this,"serverInfo");
        otherInfoFile = new FileObject(this,"otherInfo");
        ranksFile = new FileObject(this,"ranks");
    }

    @Override
    public void onEnable()
    {
        //Main Instance
        helpMenuInstance = this;

        //Commands
        Objects.requireNonNull(getCommand("help")).setExecutor(new HelpCommand());

        //Events
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);

        initiateFiles();
    }

    //Main Instance
    public static HelpMenu getMain() { return helpMenuInstance; }

}
