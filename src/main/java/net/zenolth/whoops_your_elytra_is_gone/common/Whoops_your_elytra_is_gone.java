package net.zenolth.whoops_your_elytra_is_gone.common;

import net.fabricmc.api.ModInitializer;
import net.zenolth.whoops_your_elytra_is_gone.common.config.Config;

public class Whoops_your_elytra_is_gone implements ModInitializer {

    public static final String MOD_ID = "wyeig";

    @Override
    public void onInitialize() {
        Config.load();
    }
}
