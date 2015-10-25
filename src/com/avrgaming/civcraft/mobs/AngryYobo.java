package com.avrgaming.civcraft.mobs;

import net.minecraft.server.v1_8_R3.DamageSource;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityCreature;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_8_R3.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_8_R3.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_8_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_8_R3.PathfinderGoalSelector;

import org.bukkit.Material;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;

import com.avrgaming.civcraft.mobs.components.MobComponentDefense;
import com.avrgaming.civcraft.util.ItemManager;
import com.moblib.mob.ICustomMob;
import com.moblib.mob.MobBaseZombie;

public class AngryYobo  extends CommonCustomMob implements ICustomMob {
	
	public void onCreate() {
		initLevelAndType();
		getGoalSelector().a(0, new PathfinderGoalFloat((EntityInsentient) entity));
	    getGoalSelector().a(2, new PathfinderGoalMeleeAttack((EntityCreature) entity, EntityHuman.class, 1.0D, false));
	    getGoalSelector().a(8, new PathfinderGoalLookAtPlayer((EntityInsentient) entity, EntityHuman.class, 8.0F));
	    getTargetSelector().a(2, new PathfinderGoalNearestAttackableTarget<EntityHuman>((EntityCreature) entity, EntityHuman.class, true));
	    this.setName(this.getLevel().getName()+" "+this.getType().getName());
	    MobBaseZombie zombie = ((MobBaseZombie)this.entity);
	    zombie.setBaby(true);
	}
	
	@Override
	public void onTick() {
		super.onTick();		
	}
	
	@Override
	public String getBaseEntity() {
		return MobBaseZombie.class.getName();
	}
	
	public void onDamage(EntityCreature e, DamageSource damagesource, PathfinderGoalSelector goalSelector, PathfinderGoalSelector targetSelector) {
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
	public void onRangedAttack(Entity target) {
		
	}
	
	@Override
	public String getClassName() {
		return AngryYobo.class.getName();
	}
	
	@Override
	public void onTarget(EntityTargetEvent event) {
		super.onTarget(event);
		
		if (event.getReason().equals(TargetReason.FORGOT_TARGET) ||
		    event.getReason().equals(TargetReason.TARGET_DIED)) {
			event.getEntity().remove();
		}
	}
}
