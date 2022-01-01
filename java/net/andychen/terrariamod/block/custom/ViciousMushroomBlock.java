package net.andychen.terrariamod.block.custom;

import net.andychen.terrariamod.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ViciousMushroomBlock extends PlantBlock {
    protected static final float field_31080 = 3.0F;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 11.0D, 12.0D);


    public ViciousMushroomBlock(Settings settings) {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.GRASS_BLOCK) || floor.isIn(BlockTags.DIRT) || floor.isOf(ModBlocks.CRIMSAND) || floor.isOf(ModBlocks.CRIMSTONE);
    }
}
