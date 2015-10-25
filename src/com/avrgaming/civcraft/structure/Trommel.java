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

public class Trommel extends Structure {
	public static final int COBBLE_MAX_CHANCE = CivSettings.getIntegerStructure("trommel_cobble.max");
	public static final int GRANITE_MAX_CHANCE = CivSettings.getIntegerStructure("trommel_granite.max");
	public static final int DIORITE_MAX_CHANCE = CivSettings.getIntegerStructure("trommel_diorite.max");
	public static final int ANDESITE_MAX_CHANCE = CivSettings.getIntegerStructure("trommel_andesite.max");
	
	private static final double COBBLE_SMOOTH_RATE = CivSettings.getDoubleStructure("trommel_cobble.smooth_rate");
	private static final double COBBLE_IRON_CHANCE = CivSettings.getDoubleStructure("trommel_cobble.iron_chance");
	private static final double COBBLE_GOLD_CHANCE = CivSettings.getDoubleStructure("trommel_cobble.gold_chance");
	private static final double COBBLE_REDSTONE_CHANCE = CivSettings.getDoubleStructure("trommel_cobble.redstone_chance");
	private static final double COBBLE_DIAMOND_CHANCE = CivSettings.getDoubleStructure("trommel_cobble.diamond_chance");
	private static final double COBBLE_EMERALD_CHANCE = CivSettings.getDoubleStructure("trommel_cobble.emerald_chance");
	
	private static final double GRANITE_POLISH_RATE = CivSettings.getDoubleStructure("trommel_granite.polish_rate");
	private static final double GRANITE_IRON_CHANCE = CivSettings.getDoubleStructure("trommel_granite.iron_chance");
	private static final double GRANITE_GOLD_CHANCE = CivSettings.getDoubleStructure("trommel_granite.gold_chance");
	private static final double GRANITE_REDSTONE_CHANCE = CivSettings.getDoubleStructure("trommel_granite.redstone_chance");
	private static final double GRANITE_DIAMOND_CHANCE = CivSettings.getDoubleStructure("trommel_granite.diamond_chance");
	private static final double GRANITE_EMERALD_CHANCE = CivSettings.getDoubleStructure("trommel_granite.emerald_chance");
	
	private static final double DIORITE_POLISH_RATE = CivSettings.getDoubleStructure("trommel_diorite.polish_rate");
	private static final double DIORITE_IRON_CHANCE = CivSettings.getDoubleStructure("trommel_diorite.iron_chance");
	private static final double DIORITE_GOLD_CHANCE = CivSettings.getDoubleStructure("trommel_diorite.gold_chance");
	private static final double DIORITE_REDSTONE_CHANCE = CivSettings.getDoubleStructure("trommel_diorite.redstone_chance");
	private static final double DIORITE_DIAMOND_CHANCE = CivSettings.getDoubleStructure("trommel_diorite.diamond_chance");
	private static final double DIORITE_EMERALD_CHANCE = CivSettings.getDoubleStructure("trommel_diorite.emerald_chance");
	
	private static final double ANDESITE_POLISH_RATE = CivSettings.getDoubleStructure("trommel_andesite.polish_rate");
	private static final double ANDESITE_IRON_CHANCE = CivSettings.getDoubleStructure("trommel_andesite.iron_chance");
	private static final double ANDESITE_GOLD_CHANCE = CivSettings.getDoubleStructure("trommel_andesite.gold_chance");
	private static final double ANDESITE_REDSTONE_CHANCE = CivSettings.getDoubleStructure("trommel_andesite.redstone_chance");
	private static final double ANDESITE_DIAMOND_CHANCE = CivSettings.getDoubleStructure("trommel_andesite.diamond_chance");
	private static final double ANDESITE_EMERALD_CHANCE = CivSettings.getDoubleStructure("trommel_andesite.emerald_chance");
	
	private int level = 1;
	public int skippedCounter = 0;
	public ReentrantLock lock = new ReentrantLock();
	
	public enum Mineral {
		POLISH,
		EMERALD,
		DIAMOND,
		REDSTONE,
		GOLD,
		IRON
	}
	
