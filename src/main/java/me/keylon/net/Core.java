package me.keylon.net;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.keylon.net.commands.ToggleOff;
import me.keylon.net.events.PlayerHandler;
import me.keylon.net.utils.Common;

public class Core extends JavaPlugin{
	
	public static Core instance;
	
	@Override
	public void onEnable() {
		getLogger().info("&e&lKingsmen &fhas been enabled!");

		getServer().getPluginManager().registerEvents(new PlayerHandler(), this);
		
		Common.registerCommand(new ToggleOff());
	}
	
	public Core() {
		instance = this;
	
	}

	public static Core getInstance() {
		return instance;
	}

}
