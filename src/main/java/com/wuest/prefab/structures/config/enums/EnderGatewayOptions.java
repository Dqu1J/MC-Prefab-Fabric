package com.wuest.prefab.structures.config.enums;

public class EnderGatewayOptions extends BaseOption {
	public static EnderGatewayOptions Default = new EnderGatewayOptions("item.prefab.ender_gateway", "assets/prefab/structures/ender_gateway.zip", "textures/gui/ender_gateway_topdown.png", 103, 150);

	protected EnderGatewayOptions(String translationString, String assetLocation, String pictureLocation, int imageWidth, int imageHeight) {
		super(translationString, assetLocation, pictureLocation, imageWidth, imageHeight);
	}
}
