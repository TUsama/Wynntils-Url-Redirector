package com.clefal.mixin.client;

import com.wynntils.core.net.UrlManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(UrlManager.class)
public class UrlManagerMixin {
    @ModifyArg(method = "readUrlMapper",
            at = @At(value = "INVOKE", target = "Lcom/google/gson/Gson;fromJson(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;"),
            index = 0,
            remap = false)
    private String modifyURL(String json) {
        return json.replaceAll("raw.githubusercontent.com", "fastly.jsdelivr.net/gh")
                .replaceAll("Static-Storage/main", "Static-Storage@main");
    }
}