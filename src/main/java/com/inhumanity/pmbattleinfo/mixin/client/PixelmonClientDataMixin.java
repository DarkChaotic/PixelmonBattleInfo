package com.inhumanity.pmbattleinfo.mixin.client;

import com.pixelmonmod.pixelmon.api.pokemon.stats.BattleStats;
import com.pixelmonmod.pixelmon.battles.controller.participants.PixelmonWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.pixelmonmod.pixelmon.client.gui.battles.PixelmonClientData;

@Mixin(PixelmonClientData.class)
public class PixelmonClientDataMixin {
    @Shadow
    @Final
    private BattleStats battleStats;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void init(PixelmonWrapper pixelmon, CallbackInfo ci) {
        this.battleStats = pixelmon.getBattleStats();
    }

    public BattleStats getBattleStats() {
        return this.battleStats;
    }
    
}
