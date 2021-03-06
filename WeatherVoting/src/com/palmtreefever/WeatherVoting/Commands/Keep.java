package com.palmtreefever.WeatherVoting.Commands;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.palmtreefever.WeatherVoting.Main;
import com.palmtreefever.WeatherVoting.Utils.Arrays;

public class Keep implements CommandExecutor {
	String sName = Main.plugin.getConfig().getString("ServerPrefix");

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("weathervotekeep")) {
			if (sender.hasPermission("WeatherVote.Keep")) {
				if (Main.votingPeriod == true) {
					if (Arrays.voters.contains(sender.getName())) {
						if (!Arrays.votersClear.contains(sender.getName())) {
							if (!Arrays.votersKeep.contains(sender.getName())) {
								Arrays.votersKeep.add(sender.getName());
								sender.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + ChatColor.GREEN + "Successfully voted to keep the weather!")));
							} else {
								sender.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + ChatColor.RED + "You already voted to keep the weather!")));
							}
						} else {
							sender.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + ChatColor.RED + "You can not change your vote from clear to keep!")));
						}
					} else {
						sender.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + ChatColor.RED + "You are not apart of the current vote!")));
					}
					// return true;
				} else {
					sender.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + ChatColor.RED + "There is no weather vote currently going on!")));
				}
				return true;
			}
			sender.sendMessage((ChatColor.translateAlternateColorCodes('&',sName + ChatColor.RED + "You do not have permission!")));
		}
		return false;
	}
}