package dr.rebate.main;

public class Messages {
	String notify = Startup.getPlugin().getConfig().getString("Notify").replaceAll("(&([a-f0-9]))", "\u00A7$2");
	String messageColor = Startup.getPlugin().getConfig().getString("MsgColor").replaceAll("(&([a-f0-9]))", "\u00A7$2");
	String NameColor = Startup.getPlugin().getConfig().getString("NameColor").replaceAll("(&([a-f0-9]))", "\u00A7$2");
	String commandSpy = Startup.getPlugin().getConfig().getString("CmResultPrefix").replaceAll("(&([a-f0-9]))", "\u00A7$2");

	public String formatPlaytime(String playtime, String playerName, String whoAsked) {
		if(playerName.equalsIgnoreCase(whoAsked)) {
			playtime = notify + " " + NameColor + "You" + messageColor + " Have Played " + NameColor + playtime + ".";
		}else{
			playtime = notify + " " + NameColor + playerName + messageColor + " Has Played " + NameColor + playtime + ".";
		}
		return playtime;
	}
	
	public String formatSpyMsg(String action) {
		String msg = "";
		
		switch(action) {
		
		case "remove":
			msg = notify + " " + messageColor + "CommandSpy " + NameColor + "Disabled";
			break;
		case "add":
			msg = notify + " " + messageColor + "CommandSpy" + NameColor + " Enabled";
			break;
		}
		return msg;
	}
	
	public String formatCmMsg(String cmExecuted, String whoExecuted) {
		String msg = commandSpy + " " + NameColor + whoExecuted + messageColor + ": " + NameColor + cmExecuted + messageColor + ".";
		return msg;
	}
	
	public String returnNoPlayer() {
		return notify + messageColor + "You are not allowed to check offline players time due to " + NameColor + "Data Loss";
	}
}
