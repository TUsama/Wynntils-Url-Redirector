package com.clefal;

import com.clefal.mode.ChangeModeCommand;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

public class wynntils_url_redirector_client implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ClientCommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess) -> ChangeModeCommand.register(dispatcher)));
	}
}