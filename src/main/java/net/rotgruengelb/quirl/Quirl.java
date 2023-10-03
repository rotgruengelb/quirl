package net.rotgruengelb.quirl;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Blocks;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.rotgruengelb.quirl.behavior.shovel.v1.CustomShovelInteract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Quirl implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("quirl");
    public static final String MOD_ID = "quirl";

    @Override
    public void onInitialize() {

        LOGGER.info("Hello Fabric world!");
        CustomShovelInteract.addResult(Blocks.ACACIA_PLANKS.getDefaultState(), Blocks.DIRT.getDefaultState(), SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS);
    }
}