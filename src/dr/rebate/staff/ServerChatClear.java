package dr.rebate.staff;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import dr.rebate.main.FileOps;
import dr.rebate.main.Startup;

public class ServerChatClear implements CommandExecutor {
	
	
	@Override
	public boolean onCommand(CommandSender cs, Command cm, String alias, String[] args) {
		if(cm.getName().equalsIgnoreCase("scc")) {
			if(args.length < 0) {
				clearServerChat(cs.getName());
			}
		}
		return true;
	}
	
	private void clearServerChat(String name) {
		for(int i = 0; i < FileOps.conf.getInt("Clear Amount"); i++) {
			Bukkit.getServer().broadcastMessage("");
		}
		
		Bukkit.getServer().broadcastMessage(Startup.getMessages().getChatClearMessage("s", name));
	}
}
