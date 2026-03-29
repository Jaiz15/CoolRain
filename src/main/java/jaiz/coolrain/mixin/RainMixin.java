package jaiz.coolrain.mixin;

import jaiz.coolrain.CoolRainSounds;
import jaiz.coolrain.config.CoolRainConfig;
import net.minecraft.block.Block;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WeatherRendering;
import net.minecraft.client.world.ClientWorld;

import net.minecraft.particle.ParticlesMode;
import net.minecraft.registry.Registries;

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



@Mixin(WeatherRendering.class)
public class RainMixin {

	@Redirect(
			method = "addParticlesAndSound",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWorld;playSoundAtBlockCenterClient (Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FFZ)V")
	)
	private void redirectRainSound(ClientWorld world, BlockPos pos, net.minecraft.sound.SoundEvent sound, SoundCategory category, float volume, float pitch, boolean distanceDelay) {
		BlockPos cameraPos = BlockPos.ofFloored(MinecraftClient.getInstance().gameRenderer.getCamera().getCameraPos());
		Block block = world.getBlockState(pos).getBlock();
		Identifier blockId = Registries.BLOCK.getId(block);

		boolean isAbove = pos.getY() > cameraPos.getY() + 1
				&& world.getTopPosition(Heightmap.Type.MOTION_BLOCKING, cameraPos).getY() > MathHelper.floor((float) cameraPos.getY());

		if(isAbove) {
			if (CoolRainConfig.METAL_BLOCKS.contains(blockId) && CoolRainConfig.metalSounds) {
				world.playSoundAtBlockCenterClient(pos, CoolRainSounds.RAIN_SOUNDS_METAL, SoundCategory.WEATHER, CoolRainConfig.metalBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.FABRIC_BLOCKS.contains(blockId) && CoolRainConfig.fabricSounds) {
				world.playSoundAtBlockCenterClient(pos, CoolRainSounds.RAIN_SOUNDS_FABRIC, SoundCategory.WEATHER, CoolRainConfig.fabricBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.GLASS_BLOCKS.contains(blockId) && CoolRainConfig.glassSounds) {
				world.playSoundAtBlockCenterClient(pos, CoolRainSounds.RAIN_SOUNDS_GLASS, SoundCategory.WEATHER, CoolRainConfig.glassBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			} else {
				world.playSoundAtBlockCenterClient(pos, SoundEvents.WEATHER_RAIN_ABOVE, SoundCategory.WEATHER, CoolRainConfig.vanillaRainVolume / 2, 0.75F, false);
			}
		} else {
			if (CoolRainConfig.METAL_BLOCKS.contains(blockId) && CoolRainConfig.metalSounds) {
				world.playSoundAtBlockCenterClient(pos, CoolRainSounds.RAIN_SOUNDS_METAL, SoundCategory.WEATHER, CoolRainConfig.metalBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.FABRIC_BLOCKS.contains(blockId) && CoolRainConfig.fabricSounds) {
				world.playSoundAtBlockCenterClient(pos, CoolRainSounds.RAIN_SOUNDS_FABRIC, SoundCategory.WEATHER, CoolRainConfig.fabricBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.GLASS_BLOCKS.contains(blockId) && CoolRainConfig.glassSounds) {
				world.playSoundAtBlockCenterClient(pos, CoolRainSounds.RAIN_SOUNDS_GLASS, SoundCategory.WEATHER, CoolRainConfig.glassBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.FOLIAGE_BLOCKS.contains(blockId) && CoolRainConfig.foliageSounds) {
				world.playSoundAtBlockCenterClient(pos, CoolRainSounds.RAIN_SOUNDS_FOLIAGE, SoundCategory.WEATHER, CoolRainConfig.foliageBlocksVolume, 1.0f, true);
			} else if (CoolRainConfig.WATER_BLOCKS.contains(blockId) && CoolRainConfig.waterSounds) {
				world.playSoundAtBlockCenterClient(pos, CoolRainSounds.RAIN_SOUNDS_WATER, SoundCategory.WEATHER, CoolRainConfig.waterBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.CRYSTAL_BLOCKS.contains(blockId) && CoolRainConfig.crystalSounds) {
				world.playSoundAtBlockCenterClient(pos, CoolRainSounds.RAIN_SOUNDS_GLASS, SoundCategory.WEATHER, CoolRainConfig.glassBlocksVolume, 1.0F, false);
				world.playSoundAtBlockCenterClient(pos, CoolRainSounds.RAIN_SOUNDS_AMETHYST, SoundCategory.WEATHER, CoolRainConfig.crystalBlocksVolume, world.getRandom().nextBetween(6, 10) * 0.1f, false);
			} else if (CoolRainConfig.MUSICAL_BLOCKS.contains(blockId) && CoolRainConfig.musicalSounds) {
				world.playSoundAtBlockCenterClient(pos, SoundEvents.WEATHER_RAIN, SoundCategory.WEATHER, CoolRainConfig.vanillaRainVolume, 1.0F, false);
				world.playSoundAtBlockCenterClient(pos, CoolRainSounds.RAIN_SOUNDS_NOTEBLOCK, SoundCategory.WEATHER, CoolRainConfig.musicalBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, false);
			}
			else if (CoolRainConfig.BELL_BLOCKS.contains(blockId) && CoolRainConfig.bellSounds) {
				world.playSoundAtBlockCenterClient(pos, CoolRainSounds.RAIN_SOUNDS_METAL, SoundCategory.WEATHER, CoolRainConfig.metalBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
				if(world.getRandom().nextInt(5) == 0) {
					world.playSoundAtBlockCenterClient(pos, SoundEvents.BLOCK_BELL_USE, SoundCategory.WEATHER, CoolRainConfig.bellBlocksVolume, world.getRandom().nextBetween(8, 12) * 0.1f, false);
				}
			}
			else if (CoolRainConfig.EVAPORATIVE_BLOCKS.contains(blockId) && CoolRainConfig.evaporativeSounds) {
				world.playSoundAtBlockCenterClient(pos, CoolRainSounds.RAIN_SOUNDS_LAVA, SoundCategory.WEATHER, CoolRainConfig.evaporativeBlocksVolume, 1.0F, true);
				world.playSoundAtBlockCenterClient(pos, SoundEvents.WEATHER_RAIN, SoundCategory.WEATHER, CoolRainConfig.vanillaRainVolume, world.getRandom().nextBetween(8, 12) * 0.1f, false);
			} else {
				world.playSoundAtBlockCenterClient(pos, SoundEvents.WEATHER_RAIN, SoundCategory.WEATHER, CoolRainConfig.vanillaRainVolume, 1.0F, false);
			}
		}
	}


	@Inject(at = @At("TAIL"), method = "addParticlesAndSound")
	private void stormSoundEffects(ClientWorld world, Camera camera, int ticks,
			ParticlesMode particlesMode, int weatherRadius, CallbackInfo ci) {
		BlockPos cameraPos = BlockPos.ofFloored(MinecraftClient.getInstance().gameRenderer.getCamera().getCameraPos());
        assert world != null;
        if(world.isThundering() && camera.getCameraPos().getY() > 64 && world.hasRain(cameraPos)){
			if(world.getRandom().nextInt(CoolRainConfig.thunderstormWindsFrequency) == 0 && CoolRainConfig.thunderstormWinds){
				world.playSoundClient(cameraPos.getX() + world.getRandom().nextBetween(-10, 10), cameraPos.getY(), cameraPos.getZ() + world.getRandom().nextBetween(-10, 10),
						CoolRainSounds.WIND_SOUNDS, SoundCategory.WEATHER, CoolRainConfig.thunderstormWindsVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			}
			if(world.getRandom().nextInt(CoolRainConfig.additionalThunderFrequency) == 0 && CoolRainConfig.additionalThunderSounds){
				world.playSoundClient(cameraPos.getX() + world.getRandom().nextBetween(-50, 50), cameraPos.getY() + 30, cameraPos.getZ() + world.getRandom().nextBetween(-50, 50),
						CoolRainSounds.ROLLING_THUNDER, SoundCategory.WEATHER, CoolRainConfig.additionalThunderVolume, world.getRandom().nextBetween(8, 12) * 0.1f, true);
			}
		}
	}

}