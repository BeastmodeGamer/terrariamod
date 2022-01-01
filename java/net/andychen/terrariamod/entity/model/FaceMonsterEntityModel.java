package net.andychen.terrariamod.entity.model;

import net.andychen.terrariamod.entity.mob.FaceMonsterEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class FaceMonsterEntityModel<T extends FaceMonsterEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart upperBody;
    private final ModelPart mouth;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;

    public FaceMonsterEntityModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
        this.mouth = this.head.getChild("mouth");
        this.body = root.getChild("body");
        this.upperBody = this.body.getChild("upper_body");
        this.rightArm = root.getChild("right_arm");
        this.leftArm = root.getChild("left_arm");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
        setRotationAngle(mouth, -0.2182F, 0.0F, 0.0F);
        //setRotationAngle(rightArm, -1.5708F, 0.0F, 0.0F);
        //setRotationAngle(leftArm, -1.5708F, 0.0F, 0.0F);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(1.0F)), ModelTransform.pivot(0.0F, -4.0F, 0.0F));
        modelPartData2.addChild("mouth", ModelPartBuilder.create().uv(0, 34).cuboid(-5.0F, 7.0F, -1.5F, 10.0F, 13.0F, 5.0F), ModelTransform.pivot(0.0F, -7.0F, -2.0F));
        ModelPartData modelPartData3 = modelPartData.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 3.0F, -2.0F, 8.0F, 14.0F, 4.0F), ModelTransform.pivot(0.0F, -7.0F, 0.0F));
        modelPartData3.addChild("upper_body", ModelPartBuilder.create().uv(30, 34).cuboid(-5.0F, 10.0F, -2.0F, 10.0F, 10.0F, 5.0F), ModelTransform.pivot(0.0F, -7.0F, 0.0F));
        modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(40,16).cuboid(-9.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F), ModelTransform.pivot(0.0F, -2.0F, 0.0F));
        modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(40,16).mirrored().cuboid(5.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F), ModelTransform.pivot(0.0F, -2.0F, 0.0F));
        modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.1F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));
        modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-1.9F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F), ModelTransform.pivot(1.9F, 12.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(T hostileEntity, float f, float g, float h, float i, float j) {
        CrossbowPosing.meleeAttack(this.leftArm, this.rightArm, this.isAttacking(hostileEntity), this.handSwingProgress, h);
        this.head.yaw = i * 0.017453292F;
        this.head.pitch = j * 0.017453292F;
        float k = 1.0F;
        this.rightLeg.pitch = MathHelper.cos(f * 0.6662F) * 1.4F * g / k;
        this.leftLeg.pitch = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * g / k;
        this.rightLeg.yaw = 0.0F;
        this.leftLeg.yaw = 0.0F;

        this.rightArm.pitch = MathHelper.cos(f * 0.6662F + 3.1415927F) * 2.0F * g * 0.5F / k;
        this.leftArm.pitch = MathHelper.cos(f * 0.6662F) * 2.0F * g * 0.5F / k;
        if (this.isAttacking(hostileEntity)) {
            this.rightArm.pitch = -1.5F;
            this.leftArm.pitch = -1.5F;
        }
    }

    protected void animateArms(T entity, float animationProgress) {
        if (!(this.handSwingProgress <= 0.0F)) {
            Arm arm = this.getPreferredArm(entity);
            ModelPart modelPart = this.getArm(arm);
            float f = this.handSwingProgress;
            this.body.yaw = MathHelper.sin(MathHelper.sqrt(f) * 6.2831855F) * 0.2F;
            ModelPart var10000;
            if (arm == Arm.LEFT) {
                var10000 = this.body;
                var10000.yaw *= -1.0F;
            }

            this.rightArm.pivotZ = MathHelper.sin(this.body.yaw) * 5.0F;
            this.rightArm.pivotX = -MathHelper.cos(this.body.yaw) * 5.0F;
            this.leftArm.pivotZ = -MathHelper.sin(this.body.yaw) * 5.0F;
            this.leftArm.pivotX = MathHelper.cos(this.body.yaw) * 5.0F;
            var10000 = this.rightArm;
            var10000.yaw += this.body.yaw;
            var10000 = this.leftArm;
            var10000.yaw += this.body.yaw;
            var10000 = this.leftArm;
            var10000.pitch += this.body.yaw;
            f = 1.0F - this.handSwingProgress;
            f *= f;
            f *= f;
            f = 1.0F - f;
            float g = MathHelper.sin(f * 3.1415927F);
            float h = MathHelper.sin(this.handSwingProgress * 3.1415927F) * -(this.head.pitch - 0.7F) * 0.75F;
            modelPart.pitch = (float)((double)modelPart.pitch - ((double)g * 1.2D + (double)h));
            modelPart.yaw += this.body.yaw * 2.0F;
            modelPart.roll += MathHelper.sin(this.handSwingProgress * 3.1415927F) * -0.4F;
        }
    }

    protected ModelPart getArm(Arm arm) {
        return arm == Arm.LEFT ? this.leftArm : this.rightArm;
    }

    private Arm getPreferredArm(T entity) {
        Arm arm = entity.getMainArm();
        return entity.preferredHand == Hand.MAIN_HAND ? arm : arm.getOpposite();
    }

    public boolean isAttacking(T hostileEntity) {
        return hostileEntity.isAttacking();
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }

    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }
}
