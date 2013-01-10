package bstramke.OresDropMores2.Client;

import net.minecraftforge.client.MinecraftForgeClient;
import bstramke.OresDropMores2.Common.CommonProxy;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderThings() {
		MinecraftForgeClient.preloadTexture(CommonProxy.ITEMS_PNG);
	}
}
