package jaiz.coolrain.mixin;

import jaiz.coolrain.CoolRainSounds;
import jaiz.coolrain.config.CoolRainConfig;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.WeatherEffectRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ParticleStatus;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;



@Mixin(WeatherEffectRenderer.class)
public class RainMixin {

	@Redirect(
			method = "tickRainParticles",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ClientLevel;playLocalSound (Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V")
	)
	private void redirectRainSound(ClientLevel world, BlockPos pos, net.minecraft.sounds.SoundEvent sound, SoundSource category, float volume, float pitch, boolean distanceDelay) {
		BlockPos cameraPos = BlockPos.containing(Minecraft.getInstance().gameRenderer.getMainCamera().position());
		Block block = world.getBlockState(pos).getBlock();
		Identifier blockId = BuiltInRegistries.BLOCK.getKey(block);

		boolean isAbove = pos.getY() > cameraPos.getY() + 1
				&& world.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, cameraPos).getY() > Mth.floor((float) cameraPos.getY());

		if(isAbove) {
			if (CoolRainConfig.METAL_BLOCKS.contains(blockId) && CoolRainConfig.metalSounds) {
				world.playLocalSound(pos, CoolRainSounds.RAIN_SOUNDS_METAL, SoundSource.WEATHER, CoolRainConfig.metalBlocksVolume, world.getRandom().nextIntBetweenInclusive(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.FABRIC_BLOCKS.contains(blockId) && CoolRainConfig.fabricSounds) {
				world.playLocalSound(pos, CoolRainSounds.RAIN_SOUNDS_FABRIC, SoundSource.WEATHER, CoolRainConfig.fabricBlocksVolume, world.getRandom().nextIntBetweenInclusive(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.GLASS_BLOCKS.contains(blockId) && CoolRainConfig.glassSounds) {
				world.playLocalSound(pos, CoolRainSounds.RAIN_SOUNDS_GLASS, SoundSource.WEATHER, CoolRainConfig.glassBlocksVolume, world.getRandom().nextIntBetweenInclusive(8, 12) * 0.1f, true);
			} else {
				world.playLocalSound(pos, SoundEvents.WEATHER_RAIN_ABOVE, SoundSource.WEATHER, CoolRainConfig.vanillaRainVolume / 2, 0.75F, false);
			}
		} else {
			if (CoolRainConfig.METAL_BLOCKS.contains(blockId) && CoolRainConfig.metalSounds) {
				world.playLocalSound(pos, CoolRainSounds.RAIN_SOUNDS_METAL, SoundSource.WEATHER, CoolRainConfig.metalBlocksVolume, world.getRandom().nextIntBetweenInclusive(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.FABRIC_BLOCKS.contains(blockId) && CoolRainConfig.fabricSounds) {
				world.playLocalSound(pos, CoolRainSounds.RAIN_SOUNDS_FABRIC, SoundSource.WEATHER, CoolRainConfig.fabricBlocksVolume, world.getRandom().nextIntBetweenInclusive(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.GLASS_BLOCKS.contains(blockId) && CoolRainConfig.glassSounds) {
				world.playLocalSound(pos, CoolRainSounds.RAIN_SOUNDS_GLASS, SoundSource.WEATHER, CoolRainConfig.glassBlocksVolume, world.getRandom().nextIntBetweenInclusive(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.FOLIAGE_BLOCKS.contains(blockId) && CoolRainConfig.foliageSounds) {
				world.playLocalSound(pos, CoolRainSounds.RAIN_SOUNDS_FOLIAGE, SoundSource.WEATHER, CoolRainConfig.foliageBlocksVolume, 1.0f, true);
			} else if (CoolRainConfig.WATER_BLOCKS.contains(blockId) && CoolRainConfig.waterSounds) {
				world.playLocalSound(pos, CoolRainSounds.RAIN_SOUNDS_WATER, SoundSource.WEATHER, CoolRainConfig.waterBlocksVolume, world.getRandom().nextIntBetweenInclusive(8, 12) * 0.1f, true);
			} else if (CoolRainConfig.CRYSTAL_BLOCKS.contains(blockId) && CoolRainConfig.crystalSounds) {
				world.playLocalSound(pos, CoolRainSounds.RAIN_SOUNDS_GLASS, SoundSource.WEATHER, CoolRainConfig.glassBlocksVolume, 1.0F, false);
				world.playLocalSound(pos, CoolRainSounds.RAIN_SOUNDS_AMETHYST, SoundSource.WEATHER, CoolRainConfig.crystalBlocksVolume, world.getRandom().nextIntBetweenInclusive(6, 10) * 0.1f, false);
			} else if (CoolRainConfig.MUSICAL_BLOCKS.contains(blockId) && CoolRainConfig.musicalSounds) {
				world.playLocalSound(pos, SoundEvents.WEATHER_RAIN, SoundSource.WEATHER, CoolRainConfig.vanillaRainVolume, 1.0F, false);
				world.playLocalSound(pos, CoolRainSounds.RAIN_SOUNDS_NOTEBLOCK, SoundSource.WEATHER, CoolRainConfig.musicalBlocksVolume, world.getRandom().nextIntBetweenInclusive(8, 12) * 0.1f, false);
			}
			else if (CoolRainConfig.BELL_BLOCKS.contains(blockId) && CoolRainConfig.bellSounds) {
				world.playLocalSound(pos, CoolRainSounds.RAIN_SOUNDS_METAL, SoundSource.WEATHER, CoolRainConfig.metalBlocksVolume, world.getRandom().nextIntBetweenInclusive(8, 12) * 0.1f, true);
				if(world.getRandom().nextInt(5) == 0) {
					world.playLocalSound(pos, SoundEvents.BELL_BLOCK, SoundSource.WEATHER, CoolRainConfig.bellBlocksVolume, world.getRandom().nextIntBetweenInclusive(8, 12) * 0.1f, false);
				}
			}
			else if (CoolRainConfig.EVAPORATIVE_BLOCKS.contains(blockId) && CoolRainConfig.evaporativeSounds) {
				world.playLocalSound(pos, CoolRainSounds.RAIN_SOUNDS_LAVA, SoundSource.WEATHER, CoolRainConfig.evaporativeBlocksVolume, 1.0F, true);
				world.playLocalSound(pos, SoundEvents.WEATHER_RAIN, SoundSource.WEATHER, CoolRainConfig.vanillaRainVolume, world.getRandom().nextIntBetweenInclusive(8, 12) * 0.1f, false);
			} else {
				world.playLocalSound(pos, SoundEvents.WEATHER_RAIN, SoundSource.WEATHER, CoolRainConfig.vanillaRainVolume, 1.0F, false);
			}
		}
	}


	@Inject(at = @At("TAIL"), method = "tickRainParticles")
	private void stormSoundEffects(ClientLevel world, Camera camera, int ticks,
			ParticleStatus particlesMode, int weatherRadius, CallbackInfo ci) {
		BlockPos cameraPos = BlockPos.containing(Minecraft.getInstance().gameRenderer.getMainCamera().position());
        assert world != null;
        if(world.isThundering() && camera.position().y() > 64 && world.isRainingAt(cameraPos)){
			if(world.getRandom().nextInt(CoolRainConfig.thunderstormWindsFrequency) == 0 && CoolRainConfig.thunderstormWinds){
				world.playLocalSound(cameraPos.getX() + world.getRandom().nextIntBetweenInclusive(-10, 10), cameraPos.getY(), cameraPos.getZ() + world.getRandom().nextIntBetweenInclusive(-10, 10),
						CoolRainSounds.WIND_SOUNDS, SoundSource.WEATHER, CoolRainConfig.thunderstormWindsVolume, world.getRandom().nextIntBetweenInclusive(8, 12) * 0.1f, true);
			}
			if(world.getRandom().nextInt(CoolRainConfig.additionalThunderFrequency) == 0 && CoolRainConfig.additionalThunderSounds){
				world.playLocalSound(cameraPos.getX() + world.getRandom().nextIntBetweenInclusive(-50, 50), cameraPos.getY() + 30, cameraPos.getZ() + world.getRandom().nextIntBetweenInclusive(-50, 50),
						CoolRainSounds.ROLLING_THUNDER, SoundSource.WEATHER, CoolRainConfig.additionalThunderVolume, world.getRandom().nextIntBetweenInclusive(8, 12) * 0.1f, true);
			}
		}
	}

}