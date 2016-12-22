package dr.rebate.staff;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import dr.rebate.main.FileOps;

public class ServerChatClear extends Formatting implements CommandExecutor {
	FileOps files = new FileOps();
	
	
	public boolean onCommand(CommandSender cs, Command cm, String alias, String[] args) {
		if(cm.getName().equalsIgnoreCase("scc")) {
			if(args.length < 0) {
			}
		}
	}
	
	private void clearServerChat() {
		for(int i = 0; i < )
		
	}
}
