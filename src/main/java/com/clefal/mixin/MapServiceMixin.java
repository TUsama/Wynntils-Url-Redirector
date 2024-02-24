package com.clefal.mixin;

import com.wynntils.core.WynntilsMod;
import com.wynntils.services.map.MapService;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(MapService.class)
public class MapServiceMixin {
    @ModifyArg(method = "loadMapPart",
            at = @At(value = "INVOKE", target = "Ljava/net/URI;create(Ljava/lang/String;)Ljava/net/URI;"),
            index = 0,
            remap = false)
    private String modifyURL(String json) {
        return json.replaceAll("raw.githubusercontent.com", "fastly.jsdelivr.net/gh")
                .replaceAll("Static-Storage/main", "Static-Storage@main");
    }
}
