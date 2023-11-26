package net.rotgruengelb.quirl;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Blocks;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.rotgruengelb.quirl.api.mechanic.interact.onblock.AxeBlockInteractRegistry;
import net.rotgruengelb.quirl.api.mechanic.interact.onblock.ShovelBlockInteractRegistry;
import net.rotgruengelb.quirl.internal.command.CommandNodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Quirl implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("quirl");
    public static final String MOD_ID = "quirl";
    public static final Boolean MOD_TEST_MODE = true;

    @Override
    public void onInitialize() {

        CommandNodes.registerModCommandNodes();

        LOGGER.info("Hi, im quirl \nDeveloped by rotgruengelb and quirl contributors.");

        if (MOD_TEST_MODE) {
            LOGGER.warn("quirl is in test mode! do not release with 'MOD_TEST_MOD = true'!");
            ShovelBlockInteractRegistry.register(Blocks.ACACIA_PLANKS.getDefaultState(), Blocks.DIRT.getDefaultState(), SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, true);
            ShovelBlockInteractRegistry.register(Blocks.SPRUCE_PLANKS.getDefaultState(), Blocks.DIRT.getDefaultState(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS);
            AxeBlockInteractRegistry.register(Blocks.AMETHYST_BLOCK.getDefaultState(), Blocks.BLUE_ICE.getDefaultState(), SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS);
        }
    }
}