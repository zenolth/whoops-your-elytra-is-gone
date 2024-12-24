package net.zenolth.whoops_your_elytra_is_gone.common.mixin;

import net.minecraft.structure.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.zenolth.whoops_your_elytra_is_gone.common.config.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EndCityGenerator.Piece.class)
public abstract class EndCityPieceMixin extends SimpleStructurePiece {
    public EndCityPieceMixin(StructurePieceType type, int length, StructureTemplateManager structureTemplateManager, Identifier id, String template, StructurePlacementData placementData, BlockPos pos) {
        super(type, length, structureTemplateManager, id, template, placementData, pos);
    }

    @Inject(method = "handleMetadata",at = @At("HEAD"),cancellable = true)
    public void wyeig$elytraMaybeBegone(String metadata, BlockPos pos, ServerWorldAccess world, Random random, BlockBox boundingBox, CallbackInfo ci) {
        if (metadata.startsWith("Elytra") && Math.random() > Config.get().elytraSpawnChance) {
            ci.cancel();
        }
    }
}
