package net.rynban.mcp_test;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

import java.util.HashMap;
import java.util.Map;

@SerializableAs("StatModifiers")
public class ChatStats_StatModifiers implements ConfigurationSerializable {
    public String wordKey = "DEFAULT_WORD_KEY";
    public HashMap<String, Float> modifiers = new HashMap<>();

    public ChatStats_StatModifiers(HashMap<String, Object> init) {
        System.out.println("Initializing stat modifiers");
    }

    public Map<String, Object> serialize() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("statName", wordKey);
        result.put("modifiers", modifiers);

        return result;
    }
}
