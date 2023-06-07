package me.hephaestus.uuidchecker;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UUIDCheckerCommand implements CommandExecutor {
    private final String permission = "UUIDChecker.uuid";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if the sender has the required permission
        if (!sender.hasPermission(permission)) {
            sender.sendMessage("You do not have permission to use this command.");
            return true;
        }

        // Check if the command is properly used with a player argument
        if (args.length == 0) {
            sender.sendMessage("Usage: /uuid <player>");
            return true;
        }

        // Get the player name from the command arguments
        String playerName = args[0];
        Player player = Bukkit.getPlayer(playerName);

        // Check if the player exists
        if (player != null) {
            // Player is online, retrieve and display the UUID
            String uuid = player.getUniqueId().toString();
            sender.sendMessage("UUID of " + playerName + " is: " + uuid);
        } else {
            // Player is offline, retrieve and display the UUID
            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(playerName);
            String uuid = getUUID(offlinePlayer);
            if (uuid.isEmpty()) {
                sender.sendMessage("UUID of " + playerName + " is not available.");
            } else {
                sender.sendMessage("UUID of " + playerName + " is: " + uuid);
            }
        }

        return true;
    }

    // Method to retrieve the UUID of an offline player
    private String getUUID(OfflinePlayer p) {
        if (!p.hasPlayedBefore()) {
            return "";
        }

        return p.getUniqueId().toString();
    }

}
