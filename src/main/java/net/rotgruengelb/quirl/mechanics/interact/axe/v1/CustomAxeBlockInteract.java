package net.rotgruengelb.quirl.mechanics.interact.axe.v1;

import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.rotgruengelb.quirl.mechanics.interact.result.v1.ToolBlockInteractResult;

import java.util.HashMap;
import java.util.Map;

public class CustomAxeBlockInteract {

    public static Map<BlockState, ToolBlockInteractResult> CUSTOM_AXE_INTERACT_RESULTS = new HashMap<>();

    public static void addResult(BlockState starting_blockstate, BlockState new_blockstate, SoundEvent interact_sound_event, SoundCategory interact_sound_category, Boolean disable_surrounding_checks) {
        CUSTOM_AXE_INTERACT_RESULTS.put(starting_blockstate, new ToolBlockInteractResult(new_blockstate, interact_sound_event, interact_sound_category, disable_surrounding_checks));
    }

    public static void addResult(BlockState starting_blockstate, BlockState new_blockstate, SoundEvent interact_sound_event, SoundCategory interact_sound_category) {
        CUSTOM_AXE_INTERACT_RESULTS.put(starting_blockstate, new ToolBlockInteractResult(new_blockstate, interact_sound_event, interact_sound_category, false));
    }
}