package com.palmtreefever.WeatherVoting;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.palmtreefever.WeatherVoting.Commands.Clear;
import com.palmtreefever.WeatherVoting.Commands.Keep;
import com.palmtreefever.WeatherVoting.Events.PlayerLeave;
import com.palmtreefever.WeatherVoting.Events.WeatherChange;

public class Main extends JavaPlugin implements Listener {
	
	public static Boolean votingPeriod = false;
	public static Plugin plugin;
	
	public void onEnable() {
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new WeatherChange(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerLeave(), this);
		getCommand("weathervoteclear").setExecutor(new Clear());
		getCommand("weathervotekeep").setExecutor(new Keep());
		loadConfig();
	}

	public void onDisable() {
		saveDefaultConfig();
	}

	private void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}
}