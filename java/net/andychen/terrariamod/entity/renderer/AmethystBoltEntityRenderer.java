package net.andychen.terrariamod.entity.renderer;

import net.andychen.terrariamod.TerrariaClientMod;
import net.andychen.terrariamod.TerrariaMod;
import net.andychen.terrariamod.entity.model.StaffProjectileEntityModel;
import net.andychen.terrariamod.entity.projectile.AmethystBoltEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

public class AmethystBoltEntityRenderer extends EntityRenderer<AmethystBoltEntity> {
    private static final Identifier TEXTURE = new Identifier(TerrariaMod.MOD_ID, "textures/entity/projectile/staff_projectile.png");
    private final StaffProjectileEntityModel<AmethystBoltEntity> model;

    public AmethystBoltEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new StaffProjectileEntityModel(context.getPart(TerrariaClientMod.MODEL_AMETHYST_BOLT_LAYER));
    }

    public void render(AmethystBoltEntity staffProjectileEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.translate(0.0D, 0.15000000596046448D, 0.0D);
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, staffProjectileEntity.prevYaw, staffProjectileEntity.getYaw()) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, staffProjectileEntity.prevPitch, staffProjectileEntity.getPitch())));
        this.model.setAngles(staffProjectileEntity, g, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(TEXTURE));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(staffProjectileEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public Identifier getTexture(AmethystBoltEntity staffProjectileEntity) {
        return TEXTURE;
    }
}

