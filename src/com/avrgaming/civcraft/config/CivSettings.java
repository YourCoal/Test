/*************************************************************************
 * 
 * AVRGAMING LLC
 * __________________
 * 
 *  [2013] AVRGAMING LLC
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of AVRGAMING LLC and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to AVRGAMING LLC
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from AVRGAMING LLC.
 */
package com.avrgaming.civcraft.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

import com.avrgaming.civcraft.camp.Camp;
import com.avrgaming.civcraft.endgame.ConfigEndCondition;
import com.avrgaming.civcraft.exception.CivException;
import com.avrgaming.civcraft.exception.InvalidConfiguration;
import com.avrgaming.civcraft.items.units.Unit;
import com.avrgaming.civcraft.loreenhancements.LoreEnhancement;
import com.avrgaming.civcraft.lorestorage.LoreCraftableMaterial;
import com.avrgaming.civcraft.main.CivCraft;
import com.avrgaming.civcraft.main.CivGlobal;
import com.avrgaming.civcraft.main.CivLog;
import com.avrgaming.civcraft.object.Town;
import com.avrgaming.civcraft.randomevents.ConfigRandomEvent;
import com.avrgaming.civcraft.structure.Wall;
import com.avrgaming.civcraft.template.Template;
import com.avrgaming.civcraft.util.ItemManager;
import com.avrgaming.global.perks.Perk;

public class CivSettings {
	
	public static CivCraft plugin;
	public static final long MOB_REMOVE_INTERVAL = 5000;
	
	/* Number of days that you can remain in debt before an action occurs. */
	public static final int GRACE_DAYS = 3;
	public static final int CIV_DEBT_GRACE_DAYS = 7;
	public static final int CIV_DEBT_SELL_DAYS = 14;
	public static final int CIV_DEBT_TOWN_SELL_DAYS = 21;
	public static final int TOWN_DEBT_GRACE_DAYS = 7;
	public static final int TOWN_DEBT_SELL_DAYS = 14;
	
	public static HashSet<Material> switchItems = new HashSet<Material>();
	public static Map<Material, Integer> restrictedItems = new HashMap<Material, Integer>();
	public static Map<Material, Integer> blockPlaceExceptions =  new HashMap<Material, Integer>();
	public static Map<EntityType, Integer> restrictedSpawns = new HashMap<EntityType, Integer>();
	public static HashSet<EntityType> playerEntityWeapons = new HashSet<EntityType>();
	public static HashSet<Integer> alwaysCrumble = new HashSet<Integer>();
	
	public static FileConfiguration civConfig; /* civ.yml */
	public static Map<String, ConfigEndCondition> endConditions = new HashMap<String, ConfigEndCondition>();
	public static Map<String, ConfigPlatinumReward> platinumRewards = new HashMap<String, ConfigPlatinumReward>();
	
	public static FileConfiguration cultureConfig; /* culture.yml */
	public static Map<Integer, ConfigCultureLevel> cultureLevels = new HashMap<Integer, ConfigCultureLevel>();
	private static Map<String, ConfigCultureBiomeInfo> cultureBiomes = new HashMap<String, ConfigCultureBiomeInfo>();
	
	public static FileConfiguration structureConfig; /* structures.yml */
	public static Map<String, ConfigBuildableInfo> structures = new HashMap<String, ConfigBuildableInfo>();
	public static Map<Integer, ConfigGrocerLevel> grocerLevels = new HashMap<Integer, ConfigGrocerLevel>();
	public static Map<Integer, ConfigCottageLevel> cottageLevels = new HashMap<Integer, ConfigCottageLevel>();
	public static ArrayList<ConfigTempleSacrifice> templeSacrifices = new ArrayList<ConfigTempleSacrifice>();
	public static Map<Integer, ConfigMineLevel> mineLevels = new HashMap<Integer, ConfigMineLevel>();
	
	public static FileConfiguration techsConfig; /* techs.yml */
	public static Map<String, ConfigTech> techs = new HashMap<String, ConfigTech>();
	public static Map<Integer, ConfigTechItem> techItems = new HashMap<Integer, ConfigTechItem>();
	public static Map<Integer, ConfigTechPotion> techPotions = new HashMap<Integer, ConfigTechPotion>();
	
	public static FileConfiguration townConfig; /* town.yml */
	public static Map<Integer, ConfigTownLevel> townLevels = new HashMap<Integer, ConfigTownLevel>();
	public static Map<String, ConfigTownUpgrade> townUpgrades = new TreeMap<String, ConfigTownUpgrade>();
	
