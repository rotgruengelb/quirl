package net.rotgruengelb.quirl.lib.feature.item;

import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.entity.LivingEntity;

/**
 * This interface is used to add custom arm poses to items. <br>
 * The methods positionRightArm and positionLeftArm are called by the mixin BipedEntityModelMixin.
 */
@Environment(net.fabricmc.api.EnvType.CLIENT)
public interface HasCustomArmPose {
    void positionRightArm(ModelPart rightArm, LivingEntity entity, ModelPart head, ModelPart hat, ModelPart body, ModelPart leftArm, ModelPart rightLeg, ModelPart leftLeg);

    void positionLeftArm(ModelPart leftArm, LivingEntity entity, ModelPart head, ModelPart hat, ModelPart body, ModelPart rightArm, ModelPart rightLeg, ModelPart leftLeg);
}
