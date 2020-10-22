package com.moon.manager;

import com.moon.Moon;
import com.moon.spawn.listeners.PlayerJoinListener;
import com.moon.spawn.listeners.PlayerRespawnListener;
import org.bukkit.Bukkit;

public class ListenersManager {

    private PlayerJoinListener playerJoinListener = new PlayerJoinListener();
    private PlayerRespawnListener playerRespawnListener = new PlayerRespawnListener();

    public ListenersManager (Moon moon) {
        Bukkit.getPluginManager().registerEvents(playerJoinListener, moon);
        Bukkit.getPluginManager().registerEvents(playerRespawnListener, moon);
    }

}
