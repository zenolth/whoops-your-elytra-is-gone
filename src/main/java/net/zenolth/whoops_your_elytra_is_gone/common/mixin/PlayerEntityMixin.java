package net.zenolth.whoops_your_elytra_is_gone.common.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "dropInventory",at = @At("HEAD"))
    public void wyeig$elytraBegone(CallbackInfo ci) {
        PlayerEntity thisObject = (PlayerEntity)(Object) this;

        for (int i = 0; i < thisObject.getInventory().size(); i++) {
            ItemStack itemStack = thisObject.getInventory().getStack(i);
            if (!itemStack.isEmpty() && itemStack.isOf(Items.ELYTRA)) {
                // bye bye elytra, it was nice to see ya
                thisObject.getInventory().removeStack(i);
            }
        }
    }
}
