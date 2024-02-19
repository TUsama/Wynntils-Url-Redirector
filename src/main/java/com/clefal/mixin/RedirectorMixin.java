package com.clefal.mixin;

import com.clefal.wynntils_url_redirector;
import com.wynntils.core.WynntilsMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.InputStream;

@Mixin(WynntilsMod.class)
public class RedirectorMixin {
    @Inject(at = @At("HEAD"), method = "getModResourceAsStream", remap = false, cancellable = true)
    private static void replaceToResourcesLocation(String resourceName, CallbackInfoReturnable<InputStream> cir) {
        InputStream resourceAsStream = wynntils_url_redirector.class.getClassLoader().getResourceAsStream("assets/wynntils_url_redirector/" + resourceName);
        cir.setReturnValue(resourceAsStream);
        cir.cancel();
    }
}