	protected Trommel(Location center, String id, Town town) throws CivException {
		super(center, id, town);	
	}
	
	public Trommel(ResultSet rs) throws SQLException, CivException {
		super(rs);
	}
	
	@Override
	public String getDynmapDescription() {
		String out = "<u><b>Trommel</u></b><br/>";
		out += "Level: "+this.level;
		return out;
	}
	
	@Override
	public String getMarkerIconName() {
		return "minecart";
	}
	
	public double getCobbleChance(Mineral mineral) {
		double chance = 0;
		switch (mineral) {
		case EMERALD:
			chance = COBBLE_EMERALD_CHANCE;
			break;
		case DIAMOND:
			chance = COBBLE_DIAMOND_CHANCE;
			break;
		case REDSTONE:
			chance = COBBLE_REDSTONE_CHANCE;
			break;
		case GOLD:
			chance = COBBLE_GOLD_CHANCE;
			break;
		case IRON:
			chance = COBBLE_IRON_CHANCE;
			break;
		case POLISH:
			chance = COBBLE_SMOOTH_RATE;
		default:
			break;
		}
		return this.modifyChance(chance);
	}
	
	public double getGraniteChance(Mineral mineral) {
		double chance = 0;
		switch (mineral) {
		case EMERALD:
			chance = GRANITE_EMERALD_CHANCE;
			break;
		case DIAMOND:
			chance = GRANITE_DIAMOND_CHANCE;
			break;
		case GOLD:
			chance = GRANITE_GOLD_CHANCE;
			break;
		case REDSTONE:
			chance = GRANITE_REDSTONE_CHANCE;
			break;
		case IRON:
			chance = GRANITE_IRON_CHANCE;
			break;
		case POLISH:
			chance = GRANITE_POLISH_RATE;
			break;
		}
		return this.modifyChance(chance);
	}
	
	public double getDioriteChance(Mineral mineral) {
		double chance = 0;
		switch (mineral) {
		case EMERALD:
			chance = DIORITE_EMERALD_CHANCE;
			break;
		case DIAMOND:
			chance = DIORITE_DIAMOND_CHANCE;
			break;
		case GOLD:
			chance = DIORITE_GOLD_CHANCE;
			break;
		case IRON:
			chance = DIORITE_IRON_CHANCE;
			break;
		case REDSTONE:
			chance = DIORITE_REDSTONE_CHANCE;
			break;
		case POLISH:
			chance = DIORITE_POLISH_RATE;
			break;
		}
		return this.modifyChance(chance);
	}
	
	public double getAndesiteChance(Mineral mineral) {
		double chance = 0;
		switch (mineral) {
		case EMERALD:
			chance = ANDESITE_EMERALD_CHANCE;
			break;
		case DIAMOND:
			chance = ANDESITE_DIAMOND_CHANCE;
			break;
		case GOLD:
			chance = ANDESITE_GOLD_CHANCE;
			break;
		case IRON:
			chance = ANDESITE_IRON_CHANCE;
			break;
		case REDSTONE:
			chance = ANDESITE_REDSTONE_CHANCE;
			break;
		case POLISH:
			chance = ANDESITE_POLISH_RATE;
			break;
		}
		return this.modifyChance(chance);
	}
	
	private double modifyChance(Double chance) {
		double increase = chance*this.getTown().getBuffManager().getEffectiveDouble(Buff.EXTRACTION);
		chance += increase;
		try {
			if (this.getTown().getGovernment().id.equals("gov_despotism")) {
				chance *= CivSettings.getDouble(CivSettings.structureConfig, "trommel.despotism_rate");
			} else if (this.getTown().getGovernment().id.equals("gov_anarchy")){
				chance *= CivSettings.getDouble(CivSettings.structureConfig, "trommel.penalty_rate");
			}
		} catch (InvalidConfiguration e) {
			e.printStackTrace();
		}
		return chance;
	}
	
	@Override
	public void onPostBuild(BlockCoord absCoord, SimpleBlock commandBlock) {
		this.level = getTown().saved_trommel_level;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
}
