package me.justahuman.recently_connected;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;

public class RecentlyConnected implements ClientModInitializer {
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitializeClient() {
        LOGGER.info("Starting RecentlyConnected");
    }
}