	public static FileConfiguration wonderConfig; /* wonders.yml */
	public static Map<String, ConfigBuildableInfo> wonders = new HashMap<String, ConfigBuildableInfo>();
	public static Map<String, ConfigWonderBuff> wonderBuffs = new HashMap<String, ConfigWonderBuff>();

	public static FileConfiguration goodsConfig; /* goods.yml */
	public static Map<String, ConfigTradeGood> goods = new HashMap<String, ConfigTradeGood>();
	public static Map<String, ConfigTradeGood> landGoods = new HashMap<String, ConfigTradeGood>();
	public static Map<String, ConfigTradeGood> waterGoods = new HashMap<String, ConfigTradeGood>();
	public static Map<String, ConfigHemisphere> hemispheres = new HashMap<String, ConfigHemisphere>();

	public static FileConfiguration buffConfig;
	public static Map<String, ConfigBuff> buffs = new HashMap<String, ConfigBuff>();
	
	public static FileConfiguration unitConfig;
	public static Map<String, ConfigUnit> units = new HashMap<String, ConfigUnit>();
	
	public static FileConfiguration espionageConfig;
	public static Map<String, ConfigMission> missions = new HashMap<String, ConfigMission>();
	
	public static FileConfiguration governmentConfig; /* governments.yml */
	public static Map<String, ConfigGovernment> governments = new HashMap<String, ConfigGovernment>();
	
	public static FileConfiguration religionConfig; /* governments.yml */
	public static Map<String, ConfigReligion> religions = new HashMap<String, ConfigReligion>();
	
	public static FileConfiguration warConfig; /* war.yml */
	
	public static FileConfiguration scoreConfig; /* score.yml */
	
	public static FileConfiguration perkConfig; /* perks.yml */
	public static Map<String, ConfigPerk> perks = new HashMap<String, ConfigPerk>();

	public static FileConfiguration enchantConfig; /* enchantments.yml */
	public static Map<String, ConfigEnchant> enchants = new HashMap<String, ConfigEnchant>();
	public static float speedtoe_speed;
	public static double speedtoe_consume;
	public static int thorhammerchance;
	public static int punchoutchance;
	
	public static FileConfiguration campConfig; /* camp.yml */
	public static Map<Integer, ConfigCampLonghouseLevel> longhouseLevels = new HashMap<Integer, ConfigCampLonghouseLevel>();
	public static Map<String, ConfigCampUpgrade> campUpgrades = new HashMap<String, ConfigCampUpgrade>();
	
	public static FileConfiguration marketConfig; /* market.yml */
	public static Map<Integer, ConfigMarketItem> marketItems = new HashMap<Integer, ConfigMarketItem>();
	
	public static Set<ConfigStableItem> stableItems = new HashSet<ConfigStableItem>();
	public static HashMap<Integer, ConfigStableHorse> horses = new HashMap<Integer, ConfigStableHorse>();
	
	public static FileConfiguration happinessConfig; /* happiness.yml */
	public static HashMap<Integer, ConfigTownHappinessLevel> townHappinessLevels = new HashMap<Integer, ConfigTownHappinessLevel>();
	public static HashMap<Integer, ConfigHappinessState> happinessStates = new HashMap<Integer, ConfigHappinessState>();
	
	public static FileConfiguration safetyConfig; /* safety.yml */
	public static HashMap<Integer, ConfigTownSafetyLevel> townSafetyLevels = new HashMap<Integer, ConfigTownSafetyLevel>();
	public static HashMap<Integer, ConfigSafetyState> safetyStates = new HashMap<Integer, ConfigSafetyState>();
	
	public static FileConfiguration materialsConfig; /* materials.yml */
	public static HashMap<String, ConfigMaterial> materials = new HashMap<String, ConfigMaterial>();
	
	public static FileConfiguration randomEventsConfig; /* randomevents.yml */
	public static HashMap<String, ConfigRandomEvent> randomEvents = new HashMap<String, ConfigRandomEvent>();
	public static ArrayList<String> randomEventIDs = new ArrayList<String>();
	
	public static FileConfiguration nocheatConfig; /* nocheatConfig.yml */
	public static HashMap<String, ConfigValidMod> validMods = new HashMap<String, ConfigValidMod>();
	
	public static FileConfiguration fishingConfig; /* fishing.yml */
	public static ArrayList<ConfigFishing> fishingDrops = new ArrayList<ConfigFishing>();
		
