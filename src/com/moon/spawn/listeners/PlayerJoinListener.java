package com.moon.spawn.listeners;

import com.moon.spawn.Spawn;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private Spawn spawn = new Spawn();

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onJoin (PlayerJoinEvent event) {
        boolean active = true;
        if (active) {
            Player player = event.getPlayer();
            player.teleport(spawn.getSpawn());
        }
    }

}
