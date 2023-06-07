package me.hephaestus.uuidchecker;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class UUIDChecker extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //in the getCommand() you need to add what you want the command to be in ""
        //instead of new UUIDCheckerCommand you need to call forward the name of your command class
        getCommand("uuid").setExecutor(new UUIDCheckerCommand());
        //the following code is how to make it so luckperms registers the permission
        PluginManager pluginManager = getServer().getPluginManager();
        //the new permission is the name of the permission
        Permission yourPermission = new Permission("UUIDChecker.uuid");
        //where you add the permission
        pluginManager.addPermission(yourPermission);


    }
}