	public static double iron_rate;
	public static double gold_rate;
	public static double diamond_rate;
	public static double emerald_rate;
	public static double startingCoins;
	
	public static ArrayList<String> kitItems = new ArrayList<String>();
	public static HashMap<Integer, ConfigRemovedRecipes> removedRecipies = new HashMap<Integer, ConfigRemovedRecipes>();
	public static HashSet<Material> restrictedUndoBlocks = new HashSet<Material>();
	public static boolean hasVanishNoPacket = false;
	
	public static final String STAFF = "civ.staff";
	public static final String ADMIN = "civ.admin";
	public static final String MINI_ADMIN = "civ.miniadmin";
	public static final String ECONOMY = "civ.econ";
	public static final String HACKERS = "civ.hacker";
	public static final String PERK_LIST = "civ.perk_list";
//	public static final String HACKER = "civ.hacker";
//	public static final String MINI_ADMIN = "civ.admin";
//	public static final String MODERATOR = "civ.moderator";
//	public static final String FREE_PERKS = "civ.freeperks";
//	public static final String ECON = "civ.econ";
	public static final int MARKET_COIN_STEP = 2;
	public static final int MARKET_BUYSELL_COIN_DIFF = 15;
	public static final int MARKET_STEP_THRESHOLD = 2;
	
	public static void init(JavaPlugin plugin) throws FileNotFoundException, IOException, InvalidConfigurationException, InvalidConfiguration {
		CivSettings.plugin = (CivCraft)plugin;
		
		// Check for required data folder, if it's not there export it.
		CivSettings.validateFiles();
		
		initRestrictedItems();
		initRestrictedUndoBlocks();
		initSwitchItems();
		initRestrictedSpawns();
		initBlockPlaceExceptions();
		initPlayerEntityWeapons();
		
		loadConfigFiles();
		loadConfigObjects();
		
		Perk.init();
		Unit.init();
		
		for (Object obj : civConfig.getList("global.start_kit")) {
			if (obj instanceof String) {
				kitItems.add((String)obj);
			}
		}
		
		CivGlobal.banWords.add("fuck");
		CivGlobal.banWords.add("shit");
		CivGlobal.banWords.add("nigger");
		CivGlobal.banWords.add("faggot");
		CivGlobal.banWords.add("gay");
		CivGlobal.banWords.add("rape");
		CivGlobal.banWords.add("http");
		CivGlobal.banWords.add("cunt");
		
		
		iron_rate = CivSettings.getDouble(civConfig, "ore_rates.iron");
		gold_rate = CivSettings.getDouble(civConfig, "ore_rates.gold");
		diamond_rate = CivSettings.getDouble(civConfig, "ore_rates.diamond");
		emerald_rate = CivSettings.getDouble(civConfig, "ore_rates.emerald");
		startingCoins = CivSettings.getDouble(civConfig, "global.starting_coins");
		
		
		alwaysCrumble.add(ItemManager.getId(Material.BEDROCK));
		alwaysCrumble.add(ItemManager.getId(Material.BEACON));
		alwaysCrumble.add(ItemManager.getId(Material.OBSIDIAN));
		alwaysCrumble.add(ItemManager.getId(Material.IRON_BLOCK));
		alwaysCrumble.add(ItemManager.getId(Material.GOLD_BLOCK));
		alwaysCrumble.add(ItemManager.getId(Material.DIAMOND_BLOCK));
		alwaysCrumble.add(ItemManager.getId(Material.EMERALD_BLOCK));
		alwaysCrumble.add(ItemManager.getId(Material.REDSTONE_BLOCK));
		alwaysCrumble.add(ItemManager.getId(Material.LAPIS_BLOCK));
		
		LoreEnhancement.init();
		LoreCraftableMaterial.buildStaticMaterials();
		LoreCraftableMaterial.buildRecipes();
		Template.initAttachableTypes();
		
		if (CivSettings.plugin.hasPlugin("VanishNoPacket")) {
			hasVanishNoPacket = true;
		}
	}
	
