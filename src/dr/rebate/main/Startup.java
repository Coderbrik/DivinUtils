package dr.rebate.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dr.rebate.commands.Playtime;
import dr.rebate.staff.CommandSpy;

public class Startup extends JavaPlugin {

	private static Startup plugin;

	@Override
	public void onEnable() {
		Startup.plugin = this;

		registerCommands();
		registerInstances();
		registerEvents();
		setupConfig();
	}
	@Override
	public void onDisable() {}

	private void setupConfig() {

		if(!new File(getDataFolder(), "config.yml").exists()) { 
			saveDefaultConfig();
		}
	}

	private void registerCommands() {
		getCommand("playtime").setExecutor(new Playtime());
	}

	private void registerEvents() {}

	private void registerInstances() {
		CommandSpy spy = new CommandSpy();
		getCommand("commandspy").setExecutor(spy);
		Bukkit.getServer().getPluginManager().registerEvents(spy, this);
	}

	public static Startup getPlugin() {	return plugin; }

	public static void setPlugin(Startup plugin) {
		Startup.plugin = plugin;
	}
}
