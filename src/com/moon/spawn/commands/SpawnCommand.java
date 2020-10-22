package com.moon.spawn.commands;

import com.moon.Moon;
import com.moon.spawn.Spawn;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpawnCommand implements CommandExecutor {

    private Spawn spawn = new Spawn();

    private HashMap<Player, Long> cooldown = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (!player.hasPermission("moon.commands.spawn")) {
            for(String message : Moon.getInstance().getConfig().getStringList("mensagens.permission")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                player.playSound(player.getLocation(), Sound.CAT_MEOW, 1.0f, 1.0f);
            }
            return true;
        }
        if (args.length == 0) {

            if (cooldown.containsKey(player) && !(System.currentTimeMillis() >= cooldown.get(player))) {
                player.sendMessage(" ");
                player.sendMessage(" §c§lOPS! §cEspere " + cooldownConverter(player) + " segundos para executar este comando.");
                player.sendMessage(" ");
                player.playSound(player.getLocation(), Sound.CAT_MEOW, 1.0f, 1.0f);
                return false;
            } else {
                cooldown.remove(player);
            }

            cooldown.put(player, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(3));

            player.teleport(spawn.getSpawn());

            for(String message : Moon.getInstance().getConfig().getStringList("mensagens.spawn")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 1.0f, 1.0f);
            }
        }
        return false;
    }

    private Long cooldownConverter (Player player) {
        long temp = System.currentTimeMillis() - cooldown.get(player);
        return 1 + TimeUnit.MILLISECONDS.toSeconds(temp * -1);
    }

}
