package net.andychen.terrariamod.entity.renderer;

import net.andychen.terrariamod.TerrariaClientMod;
import net.andychen.terrariamod.TerrariaMod;
import net.andychen.terrariamod.entity.mob.CrimeraEntity;
import net.andychen.terrariamod.entity.model.CrimeraEntityModel;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.Identifier;

public class CrimeraEntityRenderer extends MobEntityRenderer<CrimeraEntity, EntityModel<CrimeraEntity>> {

    public CrimeraEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CrimeraEntityModel(context.getPart(TerrariaClientMod.MODEL_CRIMERA_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(CrimeraEntity entity) {
        return new Identifier(TerrariaMod.MOD_ID, "textures/entity/crimera.png");
    }
}
