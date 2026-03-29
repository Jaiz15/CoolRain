package jaiz.coolrain;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class CoolRainSounds {

    public static final SoundEvent RAIN_SOUNDS_METAL = registerSoundEvent("rain_sounds_metal");
    public static final SoundEvent RAIN_SOUNDS_FOLIAGE = registerSoundEvent("rain_sounds_foliage");
    public static final SoundEvent RAIN_SOUNDS_FABRIC = registerSoundEvent("rain_sounds_fabric");
    public static final SoundEvent RAIN_SOUNDS_GLASS = registerSoundEvent("rain_sounds_glass");
    public static final SoundEvent RAIN_SOUNDS_WATER = registerSoundEvent("rain_sounds_water");
    public static final SoundEvent RAIN_SOUNDS_LAVA = registerSoundEvent("rain_sounds_lava");
    public static final SoundEvent RAIN_SOUNDS_AMETHYST = registerSoundEvent("rain_sounds_amethyst");
    public static final SoundEvent RAIN_SOUNDS_NOTEBLOCK = registerSoundEvent("rain_sounds_noteblock");


    public static final SoundEvent WIND_SOUNDS = registerSoundEvent("wind_sounds");
    public static final SoundEvent ROLLING_THUNDER = registerSoundEvent("rolling_thunder");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.fromNamespaceAndPath("coolrain", name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void registerSounds() {
    }
}
