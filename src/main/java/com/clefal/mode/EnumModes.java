package com.clefal.mode;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.PufferfishBigModel;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public enum EnumModes{



    ROUTE1((x) -> x.replaceAll("raw.githubusercontent.com", "img.jsdelivr.com/raw.githubusercontent.com")),
    ROUTE2((x) -> x.replaceAll("raw.githubusercontent.com", "i0.wp.com/raw.githubusercontent.com")),
    GITEA((x) -> x.replace("raw.githubusercontent.com/Wynntils/Static-Storage", "gitea.com/wuki/Static-Storage/raw/branch"));

    EnumModes(Function<String, String> replacement) {
        this.replacement = replacement;
    }

    public final Function<String, String> replacement;


    static class Error{
        public static final DynamicCommandExceptionType ERROR_INVALID_VALUE = new DynamicCommandExceptionType((object) -> Component.literal("invalid mode: " + object));
    }
}
