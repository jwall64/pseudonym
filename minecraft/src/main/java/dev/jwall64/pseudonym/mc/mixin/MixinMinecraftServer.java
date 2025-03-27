package dev.jwall64.pseudonym.mc.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import dev.jwall64.pseudonym.PipelineContext;
import dev.jwall64.pseudonym.PlaceholderManager;
import dev.jwall64.pseudonym.mc.api.ServerPlaceholders;
import dev.jwall64.pseudonym.mc.impl.ServerExtension;

import java.util.List;

@Mixin(MinecraftServer.class)
@Implements(@Interface(iface = ServerExtension.class, prefix = "pseudonym$"))
public class MixinMinecraftServer {

    @Unique
    private PlaceholderManager pseudonym$placeholderManager;

    @Inject(method="<init>", at=@At("TAIL"))
    private void onConstruct(CallbackInfo ci) {
        pseudonym$placeholderManager = new PlaceholderManager(PipelineContext.of(this), List.of(ServerPlaceholders.getGlobalPlaceholders()));
    }

    PlaceholderManager pseudonym$getPlaceholderManager() {
        return pseudonym$placeholderManager;
    }


}
