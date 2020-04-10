package com.palmtreefever.WeatherVoting.Utils;

import java.util.ArrayList;

public class Arrays {

	public static ArrayList<String> voters = new ArrayList<String>();
	public static ArrayList<String> votersClear = new ArrayList<String>();
	public static ArrayList<String> votersKeep = new ArrayList<String>();
	
	public static void clearArrays() {
		voters.clear();
		votersClear.clear();
		votersKeep.clear();
	}
}