 package com.avrgaming.civcraft.tutorial;

import gpl.AttributeUtil;

import java.util.LinkedList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.avrgaming.civcraft.config.ConfigMaterial;
import com.avrgaming.civcraft.config.ConfigMaterialCategory;
import com.avrgaming.civcraft.lorestorage.LoreCraftableMaterial;
import com.avrgaming.civcraft.lorestorage.LoreGuiItem;
import com.avrgaming.civcraft.lorestorage.LoreGuiItemListener;
import com.avrgaming.civcraft.lorestorage.LoreMaterial;
import com.avrgaming.civcraft.main.CivGlobal;
import com.avrgaming.civcraft.util.CivColor;
import com.avrgaming.civcraft.util.ItemManager;

public class CivTutorial {
	
	//XXX New Inventories
	public static Inventory leTutorialInventory = null;
	public static Inventory strucInfoTutorialInventory = null;
	public static Inventory tech1TutorialInventory = null;
	public static Inventory tech2TutorialInventory = null;
	public static Inventory strucTutorialInventory = null;
	public static Inventory wonderTutorialInventory = null;
	public static Inventory mobTutorialInventory = null;
	public static Inventory airInventory = null;
	//XXX Original Ones
	public static Inventory tutorialInventory = null;
	public static Inventory craftingHelpInventory = null;
	public static Inventory guiInventory = null;
	public static final int MAX_CHEST_SIZE = 6;
	
