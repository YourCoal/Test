package com.avrgaming.civcraft.mobs;

import net.minecraft.server.v1_8_R3.EntityCreature;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_8_R3.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_8_R3.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_8_R3.PathfinderGoalNearestAttackableTarget;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.event.entity.EntityTargetEvent;

import com.avrgaming.civcraft.mobs.MobSpawner.CustomMobLevel;
import com.avrgaming.civcraft.mobs.MobSpawner.CustomMobType;
import com.avrgaming.civcraft.mobs.components.MobComponentDefense;
import com.avrgaming.civcraft.util.ItemManager;
import com.moblib.mob.ICustomMob;
import com.moblib.mob.MobBasePigZombie;

public class Barbarian extends CommonCustomMob implements ICustomMob {

	private static final double TARGET_DISTANCE = 32;

	public void onCreate() {
	    initLevelAndType();	    
	    
	    getGoalSelector().a(0, new PathfinderGoalFloat((EntityInsentient) entity));
	    getGoalSelector().a(2, new PathfinderGoalMeleeAttack((EntityCreature) entity, EntityHuman.class, 1.0D, false));
	    getGoalSelector().a(8, new PathfinderGoalLookAtPlayer((EntityInsentient) entity, EntityHuman.class, 8.0F));
	    getTargetSelector().a(2, new PathfinderGoalNearestAttackableTarget<EntityHuman>((EntityCreature) entity, EntityHuman.class, true));
	    
	    this.setName(this.getLevel().getName()+" "+this.getType().getName());
	}
	
	public void onCreateAttributes() {
		MobComponentDefense defense;
	    this.setKnockbackResistance(0.99);

		switch (this.getLevel()) {
		case LESSER:
		    defense = new MobComponentDefense(3.5);
		    setMaxHealth(20.0);
		    modifySpeed(1.2);
		    this.setAttack(7.5);
			this.addVanillaDrop(ItemManager.getId(Material.IRON_INGOT), (short)0, 0.25);
		    this.coinDrop(1, 20);
			break;
			
		case GREATER:
		    defense = new MobComponentDefense(10);
		    setMaxHealth(25.0);
		    modifySpeed(1.3);
		    this.setAttack(10.0);
		    this.addDrop("civ:bronze_ingot", 0.2);
		    this.addDrop("civ:lowend_varnish", 0.2);
		    this.coinDrop(10, 40);
		    break;
		    
		case ELITE:
		    defense = new MobComponentDefense(16);
		    setMaxHealth(30.0);
		    modifySpeed(1.4);
		    this.setAttack(15.0);
		    this.addDrop("civ:steel_ingot", 0.2);
		    this.addDrop("civ:medend_varnish", 0.2);
		    this.coinDrop(25, 75);
			break;
			
		case BRUTAL:
		    defense = new MobComponentDefense(20);
		    setMaxHealth(35.0);
		    modifySpeed(1.5);
		    this.setAttack(20.0);
		    this.addDrop("civ:titanium_ingot", 0.2);
		    this.addDrop("civ:highend_varnish", 0.2);
		    this.coinDrop(40, 125);
			break;
		default:
		    defense = new MobComponentDefense(0);
			break;
		}
	    this.addComponent(defense);
	}
	
	@Override
	public String getBaseEntity() {
		return MobBasePigZombie.class.getName();
	}

	@Override
	public String getClassName() {
		return Barbarian.class.getName();
	}

	public static void register() {
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.LESSER, Biome.DESERT);
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.LESSER, Biome.DESERT_HILLS);
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.LESSER, Biome.DESERT_MOUNTAINS);
	
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.GREATER, Biome.SAVANNA);
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.GREATER, Biome.SAVANNA_MOUNTAINS);
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.GREATER, Biome.SAVANNA_PLATEAU);
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.GREATER, Biome.SAVANNA_PLATEAU_MOUNTAINS);

	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.ELITE, Biome.MESA);
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.ELITE, Biome.MESA_PLATEAU);
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.ELITE, Biome.MEGA_TAIGA);
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.ELITE, Biome.MEGA_SPRUCE_TAIGA);

	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.BRUTAL, Biome.MESA_BRYCE);
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.ELITE, Biome.MESA_PLATEAU_FOREST);
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.BRUTAL, Biome.MESA_PLATEAU_MOUNTAINS);
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.BRUTAL, Biome.MESA_PLATEAU_FOREST_MOUNTAINS);
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.ELITE, Biome.MEGA_SPRUCE_TAIGA_HILLS);
	    setValidBiome(CustomMobType.BARBARIAN, CustomMobLevel.ELITE, Biome.MEGA_TAIGA_HILLS);
	}
	
	public void onTarget(EntityTargetEvent event) {
		Location current = getLocation((EntityCreature) entity);
		Location targetLoc = event.getTarget().getLocation();
		if (current.distance(targetLoc) > TARGET_DISTANCE) {
			event.setCancelled(true);
		}
		super.onTarget(event);
	}
}
