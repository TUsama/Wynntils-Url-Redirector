package com.clefal.mixin.client;

import com.wynntils.services.map.MapService;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static com.clefal.mode.ChangeModeCommand.mode;

@Mixin(MapService.class)
public class MapServiceMixin {
    @ModifyArg(method = "loadMapPart",
            at = @At(value = "INVOKE", target = "Ljava/net/URI;create(Ljava/lang/String;)Ljava/net/URI;"),
            index = 0,
            remap = false)
    private String modifyURL(String json) {
        return mode.replacement.apply(json);
    }
}
