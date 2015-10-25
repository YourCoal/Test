package com.avrgaming.civcraft.threading.tasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.avrgaming.civcraft.exception.CivTaskAbortException;
import com.avrgaming.civcraft.main.CivData;
import com.avrgaming.civcraft.main.CivLog;
import com.avrgaming.civcraft.object.StructureChest;
import com.avrgaming.civcraft.structure.Structure;
import com.avrgaming.civcraft.structure.LumberMill;
import com.avrgaming.civcraft.structure.LumberMill.Woods;
import com.avrgaming.civcraft.threading.CivAsyncTask;
import com.avrgaming.civcraft.threading.sync.request.UpdateInventoryRequest.Action;
import com.avrgaming.civcraft.util.ItemManager;
import com.avrgaming.civcraft.util.MultiInventory;

public class LumberMillAsyncTask extends CivAsyncTask {
	LumberMill lm;
	
	public static HashSet<String> debugTowns = new HashSet<String>();
	
	public static void debug(LumberMill lm, String msg) {
		if (debugTowns.contains(lm.getTown().getName())) {
			CivLog.warning("LumberMillDebug:"+lm.getTown().getName()+":"+msg);
		}
	}	
	
	public LumberMillAsyncTask(Structure lm) {
		this.lm = (LumberMill)lm;
	}
	
