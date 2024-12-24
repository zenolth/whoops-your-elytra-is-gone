package net.zenolth.whoops_your_elytra_is_gone.common.config;

import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.zenolth.whoops_your_elytra_is_gone.common.Whoops_your_elytra_is_gone;

import java.io.Serial;

public class Config {
    public static ConfigClassHandler<Config> HANDLER = ConfigClassHandler.createBuilder(Config.class)
            .id(Identifier.of(Whoops_your_elytra_is_gone.MOD_ID,"elytra_spawn_config"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve("whoops_your_elytra_is_gone.json5"))
                    .appendGsonBuilder(GsonBuilder::setPrettyPrinting)
                    .setJson5(true)
                    .build())
            .build();

    @SerialEntry(comment = "Chance that an elytra will spawn in an end ship\nShould be value between 0 and 1, where 0 is 0% and 1 is 100%")
    public float elytraSpawnChance = 0.2f;

    public static Config get() {
        load();
        return HANDLER.instance();
    }

    public static void save() {
        HANDLER.save();
    }

    public static void load() {
        HANDLER.load();
    }
}