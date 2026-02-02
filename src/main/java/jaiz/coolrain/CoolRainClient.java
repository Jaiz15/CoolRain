package jaiz.coolrain;

import eu.midnightdust.lib.config.MidnightConfig;
import jaiz.coolrain.config.CoolRainConfig;
import net.fabricmc.api.ClientModInitializer;

public class CoolRainClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MidnightConfig.init("coolrain", CoolRainConfig.class);
		CoolRainSounds.registerSounds();
	}
}