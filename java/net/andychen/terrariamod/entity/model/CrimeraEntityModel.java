package net.andychen.terrariamod.entity.model;

import net.andychen.terrariamod.entity.mob.CrimeraEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class CrimeraEntityModel<T extends CrimeraEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tailEnd;
    private final ModelPart leftMouth;
    private final ModelPart rightMouth;
    private final ModelPart leftMandible1;
    private final ModelPart leftMandible2;
    private final ModelPart leftMandible3;
    private final ModelPart rightMandible1;
    private final ModelPart rightMandible2;
    private final ModelPart rightMandible3;
    private final ModelPart leftFlange1;
    private final ModelPart leftFlange2;
    private final ModelPart leftFlange3;
    private final ModelPart leftFlange4;
    private final ModelPart leftFlange5;
    private final ModelPart rightFlange1;
    private final ModelPart rightFlange2;
    private final ModelPart rightFlange3;
    private final ModelPart rightFlange4;
    private final ModelPart rightFlange5;
    private final ModelPart tail_flap_1;
    private final ModelPart tail_flap_2;
    private final ModelPart tail_flap_3;

    public CrimeraEntityModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
        this.tail1 = this.body.getChild("tail_1");
        this.tail2 = this.tail1.getChild("tail_2");
        this.tail3 = this.tail2.getChild("tail_3");
        this.tailEnd = this.tail3.getChild("tail_end");
        this.tail_flap_1 = this.tailEnd.getChild("tail_flap_1");
        this.tail_flap_2 = this.tailEnd.getChild("tail_flap_2");
        this.tail_flap_3 = this.tailEnd.getChild("tail_flap_3");
        this.leftMouth = this.body.getChild("left_mouth");
        this.rightMouth = this.body.getChild("right_mouth");
        this.leftMandible1 = this.body.getChild("left_mandible_1");
        this.leftMandible2 = this.leftMandible1.getChild("left_mandible_2");
        this.leftMandible3 = this.leftMandible2.getChild("left_mandible_3");
        this.rightMandible1 = this.body.getChild("right_mandible_1");
        this.rightMandible2 = this.rightMandible1.getChild("right_mandible_2");
        this.rightMandible3 = this.rightMandible2.getChild("right_mandible_3");
        this.leftFlange1 = this.tail1.getChild("left_flange_1");
        this.leftFlange2 = this.tail2.getChild("left_flange_2");
        this.leftFlange3 = this.tail3.getChild("left_flange_3");
        this.leftFlange4 = this.tailEnd.getChild("left_flange_4");
        this.leftFlange5 = this.tailEnd.getChild("left_flange_5");
        this.rightFlange1 = this.tail1.getChild("right_flange_1");
        this.rightFlange2 = this.tail2.getChild("right_flange_2");
        this.rightFlange3 = this.tail3.getChild("right_flange_3");
        this.rightFlange4 = this.tailEnd.getChild("right_flange_4");
        this.rightFlange5 = this.tailEnd.getChild("right_flange_5");
        setRotationAngle(leftMouth, 0.0F, -0.7854F, 0.0F);
        setRotationAngle(rightMouth, 0.0F, 0.7854F, 0.0F);
        setRotationAngle(leftMandible2, 0.0F, -0.3927F, 0.0F);
        setRotationAngle(leftMandible3, 0.0F, 1.2021F, 0.0F);
        setRotationAngle(rightMandible2, 0.0F, 0.3927F, 0.0F);
        setRotationAngle(rightMandible3, 0.0F, -1.2021F, 0.0F);
        setRotationAngle(rightFlange1, 0.0F, 0.3927F, 0.0F);
        setRotationAngle(rightFlange2, 0.0F, 0.3927F, 0.0F);
        setRotationAngle(rightFlange3, 0.0F, 0.3927F, 0.0F);
        setRotationAngle(rightFlange4, 0.0F, 0.3927F, 0.0F);
        setRotationAngle(rightFlange5, 0.0F, 0.7854F, 0.0F);
        setRotationAngle(leftFlange1, 0.0F, -0.3927F, 0.0F);
        setRotationAngle(leftFlange2, 0.0F, -0.3927F, 0.0F);
        setRotationAngle(leftFlange3, 0.0F, -0.3927F, 0.0F);
        setRotationAngle(leftFlange4, 0.0F, -0.3927F, 0.0F);
        setRotationAngle(leftFlange5, 0.0F, -0.7854F, 0.0F);
        setRotationAngle(tail_flap_1, 0.0F, 1.5708F, 0.0F);
        setRotationAngle(tail_flap_2, 0.0F, 1.5708F, 0.0F);
        setRotationAngle(tail_flap_3, 0.0F, 1.5708F, 0.0F);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-5.5F, 18.0F, -4.0F, 11.0F, 5.0F, 7.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData modelPartData3 = modelPartData2.addChild("tail_1", ModelPartBuilder.create().uv(0, 12).cuboid(-4.5F, 18.5F, 0.0F, 9.0F, 4.0F, 3.0F), ModelTransform.pivot(0.0F, 0.0F, 3.0F));
        ModelPartData modelPartData4 = modelPartData3.addChild("tail_2", ModelPartBuilder.create().uv(0, 19).cuboid(-3.5F, 19.0F, -3.0F, 7.0F, 3.0F, 2.0F), ModelTransform.pivot(0.0F, 0.0F, 6.0F));
        ModelPartData modelPartData5 = modelPartData4.addChild("tail_3", ModelPartBuilder.create().uv(0, 24).cuboid(-2.5F, 19.5F, -9.0F, 5.0F, 2.0F, 5.0F), ModelTransform.pivot(0.0F, 0.0F, 8.0F));
        ModelPartData modelPartData6 = modelPartData5.addChild("tail_end", ModelPartBuilder.create().uv(0, 31).cuboid(-1.5F, 20.0F, -17.0F, 3.0F, 1.0F, 5.0F), ModelTransform.pivot(0.0F, 0.0F, 13.0F));
        modelPartData6.addChild("tail_flap_1", ModelPartBuilder.create().uv(40, 10).cuboid(5.0F, 27.5F, -1.5F, 3.0F, 0.01F, 1.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));
        modelPartData6.addChild("tail_flap_2", ModelPartBuilder.create().uv(40, 10).cuboid(5.0F, 27.5F, 0.5F, 3.0F, 0.01F, 1.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));
        modelPartData6.addChild("tail_flap_3", ModelPartBuilder.create().uv(38, 8).cuboid(6.0F, 27.5F, -0.5F, 4.0F, 0.01F, 1.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));

        modelPartData2.addChild("left_mouth", ModelPartBuilder.create().uv(24, 12).mirrored().cuboid(-6.5931F, 18.99F, -3.6642F, 2.0F, 3.0F, 4.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData2.addChild("right_mouth", ModelPartBuilder.create().uv(24, 12).cuboid(4.5931F, 18.99F, -3.6642F, 2.0F, 3.0F, 4.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData modelPartData7 = modelPartData2.addChild("left_mandible_1", ModelPartBuilder.create().mirrored().uv(0, 37).cuboid(-7.0F, 19.0F, -6.0F, 3.0F, 3.0F, 5.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData modelPartData8 = modelPartData7.addChild("left_mandible_2", ModelPartBuilder.create().mirrored().uv(0, 45).cuboid(-7.95F, 20.0F, -7.75F, 2.0F, 1.0F, 5.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData8.addChild("left_mandible_3", ModelPartBuilder.create().mirrored().uv(14, 47).cuboid(2.225F, 26.99F, -10.625F, 1.0F, 1.0F, 3.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));

        ModelPartData modelPartData9 = modelPartData2.addChild("right_mandible_1", ModelPartBuilder.create().uv(0, 37).cuboid(3.9F, 19.0F, -6.0F, 3.0F, 3.0F, 5.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData modelPartData10 = modelPartData9.addChild("right_mandible_2", ModelPartBuilder.create().uv(0, 45).cuboid(6.0F, 20.0F, -7.5F, 2.0F, 1.0F, 5.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData10.addChild("right_mandible_3", ModelPartBuilder.create().uv(14, 47).cuboid(-2.975F, 26.99F, -10.58F, 1.0F, 1.0F, 3.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));

        modelPartData3.addChild("left_flange_1", ModelPartBuilder.create().mirrored().uv(36, 3).cuboid(4.5F, 28.0F, -1.0F, 4.0F, 0.01F, 2.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));
        modelPartData4.addChild("left_flange_2", ModelPartBuilder.create().mirrored().uv(38, 0).cuboid(2.5F, 28.0F, -3.0F, 3.0F, 0.01F, 2.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));
        modelPartData5.addChild("left_flange_3", ModelPartBuilder.create().mirrored().uv(0, 0).cuboid(-0.5F, 28.0F, -8.0F, 2.0F, 0.01F, 1.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));
        modelPartData6.addChild("left_flange_4", ModelPartBuilder.create().mirrored().uv(0, 0).cuboid(-4.5F, 28.0F, -15.0F, 2.0F, 0.01F, 1.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));
        modelPartData6.addChild("left_flange_5", ModelPartBuilder.create().mirrored().uv(40, 6).cuboid(-7.5F, 28.0F, -9.0F, 3.0F, 0.01F, 1.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));

        modelPartData3.addChild("right_flange_1", ModelPartBuilder.create().uv(36, 3).cuboid(-8.5F, 28.0F, -1.0F, 4.0F, 0.01F, 2.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));
        modelPartData4.addChild("right_flange_2", ModelPartBuilder.create().uv(38, 0).cuboid(-5.5F, 28.0F, -3.0F, 3.0F, 0.01F, 2.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));
        modelPartData5.addChild("right_flange_3", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, 28.0F, -8.0F, 2.0F, 0.01F, 1.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));
        modelPartData6.addChild("right_flange_4", ModelPartBuilder.create().uv(0, 0).cuboid(2.5F, 28.0F, -15.0F, 2.0F, 0.01F, 1.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));
        modelPartData6.addChild("right_flange_5", ModelPartBuilder.create().uv(40, 6).cuboid(4.5F, 28.0F, -9.0F, 3.0F, 0.01F, 1.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));
        return TexturedModelData.of(modelData, 48, 64);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }

    @Override
    public void setAngles(T entity, float f, float g, float h, float i, float j) {
        this.body.pitch = 0F;
        float k = 1.0F;
        this.body.yaw = i * 0.007453292F;
        this.body.pitch = j * 0.007453292F;
        this.leftMandible1.yaw = MathHelper.cos(f * 0.6662F) * 0.2F * g / k;
        this.rightMandible1.yaw = MathHelper.cos(f * -0.6662F) * -0.2F * g / k;
    }

    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }
}
