package me.crazyrealms.crazyenchants;

import me.crazyrealms.crazyenchants.commands.Enchanter;
import me.crazyrealms.crazyenchants.listeners.BlockBreak;
import me.crazyrealms.crazyenchants.listeners.EntityDamage;
import me.crazyrealms.crazyenchants.listeners.PlayerInteract;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

//Main class
public class CrazyEnchants extends JavaPlugin {
    private static String prefix = ChatColor.DARK_AQUA + "CrazyEnchants » " + ChatColor.GRAY;

    public void onEnable() {
        Enchanter enchanter = new Enchanter();
        Bukkit.getPluginCommand("enchanter").setExecutor(enchanter);
        Bukkit.getPluginManager().registerEvents(enchanter, this);
        Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteract(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamage(), this);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new CheckEnchants(), 0, 5);
    }

    public static String getPrefix() {
        return prefix;
    }
}
