package net.rynban.mcp_test;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ChatStats_Plugin extends JavaPlugin {
    private Logger _logger;
    private ChatStats_CommandExecutor _commandEx;

    @Override
    public void onEnable() {
        System.out.println("HIYA!!!");
        _logger = getLogger();
        _logger.info("onEnable has been invoked!");
        getServer().getPluginManager().registerEvents(new ChatStats_ChatListener(_logger), this);

        File dataFolder = getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }
        saveDefaultConfig();
        ConfigurationSerialization.registerClass(ChatStats_Config.class, "Config");

        Object csc = getConfig().get("config");
        if (csc == null) {
            getLogger().info("Loading the config object yielded null");
        } else if (!(csc instanceof ChatStats_Config)) {
            getLogger().info("Loaded config is not a ChatStats_Config, but rather" + csc.getClass().toString());
        } else {
            getLogger().info("Loaded config correctly: " + ((ChatStats_Config) csc).getId());
        }
//
//        FileConfiguration config = new YamlConfiguration();
//        config.set("config", new ChatStats_Config());
//        try {
//            config.save(dataFolder + "/testFile.yml");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        config = YamlConfiguration.loadConfiguration(new File(dataFolder + "/testFile.yml"));
//        Object data = (ChatStats_Config) config.get("data");
//        if (data == null) {
//            getLogger().info("Loading the config object yielded null");
//        } else if (!(csc instanceof ChatStats_Config)) {
//            getLogger().info("Loaded config is not a ChatStats_Config, but rather" + data.getClass().toString());
//        }

        _commandEx = new ChatStats_CommandExecutor(this);
        getCommand("testme").setExecutor(_commandEx);
        getCommand("addstatword").setExecutor(_commandEx);
        getCommand("addxpword").setExecutor(_commandEx);
        getCommand("statwords").setExecutor(_commandEx);
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable has been invoked!");
        //ConfigurationSerialization.unregisterClass(ChatStats_Config.class);
    }

}
