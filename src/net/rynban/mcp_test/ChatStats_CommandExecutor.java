package net.rynban.mcp_test;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChatStats_CommandExecutor implements CommandExecutor {
    private ChatStats_Plugin _plugin;

    ChatStats_CommandExecutor(ChatStats_Plugin plugin) {
        _plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] strings) {
        final String ERROR_CHAT = ChatColor.RED.toString() + ChatColor.ITALIC;
        if (command.getName().equalsIgnoreCase("testme")) {
            commandSender.sendMessage("Hey, it worked!");
            for (String s : strings) {
                commandSender.sendMessage("An argument: " + s);
            }
            return true;
        } else if (command.getName().equalsIgnoreCase("addstatword")) {
            commandSender.sendMessage(ERROR_CHAT + "TODO: add stat words!");
            return true;
        } else if (command.getName().equalsIgnoreCase("addxpword")) {
            commandSender.sendMessage(ERROR_CHAT + "TODO: add XP words!");
            return true;
        } else if (command.getName().equalsIgnoreCase("statwords")) {
            commandSender.sendMessage(ERROR_CHAT + "TODO: list all stat words!");
            commandSender.sendMessage(ERROR_CHAT + "TODO: also offer 'verbose' mode options!");
            return true;
        }

        return false;
    }
}
