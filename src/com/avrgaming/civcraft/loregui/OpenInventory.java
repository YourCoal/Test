package com.avrgaming.civcraft.loregui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.avrgaming.civcraft.exception.CivException;
import com.avrgaming.civcraft.lorestorage.LoreGuiItem;
import com.avrgaming.civcraft.lorestorage.LoreGuiItemListener;
import com.avrgaming.civcraft.main.CivGlobal;
import com.avrgaming.civcraft.main.CivLog;
import com.avrgaming.civcraft.threading.TaskMaster;
import com.avrgaming.civcraft.tutorial.CivTutorial;
import com.avrgaming.civcraft.tutorial.TownBook;

public class OpenInventory implements GuiAction {

	@Override
	public void performAction(InventoryClickEvent event, ItemStack stack) {
		Player player = (Player)event.getWhoClicked();
		player.closeInventory();
		
		class SyncTaskDelayed implements Runnable {
			String playerName;
			ItemStack stack;
			
			public SyncTaskDelayed(String playerName, ItemStack stack) {
				this.playerName = playerName;
				this.stack = stack;
			}
			
			@Override
			public void run() {
				Player player;
				try {
					player = CivGlobal.getPlayer(playerName);
				} catch (CivException e) {
					e.printStackTrace();
					return;
				}
				
				switch (LoreGuiItem.getActionData(stack, "invType")) {
				//Town Book
				case "showGroupsInventory":
					TownBook.showGroupsInventory(player);
					break;
				//XXX New Inventories
				case "showleTutorialInventory":
					CivTutorial.showleInventory(player);
					break;
				case "showStrucInfoTutorialInventory":
					CivTutorial.showStrucInfoTutorialInventory(player);
					break;
				case "showTech1TutorialInventory":
					CivTutorial.showTech1TutorialInventory(player);
					break;
				case "showTech2TutorialInventory":
					CivTutorial.showTech2TutorialInventory(player);
					break;
				case "showStrucTutorialInventory":
					CivTutorial.showStrucTutorialInventory(player);
					break;
				case "showWonderTutorialInventory":
					CivTutorial.showWonderTutorialInventory(player);
					break;
				case "showMobTutorialInventory":
					CivTutorial.showMobTutorialInventory(player);
					break;
				case "showAirInventory":
					CivTutorial.showAirInventory(player);
					break;
				//XXX Original Ones
				case "showTutorialInventory":
					CivTutorial.showTutorialInventory(player);
					break;
				case "showCraftingHelp":
					CivTutorial.showCraftingHelp(player);
					break;
				case "showGuiInv":
					String invName = LoreGuiItem.getActionData(stack, "invName");
					Inventory inv = LoreGuiItemListener.guiInventories.get(invName);
					if (inv != null) {
						player.openInventory(inv);
					} else {
						CivLog.error("Couldn't find GUI inventory:"+invName);
					}
					break;
				default:
					break;
				}
			}
		}
		TaskMaster.syncTask(new SyncTaskDelayed(player.getName(), stack));		
	}
}
