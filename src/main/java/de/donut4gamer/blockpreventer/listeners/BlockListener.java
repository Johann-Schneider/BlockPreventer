package de.donut4gamer.blockpreventer.listeners;

import de.donut4gamer.blockpreventer.BlockPreventer;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener {

    private final BlockPreventer plugin;

    public BlockListener(BlockPreventer plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        String gmString = plugin.getConfig().getString("Gamemode");
        String bypassPermission = plugin.getConfig().getString("BypassPermission", "blockpreventer.bypass");

        if (player.hasPermission(bypassPermission)) {
            return;
        }

        try {
            GameMode configuredGM = GameMode.valueOf(gmString.toUpperCase());
            if (player.getGameMode().equals(configuredGM)) {
                event.setCancelled(true);
            }
        } catch (IllegalArgumentException e) {
            plugin.getLogger().warning("Unknown gamemode in the config.yml! Please use SURVIVAL, CREATIVE or ADVENTURE.");
        }
    }
}
