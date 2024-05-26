package prospector.traverse.world.biomes;

import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import prospector.traverse.world.WorldGenConstants;
import prospector.traverse.world.features.WorldGenFirTree;

import java.util.Random;

public class BiomeConiferousForest extends Biome implements WorldGenConstants {

    protected static final WorldGenFirTree FIR_TREE_FEATURE = new WorldGenFirTree(true);

    public final boolean isSnowy;

    public BiomeConiferousForest(boolean isSnowy) {
        super(getProperties(isSnowy));
        this.isSnowy = isSnowy;
        this.decorator.treesPerChunk = 7;
        this.decorator.grassPerChunk = 9;
        this.decorator.mushroomsPerChunk = 2;

        this.spawnableCreatureList.add(new SpawnListEntry(net.minecraft.entity.passive.EntityWolf.class, 5, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityRabbit.class, 3, 2, 3));
    }

    public static BiomeProperties getProperties(boolean isSnowy) {
        BiomeProperties properties;
        if (isSnowy) {
            properties = new BiomeProperties("Snowy Coniferous Forest");
            properties.setTemperature(-0.25F);
            properties.setRainfall(0.5F);
            properties.setSnowEnabled();
        } else {
            properties = new BiomeProperties("Coniferous Forest");
            properties.setTemperature(0.45F);
            properties.setRainfall(0.5F);
        }

        properties.setBaseHeight(0.3F);
        properties.setHeightVariation(0.2F);
        return properties;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return FIR_TREE_FEATURE;
    }

    @Override
    public int getModdedBiomeGrassColor(int original) {
        return super.getModdedBiomeGrassColor(0x528F60);
    }

    @Override
    public int getModdedBiomeFoliageColor(int original) {
        return super.getModdedBiomeFoliageColor(0x528F60);
    }
}
