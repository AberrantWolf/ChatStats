package net.rynban.mcp_test;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;
import java.util.logging.Logger;

public class ChatStats_ChatListener implements Listener {
    private Logger _logger;

    ChatStats_ChatListener(Logger logger) {
        _logger = logger;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(ChatColor.AQUA + "Hi there, " + event.getPlayer().getDisplayName());
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        String msg = event.getMessage();
        event.setMessage(randoCapital(msg));
    }

    private String randoCapital(String src)
    {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(src.length());

        for (char c : src.toCharArray()) {
            sb.append(rnd.nextBoolean() ? Character.toUpperCase(c) : Character.toLowerCase(c));
        }

        return sb.toString();
    }
}