	//XXX New Inventories
	public static void showleInventory(Player player) {	
		if (leTutorialInventory == null) {
			leTutorialInventory = Bukkit.getServer().createInventory(player, 9*5, "Library Enchantments");
			
			//XXX Level 1
			leTutorialInventory.setItem(0, LoreGuiItem.build(ChatColor.BOLD+"Level 1", ItemManager.getId(Material.COAL_ORE), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			
			leTutorialInventory.setItem(2, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			
			//XXX Level 2
			leTutorialInventory.setItem(9, LoreGuiItem.build(ChatColor.BOLD+"Level 2", ItemManager.getId(Material.IRON_ORE), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			
			leTutorialInventory.setItem(11, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			
			//XXX Level 3
			leTutorialInventory.setItem(18, LoreGuiItem.build(ChatColor.BOLD+"Level 3", ItemManager.getId(Material.GOLD_ORE), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			
			leTutorialInventory.setItem(20, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			
			//XXX Level 4
			leTutorialInventory.setItem(27, LoreGuiItem.build(ChatColor.BOLD+"Level 4", ItemManager.getId(Material.DIAMOND_ORE), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			
			leTutorialInventory.setItem(29, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			
			//XXX Level 5
			leTutorialInventory.setItem(36, LoreGuiItem.build(ChatColor.BOLD+"Level 5", ItemManager.getId(Material.EMERALD_ORE), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			
			leTutorialInventory.setItem(38, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
		
			LoreGuiItemListener.guiInventories.put(leTutorialInventory.getName(), leTutorialInventory);
		}
		
		if (player != null && player.isOnline() && player.isValid()) {
			player.openInventory(leTutorialInventory);	
		}
	}
	
	public static void showStrucInfoTutorialInventory(Player player) {	
		if (strucInfoTutorialInventory == null) {
			strucInfoTutorialInventory = Bukkit.getServer().createInventory(player, 9*4, "Upgrades & Rates Tutorial");
		
			strucInfoTutorialInventory.setItem(0, LoreGuiItem.build(ChatColor.BOLD+"Trommel", ItemManager.getId(Material.FURNACE), 0, 
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Cobblestone Output:",
					ChatColor.RESET+CivColor.Rose+CivColor.ITALIC+"Iron Ingot: 5%",
					ChatColor.RESET+CivColor.Rose+CivColor.ITALIC+"Gold Ingot: 2.5%",
					ChatColor.RESET+CivColor.Rose+CivColor.ITALIC+"Diamond: 0.065%",
					ChatColor.RESET+CivColor.Rose+CivColor.ITALIC+"Emerald: 0.025%",
					ChatColor.RESET+CivColor.Rose+CivColor.ITALIC+"Chromium: 0.0075%",
					ChatColor.RESET+"",
					ChatColor.RESET+CivColor.Blue+CivColor.ITALIC+"Despotism Rate: 210%",
					ChatColor.RESET+CivColor.Blue+CivColor.ITALIC+"Penalty Rate: 90%"
					));
			
			strucInfoTutorialInventory.setItem(2, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Coming Soon!"
					));
			
			
			strucInfoTutorialInventory.setItem(9, LoreGuiItem.build(ChatColor.BOLD+"Cottage", ItemManager.getId(Material.BRICK), 0, 
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 1 (24 Hrs, 75 coins/hr)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 1 Bread, 1 Carrot",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 2 (48 Hrs, 150 coins/hr)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 2 Bread & Carrot, 1 Potato",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 3 (96 Hrs, 225 coins/hr)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 3 Bread, 2 Carrot & Potato",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 4 (120 Hrs, 300 coins/hr)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 4 Bread, 3 Carrot & Potato",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 5 (144 Hrs, 375 coins/hr)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 4 Bread & Carrot & Potato",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 6 (288 Hrs, 450 coins/hr)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 5 Bread & Carrot & Potato,",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"1 Raw Porkchop"//,
					//ChatColor.RESET+CivColor.BOLD+CivColor.Blue+"[NEW] "+CivColor.LightGray+CivColor.ITALIC+"Level: 7 (576 Hrs, 600 coins/hr)",
					//ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 6 Bread & Carrot & Potato,",
					//ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"1 Raw Porkchop & Poision Potato"
					));
			
			strucInfoTutorialInventory.setItem(11, LoreGuiItem.build(ChatColor.BOLD+"Mine", ItemManager.getId(Material.REDSTONE), 0, 
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 1 (24 Hrs, 100 Hammers)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 4 Redstone",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 2 (48 Hrs, 150 Hammers)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 7 Redstone",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 3 (96 Hrs, 200 Hammers)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 10 Redstone",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 4 (120 Hrs, 250 Hammers)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 15 Redstone",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 5 (144 Hrs, 300 Hammers)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 20 Redstone"
					));
			
			strucInfoTutorialInventory.setItem(13, LoreGuiItem.build(ChatColor.BOLD+"Lab", ItemManager.getId(Material.GLASS_BOTTLE), 0, 
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 1 (24 Hrs, 100 Beakers)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 3 Raw Fish",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 2 (48 Hrs, 150 Beakers)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 5 Raw Fish",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 3 (96 Hrs, 200 Beakers)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 8 Raw Fish",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 4 (120 Hrs, 250 Beakers)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 10 Raw Fish",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level: 5 (144 Hrs, 300 Beakers)",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Items: 15 Raw Fish"
					));
			
			strucInfoTutorialInventory.setItem(15, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Coming Soon!"
					));
			
			
			strucInfoTutorialInventory.setItem(19, LoreGuiItem.build(ChatColor.BOLD+"Grocer", ItemManager.getId(Material.COOKED_FISH), 0, 
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level 1:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Item: Cooked Fish",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Cost: 8 Coins Each"
					));
			
			strucInfoTutorialInventory.setItem(21, LoreGuiItem.build(ChatColor.BOLD+"Grocer", ItemManager.getId(Material.COOKED_CHICKEN), 0, 
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level 2:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Item: Cooked Chicken",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Cost: 15 Coins Each"
					));
			
			strucInfoTutorialInventory.setItem(23, LoreGuiItem.build(ChatColor.BOLD+"Grocer", ItemManager.getId(Material.GRILLED_PORK), 0, 
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level 3:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Item: Cooked Porkchop",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Cost: 20 Coins Each"
					));
			
			strucInfoTutorialInventory.setItem(25, LoreGuiItem.build(ChatColor.BOLD+"Grocer", ItemManager.getId(Material.PUMPKIN_PIE), 0, 
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Level 4:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Item: Pumpkin Pie",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Cost: 50 Coins Each"
					));
			
			
			strucInfoTutorialInventory.setItem(27, LoreGuiItem.build(ChatColor.BOLD+"Temple", ItemManager.getId(Material.MONSTER_EGG), 92, 
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Mob Name: Cow",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Culture Output: 30"
					));
			
			strucInfoTutorialInventory.setItem(29, LoreGuiItem.build(ChatColor.BOLD+"Temple", ItemManager.getId(Material.MONSTER_EGG), 91, 
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Mob Name: Sheep",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Culture Output: 30"
					));
			
			strucInfoTutorialInventory.setItem(31, LoreGuiItem.build(ChatColor.BOLD+"Temple", ItemManager.getId(Material.MONSTER_EGG), 90, 
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Mob Name: Pig",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Culture Output: 30"
					));
			
			strucInfoTutorialInventory.setItem(33, LoreGuiItem.build(ChatColor.BOLD+"Temple", ItemManager.getId(Material.MONSTER_EGG), 93, 
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Mob Name: Chicken",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Culture Output: 30"
					));
			
//			strucInfoTutorialInventory.setItem(35, LoreGuiItem.build(ChatColor.BOLD+"Temple", ItemManager.getId(Material.MONSTER_EGG), 101, 
//					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Mob Name: Rabbit",
//					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Culture Output: 40"
//					));
			
			LoreGuiItemListener.guiInventories.put(strucInfoTutorialInventory.getName(), strucInfoTutorialInventory);
		}
		
		if (player != null && player.isOnline() && player.isValid()) {
			player.openInventory(strucInfoTutorialInventory);	
		}
	}
	
	public static void showTech1TutorialInventory(Player player) {	
		if (tech1TutorialInventory == null) {
			tech1TutorialInventory = Bukkit.getServer().createInventory(player, 9*5, "Techs Tier 1-5 Tutorial");
			
			//XXX Tier 1
			tech1TutorialInventory.setItem(0, LoreGuiItem.build(ChatColor.BOLD+"Armory", ItemManager.getId(Material.OBSIDIAN), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 5,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 500 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Barracks, Blacksmith",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Alloys, Sword Smithing",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required:"
					));
			
			tech1TutorialInventory.setItem(2, LoreGuiItem.build(ChatColor.BOLD+"Mining", ItemManager.getId(Material.WOOD_PICKAXE), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 5,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 500 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Trommel",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Masonry, Productivity",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required:"
					));
			
			tech1TutorialInventory.setItem(5, LoreGuiItem.build(ChatColor.BOLD+"Agriculture", ItemManager.getId(Material.SEEDS), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 5,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 500 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Farm",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Pottery, Hunting",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required:"
					));
			
			tech1TutorialInventory.setItem(8, LoreGuiItem.build(ChatColor.BOLD+"Religion", ItemManager.getId(Material.QUARTZ), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 5,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 500 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Monument, Bank Lvl 1",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Code of Laws, Brewing",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required:"
					));
			
			
			//XXX Tier 2
			tech1TutorialInventory.setItem(10, LoreGuiItem.build(ChatColor.BOLD+"Masonry", ItemManager.getId(Material.COBBLESTONE), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 7,500 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 1,000 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Scout Tower, Roads",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Adv. Masonry",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Mining"
					));
			
			tech1TutorialInventory.setItem(11, LoreGuiItem.build(ChatColor.BOLD+"Productivity", ItemManager.getId(Material.REDSTONE), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 7,500 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 1,000 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Mines, Library Lvl 1, Despotism (Gov)",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Sailing",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Mining"
					));
			
			tech1TutorialInventory.setItem(13, LoreGuiItem.build(ChatColor.BOLD+"Pottery", ItemManager.getId(Material.SPONGE), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 7,500 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 1,000 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Granary",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Automation",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Agriculture"
					));
			
			tech1TutorialInventory.setItem(14, LoreGuiItem.build(ChatColor.BOLD+"Hunting", ItemManager.getId(Material.LEATHER), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 7,500 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 1,000 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Grocer Lvl 1, Pasture",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Trade",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Agriculture"
					));
			
			tech1TutorialInventory.setItem(16, LoreGuiItem.build(ChatColor.BOLD+"Code of Laws", ItemManager.getId(Material.RABBIT_HIDE), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 7,500 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 1,000 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Bank Lvl 2, Hamlet (Town Lvl)",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Writing",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Religion"
					));
			
			tech1TutorialInventory.setItem(17, LoreGuiItem.build(ChatColor.BOLD+"Brewing", ItemManager.getId(Material.POTION), 8197, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 7,500 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 1,000 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Healing I, Water Breathing 3:00, Nether Portal",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Priesthood",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Religion"
					));
			
			
			//XXX Tier 3
			tech1TutorialInventory.setItem(19, LoreGuiItem.build(ChatColor.BOLD+"Adv. Masonry", ItemManager.getId(Material.SMOOTH_BRICK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 10,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 2,000 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Walls, Cottages",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Artillery",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Masonry"
					));
			
			tech1TutorialInventory.setItem(20, LoreGuiItem.build(ChatColor.BOLD+"Sailing", ItemManager.getId(Material.BOAT), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 10,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 2,000 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Shipyard, Lab",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Taxation",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Productivity"
					));
			
			tech1TutorialInventory.setItem(22, LoreGuiItem.build(ChatColor.BOLD+"Automation", ItemManager.getId(Material.PISTON_BASE), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 10,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 2,000 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Windmill",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks:",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Pottery"
					));
			
			tech1TutorialInventory.setItem(23, LoreGuiItem.build(ChatColor.BOLD+"Trade", ItemManager.getId(Material.COOKED_CHICKEN), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 10,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 2,000 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Trade Outpost/Fishing Boat, Grocer Lvl 2",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Commerce",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Hunting"
					));
			
			tech1TutorialInventory.setItem(25, LoreGuiItem.build(ChatColor.BOLD+"Writing", ItemManager.getId(Material.BOOK_AND_QUILL), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 10,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 2,000 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Bank Lvl 3 & Interest Lvl 1",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Monarchy",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Code of Laws"
					));
			
			tech1TutorialInventory.setItem(26, LoreGuiItem.build(ChatColor.BOLD+"Priesthood", ItemManager.getId(Material.RED_ROSE), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 10,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 2,000 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Temple, Village (Town Lvl)",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Fermenation",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Brewing"
					));
			
			
			//XXX Tier 4
			tech1TutorialInventory.setItem(29, LoreGuiItem.build(ChatColor.BOLD+"Artillery", ItemManager.getId(Material.ARROW), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 15,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 2,500 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Arrow Tower, Library Lvl 2",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Adv. Artillery",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Adv. Masonry"
					));
			
			tech1TutorialInventory.setItem(32, LoreGuiItem.build(ChatColor.BOLD+"Commerce", ItemManager.getId(Material.PAINTING), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 15,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 2,500 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Global Market, Store, Grocer Lvl 3",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Global Trade",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Trade"
					));
			
			tech1TutorialInventory.setItem(34, LoreGuiItem.build(ChatColor.BOLD+"Monarchy", ItemManager.getId(Material.IRON_BLOCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 15,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 2,500 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Bank Lvl 4, Large Village (Town Lvl), Monarchy (Gov)",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Currency",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Writing"
					));
			
			tech1TutorialInventory.setItem(35, LoreGuiItem.build(ChatColor.BOLD+"Fermentation", ItemManager.getId(Material.POTION), 8203, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 15,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 2,500 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Speed I 3:00, Jump I 3:00",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Malting",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Priesthood"
					));
			
			tech1TutorialInventory.setItem(36, LoreGuiItem.build(ChatColor.BOLD+"Alloys", ItemManager.getId(Material.IRON_CHESTPLATE), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 15,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 2,500 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Steel Armor",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Forging",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Armory"
					));
			
			tech1TutorialInventory.setItem(37, LoreGuiItem.build(ChatColor.BOLD+"Sword Smithing", ItemManager.getId(Material.IRON_SWORD), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 15,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 2,500 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Steel Longsword",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Tempering",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Armory"
					));
			
			
			//XXX Tier 5
			tech1TutorialInventory.setItem(40, LoreGuiItem.build(ChatColor.BOLD+"Taxation", ItemManager.getId(Material.GLOWSTONE), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 40,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 10,000 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: x2 Cottage Money Bonus",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Efficiency",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Sailing"
					));
			
			tech1TutorialInventory.setItem(43, LoreGuiItem.build(ChatColor.BOLD+"Currency", ItemManager.getId(Material.LAPIS_BLOCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 40,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Beaker Cost: 10,000 Beakers",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Unlocks: Bank Lvl 5 & Interest Lvl 3, Town (Town Lvl)",
					ChatColor.RESET+CivColor.Yellow+CivColor.ITALIC+"Techs Unlocks: Economics",
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Techs Required: Monarchy"
					));
			
			LoreGuiItemListener.guiInventories.put(tech1TutorialInventory.getName(), tech1TutorialInventory);
		}
		
		if (player != null && player.isOnline() && player.isValid()) {
			player.openInventory(tech1TutorialInventory);	
		}
	}
	
	public static void showTech2TutorialInventory(Player player) {	
		if (tech2TutorialInventory == null) {
			tech2TutorialInventory = Bukkit.getServer().createInventory(player, 9*5, "Techs Tier 6-10 Tutorial");
			
			//XXX Tier 6
			tech2TutorialInventory.setItem(19, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			tech2TutorialInventory.setItem(21, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			tech2TutorialInventory.setItem(23, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			
			tech2TutorialInventory.setItem(25, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			
			LoreGuiItemListener.guiInventories.put(tech2TutorialInventory.getName(), tech2TutorialInventory);
		}
		
		if (player != null && player.isOnline() && player.isValid()) {
			player.openInventory(tech2TutorialInventory);	
		}
	}
	
	public static void showStrucTutorialInventory(Player player) {	
		if (strucTutorialInventory == null) {
			strucTutorialInventory = Bukkit.getServer().createInventory(player, 9*6, "Structures Tutorial");
		
			strucTutorialInventory.setItem(0, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Arrow Tower", ItemManager.getId(Material.ARROW), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(2, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Bank", ItemManager.getId(Material.IRON_INGOT), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech: Religion",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost: 1,000 Hammers",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 2500 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description: Can sell gems of Iron,",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Gold, Diamond, and Emeralds."
					));
			
			strucTutorialInventory.setItem(4, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Barracks", ItemManager.getId(Material.CHAINMAIL_CHESTPLATE), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(6, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Blacksmith", ItemManager.getId(Material.STONE), 2, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(8, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Cannon Tower", ItemManager.getId(Material.FIREBALL), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(10, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Capitol", ItemManager.getId(Material.STONE), 6, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost: 500 Hammers",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 35,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description: Built when founding a civ.",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Provides 10 culture/hour to capitol."
					));
			
			strucTutorialInventory.setItem(12, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Cottage", ItemManager.getId(Material.BRICK), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(14, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Farm", ItemManager.getId(Material.SEEDS), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(16, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Fishing Boat", ItemManager.getId(Material.WOOD), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(18, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Granary", ItemManager.getId(Material.SPONGE), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(20, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Grocer", ItemManager.getId(Material.COOKED_FISH), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech: Hunting",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost: 200 Hammers",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 1,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description: Hungry? Buy food."
					));
			
			strucTutorialInventory.setItem(22, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Lab", ItemManager.getId(Material.GLASS_BOTTLE), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(24, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Library", ItemManager.getId(Material.BOOKSHELF), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech: Productivity",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost: 1,500 Hammers",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 5,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description: Upgrade & Buy enchantments."
					));
			
			strucTutorialInventory.setItem(26, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Market", ItemManager.getId(Material.PAINTING), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(28, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Mine", ItemManager.getId(Material.REDSTONE), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(30, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Monument", ItemManager.getId(Material.RED_ROSE), 2, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(32, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Nether Portal", ItemManager.getId(Material.OBSIDIAN), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech: Brewing",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost: 5,000 Hammers",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 10,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description: Go to the nether."
					));
			
			strucTutorialInventory.setItem(34, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Pasture", ItemManager.getId(Material.WHEAT), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(36, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Scout Tower", ItemManager.getId(Material.COMMAND), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(38, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Stable", ItemManager.getId(Material.DIAMOND_BARDING), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(40, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Store", ItemManager.getId(Material.EMERALD), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech: Commerce",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost: 1,000 Hammers",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 2,500 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description: Upgrade items to the store",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"and then you and others can buy them."
					));
			
			strucTutorialInventory.setItem(42, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Temple", ItemManager.getId(Material.RED_ROSE), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(44, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Town Hall", ItemManager.getId(Material.STONE), 5, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost: 250 Hammers",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 10,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description: Built when founding a town.",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Provides 10 culture/hour to town."
					));
			
			strucTutorialInventory.setItem(46, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Trade Outpost", ItemManager.getId(Material.SIGN), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(48, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Trommel", ItemManager.getId(Material.FURNACE), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech: Mining",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost: 750 Hammers",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost: 5,000 Coins",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description: Input cobblestone for gems."
					));
			
			strucTutorialInventory.setItem(50, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Wall", ItemManager.getId(Material.SMOOTH_BRICK), 0, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
			
			strucTutorialInventory.setItem(52, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Windmill", ItemManager.getId(Material.LONG_GRASS), 1, 
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"Required Tech:",
					ChatColor.RESET+CivColor.LightGray+CivColor.ITALIC+"Hammer Cost:",
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Money Cost:",
					ChatColor.RESET+CivColor.LightBlue+CivColor.ITALIC+"Description:"
					));
		
			LoreGuiItemListener.guiInventories.put(strucTutorialInventory.getName(), strucTutorialInventory);
		}
		
		if (player != null && player.isOnline() && player.isValid()) {
			player.openInventory(strucTutorialInventory);	
		}
	}
	
	public static void showWonderTutorialInventory(Player player) {	
		if (wonderTutorialInventory == null) {
			wonderTutorialInventory = Bukkit.getServer().createInventory(player, 9*3, "Wonders Tutorial");
			
			//XXX Tier 6
			wonderTutorialInventory.setItem(10, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			wonderTutorialInventory.setItem(12, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			wonderTutorialInventory.setItem(14, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			
			wonderTutorialInventory.setItem(16, LoreGuiItem.build(ChatColor.BOLD+"N/A", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.LightGreen+CivColor.ITALIC+"Finishing Soon"
					));
			
			LoreGuiItemListener.guiInventories.put(wonderTutorialInventory.getName(), wonderTutorialInventory);
		}
		
		if (player != null && player.isOnline() && player.isValid()) {
			player.openInventory(wonderTutorialInventory);	
		}
	}
	
	public static void showMobTutorialInventory(Player player) {	
		if (mobTutorialInventory == null) {
			mobTutorialInventory = Bukkit.getServer().createInventory(player, 9*3, "Mobs Tutorial");
		
			mobTutorialInventory.setItem(2, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Snowy Yobos", ItemManager.getId(Material.SNOW_BLOCK), 0, 
					ChatColor.RESET+"These mobs spawn in snowy biomes, based",
					ChatColor.RESET+"on the biomes of the Minecraft Wiki Page.",
					ChatColor.RESET+CivColor.LightPurple+"Drops:",
					ChatColor.RESET+CivColor.LightPurple+"  Rotten Flesh: 50%",
					ChatColor.RESET+CivColor.LightPurple+"  Snow Block: 15%",
					ChatColor.RESET+CivColor.LightPurple+"  Packed Ice: 10%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Coal Ore: 25%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Emerald Ore: 5%"
					));
			
			mobTutorialInventory.setItem(6, LoreGuiItem.build(CivColor.LightBlue+ChatColor.BOLD+"Cold Yobos", ItemManager.getId(Material.ICE), 0, 
					ChatColor.RESET+"These mobs spawn in cold biomes, based",
					ChatColor.RESET+"on the biomes of the Minecraft Wiki Page.",
					ChatColor.RESET+CivColor.LightPurple+"Drops:",
					ChatColor.RESET+CivColor.LightPurple+"  Rotten Flesh: 50%",
					ChatColor.RESET+CivColor.LightPurple+"  Ice: 15%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Diamond Ore: 10%"
					));
			
			mobTutorialInventory.setItem(11, LoreGuiItem.build(CivColor.Gold+ChatColor.BOLD+"Warm Yobos", ItemManager.getId(Material.SUGAR_CANE), 0, 
					ChatColor.RESET+"These mobs spawn in snowy biomes, based",
					ChatColor.RESET+"on the biomes of the Minecraft Wiki Page.",
					ChatColor.RESET+CivColor.LightPurple+"Drops:",
					ChatColor.RESET+CivColor.LightPurple+"  Rotten Flesh: 50%",
					ChatColor.RESET+CivColor.LightPurple+"  Sugar Cane: 15%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Iron Ore: 20%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Gold Ore: 20%"
					));
			
			mobTutorialInventory.setItem(15, LoreGuiItem.build(CivColor.Rose+ChatColor.BOLD+"Hot Yobos", ItemManager.getId(Material.CACTUS), 0, 
					ChatColor.RESET+"These mobs spawn in snowy biomes, based",
					ChatColor.RESET+"on the biomes of the Minecraft Wiki Page.",
					ChatColor.RESET+CivColor.LightPurple+"Drops:",
					ChatColor.RESET+CivColor.LightPurple+"  Rotten Flesh: 50%",
					ChatColor.RESET+CivColor.LightPurple+"  Cactus: 15%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Redstone Ore: 25%"
					));
			
			mobTutorialInventory.setItem(20, LoreGuiItem.build(CivColor.White+ChatColor.BOLD+"Neutral Yobos", ItemManager.getId(Material.GRAVEL), 0, 
					ChatColor.RESET+"These mobs spawn in snowy biomes, based",
					ChatColor.RESET+"on the biomes of the Minecraft Wiki Page.",
					ChatColor.RESET+CivColor.LightPurple+"Drops:",
					ChatColor.RESET+CivColor.LightPurple+"  Rotten Flesh: 50%",
					ChatColor.RESET+CivColor.LightPurple+"  Gravel: 15%",
					ChatColor.RESET+CivColor.LightPurple+"  Sponge: 10%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Lapis Ore: 25%"
					));
			
			mobTutorialInventory.setItem(24, LoreGuiItem.build(CivColor.LightGreen+ChatColor.BOLD+"Common Information", ItemManager.getId(Material.LOG), 0, 
					ChatColor.RESET+CivColor.LightBlue+"Every mob drops between 25 and 85 coins.",
					ChatColor.RESET+CivColor.LightPurple+"Other Drops (Every mob drops):",
					ChatColor.RESET+CivColor.LightPurple+"  Raw Fish: 50%",
					ChatColor.RESET+CivColor.LightPurple+"  Pris Crystals: 35%",
					ChatColor.RESET+CivColor.LightPurple+"  Pris Shards: 25%",
					ChatColor.RESET+CivColor.LightPurple+"  Raw Potato: 20%",
					ChatColor.RESET+CivColor.LightPurple+"  Regular Carrot & Sulphur: 15%",
					ChatColor.RESET+CivColor.LightPurple+"  Bone & String & Coal: 10%",
					ChatColor.RESET+CivColor.LightPurple+"  Sugar: 5%",
					ChatColor.RESET+CivColor.LightPurple+"  Slime: 1%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Steel Ore: 10%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Tungsten Ore: 10%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Steel Ingot: 0.08%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Tungsten Ingot: 0.08%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Steel Plate: 0.04%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Tungsten Plate: 0.04%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Steel Blade: 0.02%",
					ChatColor.RESET+CivColor.Purple+CivColor.ITALIC+"  Tungsten Blade: 0.02%"
					));
			
			LoreGuiItemListener.guiInventories.put(mobTutorialInventory.getName(), mobTutorialInventory);
		}
		
		if (player != null && player.isOnline() && player.isValid()) {
			player.openInventory(mobTutorialInventory);	
		}
	}
	
	public static void showAirInventory(Player player) {	
		if (airInventory == null) {
			airInventory = Bukkit.getServer().createInventory(player, 9*1, "Air");
		
			airInventory.setItem(4, LoreGuiItem.build(ChatColor.BOLD+"NOTE", ItemManager.getId(Material.BARRIER), 0, 
					ChatColor.RESET+"You clicked nothing..."
					));
		
			LoreGuiItemListener.guiInventories.put(airInventory.getName(), airInventory);
		}
		
		if (player != null && player.isOnline() && player.isValid()) {
			player.openInventory(airInventory);	
		}
	}
	
	
	//XXX Original Ones
	public static void showTutorialInventory(Player player) {	
		if (tutorialInventory == null) {
			tutorialInventory = Bukkit.getServer().createInventory(player, 9*3, "CivCraft Tutorial");
		
	
			tutorialInventory.setItem(0, LoreGuiItem.build(CivColor.LightBlue+ChatColor.BOLD+"What is CivCraft?", ItemManager.getId(Material.WOOD_SWORD), 0, 
					ChatColor.RESET+"CivCraft is a game about creating civilizations,",
					ChatColor.RESET+"gathering a team of players and materials. You",
					ChatColor.RESET+"will then need to expand outward, create towns,",
					ChatColor.RESET+"form alliances, and brace yourself for what the",
					ChatColor.RESET+"future may hold with or against your peoples.",
					ChatColor.RESET+"Explore for the perfect spot. Find trade goods,",
					ChatColor.RESET+"get decent statistics in an area using command",
					ChatColor.RESET+"/town info, begin your journey, research, and",
					ChatColor.RESET+CivColor.Red+"fight in the battle of players and time."
					));
			
			tutorialInventory.setItem(4, LoreGuiItem.build(CivColor.White+"Camp", ItemManager.getId(Material.WOOD_DOOR), 0, 
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Recipe in: Crafting Recipes -> Special"
					));
			
			tutorialInventory.setItem(5, LoreGuiItem.build(CivColor.White+"Founding Civilization Flag", ItemManager.getId(Material.BLAZE_ROD), 0, 
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Recipe in: Crafting Recipes -> Special"
					));
			
			tutorialInventory.setItem(7, LoreGuiItem.build(CivColor.White+"War Cannon", ItemManager.getId(Material.HOPPER), 0, 
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Recipe in: Crafting Recipes -> Special"
					));
			
			tutorialInventory.setItem(8, LoreGuiItem.build(CivColor.White+"War Camp", ItemManager.getId(Material.BEDROCK), 0, 
					ChatColor.RESET+CivColor.Gold+CivColor.ITALIC+"Recipe in: Crafting Recipes -> Special"
					));
			
			
			tutorialInventory.setItem(10, LoreGuiItem.build(CivColor.LightBlue+ChatColor.BOLD+"Explore", ItemManager.getId(Material.COMPASS), 0, 
					ChatColor.RESET+"Adventure! This is the key to find the most",
					ChatColor.RESET+"perfect location for your civilization. There",
					ChatColor.RESET+"are many kinds of biomes, different ones give",
					ChatColor.RESET+"different statistics, and certain hemispheres",
					ChatColor.RESET+"give different trade goods. With poor factors,",
					ChatColor.RESET+"you will thus struggle to thrive and survive."
					));
			
			tutorialInventory.setItem(11, LoreGuiItem.build(CivColor.LightBlue+ChatColor.BOLD+"Collect Resources", ItemManager.getId(Material.DIAMOND_ORE), 0, 
					ChatColor.RESET+"CivCraft contains two custom armor/weapons",
					ChatColor.RESET+"tiers, but act as vanilla items. You will",
					ChatColor.RESET+"need to collect the ore materials of steel",
					ChatColor.RESET+"tungsten to craft this armor. Also, some",
					ChatColor.RESET+"more materials are craftable, but you can",
					ChatColor.RESET+"find them out for yourself in:",
					ChatColor.RESET+CivColor.Gold+"Crafting Recipes -> Special.",
					ChatColor.RESET+"Exchange your gems at the "+CivColor.Yellow+"Bank.",
					ChatColor.RESET+"Sell random items in a "+CivColor.Yellow+"Market."
					));
			
			tutorialInventory.setItem(14, LoreGuiItem.build(CivColor.LightBlue+ChatColor.BOLD+"Founding a Civilization", ItemManager.getId(Material.STONE), 6, 
					ChatColor.RESET+"A civilization is a band of towns that can",
					ChatColor.RESET+"be founded by you or taken in war, that",
					ChatColor.RESET+"share any technology that is researched",
					ChatColor.RESET+"by your civilization commanders. Some items",
					ChatColor.RESET+"are only obtainable with research. Techs",
					ChatColor.RESET+"are required to gain buildings to build,",
					ChatColor.RESET+"be eligible to get trade resources, or",
					ChatColor.RESET+"build structures for town stats or expand",
					ChatColor.RESET+"into the production of coins or materials."
					));
			
			tutorialInventory.setItem(15, LoreGuiItem.build(CivColor.LightBlue+ChatColor.BOLD+"Founding Towns", ItemManager.getId(Material.STONE), 5, 
					ChatColor.RESET+"Towns can be founded by civilizations to gain",
					ChatColor.RESET+"land, which can lead to more attration of",
					ChatColor.RESET+"residents to join, alliances, or maybe war.",
					ChatColor.RESET+"The benefit of towns is the gaining beakers",
					ChatColor.RESET+"for the civ's tech, to research and to expand",
					ChatColor.RESET+"the production of money which the civ can",
					ChatColor.RESET+"then tax off of. Another benefit of towns is",
					ChatColor.RESET+"spreading your player base. This can allow",
					ChatColor.RESET+"for more offense/defense during wartime, or",
					ChatColor.RESET+"or a consistant rate of working men."
					));
			
			if (CivGlobal.isCasualMode()) {
				tutorialInventory.setItem(17, LoreGuiItem.build(CivColor.LightBlue+ChatColor.BOLD+"Casual Mode War!", ItemManager.getId(Material.FIREWORK), 0, 
					ChatColor.RESET+"During casual mode, you are only allowed to",
					ChatColor.RESET+"request war, just as a request of alliance.",
					ChatColor.RESET+"The winner is given a trophy which can be put",
					ChatColor.RESET+"on display if you wish to do. After a civ",
					ChatColor.RESET+"is defeated in war, it must be requested again."
					));
			} else {
				tutorialInventory.setItem(17, LoreGuiItem.build(CivColor.LightBlue+ChatColor.BOLD+"PvP Mode War!", ItemManager.getId(Material.DIAMOND_SWORD), 0, 
					ChatColor.RESET+"During pvp mode, you can declare war on anyone at",
					ChatColor.RESET+"anytime; you are able to destroy structures and",
					ChatColor.RESET+"conquer towns, or even a whole civ. The civ that",
					ChatColor.RESET+"was taken then can revolt away from you or can",
					ChatColor.RESET+"join your force of dominance and help you."
					));
			}
			
			tutorialInventory.setItem(25, LoreGuiItem.build(CivColor.LightGreen+ChatColor.BOLD+"QUEST: N/A", ItemManager.getId(Material.BOOK_AND_QUILL), 0, 
					ChatColor.RESET+"These will be for fun and if you're bored,",
					ChatColor.RESET+"but they will sadly be coming soon!"
			));
			
//			tutorialInventory.setItem(8, LoreGuiItem.build(CivColor.LightBlue+ChatColor.BOLD+"More Info?", ItemManager.getId(Material.BOOK_AND_QUILL), 0, 
//					ChatColor.RESET+"There is much more information you will require for your",
//					ChatColor.RESET+"journey into CivCraft. Please visit the wiki at ",
//					ChatColor.RESET+CivColor.LightGreen+ChatColor.BOLD+"http://civcraft.net/wiki",
//					ChatColor.RESET+"For more detailed information about CivCraft and it's features."
//					));
//			
//			tutorialInventory.setItem(9, LoreGuiItem.build(CivColor.LightBlue+ChatColor.BOLD+"QUEST: Build a Camp", ItemManager.getId(Material.BOOK_AND_QUILL), 0, 
//					ChatColor.RESET+"First things first, in order to start your journey",
//					ChatColor.RESET+"you must first build a camp. Camps allow you to store",
//					ChatColor.RESET+"your materials safely, and allow you to obtain leadership",
//					ChatColor.RESET+"tokens which can be crafted into a civ. The recipe for a camp is below."
//					));
//			
//			tutorialInventory.setItem(18,getInfoBookForItem("mat_found_camp"));
//			
//			tutorialInventory.setItem(10, LoreGuiItem.build(CivColor.LightBlue+ChatColor.BOLD+"QUEST: Found a Civ", ItemManager.getId(Material.BOOK_AND_QUILL), 0, 
//			ChatColor.RESET+"Next, you'll want to start a civilization.",
//			ChatColor.RESET+"To do this, you must first obtain leadership tokens",
//			ChatColor.RESET+"by feeding bread to your camp's longhouse.",
//			ChatColor.RESET+"Once you have enough leadership tokens.",
//			ChatColor.RESET+"You can craft the founding flag item below."
//			));
//			
//			tutorialInventory.setItem(19,getInfoBookForItem("mat_found_civ"));
//			
			tutorialInventory.setItem(18, LoreGuiItem.build(CivColor.LightBlue+ChatColor.BOLD+"Update 7 Changelist", ItemManager.getId(Material.BUCKET), 0, 
					ChatColor.RESET+"-Added the beautiful book you see. :)",
					ChatColor.RESET+"-Added Lvl 7 Cottage, will you get it?",
					ChatColor.RESET+"-Zapped onto the potion-tech enabling.",
					ChatColor.RESET+"-Yobos now spawn 3 times a minute.",
					ChatColor.RESET+"-Fixed Yobos not spawning > 2 babies.",
					ChatColor.RESET+""
					));
			
			tutorialInventory.setItem(22, LoreGuiItem.build(CivColor.LightBlue+ChatColor.BOLD+"Need to Know a Recipe?", ItemManager.getId(Material.WORKBENCH), 0, 
					ChatColor.RESET+"You can do /resident book, and then click on the",
					ChatColor.RESET+"'Crafting Recipies' icon, which will look like a",
					ChatColor.RESET+"workbench. Any custom item in civcraft is displayed",
					ChatColor.RESET+"there, so feel free to consult this anytime you want.",
					ChatColor.RESET+"Good luck!"
					));
		
			LoreGuiItemListener.guiInventories.put(tutorialInventory.getName(), tutorialInventory);
		}
		
		if (player != null && player.isOnline() && player.isValid()) {
			player.openInventory(tutorialInventory);	
		}
	}
	
	public static ItemStack getInfoBookForItem(String matID) {
		LoreCraftableMaterial loreMat = LoreCraftableMaterial.getCraftMaterialFromId(matID);
		ItemStack stack = LoreMaterial.spawn(loreMat);
							
		if (!loreMat.isCraftable()) {
			return null;
		}
		
		AttributeUtil attrs = new AttributeUtil(stack);
		attrs.removeAll(); /* Remove all attribute modifiers to prevent them from displaying */
		LinkedList<String> lore = new LinkedList<String>();
		
		lore.add(""+ChatColor.RESET+ChatColor.BOLD+ChatColor.GOLD+"Click For Recipe");
		
		attrs.setLore(lore);				
		stack = attrs.getStack();
		return stack;
	}
	
	public static void showCraftingHelp(Player player) {
		if (craftingHelpInventory == null) {
			craftingHelpInventory = Bukkit.getServer().createInventory(player, MAX_CHEST_SIZE*9, "CivCraft Custom Item Recipes");

			/* Build the Category Inventory. */
			for (ConfigMaterialCategory cat : ConfigMaterialCategory.getCategories()) {
				if (cat.craftableCount == 0) {
					continue;
				}
				
				ItemStack infoRec = LoreGuiItem.build(cat.name, 
						ItemManager.getId(Material.WRITTEN_BOOK), 
						0, 
						CivColor.LightBlue+cat.materials.size()+" Items",
						CivColor.Gold+"<Click To Open>");
						infoRec = LoreGuiItem.setAction(infoRec, "OpenInventory");
						infoRec = LoreGuiItem.setActionData(infoRec, "invType", "showGuiInv");
						infoRec = LoreGuiItem.setActionData(infoRec, "invName", cat.name+" Recipes");
						
						craftingHelpInventory.addItem(infoRec);
						
						
				Inventory inv = Bukkit.createInventory(player, LoreGuiItem.MAX_INV_SIZE, cat.name+" Recipes");
				for (ConfigMaterial mat : cat.materials.values()) {
					ItemStack stack = getInfoBookForItem(mat.id);
					if (stack != null) {
						stack = LoreGuiItem.setAction(stack, "ShowRecipe");
						inv.addItem(LoreGuiItem.asGuiItem(stack));
					}
				}
				
				/* Add back buttons. */
				ItemStack backButton = LoreGuiItem.build("Back", ItemManager.getId(Material.MAP), 0, "Back to Categories");
				backButton = LoreGuiItem.setAction(backButton, "OpenInventory");
				backButton = LoreGuiItem.setActionData(backButton, "invType", "showCraftingHelp");
				inv.setItem(LoreGuiItem.MAX_INV_SIZE-1, backButton);
				
				LoreGuiItemListener.guiInventories.put(inv.getName(), inv);
			}
			
			LoreGuiItemListener.guiInventories.put(craftingHelpInventory.getName(), craftingHelpInventory);
		}
		player.openInventory(craftingHelpInventory);
	}
	
	public static void spawnGuiBook(Player player) {
		if (guiInventory == null) {
			guiInventory = Bukkit.getServer().createInventory(player, 2*9, "CivCraft Information");
			
			//XXX Original Inventories
			ItemStack infoRec = LoreGuiItem.build("CivCraft Info", 
					ItemManager.getId(Material.WRITTEN_BOOK),
							0, CivColor.Gold+"<Click To View>");
			infoRec = LoreGuiItem.setAction(infoRec, "OpenInventory");
			infoRec = LoreGuiItem.setActionData(infoRec, "invType", "showTutorialInventory");
			guiInventory.addItem(infoRec);
			
			ItemStack air1 = LoreGuiItem.build("",
					ItemManager.getId(Material.BARRIER),
							0, "");
			air1 = LoreGuiItem.setAction(air1, "OpenInventory");
			air1 = LoreGuiItem.setActionData(air1, "invType", "showAirInventory");
			guiInventory.addItem(air1);
			
			ItemStack craftRec = LoreGuiItem.build("Crafting Recipes", 
					ItemManager.getId(Material.WORKBENCH),
					0, CivColor.Gold+"<Click To View>");
			craftRec = LoreGuiItem.setAction(craftRec, "OpenInventory");
			craftRec = LoreGuiItem.setActionData(craftRec, "invType", "showCraftingHelp");
			guiInventory.addItem(craftRec);
			
			ItemStack air2 = LoreGuiItem.build(" ",
					ItemManager.getId(Material.BARRIER),
							0, "");
			air2 = LoreGuiItem.setAction(air2, "OpenInventory");
			air2 = LoreGuiItem.setActionData(air2, "invType", "showAirInventory");
			guiInventory.addItem(air2);
			
//XXX Disabled cuz buggy
//			ItemStack buildMenu = LoreGuiItem.build("Build Structure", ItemManager.getId(Material.BRICK_STAIRS), 0, CivColor.Gold+"<Click to View>");
//			buildMenu = LoreGuiItem.setAction(buildMenu, "BuildStructureList");
//			guiInventory.addItem(buildMenu);
			
			ItemStack mobinfoRec = LoreGuiItem.build("Tutorial: Mobs", 
					ItemManager.getId(Material.SKULL_ITEM),
							2, CivColor.Gold+"<Click To View>");
			mobinfoRec = LoreGuiItem.setAction(mobinfoRec, "OpenInventory");
			mobinfoRec = LoreGuiItem.setActionData(mobinfoRec, "invType", "showMobTutorialInventory");
			guiInventory.addItem(mobinfoRec);
			
			ItemStack air = LoreGuiItem.build("  ",
					ItemManager.getId(Material.BARRIER),
							0, "");
			air = LoreGuiItem.setAction(air, "OpenInventory");
			air = LoreGuiItem.setActionData(air, "invType", "showAirInventory");
			guiInventory.addItem(air);
			
			ItemStack strucinfoRec = LoreGuiItem.build("Tutorial: Structures", 
					ItemManager.getId(Material.DIAMOND_PICKAXE),
							0, CivColor.Gold+"<Click To View>");
			strucinfoRec = LoreGuiItem.setAction(strucinfoRec, "OpenInventory");
			strucinfoRec = LoreGuiItem.setActionData(strucinfoRec, "invType", "showStrucTutorialInventory");
			guiInventory.addItem(strucinfoRec);
			
			ItemStack air3 = LoreGuiItem.build("   ",
					ItemManager.getId(Material.BARRIER),
							0, "");
			air3 = LoreGuiItem.setAction(air3, "OpenInventory");
			air3 = LoreGuiItem.setActionData(air3, "invType", "showAirInventory");
			guiInventory.addItem(air3);
			
			ItemStack wdrinfoRec = LoreGuiItem.build("Tutorial: Wonders", 
					ItemManager.getId(Material.BEACON),
							1, CivColor.Gold+"<Click To View>");
			wdrinfoRec = LoreGuiItem.setAction(wdrinfoRec, "OpenInventory");
			wdrinfoRec = LoreGuiItem.setActionData(wdrinfoRec, "invType", "showWonderTutorialInventory");
			guiInventory.addItem(wdrinfoRec);
			
			ItemStack air4 = LoreGuiItem.build("    ",
					ItemManager.getId(Material.BARRIER),
							0, "");
			air4 = LoreGuiItem.setAction(air4, "OpenInventory");
			air4 = LoreGuiItem.setActionData(air4, "invType", "showAirInventory");
			guiInventory.addItem(air4);
			
			ItemStack strucurinfoRec = LoreGuiItem.build("Tutorial: Structure Upgrades & Rates", 
					ItemManager.getId(Material.GOLDEN_APPLE),
							1, CivColor.Gold+"<Click To View>");
			strucurinfoRec = LoreGuiItem.setAction(strucurinfoRec, "OpenInventory");
			strucurinfoRec = LoreGuiItem.setActionData(strucurinfoRec, "invType", "showStrucInfoTutorialInventory");
			guiInventory.addItem(strucurinfoRec);
			
			ItemStack air5 = LoreGuiItem.build("     ",
					ItemManager.getId(Material.BARRIER),
							0, "");
			air5 = LoreGuiItem.setAction(air5, "OpenInventory");
			air5 = LoreGuiItem.setActionData(air5, "invType", "showAirInventory");
			guiInventory.addItem(air5);
			
			ItemStack tech1infoRec = LoreGuiItem.build("Tutorial: Techs Tier 1-5", 
					ItemManager.getId(Material.PAPER),
							0, CivColor.Gold+"<Click To View>");
			tech1infoRec = LoreGuiItem.setAction(tech1infoRec, "OpenInventory");
			tech1infoRec = LoreGuiItem.setActionData(tech1infoRec, "invType", "showTech1TutorialInventory");
			guiInventory.addItem(tech1infoRec);
			
			ItemStack air6 = LoreGuiItem.build("      ",
					ItemManager.getId(Material.BARRIER),
							0, "");
			air6 = LoreGuiItem.setAction(air6, "OpenInventory");
			air6 = LoreGuiItem.setActionData(air6, "invType", "showAirInventory");
			guiInventory.addItem(air6);
			
			ItemStack tech2infoRec = LoreGuiItem.build("Tutorial: Techs Tier 6-10", 
					ItemManager.getId(Material.MAP),
							0, CivColor.Gold+"<Click To View>");
			tech2infoRec = LoreGuiItem.setAction(tech2infoRec, "OpenInventory");
			tech2infoRec = LoreGuiItem.setActionData(tech2infoRec, "invType", "showTech2TutorialInventory");
			guiInventory.addItem(tech2infoRec);
			
			ItemStack air7 = LoreGuiItem.build("       ",
					ItemManager.getId(Material.BARRIER),
							0, "");
			air7 = LoreGuiItem.setAction(air7, "OpenInventory");
			air7 = LoreGuiItem.setActionData(air7, "invType", "showAirInventory");
			guiInventory.addItem(air7);
			
			ItemStack leRec = LoreGuiItem.build("Tutorial: Library Enchantments", 
					ItemManager.getId(Material.ENCHANTED_BOOK),
							1, CivColor.Gold+"<Click To View>");
			leRec = LoreGuiItem.setAction(leRec, "OpenInventory");
			leRec = LoreGuiItem.setActionData(leRec, "invType", "showleTutorialInventory");
			guiInventory.addItem(leRec);
			
			ItemStack air8 = LoreGuiItem.build("        ",
					ItemManager.getId(Material.BARRIER),
							0, "");
			air8 = LoreGuiItem.setAction(air8, "OpenInventory");
			air8 = LoreGuiItem.setActionData(air8, "invType", "showAirInventory");
			guiInventory.addItem(air8);
			
			LoreGuiItemListener.guiInventories.put(guiInventory.getName(), guiInventory);
		}
		player.openInventory(guiInventory);

	}
}
