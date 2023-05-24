package me.hephaestus.uuidchecket;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UUIDCheckerCommand implements CommandExecutor {
    private final String permission = "UUIDChecker.uuid";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission(permission)) {
            sender.sendMessage("You do not have permission to use this command.");
            return true;
        }
        //for if the player lacks the permission
        if (args.length == 0) {
            sender.sendMessage("Usage: /uuid <player>");
            return true;
        }
        //for if the command is improperly used
        String playerName = args[0];
        Player player = Bukkit.getPlayer(playerName);

        if (player == null) {
            sender.sendMessage("Player not found.");
            return true;
        }
        //if the player doesn't exist
        String uuid = player.getUniqueId().toString();
        sender.sendMessage("UUID of " + playerName + " is: " + uuid);
        return true;
        //if everything goes right
    }
}
