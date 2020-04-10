package com.palmtreefever.WeatherVoting.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import com.palmtreefever.WeatherVoting.Utils.Timer;

public class WeatherChange implements Listener {

	@EventHandler
	public void weatherchanged(WeatherChangeEvent event) {
		// System.out.println("Weather changed");
		// delay of 5 seconds to run check
		Timer.startDelayTimer();
	}
}