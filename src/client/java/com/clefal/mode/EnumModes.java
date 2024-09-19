package com.clefal.mode;

import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import net.minecraft.network.chat.Component;

import java.util.function.Function;

public enum EnumModes {


    ROUTE1((x) -> x.replaceAll("raw.githubusercontent.com", "img.jsdelivr.com/raw.githubusercontent.com")),
    ROUTE2((x) -> x.replaceAll("raw.githubusercontent.com", "i0.wp.com/raw.githubusercontent.com")),
    GITEA((x) -> x.replace("raw.githubusercontent.com/Wynntils/Static-Storage", "gitea.com/wuki/Static-Storage/raw/branch"));

    public final Function<String, String> replacement;

    EnumModes(Function<String, String> replacement) {
        this.replacement = replacement;
    }

    static class Error {
        public static final DynamicCommandExceptionType ERROR_INVALID_VALUE = new DynamicCommandExceptionType((object) -> Component.literal("invalid mode: " + object));
    }
}
