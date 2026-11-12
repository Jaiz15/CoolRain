package jaiz.coolrain.config;

import eu.midnightdust.lib.config.MidnightConfig;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import java.util.ArrayList;
import java.util.List;

public class CoolRainConfig extends MidnightConfig {
    public static final String GENERAL = "general";
    
    private static List<Identifier> toIdHelper(List<Block> blocks) {
        ArrayList<Identifier> output = new ArrayList<>();
        for (Block b : blocks) {
            output.add(BuiltInRegistries.BLOCK.getKey(b));    
        }
        return output;
    }

    private static void addCopperFamily(List<Block> blocks, WeatheringCopperCollection<Block> family) {
        family.weathering().forEach(blocks::add);
        family.waxed().forEach(blocks::add);
    }

    private static List<Identifier> createFabricBlocks() {
        List<Block> blocks = new ArrayList<>(Blocks.WOOL.asList());
        
        // Wool Stairs
        blocks.addAll(Blocks.WOOL_STAIRS.asList());
    
        // Wool Slabs
        blocks.addAll(Blocks.WOOL_SLAB.asList());
    
        // Carpets
        blocks.addAll(Blocks.CARPET.asList());
    
        // Beds
        blocks.addAll(Blocks.BED.asList());
        
        return toIdHelper(blocks);
    }

    @Entry(category = GENERAL, name="Thunderstorm Winds")
    public static boolean thunderstormWinds = true;

    @Entry(category = GENERAL, name="Additional Thunder Sounds")
    public static boolean additionalThunderSounds = true;

    @Entry(category = GENERAL, name="Rain Sounds On Metal Blocks")
    public static boolean metalSounds = true;
    @Entry(category = GENERAL, name="Rain Sounds On Fabric Blocks")
    public static boolean fabricSounds = true;
    @Entry(category = GENERAL, name="Rain Sounds On Glass Blocks")
    public static boolean glassSounds = true;
    @Entry(category = GENERAL, name="Rain Sounds On Foliage Blocks")
    public static boolean foliageSounds = true;
    @Entry(category = GENERAL, name="Rain Sounds On Water Blocks")
    public static boolean waterSounds = true;
    @Entry(category = GENERAL, name="Rain Sounds On Evaporative Blocks")
    public static boolean evaporativeSounds = true;
    @Entry(category = GENERAL, name="Rain Sounds On Crystal Blocks")
    public static boolean crystalSounds = true;
    @Entry(category = GENERAL, name="Rain Sounds On Musical Blocks")
    public static boolean musicalSounds = true;
    @Entry(category = GENERAL, name="Rain Sounds On Bell Blocks")
    public static boolean bellSounds = true;

    @Entry(category = GENERAL, idMode = 1, name = "Metal Blocks")
    public static List<Identifier> METAL_BLOCKS = createMetalBlocks();
    
    private static List<Identifier> createMetalBlocks() {
        List<Block> blocks = new ArrayList<>();
    
        addCopperFamily(blocks, Blocks.COPPER_BLOCK);
        addCopperFamily(blocks, Blocks.COPPER_BULB);
        addCopperFamily(blocks, Blocks.COPPER_GRATE);
        addCopperFamily(blocks, Blocks.CHISELED_COPPER);
        addCopperFamily(blocks, Blocks.CUT_COPPER);
        addCopperFamily(blocks, Blocks.CUT_COPPER_STAIRS);
        addCopperFamily(blocks, Blocks.CUT_COPPER_SLAB);
        addCopperFamily(blocks, Blocks.COPPER_TRAPDOOR);
    
        blocks.addAll(List.of(
                Blocks.LANTERN, Blocks.SOUL_LANTERN, Blocks.IRON_TRAPDOOR, Blocks.IRON_CHAIN,
                Blocks.NETHERITE_BLOCK, Blocks.IRON_BLOCK, Blocks.RAW_IRON_BLOCK,
                Blocks.RAW_COPPER_BLOCK, Blocks.RAW_GOLD_BLOCK,
                Blocks.CRACKED_DEEPSLATE_TILES, Blocks.DEEPSLATE_TILE_SLAB,
                Blocks.DEEPSLATE_TILES, Blocks.DEEPSLATE_TILE_STAIRS,
                Blocks.GOLD_BLOCK, Blocks.CAULDRON, Blocks.ANVIL,
                Blocks.CHIPPED_ANVIL, Blocks.DAMAGED_ANVIL, Blocks.SMITHING_TABLE,
                Blocks.ANCIENT_DEBRIS, Blocks.GILDED_BLACKSTONE,
                Blocks.TRIAL_SPAWNER, Blocks.VAULT, Blocks.SPAWNER, Blocks.HOPPER
        ));
    
        return toIdHelper(blocks);
    }

    @Entry(category = GENERAL, idMode = 1, name = "Fabric Blocks")
    public static List<Identifier> FABRIC_BLOCKS = createFabricBlocks();

    @Entry(category = GENERAL, idMode = 1, name = "Foliage Blocks") public static List<Identifier> FOLIAGE_BLOCKS = toIdHelper(
            List.of(
                    Blocks.OAK_LEAVES,
                    Blocks.SPRUCE_LEAVES,
                    Blocks.BIRCH_LEAVES,
                    Blocks.JUNGLE_LEAVES,
                    Blocks.ACACIA_LEAVES,
                    Blocks.DARK_OAK_LEAVES,
                    Blocks.MANGROVE_LEAVES,
                    Blocks.CHERRY_LEAVES,
                    Blocks.AZALEA_LEAVES,
                    Blocks.FLOWERING_AZALEA_LEAVES
            )
    );

