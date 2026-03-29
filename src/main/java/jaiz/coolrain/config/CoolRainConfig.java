package jaiz.coolrain.config;

import eu.midnightdust.lib.config.MidnightConfig;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class CoolRainConfig extends MidnightConfig {
    public static final String GENERAL = "general";

    private static List<Identifier> toIdHelper(List<Block> blocks) {
        ArrayList<Identifier> output = new ArrayList<>();
        for (Block b : blocks) {
            output.add(BuiltInRegistries.BLOCK.getKey(b));

        }
        return output;
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

    @Entry(category = GENERAL, idMode = 1, name = "Metal Blocks") public static List<Identifier> METAL_BLOCKS = toIdHelper(
            List.of(
                    Blocks.COPPER_BLOCK, Blocks.WEATHERED_COPPER, Blocks.EXPOSED_COPPER, Blocks.OXIDIZED_COPPER,
                    Blocks.WAXED_COPPER_BLOCK, Blocks.WAXED_WEATHERED_COPPER, Blocks.WAXED_EXPOSED_COPPER, Blocks.WAXED_OXIDIZED_COPPER,
                    Blocks.COPPER_BULB, Blocks.WEATHERED_COPPER_BULB, Blocks.EXPOSED_COPPER_BULB, Blocks.OXIDIZED_COPPER_BULB,
                    Blocks.WAXED_COPPER_BULB, Blocks.WAXED_WEATHERED_COPPER_BULB, Blocks.WAXED_EXPOSED_COPPER_BULB, Blocks.WAXED_OXIDIZED_COPPER_BULB,
                    Blocks.COPPER_GRATE, Blocks.WEATHERED_COPPER_GRATE, Blocks.EXPOSED_COPPER_GRATE, Blocks.OXIDIZED_COPPER_GRATE,
                    Blocks.WAXED_COPPER_GRATE, Blocks.WAXED_WEATHERED_COPPER_GRATE, Blocks.WAXED_EXPOSED_COPPER_GRATE, Blocks.WAXED_OXIDIZED_COPPER_GRATE,
                    Blocks.CHISELED_COPPER, Blocks.WEATHERED_CHISELED_COPPER, Blocks.EXPOSED_CHISELED_COPPER, Blocks.OXIDIZED_CHISELED_COPPER,
                    Blocks.WAXED_CHISELED_COPPER, Blocks.WAXED_WEATHERED_CHISELED_COPPER, Blocks.WAXED_EXPOSED_CHISELED_COPPER, Blocks.WAXED_OXIDIZED_CHISELED_COPPER,
                    Blocks.CUT_COPPER, Blocks.WEATHERED_CUT_COPPER, Blocks.EXPOSED_CUT_COPPER, Blocks.OXIDIZED_CUT_COPPER,
                    Blocks.WAXED_CUT_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER,
                    Blocks.CUT_COPPER_STAIRS, Blocks.WEATHERED_CUT_COPPER_STAIRS, Blocks.EXPOSED_CUT_COPPER_STAIRS, Blocks.OXIDIZED_CUT_COPPER_STAIRS,
                    Blocks.WAXED_CUT_COPPER_STAIRS, Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS, Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS, Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS,
                    Blocks.CUT_COPPER_SLAB, Blocks.WEATHERED_CUT_COPPER_SLAB, Blocks.EXPOSED_CUT_COPPER_SLAB, Blocks.OXIDIZED_CUT_COPPER_SLAB,
                    Blocks.WAXED_CUT_COPPER_SLAB, Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB, Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB, Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB,
                    Blocks.COPPER_TRAPDOOR, Blocks.EXPOSED_COPPER_TRAPDOOR, Blocks.WEATHERED_COPPER_TRAPDOOR, Blocks.OXIDIZED_COPPER_TRAPDOOR,
                    Blocks.WAXED_COPPER_TRAPDOOR, Blocks.WAXED_EXPOSED_COPPER_TRAPDOOR, Blocks.WAXED_WEATHERED_COPPER_TRAPDOOR, Blocks.WAXED_OXIDIZED_COPPER_TRAPDOOR,
                    Blocks.LANTERN, Blocks.SOUL_LANTERN, Blocks.IRON_TRAPDOOR, Blocks.NETHERITE_BLOCK,
                    Blocks.IRON_BLOCK, Blocks.RAW_IRON_BLOCK, Blocks.RAW_COPPER_BLOCK, Blocks.RAW_GOLD_BLOCK,
                    Blocks.CRACKED_DEEPSLATE_TILES, Blocks.DEEPSLATE_TILE_SLAB, Blocks.DEEPSLATE_TILES, Blocks.DEEPSLATE_TILE_STAIRS,
                    Blocks.GOLD_BLOCK, Blocks.CAULDRON, Blocks.ANVIL, Blocks.CHIPPED_ANVIL, Blocks.DAMAGED_ANVIL, Blocks.SMITHING_TABLE,
                    Blocks.ANCIENT_DEBRIS, Blocks.GILDED_BLACKSTONE, Blocks.TRIAL_SPAWNER, Blocks.VAULT, Blocks.SPAWNER, Blocks.HOPPER, Blocks.IRON_CHAIN,
                    Blocks.COPPER_LANTERN.unaffected(), Blocks.COPPER_LANTERN.exposed(), Blocks.COPPER_LANTERN.weathered(), Blocks.COPPER_LANTERN.oxidized(),
                    Blocks.COPPER_LANTERN.waxed(), Blocks.COPPER_LANTERN.waxedExposed(), Blocks.COPPER_LANTERN.waxedWeathered(), Blocks.COPPER_LANTERN.waxedOxidized(),
                    Blocks.COPPER_CHAIN.unaffected(), Blocks.COPPER_CHAIN.exposed(), Blocks.COPPER_CHAIN.weathered(), Blocks.COPPER_CHAIN.oxidized(),
                    Blocks.COPPER_CHAIN.waxed(), Blocks.COPPER_CHAIN.waxedExposed(), Blocks.COPPER_CHAIN.waxedWeathered(), Blocks.COPPER_CHAIN.waxedOxidized(),
                    Blocks.COPPER_CHEST, Blocks.EXPOSED_COPPER_CHEST, Blocks.WEATHERED_COPPER_CHEST, Blocks.OXIDIZED_COPPER_CHEST,
                    Blocks.WAXED_COPPER_CHEST, Blocks.WAXED_EXPOSED_COPPER_CHEST, Blocks.WAXED_WEATHERED_COPPER_CHEST, Blocks.WAXED_OXIDIZED_COPPER_CHEST,
                    Blocks.COPPER_GOLEM_STATUE, Blocks.EXPOSED_COPPER_GOLEM_STATUE, Blocks.WEATHERED_COPPER_GOLEM_STATUE, Blocks.OXIDIZED_COPPER_GOLEM_STATUE,
                    Blocks.WAXED_COPPER_GOLEM_STATUE, Blocks.WAXED_EXPOSED_COPPER_GOLEM_STATUE, Blocks.WAXED_WEATHERED_COPPER_GOLEM_STATUE, Blocks.WAXED_OXIDIZED_COPPER_GOLEM_STATUE
            )
    );

    @Entry(category = GENERAL, idMode = 1, name = "Fabric Blocks") public static List<Identifier> FABRIC_BLOCKS = toIdHelper(
            List.of(
                    Blocks.WHITE_WOOL, Blocks.ORANGE_WOOL, Blocks.MAGENTA_WOOL, Blocks.LIGHT_BLUE_WOOL, Blocks.YELLOW_WOOL, Blocks.LIME_WOOL, Blocks.PINK_WOOL,
                    Blocks.GRAY_WOOL, Blocks.LIGHT_GRAY_WOOL, Blocks.CYAN_WOOL, Blocks.PURPLE_WOOL, Blocks.BLUE_WOOL, Blocks.BROWN_WOOL, Blocks.GREEN_WOOL,
                    Blocks.RED_WOOL, Blocks.BLACK_WOOL, Blocks.WHITE_CARPET, Blocks.ORANGE_CARPET, Blocks.MAGENTA_CARPET, Blocks.LIGHT_BLUE_CARPET,
                    Blocks.YELLOW_CARPET, Blocks.LIME_CARPET, Blocks.PINK_CARPET, Blocks.GRAY_CARPET, Blocks.LIGHT_GRAY_CARPET, Blocks.CYAN_CARPET,
                    Blocks.PURPLE_CARPET, Blocks.BLUE_CARPET, Blocks.BROWN_CARPET, Blocks.GREEN_CARPET, Blocks.RED_CARPET, Blocks.BLACK_CARPET,
                    Blocks.WHITE_BED, Blocks.ORANGE_BED, Blocks.MAGENTA_BED, Blocks.LIGHT_BLUE_BED, Blocks.YELLOW_BED, Blocks.LIME_BED, Blocks.PINK_BED,
                    Blocks.GRAY_BED, Blocks.LIGHT_GRAY_BED, Blocks.CYAN_BED, Blocks.PURPLE_BED, Blocks.BLUE_BED, Blocks.BROWN_BED, Blocks.GREEN_BED,
                    Blocks.RED_BED, Blocks.BLACK_BED
            )
    );

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
