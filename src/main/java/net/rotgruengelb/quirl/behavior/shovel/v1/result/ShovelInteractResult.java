package net.rotgruengelb.quirl.behavior.shovel.v1.result;

import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;

public class ShovelInteractResult {

    BlockState new_blockstate;
    SoundEvent interact_sound_event;
    SoundCategory interact_sound_category;

    public ShovelInteractResult(BlockState newBlockstate, SoundEvent interactSoundEvent, SoundCategory interactSoundCategory) {
        new_blockstate = newBlockstate;
        interact_sound_event = interactSoundEvent;
        interact_sound_category = interactSoundCategory;
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
}
