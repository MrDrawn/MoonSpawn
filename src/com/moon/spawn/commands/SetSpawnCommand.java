package com.moon.spawn.commands;

import com.moon.Moon;
import com.moon.spawn.Spawn;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private Spawn spawn = new Spawn();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (!player.hasPermission("moon.commands.spawn.setspawn")) {
            for(String message : Moon.getInstance().getConfig().getStringList("mensagens.permission")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                player.playSound(player.getLocation(), Sound.CAT_MEOW, 1.0f, 1.0f);
            }
            return true;
        }
        if (args.length == 0) {
            spawn.setSpawn(player.getLocation());
            for(String message : Moon.getInstance().getConfig().getStringList("mensagens.setspawn")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 1.0f, 1.0f);
            }
        }
        return false;
    }
}