    @Entry(category = GENERAL, idMode = 1, name = "Water Blocks") public static List<Identifier> WATER_BLOCKS = toIdHelper(
            List.of(
                    Blocks.WATER,
                    Blocks.WATER_CAULDRON
            )
    );

    @Entry(category = GENERAL, idMode = 1, name = "Glass Blocks") public static List<Identifier> GLASS_BLOCKS = toIdHelper(
            List.of(
                    Blocks.GLASS, Blocks.TINTED_GLASS, Blocks.ICE, Blocks.BLUE_ICE, Blocks.PACKED_ICE, Blocks.LIGHT_GRAY_STAINED_GLASS,
                    Blocks.GREEN_STAINED_GLASS, Blocks.BROWN_STAINED_GLASS, Blocks.BLUE_STAINED_GLASS, Blocks.RED_STAINED_GLASS, Blocks.PINK_STAINED_GLASS,
                    Blocks.MAGENTA_STAINED_GLASS, Blocks.YELLOW_STAINED_GLASS, Blocks.GRAY_STAINED_GLASS, Blocks.BLACK_STAINED_GLASS, Blocks.WHITE_STAINED_GLASS,
                    Blocks.LIME_STAINED_GLASS, Blocks.PURPLE_STAINED_GLASS, Blocks.LIGHT_BLUE_STAINED_GLASS, Blocks.ORANGE_STAINED_GLASS,
                    Blocks.CYAN_STAINED_GLASS, Blocks.REDSTONE_LAMP, Blocks.DAYLIGHT_DETECTOR, Blocks.BEACON

            )
    );

    @Entry(category = GENERAL, idMode = 1, name = "Crystal Blocks") public static List<Identifier> CRYSTAL_BLOCKS = toIdHelper(
            List.of(
                    Blocks.AMETHYST_BLOCK,
                    Blocks.BUDDING_AMETHYST,
                    Blocks.AMETHYST_CLUSTER,
                    Blocks.SMALL_AMETHYST_BUD,
                    Blocks.MEDIUM_AMETHYST_BUD,
                    Blocks.LARGE_AMETHYST_BUD
            )
    );

    @Entry(category = GENERAL, idMode = 1, name = "Musical Blocks") public static List<Identifier> MUSICAL_BLOCKS = toIdHelper(
            List.of(
                    Blocks.NOTE_BLOCK
            )
    );

    @Entry(category = GENERAL, idMode = 1, name = "Bell Blocks") public static List<Identifier> BELL_BLOCKS = toIdHelper(
            List.of(
                    Blocks.BELL
            )
    );

    @Entry(category = GENERAL, idMode = 1, name = "Evaporative Blocks") public static List<Identifier> EVAPORATIVE_BLOCKS = toIdHelper(
            List.of(
                    Blocks.LAVA,
                    Blocks.LAVA_CAULDRON,
                    Blocks.CAMPFIRE,
                    Blocks.SOUL_CAMPFIRE,
                    Blocks.FIRE,
                    Blocks.SOUL_FIRE,
                    Blocks.MAGMA_BLOCK
            )
    );


    @Entry(category = GENERAL, name = "Vanilla Rain Volume", isSlider = true,
            min = 0.01f, max = 1f, precision = 1000) public static float vanillaRainVolume = 0.2f;
    @Entry(category = GENERAL, name = "Metal Blocks Volume", isSlider = true,
            min = 0f, max = 1f, precision = 1000) public static float metalBlocksVolume = 0.5f;
    @Entry(category = GENERAL, name = "Fabric Blocks Volume", isSlider = true,
            min = 0f, max = 1f, precision = 1000) public static float fabricBlocksVolume = 0.75f;
    @Entry(category = GENERAL, name = "Glass Blocks Volume", isSlider = true,
            min = 0f, max = 1f, precision = 1000) public static float glassBlocksVolume = 0.5f;
    @Entry(category = GENERAL, name = "Foliage Blocks Volume", isSlider = true,
            min = 0f, max = 1f, precision = 1000) public static float foliageBlocksVolume = 0.5f;
    @Entry(category = GENERAL, name = "Water Blocks Volume", isSlider = true,
            min = 0f, max = 1f, precision = 1000) public static float waterBlocksVolume = 0.175f;
    @Entry(category = GENERAL, name = "Musical Blocks Volume", isSlider = true,
            min = 0f, max = 1f, precision = 1000) public static float musicalBlocksVolume = 0.2f;
    @Entry(category = GENERAL, name = "Crystal Blocks Volume", isSlider = true,
            min = 0f, max = 1f, precision = 1000) public static float crystalBlocksVolume = 0.3f;
    @Entry(category = GENERAL, name = "Evaporative Blocks Volume", isSlider = true,
            min = 0f, max = 1f, precision = 1000) public static float evaporativeBlocksVolume = 0.2f;
    @Entry(category = GENERAL, name = "Bell Blocks Volume", isSlider = true,
            min = 0f, max = 1f, precision = 1000) public static float bellBlocksVolume = 0.2f;

    @Entry(category = GENERAL, name = "Thunderstorm Winds Volume", isSlider = true,
            min = 0f, max = 3f, precision = 1000) public static float thunderstormWindsVolume = 1.5f;

    @Entry(category = GENERAL, name = "Thunderstorm Winds Frequency - Higher is less often",isSlider = true,
            min = 1, max = 100) public static int thunderstormWindsFrequency = 15;

    @Entry(category = GENERAL, name = "Additional Thunder Volume", isSlider = true,
            min = 0f, max = 20f, precision = 1000) public static float additionalThunderVolume = 10f;

    @Entry(category = GENERAL, name = "Additional Thunder Frequency - Higher is less often",isSlider = true,
            min = 1, max = 300) public static int additionalThunderFrequency = 150;


}
