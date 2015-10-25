package com.avrgaming.civcraft.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;

import com.avrgaming.civcraft.main.CivLog;
import com.avrgaming.civcraft.object.Town;

public class ConfigReligion {

	public String id;
	public String displayName;
	
	public double growth_rate;
	public double culture_rate;
	public double hammer_rate;
	public double beaker_rate;
	
	public static void loadConfig(FileConfiguration cfg, Map<String, ConfigReligion> religion_map) {
		religion_map.clear();
		List<Map<?, ?>> techs = cfg.getMapList("religions");
		for (Map<?, ?> level : techs) {
			ConfigReligion rg = new ConfigReligion();
			
			rg.id = (String)level.get("id");
			rg.displayName = (String)level.get("displayName");
			
			rg.culture_rate = (Double)level.get("culture_rate");
			rg.hammer_rate = (Double)level.get("hammer_rate");
			rg.beaker_rate = (Double)level.get("beaker_rate");
			rg.growth_rate = (Double)level.get("growth_rate");

			religion_map.put(rg.id, rg);
		}
		CivLog.info("Loaded "+religion_map.size()+" religions.");		
	}

	public static ArrayList<ConfigReligion> getAvailableReligions(Town town) {
		ArrayList<ConfigReligion> govs = new ArrayList<ConfigReligion>();
		
		for (ConfigReligion rg : CivSettings.religions.values()) {
			if (rg.id.equalsIgnoreCase("religion:athiesism")) {
				continue;
			}
			govs.add(rg);
		}
		return govs;
	}

	public static ConfigReligion getReligionFromName(String string) {
		for (ConfigReligion rg : CivSettings.religions.values()) {
			if (rg.id.equalsIgnoreCase("religion:athiesism")) {
				continue;
			}
			if (rg.displayName.equalsIgnoreCase(string)) {
				return rg;
			}
		}
		return null;
	}
}