	private static void initRestrictedUndoBlocks() {
		restrictedUndoBlocks.add(Material.CROPS);
		restrictedUndoBlocks.add(Material.CARROT);
		restrictedUndoBlocks.add(Material.POTATO);
		restrictedUndoBlocks.add(Material.REDSTONE);
		restrictedUndoBlocks.add(Material.REDSTONE_WIRE);
		restrictedUndoBlocks.add(Material.REDSTONE_TORCH_OFF);
		restrictedUndoBlocks.add(Material.REDSTONE_TORCH_ON);
		restrictedUndoBlocks.add(Material.DIODE_BLOCK_OFF);
		restrictedUndoBlocks.add(Material.DIODE_BLOCK_ON);
		restrictedUndoBlocks.add(Material.REDSTONE_COMPARATOR_OFF);
		restrictedUndoBlocks.add(Material.REDSTONE_COMPARATOR_ON);
		restrictedUndoBlocks.add(Material.REDSTONE_COMPARATOR);
		restrictedUndoBlocks.add(Material.STRING);
		restrictedUndoBlocks.add(Material.LEVER);
		restrictedUndoBlocks.add(Material.TRIPWIRE);
		restrictedUndoBlocks.add(Material.SUGAR_CANE_BLOCK);
		restrictedUndoBlocks.add(Material.POWERED_RAIL);
		restrictedUndoBlocks.add(Material.RAILS);
		restrictedUndoBlocks.add(Material.DETECTOR_RAIL);
		restrictedUndoBlocks.add(Material.ACTIVATOR_RAIL);
		restrictedUndoBlocks.add(Material.LADDER);
		restrictedUndoBlocks.add(Material.VINE);
		restrictedUndoBlocks.add(Material.WEB);
		restrictedUndoBlocks.add(Material.SAPLING);
		restrictedUndoBlocks.add(Material.STONE_PLATE);
		restrictedUndoBlocks.add(Material.WOOD_PLATE);
		restrictedUndoBlocks.add(Material.GOLD_PLATE);
		restrictedUndoBlocks.add(Material.IRON_PLATE);
		restrictedUndoBlocks.add(Material.TRIPWIRE_HOOK);
		restrictedUndoBlocks.add(Material.MELON_STEM);
		restrictedUndoBlocks.add(Material.PUMPKIN_STEM);
	}
	
	private static void initPlayerEntityWeapons() {
		playerEntityWeapons.add(EntityType.PLAYER);
		playerEntityWeapons.add(EntityType.ARROW);
		playerEntityWeapons.add(EntityType.EGG);
		playerEntityWeapons.add(EntityType.SNOWBALL);
		playerEntityWeapons.add(EntityType.SPLASH_POTION);
		playerEntityWeapons.add(EntityType.FISHING_HOOK);
	}
	
	public static void validateFiles() {
//		if (plugin == null) {
//			CivLog.debug("null plugin");
//		}
//		
//		if (plugin.getDataFolder() == null) {
//			CivLog.debug("null data folder");
//		}
//		
//		if (plugin.getDataFolder().getPath() == null) {
//			CivLog.debug("path null");
//		}
		File data = new File(plugin.getDataFolder().getPath()+"/data");
		if (!data.exists()) {
			data.mkdirs();
		}
	}
	
	public static void streamResourceToDisk(String filepath) throws IOException {
		URL inputUrl = plugin.getClass().getResource(filepath);
		File dest = new File(plugin.getDataFolder().getPath()+filepath);
		FileUtils.copyURLToFile(inputUrl, dest);
	}
	
	public static FileConfiguration loadCivConfig(String filepath) throws FileNotFoundException, IOException, InvalidConfigurationException {

		File file = new File(plugin.getDataFolder().getPath()+"/data/"+filepath);
		if (!file.exists()) {
			CivLog.warning("Configuration file:"+filepath+" was missing. Streaming to disk from Jar.");
			streamResourceToDisk("/data/"+filepath);
		}
		
		CivLog.info("Loading Configuration file:"+filepath);
		// read the config.yml into memory
		YamlConfiguration cfg = new YamlConfiguration(); 
		cfg.load(file);
		return cfg;
	}
	
