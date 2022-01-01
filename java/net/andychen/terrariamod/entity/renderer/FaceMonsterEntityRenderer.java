package net.andychen.terrariamod.entity.renderer;

import net.andychen.terrariamod.TerrariaClientMod;
import net.andychen.terrariamod.TerrariaMod;
import net.andychen.terrariamod.entity.mob.FaceMonsterEntity;
import net.andychen.terrariamod.entity.model.FaceMonsterEntityModel;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.Identifier;

public class FaceMonsterEntityRenderer extends MobEntityRenderer<FaceMonsterEntity, EntityModel<FaceMonsterEntity>> {

    public FaceMonsterEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new FaceMonsterEntityModel(context.getPart(TerrariaClientMod.MODEL_FACE_MONSTER_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(FaceMonsterEntity entity) {
        return new Identifier(TerrariaMod.MOD_ID, "textures/entity/face_monster.png");
    }
}
