package org.styllex.setting;

import org.bukkit.entity.Player;
import org.bukkit.event.player.*;
import org.styllex.main.Base;

public class JoinListener extends PlayerListener{
	public Base plugin;
	public JoinListener(Base plugin){
		this.plugin=plugin;
	}
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		this.plugin.sqls.loadStats(player);
	}
}
