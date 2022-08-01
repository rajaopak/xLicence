package dev.rajaopak.xlicence;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class XLicence extends JavaPlugin {

    private static final List<String> licences = List.of(
            "JS9EN-X7K3B-J9N26-NS8D2-JS9N7",
            "0WDIW-ALD72-AK6ED-2EZU2-DW9AM",
            "9JDJF-E5HFU-DN8IH-FU3HD-YE44E",
            "2QW9E-0SKOP-IJFKO-SNWIQ-AODS9",
            "R467G-4ROKP-89UIJ-QW2SM-NJK0P");

    private static XLicence instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();
        if (!licences.contains(getConfig().getString("licence"))) {
            Bukkit.getPluginManager().disablePlugin(this);
            Bukkit.getLogger().severe("Your license is invalid!");
        } else {
            Bukkit.getLogger().info("Your license is valid!");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static XLicence getInstance() {
        return instance;
    }

    public static boolean isLicence(String licence) {
        return licences.contains(licence);
    }

    public static void init(Plugin plugin) {
        if (!isLicence(XLicence.getInstance().getConfig().getString("licence"))) {
            Bukkit.getPluginManager().disablePlugin(plugin);
        }
    }
}