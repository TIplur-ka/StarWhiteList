package necode.angelitex.starwhitelist;

import necode.angelitex.starwhitelist.Commands.WhiteList;
import necode.angelitex.starwhitelist.Listeners.Events;
import necode.angelitex.starwhitelist.Tools.Colors;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public final class StarWhiteList extends JavaPlugin {

    public String PluginPrefix() {return this.getConfig().getString("Prefix") + " ";}

    public FileConfiguration customConfig;
    public String WhiteListEnabled;
    public String WhiteListDisabled;
    public String ReloadMessage;
    public String NoneWhiteList;
    public String AlreadyWhiteList;
    public String ListingWhiteList;
    public String PlayerCheckTimeMessage;
    public String PlayerAddWhiteList;
    public String PlayerRemoveWhiteList;
    public String PlayerNoneWhiteList;
    public String GuestMessageJoin;
    public String GuestChatDisableMessage;
    public String GuestInteractMessage;
    public Boolean WhiteListEnable;
    public Boolean GuestModeEnable;
    public Boolean OnlineMode;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        createDataYml();
        Strings();
        Events();
        registercommands();
        Bools();
        Bukkit.getLogger().info("");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void Strings() {
        this.WhiteListEnabled = getConfig().getString("Messages.WhiteListEnabled");
        this.WhiteListDisabled = getConfig().getString("Messages.WhiteListDisabled");
        this.ReloadMessage = getConfig().getString("Messages.ReloadMessage");
        this.NoneWhiteList = getConfig().getString("Messages.NoneWhiteList");
        this.AlreadyWhiteList = getConfig().getString("Messages.AlreadyWhiteList");
        this.ListingWhiteList = getConfig().getString("Messages.ListingWhiteList");
        this.PlayerCheckTimeMessage = getConfig().getString("Messages.PLayerCheckTimeMessage");
        this.PlayerAddWhiteList = getConfig().getString("Messages.PlayerAddWhiteList");
        this.PlayerRemoveWhiteList = getConfig().getString("Messages.PlayerRemoveWhiteList");
        this.PlayerNoneWhiteList = getConfig().getString("Messages.PlayerNoneWhiteList");
        this.GuestChatDisableMessage = getConfig().getString("Messages.GuestChatDisableMessage");
        this.GuestMessageJoin = getConfig().getString("Messages.GuestMessageJoin");
        this.GuestInteractMessage = getConfig().getString("Messages.GuestInteractMessage");
    }
    public void Bools() {
        this.WhiteListEnable = getConfig().getBoolean("WhiteListEnable");
        this.GuestModeEnable = getConfig().getBoolean("GuestGamemode.enabled");
        this.OnlineMode = Boolean.getBoolean("OnlineMode");
    }
    private void Events() {
        Bukkit.getPluginManager().registerEvents(new Events(this), this);
    }
    private void registercommands(){
        this.getCommand("StarWhiteList").setExecutor((CommandExecutor) new WhiteList(this));
    }


    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    public void createDataYml() {
        File customConfigFile = new File(getDataFolder(), "whitelist.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("whitelsit.yml", true);
        }

        customConfig= new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }


}
