package com.clefal.mixin;

import com.wynntils.services.map.MapService;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Random;

import static com.clefal.mode.ChangeModeCommand.mode;

@Mixin(MapService.class)
public class MapServiceMixin {
    @Unique
    private Random random = new Random();
    @ModifyArg(method = "loadMapPart",
            at = @At(value = "INVOKE", target = "Ljava/net/URI;create(Ljava/lang/String;)Ljava/net/URI;"),
            index = 0,
            remap = false)
    private String modifyURL(String json) {

        return mode.replacement.apply(json);
    }
}
