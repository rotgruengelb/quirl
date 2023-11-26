package net.rotgruengelb.quirl.api.mechanic.interact.onblock;

import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class AxeBlockInteractRegistry {

    private static final Map<BlockState, ToolBlockInteractResult> REG = new HashMap<>();

    public static void register(BlockState starting_blockstate, BlockState new_blockstate, SoundEvent sound_event, SoundCategory sound_category) {
        REG.put(starting_blockstate, new ToolBlockInteractResult(new_blockstate, sound_event, sound_category, false));
    }

    public static @Nullable ToolBlockInteractResult getResult(BlockState blockState) {
        return REG.get(blockState);
    }
}
