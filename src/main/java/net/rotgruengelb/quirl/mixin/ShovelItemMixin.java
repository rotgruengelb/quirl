package net.rotgruengelb.quirl.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.rotgruengelb.quirl.api.mechanic.interact.result.v1.ToolBlockInteractResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.rotgruengelb.quirl.api.mechanic.interact.shovel.v1.CustomShovelBlockInteract.CUSTOM_SHOVEL_INTERACT_RESULTS;

@Mixin(ShovelItem.class)
public class ShovelItemMixin {

    @Inject(at = @At(value = "HEAD", target = "Lnet/minecraft/item/Item;useOnBlock(Lnet/minecraft/item/ItemUsageContext;)Lnet/minecraft/util/ActionResult;"), method = "useOnBlock", cancellable = true)
    private void add_custom_useOn(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        PlayerEntity playerEntity = context.getPlayer();
        ToolBlockInteractResult shovelInteractResult = CUSTOM_SHOVEL_INTERACT_RESULTS.get(blockState);
        BlockState blockState3 = null;
        if (shovelInteractResult != null) {
            if ((world.getBlockState(blockPos.up()).isAir() && (context.getSide() != Direction.DOWN)) || shovelInteractResult.getDisable_surrounding_checks()) {
                world.playSound(playerEntity, blockPos, shovelInteractResult.getInteract_sound_event(), shovelInteractResult.getInteract_sound_category(), 1.0f, 1.0f);
                blockState3 = shovelInteractResult.getNew_blockstate();
            }
        }
        if (blockState3 != null) {
            if (!world.isClient) {
                world.setBlockState(blockPos, blockState3, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, blockState3));
                if (playerEntity != null) {
                    context.getStack().damage(1, playerEntity, p -> p.sendToolBreakStatus(context.getHand()));
                }
            }
            cir.setReturnValue(ActionResult.success(world.isClient));
            cir.cancel();
        }
    }
}