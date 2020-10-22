package com.moon.spawn.commands;

import com.moon.Moon;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MoonSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            Moon.getInstance().reloadConfig();
            sender.sendMessage(" ");
            sender.sendMessage(" §a§lYAY! §aAs configurações foram recarregadas.");
            sender.sendMessage(" ");
        }
        return false;
    }
}
