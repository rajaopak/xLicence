package id.rajaopak.xlicence;

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

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static List<String> getLicences() {
        return licences;
    }

    public static boolean isLicence(String licence) {
        return licences.contains(licence);
    }

    public static void init(Plugin plugin, String licence) {
        if (!isLicence(licence)) {
            plugin.getLogger().severe("Your license is invalid!");
            Bukkit.getPluginManager().disablePlugin(plugin);
            throw new IllegalArgumentException("Invalid licence");
        } else {
            plugin.getLogger().info("Your license is valid!");
        }
    }
}
