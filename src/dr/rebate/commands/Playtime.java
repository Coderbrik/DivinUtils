package dr.rebate.commands;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dr.rebate.main.Startup;

public class Playtime implements CommandExecutor {

	Player player;
	@Override
	public boolean onCommand(CommandSender cs, Command cm, String alias, String[] args) {
		if(cs instanceof Player) {
			if(cm.getName().equalsIgnoreCase("playtime")) {
				if(args.length > 0) {
					cs.sendMessage(getTime(args[0], cs.getName()));
				}else{
					cs.sendMessage(getTime(cs.getName(), cs.getName()));
				}
			}
		}
		return true;
	}

	private String getTime(String playername, String whoAsked) {
		String time;
		if(Bukkit.getServer().getPlayer(playername) != null) {
			Player player = Bukkit.getServer().getPlayer(playername);

			time = Startup.getAlgorithms().convertTicksToTimeUnits(player.getStatistic(Statistic.PLAY_ONE_TICK) / 23);
			time = Startup.getMessages().getFormattedPlaytime(time, playername, whoAsked);
		}else{
			time = Startup.getMessages().getNoPlayerMessage();
		}
		return time;
	}
}
