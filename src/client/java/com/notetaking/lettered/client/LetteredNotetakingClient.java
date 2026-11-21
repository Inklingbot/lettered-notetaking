package com.notetaking.lettered.client;
import com.mojang.blaze3d.platform.InputConstants;
import com.notetaking.lettered.LetteredNotetaking;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.fabricmc.api.ClientModInitializer;


public class LetteredNotetakingClient implements ClientModInitializer {
	private static final KeyMapping.Category NOTES_CATEGORY =
			KeyMapping.Category.register(LetteredNotetaking.id("notes"));
	private static KeyMapping openNotesKey;

		@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		openNotesKey = KeyMappingHelper.registerKeyMapping(new KeyMapping(
		"key.lettered-notetaking.open_notes",
		InputConstants.Type.KEYBOARD,
		InputConstants.KEY_N,
		NOTES_CATEGORY
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (openNotesKey.consumeClick()) {
				if (client.player != null && client.gui.screen() == null) {
					client.gui.setScreen(new NotesScreen());
				}
			}
		});
	}
}


