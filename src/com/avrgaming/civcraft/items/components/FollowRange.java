package com.avrgaming.civcraft.items.components;

import gpl.AttributeUtil;
import gpl.AttributeUtil.Attribute;
import gpl.AttributeUtil.AttributeType;

public class FollowRange extends ItemComponent {

	@Override
	public void onPrepareCreate(AttributeUtil attrs) {
		attrs.add(Attribute.newBuilder().name("FollowRange").
				type(AttributeType.GENERIC_FOLLOW_RANGE).
				amount(this.getDouble("value")).
				build());
	}
}
