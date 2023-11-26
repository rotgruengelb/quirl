package net.rotgruengelb.quirl.mixin;

import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.rotgruengelb.quirl.lib.feature.item.HasCustomArmPose;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(net.fabricmc.api.EnvType.CLIENT)
@Mixin(BipedEntityModel.class)
public class BipedEntityModelMixin {

    @Shadow
    @Final
    public ModelPart rightArm;

    @Shadow
    @Final
    public ModelPart head;

    @Shadow
    @Final
    public ModelPart leftArm;

    @Shadow
    @Final
    public ModelPart hat;

    @Shadow
    @Final
    public ModelPart body;

    @Shadow
    @Final
    public ModelPart leftLeg;

    @Shadow
    @Final
    public ModelPart rightLeg;

    @Inject(at = @At(value = "TAIL"), method = "positionRightArm")
    void positionRightArm(LivingEntity entity, CallbackInfo ci) {
        Item activeItem = entity.getActiveItem().getItem();
        if (activeItem instanceof HasCustomArmPose) {
            ((HasCustomArmPose) activeItem).positionRightArm(this.rightArm, entity, this.head, this.hat, this.body, this.leftArm, this.rightLeg, this.leftLeg);
        }
    }

    @Inject(at = @At(value = "TAIL"), method = "positionLeftArm")
    void positionLeftArm(LivingEntity entity, CallbackInfo ci) {
        Item activeItem = entity.getActiveItem().getItem();
        if (activeItem instanceof HasCustomArmPose) {
            ((HasCustomArmPose) activeItem).positionLeftArm(this.leftArm, entity, this.head, this.hat, this.body, this.rightArm, this.rightLeg, this.leftLeg);
        }
    }
}
