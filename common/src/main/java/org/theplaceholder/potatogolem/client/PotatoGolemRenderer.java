package org.theplaceholder.potatogolem.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.theplaceholder.potatogolem.PotatoGolemEntity;

import static org.theplaceholder.potatogolem.PotatoGolemMod.MOD_ID;

public class PotatoGolemRenderer extends MobRenderer<PotatoGolemEntity, PotatoGolemModel<PotatoGolemEntity>> {
    private static final ResourceLocation GOLEM_LOCATION = new ResourceLocation(MOD_ID, "textures/" + MOD_ID + ".png");

    public PotatoGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new PotatoGolemModel<>(context.bakeLayer(PotatoGolemModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(PotatoGolemEntity entity) {
        return GOLEM_LOCATION;
    }

    protected void setupRotations(PotatoGolemEntity ironGolem, PoseStack poseStack, float f, float g, float h) {
        super.setupRotations(ironGolem, poseStack, f, g, h);
        if (!((double)ironGolem.walkAnimation.speed() < 0.01)) {
            float j = ironGolem.walkAnimation.position(h) + 6.0F;
            float k = (Math.abs(j % 13.0F - 6.5F) - 3.25F) / 3.25F;
            poseStack.mulPose(Axis.ZP.rotationDegrees(6.5F * k));
        }
    }
}
