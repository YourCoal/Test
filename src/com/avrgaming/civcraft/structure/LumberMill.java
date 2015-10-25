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

public class LumberMill extends Structure {
	public static final int OAK_MAX = CivSettings.getIntegerStructure("lumber_oak.max");
	public static final int SPRUCE_MAX = CivSettings.getIntegerStructure("lumber_spruce.max");
	public static final int BIRCH_MAX = CivSettings.getIntegerStructure("lumber_birch.max");
	public static final int JUNGLE_MAX = CivSettings.getIntegerStructure("lumber_jungle.max");
	
	private static final double OAK_LOG_RATE = CivSettings.getDoubleStructure("lumber_oak.log_rate");
	private static final double OAK_SAP_RATE = CivSettings.getDoubleStructure("lumber_oak.sap_rate");
	
	private static final double SPRUCE_LOG_RATE = CivSettings.getDoubleStructure("lumber_spruce.log_rate");
	private static final double SPRUCE_SAP_RATE = CivSettings.getDoubleStructure("lumber_spruce.sap_rate");
	
	private static final double BIRCH_LOG_RATE = CivSettings.getDoubleStructure("lumber_birch.log_rate");
	private static final double BIRCH_SAP_RATE = CivSettings.getDoubleStructure("lumber_birch.sap_rate");
	
	private static final double JUNGLE_LOG_RATE = CivSettings.getDoubleStructure("lumber_jungle.log_rate");
	private static final double JUNGLE_SAP_RATE = CivSettings.getDoubleStructure("lumber_jungle.sap_rate");
	
	private int level = 1;
	public int skippedCounter = 0;
	public ReentrantLock lock = new ReentrantLock();
	
	public enum Woods {
		LOG,
		SAP
	}
	
	protected LumberMill(Location center, String id, Town town) throws CivException {
		super(center, id, town);	
	}
	
	public LumberMill(ResultSet rs) throws SQLException, CivException {
		super(rs);
	}
	
	@Override
	public String getDynmapDescription() {
		String out = "<u><b>Lumber Mill</u></b><br/>";
		out += "Level: "+this.level;
		return out;
	}
	
	@Override
	public String getMarkerIconName() {
		return "tree";
	}
	
	public double getOakCutting(Woods wood) {
		double chance = 0;
		switch (wood) {
		case LOG:
			chance = OAK_LOG_RATE;
			break;
		case SAP:
			chance = OAK_SAP_RATE;
		default:
			break;
		}
		return this.modifyChance(chance);
	}
	
	public double getSpruceCutting(Woods wood) {
		double chance = 0;
		switch (wood) {
		case LOG:
			chance = SPRUCE_LOG_RATE;
			break;
		case SAP:
			chance = SPRUCE_SAP_RATE;
			break;
		}
		return this.modifyChance(chance);
	}
	
	public double getBirchCutting(Woods wood) {
		double chance = 0;
		switch (wood) {
		case LOG:
			chance = BIRCH_LOG_RATE;
			break;
		case SAP:
			chance = BIRCH_SAP_RATE;
			break;
		}
		return this.modifyChance(chance);
	}
	
	public double getJungleCutting(Woods wood) {
		double chance = 0;
		switch (wood) {
		case LOG:
			chance = JUNGLE_LOG_RATE;
			break;
		case SAP:
			chance = JUNGLE_SAP_RATE;
			break;
		}
		return this.modifyChance(chance);
	}
	
	private double modifyChance(Double chance) {
		double increase = chance*this.getTown().getBuffManager().getEffectiveDouble(Buff.EXTRACTION);
		chance += increase;
		try {
			if (this.getTown().getGovernment().id.equals("gov_monarchy")) {
				chance *= CivSettings.getDouble(CivSettings.structureConfig, "lumber.monarchy_rate");
			} else if (this.getTown().getGovernment().id.equals("gov_tribalism")){
				chance *= CivSettings.getDouble(CivSettings.structureConfig, "lumber.penalty_rate");
			}
		} catch (InvalidConfiguration e) {
			e.printStackTrace();
		}
		return chance;
	}
	
	@Override
	public void onPostBuild(BlockCoord absCoord, SimpleBlock commandBlock) {
		this.level = getTown().saved_lumber_mill_level;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
}
