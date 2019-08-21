package me.keylon.net.commands;

import org.bukkit.entity.Player;

import me.keylon.net.utils.Common;
import me.keylon.net.utils.Toggles;

public class ToggleOff extends PlayerCommand {

	public ToggleOff() {
		super("wesup");
	}

	@Override
	protected void run(Player player, String[] args) {
		if(player.hasPermission("worldeditsupervisor.toggle")) {
		if(!Toggles.getEnabled().contains(player.getDisplayName())) {
			Toggles.getEnabled().add(player.getDisplayName());
			Common.tell(player, "&cWorldEdit Supervisor Toggled Off!");
		} else {
			Toggles.getEnabled().remove(Toggles.getEnabled().indexOf(player.getDisplayName()));
			Common.tell(player, "&aWorldEdit Supervisor Toggled On!");
		}
		} else {
			Common.tell(player, "&cYou do not have permission to preform this command.");
		}
	}

}
