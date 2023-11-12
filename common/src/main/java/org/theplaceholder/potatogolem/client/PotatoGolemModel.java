package org.theplaceholder.potatogolem.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.theplaceholder.potatogolem.PotatoGolemEntity;

import static org.theplaceholder.potatogolem.PotatoGolemMod.MOD_ID;

public class PotatoGolemModel<T extends PotatoGolemEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MOD_ID, MOD_ID), "main");
    private final ModelPart root;
    private final ModelPart LeftLeg;
    private final ModelPart LeftArm;
    private final ModelPart Head;
    private final ModelPart RightLeg;
    private final ModelPart Body;
    private final ModelPart RightArm;

    public PotatoGolemModel(ModelPart root) {
        this.root = root;
        this.LeftLeg = root.getChild("LeftLeg");
        this.LeftArm = root.getChild("LeftArm");
        this.Head = root.getChild("Head");
        this.RightLeg = root.getChild("RightLeg");
        this.Body = root.getChild("Body");
        this.RightArm = root.getChild("RightArm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(166, 50).addBox(0.2F, 1.0F, -3.0F, 12.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -16.0F, 0.0F, -0.0436F, 0.0F, -0.0436F));

        PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 176).addBox(3.1F, -22.0F, -3.0F, 10.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 40.0F, 0.0F));

        PartDefinition bone_r1 = LeftFoot.addOrReplaceChild("bone_r1", CubeListBuilder.create().texOffs(0, 149).addBox(5.0F, 34.0F, -11.0F, 10.0F, 6.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, -40.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(96, 167).addBox(-9.0F, -2.0F, -7.0F, 13.0F, 2.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 106).addBox(-9.0F, 10.0F, -7.0F, 16.0F, 23.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 106).addBox(-9.0F, 10.0F, -7.0F, 16.0F, 23.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.0F, -57.0F, 2.0F, 0.0436F, 0.0F, -0.0436F));

        PartDefinition LeftArm_r1 = LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(117, 67).addBox(22.0F, -81.0F, -4.0F, 13.0F, 12.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, 81.0F, -3.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition HandLeft = LeftArm.addOrReplaceChild("HandLeft", CubeListBuilder.create(), PartPose.offset(-21.0F, 36.0F, 0.0F));

        PartDefinition bone7_r1 = HandLeft.addOrReplaceChild("bone7_r1", CubeListBuilder.create().texOffs(84, 188).addBox(13.0F, 11.0F, -5.0F, 14.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(162, 153).addBox(13.0F, -5.0F, -6.0F, 14.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(106, 0).addBox(-6.0F, -8.0F, -9.0F, 16.0F, 9.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.0F, -1.0F, -98.0F, 0.0F, 0.0F, 78.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(5.0F, -7.0F, -10.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-6.0F, -7.0F, -10.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -60.0F, 0.0F));

        PartDefinition Eyes1 = Head.addOrReplaceChild("Eyes1", CubeListBuilder.create().texOffs(13, 13).addBox(7.0F, -7.0F, -11.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Eyes2 = Head.addOrReplaceChild("Eyes2", CubeListBuilder.create().texOffs(13, 13).addBox(-6.0F, -7.0F, -11.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(165, 83).addBox(-7.0F, 1.0F, -3.0F, 12.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, -16.0F, 0.0F, -0.0436F, 0.0F, 0.0436F));

        PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(48, 170).addBox(-7.9F, -22.0F, -3.0F, 10.0F, 16.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(114, 140).addBox(-7.9F, -6.0F, -10.0F, 10.0F, 6.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 40.0F, 0.0F));

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(64, 41).addBox(-7.0F, -14.0F, 10.0F, 19.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-13.0F, -13.0F, -8.0F, 31.0F, 19.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(158, 0).addBox(10.0F, -15.0F, -5.0F, 8.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(84, 0).addBox(-12.0F, -15.0F, -5.0F, 8.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(129, 201).addBox(-2.0F, -23.0F, 3.0F, 10.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(187, 0).addBox(-2.0F, -19.0F, -3.0F, 10.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, 5.0F, -5.0F, 6.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 41).addBox(-9.0F, 18.0F, -5.0F, 23.0F, 11.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -44.0F, 0.0F));

        PartDefinition Body_r1 = Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(111, 105).addBox(-13.0F, 15.0F, -4.0F, 17.0F, 19.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition Body_r2 = Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(61, 49).addBox(0.0F, 6.0F, -10.0F, 16.0F, 15.0F, 21.0F, new CubeDeformation(0.0F))
                .texOffs(2, 70).addBox(0.0F, 6.0F, -10.0F, 16.0F, 15.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition Body_r3 = Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(0, 41).addBox(1.0F, 32.0F, -6.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(68, 121).addBox(1.0F, 22.0F, -8.0F, 10.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition Body_r4 = Body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(0, 45).addBox(-2.0F, 32.0F, -6.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(82, 170).addBox(-6.0F, 22.0F, -8.0F, 9.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

        PartDefinition Body_r5 = Body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(114, 29).addBox(1.0F, 15.0F, -4.0F, 17.0F, 19.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition Body_r6 = Body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(53, 85).addBox(-11.0F, 5.0F, -10.0F, 16.0F, 15.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition Body_r7 = Body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(37, 200).addBox(12.0F, -14.0F, -3.0F, 4.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0492F, -0.0226F, -0.4333F));

        PartDefinition Body_r8 = Body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(201, 114).addBox(-10.0F, -17.0F, -3.0F, 4.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0453F, 0.0435F, 0.3107F));

        PartDefinition bone2 = Body.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, -16.0F, 0.0F));

        PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.0F, -57.0F, 3.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(52, 131).addBox(-31.0F, -27.0F, -6.0F, 15.0F, 23.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(142, 183).addBox(-28.0F, -37.0F, -6.0F, 12.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, 36.0F, 0.0F, 0.0116F, 0.0039F, 0.0855F));

        PartDefinition RightArm_r2 = RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(161, 124).addBox(-31.0F, -35.0F, -6.0F, 12.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, 36.0F, 0.0F, 0.0117F, 0.0034F, 0.1292F));

        PartDefinition HandRight = RightArm.addOrReplaceChild("HandRight", CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -47.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(27.0F, 36.0F, 0.0F));

        PartDefinition bone3_r1 = HandRight.addOrReplaceChild("bone3_r1", CubeListBuilder.create().texOffs(186, 189).addBox(-30.0F, 11.0F, -7.0F, 13.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(164, 15).addBox(-30.0F, -5.0F, -8.0F, 13.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0873F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public @NotNull ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(T entity, float f, float g, float h, float i, float j) {
        this.Head.yRot = i * 0.017453292F;
        this.Head.xRot = j * 0.017453292F;
        this.RightLeg.xRot = -1.5F * Mth.triangleWave(f, 13.0F) * g;
        this.LeftLeg.xRot = 1.5F * Mth.triangleWave(f, 13.0F) * g;
        this.RightLeg.yRot = 0.0F;
        this.LeftLeg.yRot = 0.0F;
    }

    public void prepareMobModel(T ironGolem, float f, float g, float h) {
        int i = ironGolem.getAttackAnimationTick();
        if (i > 0) {
            this.RightArm.xRot = -2.0F + 1.5F * Mth.triangleWave((float)i - h, 10.0F);
            this.LeftArm.xRot = -2.0F + 1.5F * Mth.triangleWave((float)i - h, 10.0F);
        } else {
            int j = ironGolem.getOfferFlowerTick();
            if (j > 0) {
                this.RightArm.xRot = -0.8F + 0.025F * Mth.triangleWave((float)j, 70.0F);
                this.LeftArm.xRot = 0.0F;
            } else {
                this.RightArm.xRot = (-0.2F + 1.5F * Mth.triangleWave(f, 13.0F)) * g;
                this.LeftArm.xRot = (-0.2F - 1.5F * Mth.triangleWave(f, 13.0F)) * g;
            }
        }

    }
}
