package jaiz.coolrain.mixin;

import jaiz.coolrain.CoolRainSounds;
import jaiz.coolrain.config.CoolRainConfig;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Heightmap;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;
import java.util.Set;

@Mixin(WorldRenderer.class)
public class RainMixin {

	@Mutable
	@Final
	@Shadow
	private final MinecraftClient client;

    public RainMixin(MinecraftClient client) {
        this.client = client;
    }

	@Redirect(
			method = "tickRainSplashing",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWorld;playSoundAtBlockCenter(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FFZ)V")
	)
	private void redirectRainSound(ClientWorld world, BlockPos pos, net.minecraft.sound.SoundEvent sound, SoundCategory category, float volume, float pitch, boolean distanceDelay) {
		BlockPos cameraPos = BlockPos.ofFloored(MinecraftClient.getInstance().gameRenderer.getCamera().getPos());
		Block block = world.getBlockState(pos).getBlock();
		Identifier blockId = Registries.BLOCK.getId(block);

		boolean isAbove = pos.getY() > cameraPos.getY() + 1
				&& world.getTopPosition(Heightmap.Type.MOTION_BLOCKING, cameraPos).getY() > MathHelper.floor((float) cameraPos.getY());

		if(isAbove) {
			if (CoolRainConfig.METAL_BLOCKS.contains(blockId) && CoolRainConfig.metalSounds) {
				world.playSoundAtBlockCenter(pos, CoolRainSounds.RAIN_SOUNDS_METAL, SoundCategory.WEATHER, CoolRainConfig.metalBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.FABRIC_BLOCKS.contains(blockId) && CoolRainConfig.fabricSounds) {
				world.playSoundAtBlockCenter(pos, CoolRainSounds.RAIN_SOUNDS_FABRIC, SoundCategory.WEATHER, CoolRainConfig.fabricBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.GLASS_BLOCKS.contains(blockId) && CoolRainConfig.glassSounds) {
				world.playSoundAtBlockCenter(pos, CoolRainSounds.RAIN_SOUNDS_GLASS, SoundCategory.WEATHER, CoolRainConfig.glassBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			} else {
				world.playSoundAtBlockCenter(pos, SoundEvents.WEATHER_RAIN_ABOVE, SoundCategory.WEATHER, CoolRainConfig.vanillaRainVolume / 2, 0.75F, false);
			}
		} else {
			if (CoolRainConfig.METAL_BLOCKS.contains(blockId) && CoolRainConfig.metalSounds) {
				world.playSoundAtBlockCenter(pos, CoolRainSounds.RAIN_SOUNDS_METAL, SoundCategory.WEATHER, CoolRainConfig.metalBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.FABRIC_BLOCKS.contains(blockId) && CoolRainConfig.fabricSounds) {
				world.playSoundAtBlockCenter(pos, CoolRainSounds.RAIN_SOUNDS_FABRIC, SoundCategory.WEATHER, CoolRainConfig.fabricBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.GLASS_BLOCKS.contains(blockId) && CoolRainConfig.glassSounds) {
				world.playSoundAtBlockCenter(pos, CoolRainSounds.RAIN_SOUNDS_GLASS, SoundCategory.WEATHER, CoolRainConfig.glassBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.FOLIAGE_BLOCKS.contains(blockId) && CoolRainConfig.foliageSounds) {
				world.playSoundAtBlockCenter(pos, CoolRainSounds.RAIN_SOUNDS_FOLIAGE, SoundCategory.WEATHER, CoolRainConfig.foliageBlocksVolume, 1.0f, true);
			} else if (CoolRainConfig.WATER_BLOCKS.contains(blockId) && CoolRainConfig.waterSounds) {
				world.playSoundAtBlockCenter(pos, CoolRainSounds.RAIN_SOUNDS_WATER, SoundCategory.WEATHER, CoolRainConfig.waterBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.CRYSTAL_BLOCKS.contains(blockId) && CoolRainConfig.crystalSounds) {
				world.playSoundAtBlockCenter(pos, CoolRainSounds.RAIN_SOUNDS_GLASS, SoundCategory.WEATHER, CoolRainConfig.glassBlocksVolume, 1.0F, false);
				world.playSoundAtBlockCenter(pos, CoolRainSounds.RAIN_SOUNDS_AMETHYST, SoundCategory.WEATHER, CoolRainConfig.crystalBlocksVolume, world.getRandom().nextBetween(6, 10) * 0.1f, false);
			} else if (CoolRainConfig.MUSICAL_BLOCKS.contains(blockId) && CoolRainConfig.musicalSounds) {
				world.playSoundAtBlockCenter(pos, SoundEvents.WEATHER_RAIN, SoundCategory.WEATHER, CoolRainConfig.vanillaRainVolume, 1.0F, false);
				world.playSoundAtBlockCenter(pos, CoolRainSounds.RAIN_SOUNDS_NOTEBLOCK, SoundCategory.WEATHER, CoolRainConfig.musicalBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, false);
			}
			else if (CoolRainConfig.BELL_BLOCKS.contains(blockId) && CoolRainConfig.bellSounds) {
				world.playSoundAtBlockCenter(pos, CoolRainSounds.RAIN_SOUNDS_METAL, SoundCategory.WEATHER, CoolRainConfig.metalBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
				if(world.getRandom().nextInt(5) == 0) {
					world.playSoundAtBlockCenter(pos, SoundEvents.BLOCK_BELL_USE, SoundCategory.WEATHER, CoolRainConfig.bellBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, false);
				}
			}
			else if (CoolRainConfig.EVAPORATIVE_BLOCKS.contains(blockId) && CoolRainConfig.evaporativeSounds) {
				world.playSoundAtBlockCenter(pos, CoolRainSounds.RAIN_SOUNDS_LAVA, SoundCategory.WEATHER, CoolRainConfig.evaporativeBlocksVolume, 1.0F, true);
				world.playSoundAtBlockCenter(pos, SoundEvents.WEATHER_RAIN, SoundCategory.WEATHER, CoolRainConfig.vanillaRainVolume, world.getRandom().nextBetween(8, 12) * 0.1f, false);
			} else {
				world.playSoundAtBlockCenter(pos, SoundEvents.WEATHER_RAIN, SoundCategory.WEATHER, CoolRainConfig.vanillaRainVolume, 1.0F, false);
			}
		}
	}


	@Inject(at = @At("TAIL"), method = "tickRainSplashing")
	private void stormSoundEffects(Camera camera, CallbackInfo ci) {
		BlockPos cameraPos = BlockPos.ofFloored(MinecraftClient.getInstance().gameRenderer.getCamera().getPos());
        assert client.world != null;
        if(client.world.isThundering() && camera.getPos().getY() > 64 && client.world.hasRain(cameraPos)){
			if(client.world.getRandom().nextInt(CoolRainConfig.thunderstormWindsFrequency) == 0 && CoolRainConfig.thunderstormWinds){
				client.world.playSound(cameraPos.getX() + client.world.getRandom().nextBetween(-10, 10), cameraPos.getY(), cameraPos.getZ() + client.world.getRandom().nextBetween(-10, 10),
						CoolRainSounds.WIND_SOUNDS, SoundCategory.WEATHER, CoolRainConfig.thunderstormWindsVolume, client.world.getRandom().nextBetween(8, 12) * 0.1f, true);
			}
			if(client.world.getRandom().nextInt(CoolRainConfig.additionalThunderFrequency) == 0 && CoolRainConfig.additionalThunderSounds){
				client.world.playSound(cameraPos.getX() + client.world.getRandom().nextBetween(-50, 50), cameraPos.getY() + 30, cameraPos.getZ() + client.world.getRandom().nextBetween(-50, 50),
						CoolRainSounds.ROLLING_THUNDER, SoundCategory.WEATHER, CoolRainConfig.additionalThunderVolume, client.world.getRandom().nextBetween(8, 12) * 0.1f, true);
			}
		}
	}

}