	private static void loadConfigFiles() throws FileNotFoundException, IOException, InvalidConfigurationException {
		buffConfig = loadCivConfig("buffs.yml");
		campConfig = loadCivConfig("camp.yml");
		civConfig = loadCivConfig("civ.yml");
		cultureConfig = loadCivConfig("culture.yml");
		enchantConfig = loadCivConfig("enchantments.yml");
		espionageConfig = loadCivConfig("espionage.yml");
		fishingConfig = loadCivConfig("fishing.yml");
		goodsConfig = loadCivConfig("goods.yml");
		governmentConfig = loadCivConfig("governments.yml");
		religionConfig = loadCivConfig("religions.yml");
		happinessConfig = loadCivConfig("happiness.yml");
		marketConfig = loadCivConfig("market.yml");
		materialsConfig = loadCivConfig("materials.yml");
		nocheatConfig = loadCivConfig("nocheat.yml");
		perkConfig = loadCivConfig("perks.yml");
		randomEventsConfig = loadCivConfig("randomevents.yml");
		safetyConfig = loadCivConfig("safety.yml");
		scoreConfig = loadCivConfig("score.yml");
		structureConfig = loadCivConfig("structures.yml");
		techsConfig = loadCivConfig("techs.yml");
		townConfig = loadCivConfig("town.yml");
		unitConfig = loadCivConfig("units.yml");
		warConfig = loadCivConfig("war.yml");
		wonderConfig = loadCivConfig("wonders.yml");
	}
	
	private static void loadConfigObjects() throws InvalidConfiguration {
		ConfigTownSafetyLevel.loadConfig(safetyConfig, townSafetyLevels);
		ConfigSafetyState.loadConfig(safetyConfig, safetyStates);
		ConfigTownLevel.loadConfig(townConfig, townLevels);
		ConfigTownUpgrade.loadConfig(townConfig, townUpgrades);
		ConfigCultureLevel.loadConfig(cultureConfig, cultureLevels);
		ConfigBuildableInfo.loadConfig(structureConfig, "structures", structures, false);
		ConfigBuildableInfo.loadConfig(wonderConfig, "wonders", wonders, true);
		ConfigTech.loadConfig(techsConfig, techs);
		ConfigTechItem.loadConfig(techsConfig, techItems);
		ConfigTechPotion.loadConfig(techsConfig, techPotions);
		ConfigHemisphere.loadConfig(goodsConfig, hemispheres);
		ConfigBuff.loadConfig(buffConfig, buffs);
		ConfigWonderBuff.loadConfig(wonderConfig, wonderBuffs);
		ConfigTradeGood.loadConfig(goodsConfig, goods, landGoods, waterGoods);
		ConfigGrocerLevel.loadConfig(structureConfig, grocerLevels);
		ConfigCottageLevel.loadConfig(structureConfig, cottageLevels);
		ConfigTempleSacrifice.loadConfig(structureConfig, templeSacrifices);
		ConfigMineLevel.loadConfig(structureConfig, mineLevels);
		ConfigGovernment.loadConfig(governmentConfig, governments);
		ConfigReligion.loadConfig(religionConfig, religions);
		ConfigEnchant.loadConfig(enchantConfig, enchants);
		ConfigUnit.loadConfig(unitConfig, units);
		ConfigMission.loadConfig(espionageConfig, missions);
		ConfigPerk.loadConfig(perkConfig, perks);
		ConfigCampLonghouseLevel.loadConfig(campConfig, longhouseLevels);
		ConfigCampUpgrade.loadConfig(campConfig, campUpgrades);
		ConfigMarketItem.loadConfig(marketConfig, marketItems);
		ConfigStableItem.loadConfig(structureConfig, stableItems);
		ConfigStableHorse.loadConfig(structureConfig, horses);
		ConfigTownHappinessLevel.loadConfig(happinessConfig, townHappinessLevels);
		ConfigHappinessState.loadConfig(happinessConfig, happinessStates);
		ConfigCultureBiomeInfo.loadConfig(cultureConfig, cultureBiomes);
		ConfigMaterial.loadConfig(materialsConfig, materials);
		ConfigRandomEvent.loadConfig(randomEventsConfig, randomEvents, randomEventIDs);
		ConfigEndCondition.loadConfig(civConfig, endConditions);
		ConfigPlatinumReward.loadConfig(civConfig, platinumRewards);
		ConfigValidMod.loadConfig(nocheatConfig, validMods);
		ConfigFishing.loadConfig(fishingConfig, fishingDrops);
	
		ConfigRemovedRecipes.removeRecipes(materialsConfig, removedRecipies );
		CivGlobal.preGenerator.preGenerate();
		Wall.init_settings();
	}

