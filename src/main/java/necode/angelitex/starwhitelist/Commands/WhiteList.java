package necode.angelitex.starwhitelist.Commands;

import necode.angelitex.starwhitelist.StarWhiteList;
import necode.angelitex.starwhitelist.Tools.Colors;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class WhiteList implements CommandExecutor {
    private StarWhiteList pl;
    public WhiteList(StarWhiteList plugin){
        this.pl = plugin;
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage(pl.getConfig().getStringList("Help") + "");
            return true;
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("on")) {
                pl.getConfig().set("WhiteListEnable", true);
                pl.saveConfig();
                pl.reloadConfig();
                sender.sendMessage(Colors.normalchat(Colors.hexchat("<#",">",pl.PluginPrefix() + pl.WhiteListEnabled)));
            }
            if (args[0].equalsIgnoreCase("off")) {
                pl.getConfig().set("WhiteListEnable", false);
                pl.saveConfig();
                pl.reloadConfig();
                sender.sendMessage(Colors.normalchat(Colors.hexchat("<#",">", pl.PluginPrefix() + pl.WhiteListDisabled)));
            }
        }
        if (args.length == 2) {
            String name = args[1];
            Player pd = sender.getServer().getPlayer(name);
            if (args[0].equalsIgnoreCase("remove")) {
                if (pl.getConfig().getBoolean("OnlineMode")) {
                    if (pd != null) {
                        pl.getCustomConfig().set("Players.UUID." + pd.getUniqueId(), null);
                        File customConfigFile = new File(pl.getDataFolder(), "whitelist.yml");
                        try {
                            pl.getCustomConfig().save(customConfigFile);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                        try {
                            pl.getCustomConfig().load(customConfigFile);
                        } catch (IOException | InvalidConfigurationException ioe) {
                            ioe.printStackTrace();
                        }
                    } else {
                        OfflinePlayer ofpd = Bukkit.getOfflinePlayer(name);
                        pl.getCustomConfig().set("Players.UUID." + ofpd.getUniqueId(), null);
                        File customConfigFile = new File(pl.getDataFolder(), "whitelist.yml");
                        try {
                            pl.getCustomConfig().save(customConfigFile);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                        try {
                            pl.getCustomConfig().load(customConfigFile);
                        } catch (IOException | InvalidConfigurationException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                } else {
                    if (pd != null) {
                        pl.getCustomConfig().set("Players.NickName." + pd.getName(), null);
                        File customConfigFile = new File(pl.getDataFolder(), "whitelist.yml");
                        try {
                            pl.getCustomConfig().save(customConfigFile);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                        try {
                            pl.getCustomConfig().load(customConfigFile);
                        } catch (IOException | InvalidConfigurationException ioe) {
                            ioe.printStackTrace();
                        }
                    } else {
                        OfflinePlayer ofpd = Bukkit.getOfflinePlayer(name);
                        pl.getCustomConfig().set("Players.NickName." + ofpd.getName(), null);
                        File customConfigFile = new File(pl.getDataFolder(), "whitelist.yml");
                        try {
                            pl.getCustomConfig().save(customConfigFile);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                        try {
                            pl.getCustomConfig().load(customConfigFile);
                        } catch (IOException | InvalidConfigurationException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                }
            }
            if (args[0].equalsIgnoreCase("add")) {
                if (pl.getConfig().getBoolean("OnlineMode")) {
                    if (pd != null) {
                    pl.getCustomConfig().set("Players.UUID." + pd.getUniqueId(), ".Everything");
                    pl.getCustomConfig().set("Players.UUID." + pd.getUniqueId() + ".Everything", true);
                    File customConfigFile = new File(pl.getDataFolder(), "whitelist.yml");
                    try {
                        pl.getCustomConfig().save(customConfigFile);
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                    try {
                        pl.getCustomConfig().load(customConfigFile);
                    } catch (IOException | InvalidConfigurationException ioe) {
                        ioe.printStackTrace();
                    }
                } else {
                        OfflinePlayer ofpd = Bukkit.getOfflinePlayer(name);
                        pl.getCustomConfig().set("Players.UUID." + ofpd.getUniqueId(), ".Everything");
                        pl.getCustomConfig().set("Players.UUID." + ofpd.getUniqueId() + ".Everything", true);
                        File customConfigFile = new File(pl.getDataFolder(), "whitelist.yml");
                        try {
                            pl.getCustomConfig().save(customConfigFile);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                        try {
                            pl.getCustomConfig().load(customConfigFile);
                        } catch (IOException | InvalidConfigurationException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                } else {
                    if (pd != null) {
                        pl.getCustomConfig().set("Players.NickName." + pd.getName(), ".Everything");
                        pl.getCustomConfig().set("Players.NickName." + pd.getName() + ".Everything", true);
                        File customConfigFile = new File(pl.getDataFolder(), "whitelist.yml");
                        try {
                            pl.getCustomConfig().save(customConfigFile);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                        try {
                            pl.getCustomConfig().load(customConfigFile);
                        } catch (IOException | InvalidConfigurationException ioe) {
                            ioe.printStackTrace();
                        }
                    } else {
                        OfflinePlayer ofpd = Bukkit.getOfflinePlayer(name);
                        pl.getCustomConfig().set("Players.NickName." + ofpd.getName(), ".Everything");
                        pl.getCustomConfig().set("Players.NickName." + ofpd.getName() + ".Everything", true);
                        File customConfigFile = new File(pl.getDataFolder(), "whitelist.yml");
                        try {
                            pl.getCustomConfig().save(customConfigFile);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                        try {
                            pl.getCustomConfig().load(customConfigFile);
                        } catch (IOException | InvalidConfigurationException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                }
            }
        }
        return false;
    }
}
