package me.hephaestus.uuidchecket;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class UUIDChecket extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //in the getCommand() you need to add what you want the command to be in ""
        //instead of new UUIDCheckerCommand you need to call forward the name of your command class
        getCommand("uuid").setExecutor(new UUIDCheckerCommand());
        PluginManager pluginManager = getServer().getPluginManager();
        Permission yourPermission = new Permission("UUIDChecker.uuid");
        pluginManager.addPermission(yourPermission);


    }
}
