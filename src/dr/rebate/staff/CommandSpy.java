package dr.rebate.staff;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import dr.rebate.main.Formatting;
import dr.rebate.main.Startup;

public class CommandSpy extends Formatting implements CommandExecutor, Listener {
	FileConfiguration conf = Startup.getPlugin().getConfig();
	List<Player>spys = new ArrayList<Player>();

	public boolean onCommand(CommandSender cs, Command cm, String alias, String[] args) {
		if(cs instanceof Player) {
			Player player = (Player) cs;
			if(cm.getName().equalsIgnoreCase("commandspy")) {
				if(spys.contains(player)) {
					spys.remove(player);

					conf.set(player.getUniqueId().toString() + ".settings.cmspy", false);
					super.saveConfig();
					super.reloadConfig();

					cs.sendMessage(super.formatSpyMsg("remove"));
				}else{
					spys.add(player);

					Startup.getPlugin().getConfig().set(player.getUniqueId().toString() + ".settings.cmspy", true);
					super.saveConfig();
					super.reloadConfig();

					cs.sendMessage(super.formatSpyMsg("add"));
				}
			}
		}
		return true;
	}
	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
		String cmExecuted = e.getMessage();
		String whoExecuted = e.getPlayer().getName();

		int spysSize = spys.size();

		for(int i = 0; i < spysSize; i ++) {
			if(!whoExecuted.equalsIgnoreCase(spys.get(i).getName())) {
				spys.get(i).sendMessage(super.formatCmMsg(cmExecuted, whoExecuted));
			}
		}
	}
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) { 
		if(spys.contains(e.getPlayer())) {
			spys.remove(e.getPlayer());
		}
	}
    @EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if(conf.getBoolean(e.getPlayer().getUniqueId().toString() + ".settings.cmspy")) {
			spys.add(e.getPlayer());
			e.getPlayer().sendMessage(super.formatSpyMsg("add"));
		}
	}
}
