package me.rang.checkthrow.checkthrow;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CheckThrow extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CheckThrowListener(this), this);
        getCommand("qtoggle").setExecutor(new CheckThrowCommand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
