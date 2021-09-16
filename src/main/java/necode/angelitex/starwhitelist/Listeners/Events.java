package necode.angelitex.starwhitelist.Listeners;

import necode.angelitex.starwhitelist.StarWhiteList;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {
    private StarWhiteList pl;
    public Events(StarWhiteList plugin){
        this.pl = plugin;
    }
    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        if (pl.getConfig().getBoolean("WhiteListEnable")) {
            if (pl.getConfig().getBoolean("OnlineMode")){
                if (!pl.getCustomConfig().contains("Players.UUID." + e.getPlayer().getUniqueId())) {
                    e.getPlayer().kickPlayer(pl.NoneWhiteList);
                    return;
                }
                    if (pl.getCustomConfig().getBoolean("PLayers.UUID." + e.getPlayer().getUniqueId() + ".Everything")) {
                        return;
                    }
                    if (pl.getCustomConfig().getBoolean("Players.UUID." + e.getPlayer().getUniqueId() + ".Timed")) {
                        e.getPlayer().sendMessage(pl.PluginPrefix() + "Здравствуйте, у вас осталось времени: %code_time%");
                        return;
                    }
                
                return;
            }
        }
    }
}
