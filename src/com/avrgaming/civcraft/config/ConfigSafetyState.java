package com.avrgaming.civcraft.config;

import java.util.List;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;

import com.avrgaming.civcraft.main.CivLog;

public class ConfigSafetyState {
	public int level;
	public String name;
	public String color;
	public double amount;
	public double beaker_rate;
	public double coin_rate;
	public double culture_rate;
	public double hammer_rate;
	
	public static void loadConfig(FileConfiguration cfg, Map<Integer, ConfigSafetyState> happiness_states) {
		happiness_states.clear();
		List<Map<?, ?>> list = cfg.getMapList("safety.states");
		for (Map<?,?> cl : list) {
			
			ConfigSafetyState happy_level = new ConfigSafetyState();
			happy_level.level = (Integer)cl.get("level");
			happy_level.name = (String)cl.get("name");
			happy_level.color = (String)cl.get("color");
			happy_level.amount = (Double)cl.get("amount");
			happy_level.beaker_rate = (Double)cl.get("beaker_rate");
			happy_level.coin_rate = (Double)cl.get("coin_rate");
			happy_level.culture_rate = (Double)cl.get("culture_rate");
			happy_level.hammer_rate = (Double)cl.get("hammer_rate");
			happiness_states.put(happy_level.level, happy_level);
		}
		CivLog.info("Loaded "+happiness_states.size()+" Safety States.");		
	}
}
