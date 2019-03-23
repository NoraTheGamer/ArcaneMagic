package com.raphydaphy.arcanemagic.core.client;

import com.raphydaphy.arcanemagic.cutscene.CutsceneManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.util.shape.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin
{
	@Inject(at = @At("HEAD"), method = "drawShapeOutline", cancellable = true)
	private static void drawShapeOutline(VoxelShape voxelShape_1, double double_1, double double_2, double double_3, float float_1, float float_2, float float_3, float float_4, CallbackInfo info)
	{
		if (CutsceneManager.hideHud(MinecraftClient.getInstance().player))
		{
			info.cancel();
		}
	}
}
