package com.clefal.mixin;

import com.wynntils.core.net.UrlManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(UrlManager.class)
public class UrlManagerMixin {
    @ModifyArg(method = "readUrls",
            at = @At(value = "INVOKE", target = "Lcom/google/gson/Gson;fromJson(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;"),
            index = 0,
            remap = false)
    private String modifyURL(String json) {
        return json.replaceAll("raw.githubusercontent.com", "fastly.jsdelivr.net/gh")
                .replaceAll("Static-Storage/main", "Static-Storage@main")
                .replaceAll("WynntilsWebsite-API/master", "WynntilsWebsite-API@master")
                .replaceAll("translate.googleapis.com", "gtransapi.wuki.moe");
    }
}