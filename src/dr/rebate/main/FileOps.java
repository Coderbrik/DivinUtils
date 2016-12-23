package dr.rebate.main;

import org.bukkit.configuration.file.FileConfiguration;

public class FileOps {
	public static FileConfiguration conf = Startup.getPlugin().getConfig();
	
	public static void saveConfig() {
		Startup.getPlugin().saveConfig();
	}
	
	public static void reloadConfig() {
		Startup.getPlugin().reloadConfig();
	}
}
