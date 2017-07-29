package net.rynban.mcp_test;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SerializableAs("Config")
public class ChatStats_Config implements ConfigurationSerializable {
    public ArrayList<ChatStats_StatModifiers> wordList = new ArrayList<>();

    ChatStats_Config() {
        id = total;
        total++;
    }

    public int getId() {return id;}

    private int id;
    private static int total = 0;

    public ChatStats_Config(Map<String, Object> map) {
        id = total;
        total++;

        Object oWordList = map.get("wordList");
        System.out.println("Found word list containing: " + oWordList.getClass().getName());

//        for (String key : map.get("wordList")) {
//            System.out.println("Found key: " + key + " with type " + map.get(key).getClass().getName());
//            ChatStats_StatModifiers mod = new ChatStats_StatModifiers(map.get("word"))
//        }
    }

    @Override
    public Map<String, Object> serialize() {
        System.out.println("Serializing ChatStats_Config " + id);
        HashMap<String, Object> result = new HashMap<>();

        result.put("wordList", wordList);

        return result;
    }
}
