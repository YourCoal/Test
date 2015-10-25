package com.avrgaming.civcraft.items.components;

import gpl.AttributeUtil;
import gpl.AttributeUtil.Attribute;
import gpl.AttributeUtil.AttributeType;

public class KBResistance extends ItemComponent {

	@Override
	public void onPrepareCreate(AttributeUtil attrs) {
		attrs.add(Attribute.newBuilder().name("KBResistance").
				type(AttributeType.GENERIC_KB_RESISTANCE).
				amount(this.getDouble("value")).
				build());
	}
}
