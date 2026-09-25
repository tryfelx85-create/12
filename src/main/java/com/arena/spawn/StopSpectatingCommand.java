package com.arena.spawn;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StopSpectatingCommand implements CommandExecutor {

    // Where a player lands after leaving spectator mode
    private static final double SPAWN_X = 32, SPAWN_Y = 10, SPAWN_Z = 66;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        World world = player.getWorld();
        player.setGameMode(GameMode.ADVENTURE);
        player.teleport(new Location(world, SPAWN_X, SPAWN_Y, SPAWN_Z));
        player.sendMessage("§7You have left spectator mode.");
        return true;
    }
}
