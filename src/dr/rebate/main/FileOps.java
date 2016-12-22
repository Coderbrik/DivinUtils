package dr.rebate.main;

public class FileOps {
	public void saveConfig() {
		Startup.getPlugin().saveConfig();
	}
	
	public void reloadConfig() {
		Startup.getPlugin().reloadConfig();
	}
}
