 package com.avrgaming.civcraft.tutorial;

import gpl.AttributeUtil;

import java.util.LinkedList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.avrgaming.civcraft.lorestorage.LoreCraftableMaterial;
import com.avrgaming.civcraft.lorestorage.LoreGuiItem;
import com.avrgaming.civcraft.lorestorage.LoreGuiItemListener;
import com.avrgaming.civcraft.lorestorage.LoreMaterial;
import com.avrgaming.civcraft.util.CivColor;
import com.avrgaming.civcraft.util.ItemManager;

public class TownBook {
	
	//XXX New Inventories
	public static Inventory groupsInventory = null;
	public static Inventory airInventory = null;
	//XXX Original Ones
	public static Inventory guiInventory = null;
	public static final int MAX_CHEST_SIZE = 6;
	
	public static void showGroupsInventory(Player player) {	
		if (groupsInventory == null) {
			groupsInventory = Bukkit.getServer().createInventory(player, 9*3, "Town Groups");
		
			groupsInventory.setItem(0, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Creating Groups", ItemManager.getId(Material.PRISMARINE_CRYSTALS), 0, 
					ChatColor.RESET+"Creating groups is a great way to limit access to",
					ChatColor.RESET+"players you may not trust, and also is good to",
					ChatColor.RESET+"assure you can be organized, or if you want players",
					ChatColor.RESET+"not in your town to help you on plots, this is also",
					ChatColor.RESET+"good for them to help you. This is how you create",
					ChatColor.RESET+"your very own group:",
					ChatColor.RESET+" ",
					ChatColor.RESET+CivColor.Green+"/town group new (groupName)",
					ChatColor.RESET+"",
					ChatColor.RESET+"(groupName) will be the display name of this group",
					ChatColor.RESET+"you are creating."
					));
			groupsInventory.setItem(9, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Adding Players to Groups", ItemManager.getId(Material.GOLDEN_APPLE), 0, 
					ChatColor.RESET+"When adding a player to a group, they will be told",
					ChatColor.RESET+"they joined it. Remember, once added to this group,",
					ChatColor.RESET+"the player can do anything they can to the plot the",
					ChatColor.RESET+"group was added to. Lets learn how to add players",
					ChatColor.RESET+"to group you want them in:",
					ChatColor.RESET+" ",
					ChatColor.RESET+CivColor.Green+"/town group add (player) (groupName)",
					ChatColor.RESET+"",
					ChatColor.RESET+CivColor.Green+"(player)"+ChatColor.RESET+" will be the player you want in the",
					ChatColor.RESET+"group you want them in.",
					ChatColor.RESET+CivColor.Green+"(groupName)"+ChatColor.RESET+" will be the name of the group you",
					ChatColor.RESET+"created in the previous step."
					));
			groupsInventory.setItem(18, LoreGuiItem.build(CivColor.LightGray+ChatColor.BOLD+"Removing Players to Groups", ItemManager.getId(Material.BARRIER), 0, 
					ChatColor.RESET+"When/if you no longer need a player in a group, or",
					ChatColor.RESET+"they are abusing the permissions you gave them, you",
					ChatColor.RESET+"can do the following to stop them & remove them from",
					ChatColor.RESET+"to group you want them out of:",
					ChatColor.RESET+" ",
					ChatColor.RESET+CivColor.Green+"/town group remove (player) (groupName)",
					ChatColor.RESET+"",
					ChatColor.RESET+CivColor.Green+"(player)"+ChatColor.RESET+" will be the player you want to remove",
					ChatColor.RESET+"from the group.",
					ChatColor.RESET+CivColor.Green+"(groupName)"+ChatColor.RESET+" will be the name of the group you",
					ChatColor.RESET+"added them to in the previous step."
					));
			
			LoreGuiItemListener.guiInventories.put(groupsInventory.getName(), groupsInventory);
		}
		if (player != null && player.isOnline() && player.isValid()) {
			player.openInventory(groupsInventory);	
		}
	}
	
	public static void showAirInventory(Player player) {	
		if (airInventory == null) {
			airInventory = Bukkit.getServer().createInventory(player, 9*1, " ");
		
			airInventory.setItem(4, LoreGuiItem.build(ChatColor.BOLD+" ", ItemManager.getId(Material.STONE_BUTTON), 0, 
					ChatColor.RESET+" "
					));
		
			LoreGuiItemListener.guiInventories.put(airInventory.getName(), airInventory);
		}
		if (player != null && player.isOnline() && player.isValid()) {
			player.openInventory(airInventory);	
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
	
	public static void spawnGuiBook(Player player) {
		if (guiInventory == null) {
			guiInventory = Bukkit.getServer().createInventory(player, 1*9, "Town Groups");
			ItemStack help = LoreGuiItem.build("Town Groups",
					ItemManager.getId(Material.PRISMARINE_CRYSTALS),
						0, CivColor.Gold+"<Click To View>");
			help = LoreGuiItem.setAction(help, "OpenInventory");
			help = LoreGuiItem.setActionData(help, "invType", "showGroupsInventory");
			guiInventory.addItem(help);
			
			ItemStack air = LoreGuiItem.build(" ",
					ItemManager.getId(Material.BARRIER),
						0, "");
			air = LoreGuiItem.setAction(air, "OpenInventory");
			air = LoreGuiItem.setActionData(air, "invType", "showAirInventory");
			guiInventory.addItem(air);
			
			LoreGuiItemListener.guiInventories.put(guiInventory.getName(), guiInventory);
		}
		player.openInventory(guiInventory);
	}
}