	private static void initRestrictedSpawns() {
		restrictedSpawns.put(EntityType.BLAZE, 0);
		restrictedSpawns.put(EntityType.CAVE_SPIDER, 0);
		restrictedSpawns.put(EntityType.CREEPER, 0);
		restrictedSpawns.put(EntityType.ENDER_DRAGON, 0);
		restrictedSpawns.put(EntityType.ENDERMAN, 0);
		restrictedSpawns.put(EntityType.GHAST, 0);
		restrictedSpawns.put(EntityType.GIANT, 0);
		restrictedSpawns.put(EntityType.PIG_ZOMBIE, 0);
		restrictedSpawns.put(EntityType.SILVERFISH, 0);
		restrictedSpawns.put(EntityType.SKELETON, 0);
		restrictedSpawns.put(EntityType.SLIME, 0);
		restrictedSpawns.put(EntityType.SPIDER, 0);
		restrictedSpawns.put(EntityType.WITCH, 0);
		restrictedSpawns.put(EntityType.WITHER, 0);
		restrictedSpawns.put(EntityType.ZOMBIE, 0);
	}
	
	private static void initRestrictedItems() {
		// TODO make this configurable? 
		//XXX Added 1.7 and 1.8 Items
		restrictedItems.put(Material.FLINT_AND_STEEL, 0);
		restrictedItems.put(Material.BUCKET, 0);
		restrictedItems.put(Material.WATER_BUCKET, 0);
		restrictedItems.put(Material.LAVA_BUCKET, 0);
		restrictedItems.put(Material.STATIONARY_LAVA, 0);
		restrictedItems.put(Material.STATIONARY_WATER, 0);
		restrictedItems.put(Material.DIODE, 0);
		restrictedItems.put(Material.REDSTONE_COMPARATOR, 0);
		restrictedItems.put(Material.CAKE_BLOCK, 0);
		restrictedItems.put(Material.CAULDRON, 0);
		restrictedItems.put(Material.ITEM_FRAME, 0);
		restrictedItems.put(Material.PAINTING, 0);
		restrictedItems.put(Material.INK_SACK, 0);
		restrictedItems.put(Material.SHEARS, 0);
		restrictedItems.put(Material.TNT, 0);
		
		restrictedItems.put(Material.LEASH, 0);
		restrictedItems.put(Material.NAME_TAG, 0);
		restrictedItems.put(Material.ARMOR_STAND, 0);
		
		restrictedItems.put(Material.BOAT, 0);
		restrictedItems.put(Material.MINECART, 0);
		restrictedItems.put(Material.STORAGE_MINECART, 0);
		restrictedItems.put(Material.POWERED_MINECART, 0);
		restrictedItems.put(Material.EXPLOSIVE_MINECART, 0);
		restrictedItems.put(Material.HOPPER_MINECART, 0);
		restrictedItems.put(Material.COMMAND_MINECART, 0);
	}

	private static void initSwitchItems() {
		//TODO make this configurable?
		//XXX Added 1.8 Items
		switchItems.add(Material.DISPENSER);
		switchItems.add(Material.NOTE_BLOCK);
		switchItems.add(Material.TNT);
		switchItems.add(Material.CHEST);
		switchItems.add(Material.TRAPPED_CHEST);
		switchItems.add(Material.ENDER_CHEST);
		switchItems.add(Material.FURNACE);
		switchItems.add(Material.BURNING_FURNACE);
		switchItems.add(Material.WOOD_DOOR);
		switchItems.add(Material.WOODEN_DOOR);
		switchItems.add(Material.SPRUCE_DOOR);
		switchItems.add(Material.BIRCH_DOOR);
		switchItems.add(Material.JUNGLE_DOOR);
		switchItems.add(Material.ACACIA_DOOR);
		switchItems.add(Material.DARK_OAK_DOOR);
		switchItems.add(Material.IRON_DOOR);
		switchItems.add(Material.LEVER);
		switchItems.add(Material.WOOD_PLATE);
		switchItems.add(Material.STONE_PLATE);
		switchItems.add(Material.WOOD_BUTTON);
		switchItems.add(Material.STONE_BUTTON);
		switchItems.add(Material.GOLD_PLATE);
		switchItems.add(Material.IRON_PLATE);
		switchItems.add(Material.JUKEBOX);
		switchItems.add(Material.CAKE_BLOCK);
		switchItems.add(Material.DIODE);
		switchItems.add(Material.DIODE_BLOCK_OFF);
		switchItems.add(Material.DIODE_BLOCK_ON);
		switchItems.add(Material.REDSTONE_COMPARATOR);
		switchItems.add(Material.REDSTONE_COMPARATOR_ON);
		switchItems.add(Material.REDSTONE_COMPARATOR_OFF);
		switchItems.add(Material.TRAP_DOOR);
		switchItems.add(Material.IRON_TRAPDOOR);
		switchItems.add(Material.FENCE_GATE);
		switchItems.add(Material.SPRUCE_FENCE_GATE);
		switchItems.add(Material.BIRCH_FENCE_GATE);
		switchItems.add(Material.JUNGLE_FENCE_GATE);
		switchItems.add(Material.ACACIA_FENCE_GATE);
		switchItems.add(Material.DARK_OAK_FENCE_GATE);
		switchItems.add(Material.ENCHANTMENT_TABLE);
		switchItems.add(Material.BREWING_STAND);
		switchItems.add(Material.CAULDRON);
		switchItems.add(Material.DRAGON_EGG);
		switchItems.add(Material.COMMAND);
		switchItems.add(Material.BEACON);
		switchItems.add(Material.ANVIL);
		switchItems.add(Material.DAYLIGHT_DETECTOR);
		switchItems.add(Material.HOPPER);
		switchItems.add(Material.DROPPER);
		switchItems.add(Material.ARMOR_STAND);
		
		switchItems.add(Material.BOAT);
		switchItems.add(Material.MINECART);
		switchItems.add(Material.STORAGE_MINECART);
		switchItems.add(Material.POWERED_MINECART);
		switchItems.add(Material.EXPLOSIVE_MINECART);
		switchItems.add(Material.HOPPER_MINECART);
		switchItems.add(Material.COMMAND_MINECART);
	}
	
