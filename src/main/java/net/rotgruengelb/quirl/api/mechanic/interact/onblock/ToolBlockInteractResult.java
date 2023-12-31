package net.rotgruengelb.quirl.api.mechanic.interact.onblock;

import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;

public class ToolBlockInteractResult {

    final BlockState new_blockstate;
    final SoundEvent interact_sound_event;
    final SoundCategory interact_sound_category;
    final Boolean disable_surrounding_checks;

    public ToolBlockInteractResult(BlockState newBlockstate, SoundEvent interactSoundEvent, SoundCategory interactSoundCategory, Boolean disableSurroundingChecks) {
        new_blockstate = newBlockstate;
        interact_sound_event = interactSoundEvent;
        interact_sound_category = interactSoundCategory;
        disable_surrounding_checks = disableSurroundingChecks;
    }


    public BlockState getNew_blockstate() {
        return new_blockstate;
    }

    public SoundEvent getInteract_sound_event() {
        return interact_sound_event;
    }

    public SoundCategory getInteract_sound_category() {
        return interact_sound_category;
    }

    public Boolean getDisable_surrounding_checks() {
        return disable_surrounding_checks;
    }
}