	public void processTrommelUpdate() {
		if (!lm.isActive()) {
			debug(lm, "lumbermill inactive...");
			return;
		}
		
		debug(lm, "Processing lumbermill...");
		// Grab each CivChest object we'll require.
		ArrayList<StructureChest> sources = lm.getAllChestsById(0);
		ArrayList<StructureChest> destinations = lm.getAllChestsById(1);
		
		if (sources.size() != 2 || destinations.size() != 2) {
			CivLog.error("Bad chests for lumbermill in town:"+lm.getTown().getName()+" sources:"+sources.size()+" dests:"+destinations.size());
			return;
		}
		
		// Make sure the chunk is loaded before continuing. Also, add get chest and add it to inventory.
		MultiInventory source_inv = new MultiInventory();
		MultiInventory dest_inv = new MultiInventory();
		
		try {
			for (StructureChest src : sources) {
				//this.syncLoadChunk(src.getCoord().getWorldname(), src.getCoord().getX(), src.getCoord().getZ());				
				Inventory tmp;
				try {
					tmp = this.getChestInventory(src.getCoord().getWorldname(), src.getCoord().getX(), src.getCoord().getY(), src.getCoord().getZ(), false);
				} catch (CivTaskAbortException e) {
					//e.printStackTrace();
					CivLog.warning("LumberMill:"+e.getMessage());
					return;
				}
				if (tmp == null) {
					lm.skippedCounter++;
					return;
				}
				source_inv.addInventory(tmp);
			}
			
			boolean full = true;
			for (StructureChest dst : destinations) {
				//this.syncLoadChunk(dst.getCoord().getWorldname(), dst.getCoord().getX(), dst.getCoord().getZ());
				Inventory tmp;
				try {
					tmp = this.getChestInventory(dst.getCoord().getWorldname(), dst.getCoord().getX(), dst.getCoord().getY(), dst.getCoord().getZ(), false);
				} catch (CivTaskAbortException e) {
					//e.printStackTrace();
					CivLog.warning("LumberMill:"+e.getMessage());
					return;
				}
				if (tmp == null) {
					lm.skippedCounter++;
					return;
				}
				dest_inv.addInventory(tmp);
				
				for (ItemStack stack : tmp.getContents()) {
					if (stack == null) {
						full = false;
						break;
					}
				}
			}
			if (full) {
				return;
			}
		} catch (InterruptedException e) {
			return;
		}
		
		debug(lm, "Processing lumbermill:"+lm.skippedCounter+1);
		ItemStack[] contents = source_inv.getContents();
		for (int i = 0; i < lm.skippedCounter+1; i++) {
			for(ItemStack stack : contents) {
				if (stack == null) {
					continue;
				}
				
				if (ItemManager.getId(stack) == CivData.WOOD) {
					if (this.lm.getLevel() >= 1 && ItemManager.getData(stack) == 
							ItemManager.getData(ItemManager.getMaterialData(CivData.WOOD, CivData.OAK))) {
						try {
							this.updateInventory(Action.REMOVE, source_inv, ItemManager.createItemStack(CivData.WOOD, 2, (short) CivData.OAK));
						} catch (InterruptedException e) {
							return;
						}
						Random rand = new Random();
						int randMax = LumberMill.OAK_MAX;
						int rand1 = rand.nextInt(randMax);
						ItemStack newItem;
						if (rand1 < ((int)((lm.getOakCutting(Woods.LOG))*randMax))) {
							newItem = ItemManager.createItemStack(CivData.WOOD, 2, (short) CivData.OAK);
						}
						else if (rand1 < ((int)((lm.getOakCutting(Woods.SAP))*randMax))) {
							newItem = ItemManager.createItemStack(CivData.SAPLING, 1, (short) CivData.OAK);
						} else {
							newItem = ItemManager.createItemStack(CivData.PLANKS, 4, (short) CivData.OAK);
						}
						try {
							debug(lm, "Updating inventory:"+newItem);
							this.updateInventory(Action.ADD, dest_inv, newItem);
						} catch (InterruptedException e) {
							return;
						}
						break;
					}
				}
				
				if (ItemManager.getId(stack) == CivData.WOOD) {
					if (this.lm.getLevel() >= 1 && ItemManager.getData(stack) == 
							ItemManager.getData(ItemManager.getMaterialData(CivData.WOOD, CivData.SPRUCE))) {
						try {
							this.updateInventory(Action.REMOVE, source_inv, ItemManager.createItemStack(CivData.WOOD, 2, (short) CivData.SPRUCE));
						} catch (InterruptedException e) {
							return;
						}
						Random rand = new Random();
						int randMax = LumberMill.SPRUCE_MAX;
						int rand1 = rand.nextInt(randMax);
						ItemStack newItem;
						if (rand1 < ((int)((lm.getOakCutting(Woods.LOG))*randMax))) {
							newItem = ItemManager.createItemStack(CivData.WOOD, 2, (short) CivData.SPRUCE);
						}
						else if (rand1 < ((int)((lm.getOakCutting(Woods.SAP))*randMax))) {
							newItem = ItemManager.createItemStack(CivData.SAPLING, 1, (short) CivData.SPRUCE);
						} else {
							newItem = ItemManager.createItemStack(CivData.PLANKS, 4, (short) CivData.SPRUCE);
						}
						try {
							debug(lm, "Updating inventory:"+newItem);
							this.updateInventory(Action.ADD, dest_inv, newItem);
						} catch (InterruptedException e) {
							return;
						}
						break;
					}
				}
				
				if (ItemManager.getId(stack) == CivData.WOOD) {
					if (this.lm.getLevel() >= 1 && ItemManager.getData(stack) == 
							ItemManager.getData(ItemManager.getMaterialData(CivData.WOOD, CivData.BIRCH))) {
						try {
							this.updateInventory(Action.REMOVE, source_inv, ItemManager.createItemStack(CivData.WOOD, 2, (short) CivData.BIRCH));
						} catch (InterruptedException e) {
							return;
						}
						Random rand = new Random();
						int randMax = LumberMill.BIRCH_MAX;
						int rand1 = rand.nextInt(randMax);
						ItemStack newItem;
						if (rand1 < ((int)((lm.getOakCutting(Woods.LOG))*randMax))) {
							newItem = ItemManager.createItemStack(CivData.WOOD, 2, (short) CivData.BIRCH);
						}
						else if (rand1 < ((int)((lm.getOakCutting(Woods.SAP))*randMax))) {
							newItem = ItemManager.createItemStack(CivData.SAPLING, 1, (short) CivData.BIRCH);
						} else {
							newItem = ItemManager.createItemStack(CivData.PLANKS, 4, (short) CivData.BIRCH);
						}
						try {
							debug(lm, "Updating inventory:"+newItem);
							this.updateInventory(Action.ADD, dest_inv, newItem);
						} catch (InterruptedException e) {
							return;
						}
						break;
					}
				}
				
				if (ItemManager.getId(stack) == CivData.WOOD) {
					if (this.lm.getLevel() >= 1 && ItemManager.getData(stack) == 
							ItemManager.getData(ItemManager.getMaterialData(CivData.WOOD, CivData.JUNGLE))) {
						try {
							this.updateInventory(Action.REMOVE, source_inv, ItemManager.createItemStack(CivData.WOOD, 2, (short) CivData.JUNGLE));
						} catch (InterruptedException e) {
							return;
						}
						Random rand = new Random();
						int randMax = LumberMill.JUNGLE_MAX;
						int rand1 = rand.nextInt(randMax);
						ItemStack newItem;
						if (rand1 < ((int)((lm.getOakCutting(Woods.LOG))*randMax))) {
							newItem = ItemManager.createItemStack(CivData.WOOD, 2, (short) CivData.JUNGLE);
						}
						else if (rand1 < ((int)((lm.getOakCutting(Woods.SAP))*randMax))) {
							newItem = ItemManager.createItemStack(CivData.SAPLING, 1, (short) CivData.JUNGLE);
						} else {
							newItem = ItemManager.createItemStack(CivData.PLANKS, 4, (short) CivData.JUNGLE);
						}
						try {
							debug(lm, "Updating inventory:"+newItem);
							this.updateInventory(Action.ADD, dest_inv, newItem);
						} catch (InterruptedException e) {
							return;
						}
						break;
					}
				}
			}
		}	
	lm.skippedCounter = 0;
	}
	
	@Override
	public void run() {
		if (this.lm.lock.tryLock()) {
			try {
				try {
					processTrommelUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} finally {
				this.lm.lock.unlock();
			}
		} else {
			debug(this.lm, "Failed to get lock while trying to start task, aborting.");
		}
	}
}
