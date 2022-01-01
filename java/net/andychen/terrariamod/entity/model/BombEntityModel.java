package net.andychen.terrariamod.entity.model;

import com.ibm.icu.text.Normalizer2;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class BombEntityModel<T extends Entity> extends SinglePartEntityModel<T> {
    private final ModelPart root;
    private final ModelPart base;

    public BombEntityModel(ModelPart root) {
        this.root = root;
        this.base = root.getChild("base");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("base", ModelPartBuilder.create().uv(0, 0)
                .cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F)
                .cuboid(-0.5F, -6.0F, -0.5F, 1.0F, 3.0F, 1.0F), ModelTransform.pivot(0.0F, 1.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        float k = 1.0F;
        this.base.pitch = 3.15F + MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance / k;;
    }

    public ModelPart getPart() {
        return this.root;
    }
}

