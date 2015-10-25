package com.avrgaming.civcraft.items.components;

import gpl.AttributeUtil;
import gpl.AttributeUtil.Attribute;
import gpl.AttributeUtil.AttributeType;

public class ModifiedDamage extends ItemComponent {

	@Override
	public void onPrepareCreate(AttributeUtil attrs) {
		attrs.add(Attribute.newBuilder().name("Damage").
				type(AttributeType.GENERIC_ATTACK_DAMAGE).
				amount(this.getDouble("value")).
				build());
	}
}