	private static void initBlockPlaceExceptions() {
		/* These blocks can be placed regardless of permissions.
		 * this is currently used only for blocks that are generated
		 * by specific events such as portal or fire creation.
		 */
		blockPlaceExceptions.put(Material.FIRE, 0);
		blockPlaceExceptions.put(Material.PORTAL, 0);
	}
	
	public static String getStringBase(String path) throws InvalidConfiguration {
		return getString(plugin.getConfig(), path);
	}
	
	public static double getDoubleTown(String path) throws InvalidConfiguration {
		return getDouble(townConfig, path);
	}
	
	public static double getDoubleCiv(String path) throws InvalidConfiguration {
		return getDouble(civConfig, path);
	}
	
	public static void saveGenID(String gen_id) {
		try {
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("plugins/CivCraft/genid.data")));
			writer.write(gen_id);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getGenID() {
		String genid = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("plugins/CivCraft/genid.data"));
			genid = br.readLine();
			br.close();
		} catch (IOException e) {
		}
		return genid;
	}
	
	public static Double getDoubleStructure(String path) {
		Double ret;
		try {
			ret = getDouble(structureConfig, path);
		} catch (InvalidConfiguration e) {
			ret = 0.0;
			e.printStackTrace();
		}
		return ret;
	}
	
	public static int getIntegerStructure(String path) {
		Integer ret;
		try {
			ret = getInteger(structureConfig, path);
		} catch (InvalidConfiguration e) {
			ret = 0;
			e.printStackTrace();
		}
		return ret;
	}
	
	public static Integer getIntegerGovernment(String path) {
		Integer ret;
		try {
			ret = getInteger(governmentConfig, path);
		} catch (InvalidConfiguration e) {
			ret = 0;
			e.printStackTrace();
		}
		return ret;
	}
	
	public static Integer getInteger(FileConfiguration cfg, String path) throws InvalidConfiguration {
		if (!cfg.contains(path)) {
			throw new InvalidConfiguration("Could not get configuration integer "+path);
		}
		int data = cfg.getInt(path);
		return data;
	}
	
	public static String getString(FileConfiguration cfg, String path) throws InvalidConfiguration {
		String data = cfg.getString(path);
		if (data == null) {
			throw new InvalidConfiguration("Could not get configuration string "+path);
		}
		return data;
	}
	
	public static double getDouble(FileConfiguration cfg, String path) throws InvalidConfiguration {
		if (!cfg.contains(path)) {
			throw new InvalidConfiguration("Could not get configuration double "+path);
		}
		double data = cfg.getDouble(path);
		return data;
	}
	
	public static int getMaxNameLength() {
		// TODO make this configurable?
		return 64;
	}
	
	public static String getNameCheckRegex() throws InvalidConfiguration {
		return getStringBase("regex.name_check_regex");
	}

	public static String getNameFilterRegex() throws InvalidConfiguration {
		return getStringBase("regex.name_filter_regex");
	}

	public static String getNameRemoveRegex() throws InvalidConfiguration {
		return getStringBase("regex.name_remove_regex");
	}
	
	public static ConfigTownUpgrade getUpgradeByName(String name) {
		for (ConfigTownUpgrade upgrade : townUpgrades.values()) {
			if (upgrade.name.equalsIgnoreCase(name)) {
				return upgrade;
			}
		}
		return null;
	}
	
	public static ConfigHappinessState getHappinessState(double amount) {
		ConfigHappinessState closestState = happinessStates.get(0);
		
		for (int i = 0; i < happinessStates.size(); i++) {
			ConfigHappinessState state = happinessStates.get(i);
			amount = (double) Math.round(amount * 100) / 100;
			if (amount >= state.amount) {
				closestState = state;
			}
		}
		return closestState;
	}
	
	public static ConfigSafetyState getSafetyState(double amount) {
		ConfigSafetyState closestState = safetyStates.get(0);
		for (int i = 0; i < safetyStates.size(); i++) {
			ConfigSafetyState state = safetyStates.get(i);
			amount = (double) Math.round(amount * 100) / 100;
			if (amount >= state.amount) {
				closestState = state;
			}
		}
		return closestState;
	}
	
	public static ConfigTownUpgrade getUpgradeByNameRegex(Town town, String name) throws CivException {
		ConfigTownUpgrade returnUpgrade = null;
		for (ConfigTownUpgrade upgrade : townUpgrades.values()) {
			if (!upgrade.isAvailable(town)) {
				continue;
			}
			
			if (name.equalsIgnoreCase(upgrade.name)) {
				return upgrade;
			}
			
			String loweredUpgradeName = upgrade.name.toLowerCase();
			String loweredName = name.toLowerCase();
			
			if (loweredUpgradeName.contains(loweredName)) {
				if (returnUpgrade == null) {
					returnUpgrade = upgrade;
				} else {
					throw new CivException(name+" is not specific enough to single out only one upgrade.");
				}
			}
		}
		return returnUpgrade;
	}
	
	public static ConfigCampUpgrade getCampUpgradeByNameRegex(Camp camp, String name) throws CivException {
		ConfigCampUpgrade returnUpgrade = null;
		for (ConfigCampUpgrade upgrade : campUpgrades.values()) {
			if (!upgrade.isAvailable(camp)) {
				continue;
			}
			
			if (name.equalsIgnoreCase(upgrade.name)) {
				return upgrade;
			}
			
			String loweredUpgradeName = upgrade.name.toLowerCase();
			String loweredName = name.toLowerCase();
			
			if (loweredUpgradeName.contains(loweredName)) {
				if (returnUpgrade == null) {
					returnUpgrade = upgrade;
				} else {
					throw new CivException(name+" is not specific enough to single out only one upgrade.");
				}
			}
		}
		return returnUpgrade;
	}
	
	public static ConfigBuildableInfo getBuildableInfoByName(String fullArgs) {
		for (ConfigBuildableInfo sinfo : structures.values()) {
			if (sinfo.displayName.equalsIgnoreCase(fullArgs)) {
				return sinfo;
			}
		}
		
		for (ConfigBuildableInfo sinfo : wonders.values()) {
			if (sinfo.displayName.equalsIgnoreCase(fullArgs)) {
				return sinfo;
			}
		}
		return null;
	}
	
	public static ConfigTech getTechByName(String techname) {
		for (ConfigTech tech : techs.values()) {
			if (tech.name.equalsIgnoreCase(techname)) {
				return tech;
			}
		}
		return null;
	}
	
	public static int getCottageMaxLevel() {
		int returnLevel = 0;
		for (Integer level : cottageLevels.keySet()) {
			if (returnLevel < level) {
				returnLevel = level;
			}
		}
		return returnLevel;
	}
	
	public static int getMineMaxLevel() {
		int returnLevel = 0;
		for (Integer level : mineLevels.keySet()) {
			if (returnLevel < level) {
				returnLevel = level;
			}
		}
		return returnLevel;
	}
	
	public static int getMaxCultureLevel() {
		int returnLevel = 0;
		for (Integer level : cultureLevels.keySet()) {
			if (returnLevel < level) {
				returnLevel = level;
			}
		}
		return returnLevel;
	}
	
	public static ConfigCultureBiomeInfo getCultureBiome(String name) {
		ConfigCultureBiomeInfo biomeInfo = cultureBiomes.get(name);
		if (biomeInfo == null) {
			biomeInfo = cultureBiomes.get("UNKNOWN");
		}
		return biomeInfo;
	}
}
