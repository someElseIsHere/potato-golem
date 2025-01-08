package org.theplaceholder.potatogolem.client.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.theplaceholder.potatogolem.entity.PotatoGolemEntity;

import static org.theplaceholder.potatogolem.PotatoGolemMod.LOCATION;

public class PotatoGolemModel<T extends PotatoGolemEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(LOCATION, "main");
    private final ModelPart root;
    private final ModelPart leftLeg;
    private final ModelPart leftArm;
    private final ModelPart head;
    private final ModelPart rightLeg;
    private final ModelPart body;
    private final ModelPart rightArm;

    public PotatoGolemModel(ModelPart root) {
        this.root = root;
        this.leftLeg = root.getChild("leftLeg");
        this.leftArm = root.getChild("leftArm");
        this.head = root.getChild("head");
        this.rightLeg = root.getChild("rightLeg");
        this.body = root.getChild("body");
        this.rightArm = root.getChild("rightArm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition leftLeg = partdefinition
                .addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(166, 50)
                .addBox(0.2F, 1.0F, -3.0F, 12.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -16.0F, 0.0F, -0.0436F, 0.0F, -0.0436F));
        PartDefinition leftFoot = leftLeg
                .addOrReplaceChild("leftFoot", CubeListBuilder.create().texOffs(0, 176).addBox(3.1F, -22.0F, -3.0F, 10.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 40.0F, 0.0F));
        leftFoot.addOrReplaceChild("leftFoot0", CubeListBuilder.create().texOffs(0, 149).addBox(5.0F, 34.0F, -11.0F, 10.0F, 6.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, -40.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(96, 167).addBox(-9.0F, -2.0F, -7.0F, 13.0F, 2.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 106).addBox(-9.0F, 10.0F, -7.0F, 16.0F, 23.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 106).addBox(-9.0F, 10.0F, -7.0F, 16.0F, 23.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.0F, -57.0F, 2.0F, 0.0436F, 0.0F, -0.0436F));
         leftArm.addOrReplaceChild("leftArm0", CubeListBuilder.create().texOffs(117, 67).addBox(22.0F, -81.0F, -4.0F, 13.0F, 12.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, 81.0F, -3.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition handLeft = leftArm.addOrReplaceChild("handLeft", CubeListBuilder.create(), PartPose.offset(-21.0F, 36.0F, 0.0F));
        handLeft.addOrReplaceChild("handLeft0", CubeListBuilder.create().texOffs(84, 188).addBox(13.0F, 11.0F, -5.0F, 14.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(162, 153).addBox(13.0F, -5.0F, -6.0F, 14.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(106, 0).addBox(-6.0F, -8.0F, -9.0F, 16.0F, 9.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.0F, -1.0F, -98.0F, 0.0F, 0.0F, 78.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(5.0F, -7.0F, -10.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-6.0F, -7.0F, -10.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -60.0F, 0.0F));

        head.addOrReplaceChild("eye0", CubeListBuilder.create().texOffs(13, 13).addBox(7.0F, -7.0F, -11.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        head.addOrReplaceChild("eye1", CubeListBuilder.create().texOffs(13, 13).addBox(-6.0F, -7.0F, -11.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(165, 83).addBox(-7.0F, 1.0F, -3.0F, 12.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, -16.0F, 0.0F, -0.0436F, 0.0F, 0.0436F));
        rightLeg.addOrReplaceChild("rightFoot", CubeListBuilder.create().texOffs(48, 170).addBox(-7.9F, -22.0F, -3.0F, 10.0F, 16.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(114, 140).addBox(-7.9F, -6.0F, -10.0F, 10.0F, 6.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 40.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(64, 41).addBox(-7.0F, -14.0F, 10.0F, 19.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-13.0F, -13.0F, -8.0F, 31.0F, 19.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(158, 0).addBox(10.0F, -15.0F, -5.0F, 8.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(84, 0).addBox(-12.0F, -15.0F, -5.0F, 8.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(129, 201).addBox(-2.0F, -23.0F, 3.0F, 10.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(187, 0).addBox(-2.0F, -19.0F, -3.0F, 10.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, 5.0F, -5.0F, 6.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 41).addBox(-9.0F, 18.0F, -5.0F, 23.0F, 11.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -44.0F, 0.0F));

        body.addOrReplaceChild("body0", CubeListBuilder.create().texOffs(111, 105).addBox(-13.0F, 15.0F, -4.0F, 17.0F, 19.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, -0.1309F));
        body.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(61, 49).addBox(0.0F, 6.0F, -10.0F, 16.0F, 15.0F, 21.0F, new CubeDeformation(0.0F))
                .texOffs(2, 70).addBox(0.0F, 6.0F, -10.0F, 16.0F, 15.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 41).addBox(1.0F, 32.0F, -6.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(68, 121).addBox(1.0F, 22.0F, -8.0F, 10.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

        body.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(0, 45).addBox(-2.0F, 32.0F, -6.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(82, 170).addBox(-6.0F, 22.0F, -8.0F, 9.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

        body.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(114, 29).addBox(1.0F, 15.0F, -4.0F, 17.0F, 19.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.1309F));
        body.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(53, 85).addBox(-11.0F, 5.0F, -10.0F, 16.0F, 15.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
        body.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(37, 200).addBox(12.0F, -14.0F, -3.0F, 4.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0492F, -0.0226F, -0.4333F));
        body.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(201, 114).addBox(-10.0F, -17.0F, -3.0F, 4.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0453F, 0.0435F, 0.3107F));
        body.addOrReplaceChild("body8", CubeListBuilder.create(), PartPose.offset(0.0F, -16.0F, 0.0F));

        PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.0F, -57.0F, 3.0F, 0.0873F, 0.0F, 0.0F));
        rightArm.addOrReplaceChild("rightArm0", CubeListBuilder.create().texOffs(52, 131).addBox(-31.0F, -27.0F, -6.0F, 15.0F, 23.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(142, 183).addBox(-28.0F, -37.0F, -6.0F, 12.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, 36.0F, 0.0F, 0.0116F, 0.0039F, 0.0855F));
        rightArm.addOrReplaceChild("rightArm1", CubeListBuilder.create().texOffs(161, 124).addBox(-31.0F, -35.0F, -6.0F, 12.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, 36.0F, 0.0F, 0.0117F, 0.0034F, 0.1292F));

        PartDefinition handRight = rightArm.addOrReplaceChild("handRight", CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -47.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(27.0F, 36.0F, 0.0F));

        handRight.addOrReplaceChild("bone3_r1", CubeListBuilder.create().texOffs(186, 189).addBox(-30.0F, 11.0F, -7.0F, 13.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(164, 15).addBox(-30.0F, -5.0F, -8.0F, 13.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0873F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public @NotNull ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(T entity, float f, float g, float h, float i, float j) {
        this.head.yRot = i * 0.017453292F;
        this.head.xRot = j * 0.017453292F;
        this.rightLeg.xRot = -1.5F * Mth.triangleWave(f, 13.0F) * g;
        this.leftLeg.xRot = 1.5F * Mth.triangleWave(f, 13.0F) * g;
        this.rightLeg.yRot = 0.0F;
        this.leftLeg.yRot = 0.0F;
    }

    public void prepareMobModel(T ironGolem, float f, float g, float h) {
        int i = ironGolem.getAttackAnimationTick();
        if (i > 0) {
            this.rightArm.xRot = -2.0F + 1.5F * Mth.triangleWave((float)i - h, 10.0F);
            this.leftArm.xRot = -2.0F + 1.5F * Mth.triangleWave((float)i - h, 10.0F);
        } else {
            int j = ironGolem.getOfferFlowerTick();
            if (j > 0) {
                this.rightArm.xRot = -0.8F + 0.025F * Mth.triangleWave((float)j, 70.0F);
                this.leftArm.xRot = 0.0F;
            } else {
                this.rightArm.xRot = (-0.2F + 1.5F * Mth.triangleWave(f, 13.0F)) * g;
                this.leftArm.xRot = (-0.2F - 1.5F * Mth.triangleWave(f, 13.0F)) * g;
            }
        }

    }
}
