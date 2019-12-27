package com.raphydaphy.arcanemagic.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.raphydaphy.arcanemagic.block.entity.AnalyzerBlockEntity;
import com.raphydaphy.arcanemagic.util.ArcaneMagicUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Quaternion;

public class AnalyzerRenderer extends BlockEntityRenderer<AnalyzerBlockEntity> {
    
	public AnalyzerRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
		super(blockEntityRenderDispatcher);
	}

	@Override
    public void render(AnalyzerBlockEntity entity, float partialTicks, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (entity != null) {
            ItemStack stack = entity.getInvStack(0);
            if (!stack.isEmpty()) {
            	double renderX = dispatcher.camera.getPos().x;
                double renderY = dispatcher.camera.getPos().y;
                double renderZ = dispatcher.camera.getPos().z;
                
                float ticks = ArcaneMagicUtils.lerp(entity.ticks - 1, entity.ticks, partialTicks);
            	
            	matrices.push();

                DiffuseLighting.enable();
                RenderSystem.enableLighting();
                RenderSystem.disableRescaleNormal();
                matrices.translate(renderX + .5, renderY + 0.45, renderZ + .5);
                if (MinecraftClient.getInstance().getItemRenderer().getHeldItemModel(stack, entity.getWorld(), null).hasDepthInGui()) {
                	matrices.translate(0, -0.06, 0);
                }
                
                Vector3f vec = new Vector3f(0F, 1F, 0F);
    			vec.reciprocal();                
                matrices.multiply(new Quaternion(vec, 2 * ticks, true));
                matrices.scale(0.7F, 0.7F, 0.7F);
                MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, light, overlay, matrices, vertexConsumers);

                matrices.pop();
            }
        }
    }
}
