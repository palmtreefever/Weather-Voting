package com.palmtreefever.WeatherVoting.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.palmtreefever.WeatherVoting.Main;
import com.palmtreefever.WeatherVoting.Utils.Arrays;

public class PlayerLeave implements Listener {

	String sName = Main.plugin.getConfig().getString("ServerPrefix");

	@EventHandler
	public void playerleft(PlayerQuitEvent event) {
		String quitter = event.getPlayer().getName();
		if(Arrays.voters.contains(quitter)) {
			Arrays.voters.remove(quitter);
		} else {
			return;
		}
	}
}