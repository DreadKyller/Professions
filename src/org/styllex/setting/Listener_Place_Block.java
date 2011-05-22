package org.styllex.setting;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.*;
import org.styllex.main.Base;

public class Listener_Place_Block extends BlockListener{
	public Base plugin;
	public Listener_Place_Block(Base plug){
		this.plugin=plug;
	}
	public void onPlaceBreak(BlockPlaceEvent event){
		Player player = event.getPlayer();
		if(this.plugin.chosen.containsKey(player)){
			if(hasPerm(event.getBlock().getType(), this.plugin.chosen.get(player).getTypeName())){
				this.plugin.blocks.put(player, this.plugin.blocks.get(player)+2);
				if(this.plugin.blocks.get(player)>=this.plugin.lvl_2){
					if(this.plugin.levels.get(player)<2){
						this.plugin.levels.put(player, 2);
						player.sendMessage(ChatColor.GOLD+"Your Skill Level Is Now Level 2!");
					}
				}
				if(this.plugin.blocks.get(player)>=this.plugin.lvl_3){
					if(this.plugin.levels.get(player)<3){
						this.plugin.levels.put(player, 3);
						player.sendMessage(ChatColor.GOLD+"Your Skill Level Is Now Level 3!");
					}
				}
				if(!(this.plugin.chosen.get(player).getTypeName().equalsIgnoreCase("*****"))){
					if(this.plugin.blocks.get(player)>=this.plugin.lvl_4){
						if(this.plugin.levels.get(player)<4){
							this.plugin.levels.put(player, 4);
							player.sendMessage(ChatColor.GOLD+"Your Skill Level Is Now Level 4!");
						}
					}
					if(this.plugin.blocks.get(player)>=this.plugin.lvl_5){
						if(this.plugin.levels.get(player)<5){
							this.plugin.levels.put(player, 5);
							player.sendMessage(ChatColor.GOLD+"Your Skill Level Is Now Level 5!");
						}
					}
					if(this.plugin.blocks.get(player)>=this.plugin.lvl_6){
						if(this.plugin.levels.get(player)<6){
							this.plugin.levels.put(player, 5);
							player.sendMessage(ChatColor.GOLD+"Your Skill Level Is Now Level 6!");
						}
					}
				}
				this.plugin.sqls.setStats(player);
			}
		}
	}
	public boolean hasPerm(Material mat, String classname){
		if(classname.equalsIgnoreCase("builder")||classname.equalsIgnoreCase("*****")){
			return true;
		}
		if(classname.equalsIgnoreCase("gardener")){
			if(mat.name().equalsIgnoreCase("dirt")||mat.name().equalsIgnoreCase("crops")||mat.name().equalsIgnoreCase("pumpkin")||mat.name().equalsIgnoreCase("red_mushroom")||mat.name().equalsIgnoreCase("yellow_flower")||mat.name().equalsIgnoreCase("brown_mushroom")||mat.name().equalsIgnoreCase("wheat")){
				return true;
			}else{
				return false;
			}
		}return false;
	}
}