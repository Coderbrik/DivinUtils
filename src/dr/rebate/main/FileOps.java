package dr.rebate.main;

import org.bukkit.configuration.file.FileConfiguration;

public class FileOps {
	FileConfiguration conf = Startup.getPlugin().getConfig();
	
	public static void saveConfig() {
		Startup.getPlugin().saveConfig();
	}
	
	public static void reloadConfig() {
		Startup.getPlugin().reloadConfig();
	}
	
	public String getString(String toGet) {
		return conf.getString(toGet);
	}
	
	public int getInt(String toGet) {
		return conf.getInt(toGet);
	}
	
	public boolean getBoolean(String toGet) {
		return conf.getBoolean(toGet);		
	}
}
