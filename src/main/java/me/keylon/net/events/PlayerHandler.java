package me.keylon.net.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.keylon.net.utils.Common;
import me.keylon.net.utils.SimpleConfig;
import me.keylon.net.utils.Toggles;

public class PlayerHandler implements Listener {
	
	@EventHandler
	public void onChat(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        String message = e.getMessage().replaceAll("/", "");
        String[] args = message.split(" ");
        String cmd = args[0];
        if (args.length == 0) return;
        SimpleConfig cfg = new SimpleConfig("config.yml");
        for(String blockedWord : cfg.getStringList("Blocked-Commands")) {
        	
		if(e.getMessage().contains(blockedWord.toString()) || e.getMessage().startsWith(blockedWord.toString())) {
			for(Player pa : Bukkit.getOnlinePlayers()) {
				if(pa.hasPermission("worldeditsupervisor.supervise")) {
					if(!Toggles.getEnabled().contains(pa.getDisplayName())) {
					Common.tell(pa, "&8(&b" + e.getPlayer().getDisplayName() + "&8)&7 used command &8» &e" + cmd);
					}
				}
			}
		}
		}
    }
}
