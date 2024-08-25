package com.clefal.mode;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.commands.SharedSuggestionProvider;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

public class ModeArgument implements ArgumentType<EnumModes> {

    public ModeArgument() {
    }

    public static ModeArgument mode() {
        return new ModeArgument();
    }

    @Override
    public EnumModes parse(StringReader reader) throws CommandSyntaxException {
        String string = reader.readUnquotedString();
        try {
            return EnumModes.valueOf(string);
        } catch (IllegalArgumentException e) {

            throw EnumModes.Error.ERROR_INVALID_VALUE.create(string);
        }
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        return SharedSuggestionProvider.suggest(Arrays.stream(EnumModes.values()).map(Enum::toString).toList(), builder);
    }

    @Override
    public Collection<String> getExamples() {
        return Arrays.stream(EnumModes.values()).map(Enum::toString).toList();
    }
}
