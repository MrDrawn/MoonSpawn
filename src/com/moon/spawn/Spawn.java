package com.moon.spawn;

import com.moon.Moon;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class Spawn {

    public Location getSpawn() {
        String string = Moon.getInstance().getConfig().getString("spawn.world");

        if(string == null || string.equalsIgnoreCase("")) {
            return null;

        } else {
            World w = Bukkit.getServer().getWorld(string);
            double x = Moon.getInstance().getConfig().getDouble("spawn.x");
            double y = Moon.getInstance().getConfig().getDouble("spawn.y");
            double z = Moon.getInstance().getConfig().getDouble("spawn.z");
            float yaw = Moon.getInstance().getConfig().getInt("spawn.yaw");
            float pitch = Moon.getInstance().getConfig().getInt("spawn.pitch");

            return new Location(w, x, y, z, yaw, pitch);
        }

    }

    public void setSpawn(Location location) {
        Moon.getInstance().getConfig().set("spawn.world", location.getWorld().getName());
        Moon.getInstance().getConfig().set("spawn.x", location.getX());
        Moon.getInstance().getConfig().set("spawn.y", location.getY());
        Moon.getInstance().getConfig().set("spawn.z", location.getZ());
        Moon.getInstance().getConfig().set("spawn.yaw", (float) location.getYaw());
        Moon.getInstance().getConfig().set("spawn.pitch", (float) location.getPitch());

        Moon.getInstance().saveConfig();
    }



}
