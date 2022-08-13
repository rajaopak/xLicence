package dev.rajaopak.xlicence;

import org.bukkit.plugin.java.JavaPlugin;

public final class XLicence extends JavaPlugin {

    private static XLicence instance;

    private boolean firstRun = true;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        if (getDataFolder().exists()) {
            firstRun = false;
        }

        if (firstRun) {
            firstRun = false;
            saveDefaultConfig();
            getLogger().info("Its your first run, config.yml has been generated.");
            getLogger().info("Please enter your license key in config.yml.");
            getLogger().info("After that, restart your server.");
            getLogger().info("Thank you for using this plugin.");
            return;
        }

        saveDefaultConfig();
        if (!new AdvancedLicense(getConfig().getString("licence"), "https://mc-challenge.com/xlicence/verify.php", this).setSecurityKey("7w@hDaq49rFVscz!Djks*ZADSo^udR83qEwuI").register())
            return;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static XLicence getInstance() {
        return instance;
    }

    public static boolean isLicenseValid() {
        return new AdvancedLicense(getInstance().getConfig().getString("licence"),
                "https://mc-challenge.com/xlicence/verify.php", getInstance())
                .setSecurityKey("7w@hDaq49rFVscz!Djks*ZADSo^udR83qEwuI").isValidSimple();
    }
}
