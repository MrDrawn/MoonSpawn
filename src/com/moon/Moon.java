package com.moon;

import com.moon.manager.CommandsManager;
import com.moon.manager.ListenersManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Moon extends JavaPlugin {

    private static Moon instance;

    @Override
    public void onEnable() {
        instance = this;
        loadConfiguration();
        new CommandsManager(this);
        new ListenersManager(this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static Moon getInstance() {
        return instance;
    }

    private void loadConfiguration () {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

}
