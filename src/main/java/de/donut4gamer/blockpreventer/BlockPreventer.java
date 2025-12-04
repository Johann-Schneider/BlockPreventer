package de.donut4gamer.blockpreventer;

import de.donut4gamer.blockpreventer.listeners.BlockListener;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockPreventer extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockListener(this), this);

        getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&6BlockPreventer &8× &7Plugin enabled &8- &7Version: &6v" + getDescription().getVersion()));
        getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&6BlockPreventer &8× &7Developed by &6Donut4GAMER"));

        loadConfig();
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&6BlockPreventer &8× &7Plugin disabled"));
        getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&6BlockPreventer &8× &7Developed by &6Donut4GAMER"));
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }
}
