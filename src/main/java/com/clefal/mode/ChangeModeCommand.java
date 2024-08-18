package com.clefal.mode;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class ChangeModeCommand {

    public static EnumModes mode = EnumModes.ROUTE1;

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(
                ClientCommandManager.literal("wur")
                        .then(ClientCommandManager.literal("route")
                                .then(ClientCommandManager.argument("mode", ModeArgument.mode())
                                        .executes(ctx -> {
                                                    EnumModes mode1 = ctx.getArgument("mode", EnumModes.class);
                                                    mode = mode1;
                                                    Minecraft.getInstance().player.sendSystemMessage(Component.literal("change to " + mode1));
                                                    return Command.SINGLE_SUCCESS;
                                                }
                                        )
                                )
                        )
        );


    }


}
