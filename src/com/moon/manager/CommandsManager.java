package com.moon.manager;

import com.moon.Moon;
import com.moon.spawn.commands.SetSpawnCommand;
import com.moon.spawn.commands.SpawnCommand;

public class CommandsManager {

    private SetSpawnCommand setSpawnCommand = new SetSpawnCommand();
    private SpawnCommand spawnCommand = new SpawnCommand();

    public CommandsManager (Moon moon) {
        moon.getInstance().getCommand("setspawn").setExecutor(setSpawnCommand);
        moon.getInstance().getCommand("spawn").setExecutor(spawnCommand);
    }

}
