package org.styllex.setting;

import org.bukkit.event.player.*;
import org.styllex.main.Base;


public class AntiHackKick extends PlayerListener{
	public Base plugin;
	public AntiHackKick(Base plug){
		this.plugin=plug;
	}
	public void onPlayerKick(PlayerKickEvent event){
		if(event.getLeaveMessage().equalsIgnoreCase("you moved too quickly :( (Hacking?)")||event.getReason().equalsIgnoreCase("you moved too quickly :( (Hacking?)")){
			event.setCancelled(true);
		}
	}
}
