package net.sweenus.simplyswords;

import com.google.gson.JsonObject;
import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.sweenus.simplyswords.config.Config;
import net.sweenus.simplyswords.config.SimplySwordsConfig;
import net.sweenus.simplyswords.registry.EffectRegistry;
import net.sweenus.simplyswords.registry.ItemsRegistry;
import net.sweenus.simplyswords.registry.SoundRegistry;
import net.sweenus.simplyswords.util.ModLootTableModifiers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class SimplySwords {
    public static final String MOD_ID = "simplyswords";
    // Registering a new creative tab
    //public static final ItemGroup SIMPLYSWORDS = CreativeTabRegistry.create(new Identifier(MOD_ID, "simplyswords"), () ->
            //new ItemStack(ItemsRegistry.RUNIC_TABLET.get()));

    public static final CreativeTabRegistry.TabSupplier SIMPLYSWORDS = CreativeTabRegistry.create(new Identifier(MOD_ID, "simplyswords"),
            () -> new ItemStack(ItemsRegistry.RUNIC_TABLET.get()));

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static boolean isConfigOutdated;

    public static void init() {

        //CONFIG

        SimplySwordsConfig.init();

        String version = SimplySwordsExpectPlatform.getVersion();
        String defaultConfig = String.format("""
                {
                  "regen_simplyswords_config_file": false,
                  "config_version": %s
                }""", version.substring(0, 4));

        File configFile = Config.createFile("config/simplyswords/backupconfig.json", defaultConfig, false);
        JsonObject json = Config.getJsonObject(Config.readFile(configFile));
        if (json.has("config_version")) {
            if (version.startsWith(json.get("config_version").getAsString())) {
                isConfigOutdated = false;
            }
            else {
                isConfigOutdated = true;
                System.out.println("SimplySwords: It looks like you've updated from a previous version. Please regenerate the Simply Swords configs to get the latest features.");
                //System.out.println(version.substring(0, 4));
            }
        }
        else {
            isConfigOutdated = true;
            System.out.println("SimplySwords: It looks like you've updated from a previous version. Please regenerate the Simply Swords configs to get the latest features.");
            //System.out.println(version.substring(0, 4));
        }

        SimplySwordsConfig.generateConfigs(json == null || !json.has("regen_simplyswords_config_file") || json.get("regen_simplyswords_config_file").getAsBoolean());
        SimplySwordsConfig.loadConfig();


        ItemsRegistry.ITEM.register();
        SoundRegistry.SOUND.register();
        EffectRegistry.EFFECT.register();
        ModLootTableModifiers.init();
        //Don't announce via in-game chat because that's kinda annoying
        //ClientPlayerEvent.CLIENT_PLAYER_JOIN.register(new EventGameStart());
        
        System.out.println(SimplySwordsExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());

    }
}
