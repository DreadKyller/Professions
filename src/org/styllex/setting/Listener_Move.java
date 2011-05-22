package org.styllex.setting;


import org.bukkit.event.player.*;
import org.styllex.main.Base;

public class Listener_Move extends PlayerListener{
	public Base plugin;
	public Listener_Move(Base plug){
		this.plugin=plug;
	}
	public void onPlayerMove(PlayerMoveEvent event){
		if(this.plugin.enabled==true){
			if(!(this.plugin.chosen.containsKey(event.getPlayer()))){
				event.getPlayer().sendMessage("You Can Not Move Until You Choose A Class");
				event.getPlayer().sendMessage("/profession <ClassName>");
				event.getPlayer().teleport(event.getFrom());
				event.setCancelled(true);
			}
		}
	}
}
