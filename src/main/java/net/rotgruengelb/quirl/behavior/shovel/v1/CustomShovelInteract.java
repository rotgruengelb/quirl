package net.rotgruengelb.quirl.behavior.shovel.v1;

import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.rotgruengelb.quirl.behavior.shovel.v1.result.ShovelInteractResult;

import java.util.HashMap;
import java.util.Map;

public class CustomShovelInteract {

    public static Map<BlockState, ShovelInteractResult> CUSTOM_SHOVEL_INTERACT_RESULTS = new HashMap<>();

    public static void addResult(BlockState starting_blockstate, BlockState new_blockstate, SoundEvent interact_sound_event, SoundCategory interact_sound_category) {
        CUSTOM_SHOVEL_INTERACT_RESULTS.put(starting_blockstate, new ShovelInteractResult(new_blockstate, interact_sound_event, interact_sound_category));
    }
}
