package com.moon.spawn.listeners;

import com.moon.spawn.Spawn;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {

    private Spawn spawn = new Spawn();

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onRespawn (PlayerRespawnEvent event) {
        boolean active = true;
        if (active) {
            event.setRespawnLocation(spawn.getSpawn());
        }
    }

}
