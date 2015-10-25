package com.avrgaming.civcraft.structure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.locks.ReentrantLock;

import org.bukkit.Location;

import com.avrgaming.civcraft.config.CivSettings;
import com.avrgaming.civcraft.exception.CivException;
import com.avrgaming.civcraft.exception.InvalidConfiguration;
import com.avrgaming.civcraft.object.Buff;
import com.avrgaming.civcraft.object.Town;
import com.avrgaming.civcraft.util.BlockCoord;
import com.avrgaming.civcraft.util.SimpleBlock;

public class Quarry extends Structure {
	public static final int MAX_CHANCE = CivSettings.getIntegerStructure("quarry.max");
	private static final double COBBLESTONE_RATE = CivSettings.getDoubleStructure("quarry.cobblestone_rate");
	private static final double COAL_ORE = CivSettings.getDoubleStructure("quarry.coal_ore");
	private static final double IRON_ORE = CivSettings.getDoubleStructure("quarry.iron_ore");
	private static final double GOLD_ORE = CivSettings.getDoubleStructure("quarry.gold_ore");
	private static final double LAPIS_ORE = CivSettings.getDoubleStructure("quarry.lapis_ore");
	private static final double REDSTONE_ORE = CivSettings.getDoubleStructure("quarry.redstone_ore");
	private static final double DIAMOND_ORE = CivSettings.getDoubleStructure("quarry.diamond_ore");
	private static final double EMERALD_ORE = CivSettings.getDoubleStructure("quarry.emerald_ore");
	private static final double RARE_RATE = CivSettings.getDoubleStructure("quarry.rare_chance");
	private static final double OTHER_RATE = CivSettings.getDoubleStructure("quarry.other_chance");
	
	private int level = 1;
	public int skippedCounter = 0;
	public ReentrantLock lock = new ReentrantLock();
	
	public enum Mineral {
		COBBLESTONE,
		COAL,
		IRON,
		GOLD,
		LAPIS,
		REDSTONE,
		DIAMOND,
		EMERALD,
		RARE,
		OTHER
	}
	
	protected Quarry(Location center, String id, Town town) throws CivException {
		super(center, id, town);	
	}
	
	public Quarry(ResultSet rs) throws SQLException, CivException {
		super(rs);
	}

	@Override
	public String getDynmapDescription() {
		String out = "<u><b>Quarry</u></b><br/>";
		out += "Level: "+this.level;
		return out;
	}
	
	@Override
	public String getMarkerIconName() {
		return "minecart";
	}

	public double getChance(Mineral mineral) {
		double chance = 0;
		switch (mineral) {
		case OTHER:
			chance = OTHER_RATE;
			break;
		case RARE:
			chance = RARE_RATE;
			break;
		case EMERALD:
			chance = EMERALD_ORE;
			break;
		case DIAMOND:
			chance = DIAMOND_ORE;
			break;
		case REDSTONE:
			chance = REDSTONE_ORE;
			break;
		case LAPIS:
			chance = LAPIS_ORE;
			break;
		case GOLD:
			chance = GOLD_ORE;
			break;
		case IRON:
			chance = IRON_ORE;
			break;
		case COAL:
			chance = COAL_ORE;
			break;
		case COBBLESTONE:
			chance = COBBLESTONE_RATE;
			break;
		}
		return this.modifyChance(chance);
	}
	
	private double modifyChance(Double chance) {
		double increase = chance*this.getTown().getBuffManager().getEffectiveDouble(Buff.EFFICIENCY);
		chance += increase;
		
		try {
			if (this.getTown().getGovernment().id.equals("gov_despotism")) {
				chance *= CivSettings.getDouble(CivSettings.structureConfig, "quarry.despotism_rate");
			} else if (this.getTown().getGovernment().id.equals("gov_theocracy") || this.getTown().getGovernment().id.equals("gov_monarchy")){
				chance *= CivSettings.getDouble(CivSettings.structureConfig, "quarry.penalty_rate");
			}
		} catch (InvalidConfiguration e) {
			e.printStackTrace();
		}
		return chance;
	}
	
	@Override
	public void onPostBuild(BlockCoord absCoord, SimpleBlock commandBlock) {
		this.level = getTown().saved_quarry_level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
