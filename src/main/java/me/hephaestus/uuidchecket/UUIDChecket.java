package me.hephaestus.uuidchecket;

import org.bukkit.plugin.java.JavaPlugin;

public final class UUIDChecket extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("uuid").setExecutor(new UUIDCheckerCommand());

    }
}
