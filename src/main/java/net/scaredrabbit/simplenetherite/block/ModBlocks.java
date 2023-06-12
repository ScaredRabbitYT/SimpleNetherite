package net.scaredrabbit.simplenetherite.block;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.scaredrabbit.simplenetherite.SimpleNetheriteFabric;

public class ModBlocks  {

    public static final Block RAW_NETHERITE_BLOCK = registerBlock("raw_netherite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).strength(3f).requiresTool()));

    public static final Block STONE_NETHERITE_ORE = registerBlock("stone_netherite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).strength(3f).requiresTool(),
                    UniformIntProvider.create(3, 7)));

    public static final Block NETHERITE_ORE = registerBlock("netherite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.NETHERRACK).strength(1f).requiresTool(),
                    UniformIntProvider.create(3, 7)));
    public static final Block DEEPSLATE_NETHERITE_ORE = registerBlock("deepslate_netherite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.DEEPSLATE).strength(5f).requiresTool(),
                    UniformIntProvider.create(3,7)));
    public static final Block ENDSTONE_NETHERITE_ORE = registerBlock("endstone_netherite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).strength(3f).requiresTool(),
                    UniformIntProvider.create(3,7)));
    

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(SimpleNetheriteFabric.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(SimpleNetheriteFabric.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }

    public static void registerModBlocks() {
        SimpleNetheriteFabric.LOGGER.debug("Registering ModBlocks for " + SimpleNetheriteFabric.MOD_ID);
    }
}
