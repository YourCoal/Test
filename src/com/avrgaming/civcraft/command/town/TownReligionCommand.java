package com.avrgaming.civcraft.command.town;

import java.util.ArrayList;

import com.avrgaming.civcraft.command.CommandBase;
import com.avrgaming.civcraft.config.ConfigReligion;
import com.avrgaming.civcraft.exception.CivException;
import com.avrgaming.civcraft.main.CivMessage;
import com.avrgaming.civcraft.object.Town;
import com.avrgaming.civcraft.util.CivColor;

public class TownReligionCommand extends CommandBase {

	@Override
	public void init() {
		command = "/town religion";
		displayName = "Town Religion";
		
		commands.put("info", "Information about your current religion.");
		commands.put("change", "[name] - change your government to the named religion.");
		commands.put("list", "lists available religions to change to.");
	}
	
	public void change_cmd() throws CivException {
		Town town = getSelectedTown();
		
		if (args.length < 2) {
			throw new CivException("You must enter the name of a government you want to change to.");
		}
		
		ConfigReligion rg = ConfigReligion.getReligionFromName(args[1]);
		if (rg == null) {
			throw new CivException("Could not find government named "+args[1]);
		}
		
		town.changeReligion(town, rg, false);
		CivMessage.sendSuccess(sender, "Revolution Successful.");
	}
	
	public void list_cmd() throws CivException {
		Town town = getSelectedTown();
		
		CivMessage.sendHeading(sender, "Available Religion");
		ArrayList<ConfigReligion> rgs = ConfigReligion.getAvailableReligions(town);
		
		for (ConfigReligion rg : rgs) {
			if (rg == town.getReligion()) {
				CivMessage.send(sender, CivColor.Gold+rg.displayName+" (current)");
			} else {
				CivMessage.send(sender, CivColor.Green+rg.displayName);
			}
		}
	}
	
	public void info_cmd() throws CivException {
		Town town = getSelectedTown();
		
		CivMessage.sendHeading(sender, "Government "+town.getReligion().displayName);
		CivMessage.send(sender, CivColor.Green+" Growth Rate: "+CivColor.LightGreen+town.getReligion().growth_rate);
		CivMessage.send(sender, CivColor.Green+" Hammer Rate: "+CivColor.LightGreen+town.getReligion().hammer_rate);
		CivMessage.send(sender, CivColor.Green+" Beaker Rate: "+CivColor.LightGreen+town.getReligion().beaker_rate);
		CivMessage.send(sender, CivColor.Green+" Culture Rate: "+CivColor.LightGreen+town.getReligion().culture_rate);	
	}
	
	@Override
	public void doDefaultAction() throws CivException {
		showHelp();
	}
	
	@Override
	public void showHelp() {
		showBasicHelp();
	}
	
	@Override
	public void permissionCheck() throws CivException {
		validMayor();		
	}
}
