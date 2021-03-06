package com.github.ustc_zzzz.fmltutor.worldgen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGeneratorGlowstone implements IWorldGenerator
{
    public final WorldGenMinable glowstoneGenerator = new WorldGenMinable(Blocks.glowstone.getDefaultState(), 16);

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
            IChunkProvider chunkProvider)
    {
        if (world.provider.getDimensionId() != 0)
        {
            return;
        }
        for (int i = 0; i < 4; ++i)
        {
            int posX = chunkX * 16 + random.nextInt(16);
            int posY = 16 + random.nextInt(16);
            int posZ = chunkZ * 16 + random.nextInt(16);
            BlockPos blockpos = new BlockPos(posX, posY, posZ);
            BiomeGenBase biomeGenBase = world.getBiomeGenForCoords(blockpos);
            if (biomeGenBase.getIntRainfall() < random.nextInt(65536))
            {
                glowstoneGenerator.generate(world, random, blockpos);
            }
        }
    }
}
