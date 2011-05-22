package org.styllex.setting;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.*;
import org.styllex.main.Base;

public class Listener_Break_Block extends BlockListener{
	public Base plugin;
	public Listener_Break_Block(Base plug){
		this.plugin=plug;
	}
	public void onBlockBreak(BlockBreakEvent event){
		if(this.plugin.enabled==true){
			Player player = event.getPlayer();
			Material mat = player.getItemInHand().getType();
			if(this.plugin.chosen.containsKey(player)){
				if(this.plugin.chosen.get(player).getTypeName().equalsIgnoreCase("*****")){
					return;
				}
				if(this.plugin.chosen.get(player).getTypeName().equalsIgnoreCase("digger")){
					if(toolOfType(mat, "PICKAXE")||toolOfType(mat, "HOE")||toolOfType(mat, "SWORD")||toolOfType(mat, "AXE")){
						event.setCancelled(true);
						return;
					}else{
						if(getItemLevel(mat)>(this.plugin.levels.get(player))){
							event.setCancelled(true);
							player.sendMessage("You Are Not High Enough Level To Use That");
						}else{
							this.plugin.blocks.put(player, this.plugin.blocks.get(player)+1);
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
							this.plugin.sqls.setStats(player);
						}
					}
				}
				if(this.plugin.chosen.get(player).getTypeName().equalsIgnoreCase("miner")){
					if(toolOfType(mat, "SPADE")||toolOfType(mat, "HOE")||toolOfType(mat, "SWORD")||toolOfType(mat, "AXE")){
						event.setCancelled(true);
						return;
					}else{
						if(getItemLevel(mat)>(this.plugin.levels.get(player))){
							event.setCancelled(true);
							player.sendMessage("You Are Not High Enough Level To Use That");
						}else{
							this.plugin.blocks.put(player, this.plugin.blocks.get(player)+1);
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
							this.plugin.sqls.setStats(player);
						}
					}
				}
				if(this.plugin.chosen.get(player).getTypeName().equalsIgnoreCase("logger")){
					if(toolOfType(mat, "PICKAXE")||toolOfType(mat, "HOE")||toolOfType(mat, "SWORD")||toolOfType(mat, "SPADE")){
						event.setCancelled(true);
						return;
					}else{
						if(getItemLevel(mat)>(this.plugin.levels.get(player))){
							event.setCancelled(true);
							player.sendMessage("You Are Not High Enough Level To Use That");
						}else{
							this.plugin.blocks.put(player, this.plugin.blocks.get(player)+1);
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
							this.plugin.sqls.setStats(player);
						}
					}
				}
				if(this.plugin.chosen.get(player).getTypeName().equalsIgnoreCase("builder")){
					int lvl = this.plugin.levels.get(player);
					if(lvl > 3){
						lvl=3;
					}
					if(getItemLevel(mat)>(lvl)){
						event.setCancelled(true);
						player.sendMessage("You Are Not High Enough Level To Use That");
					}else{
						this.plugin.blocks.put(player, this.plugin.blocks.get(player)+1);
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
						this.plugin.sqls.setStats(player);
					}
				}
				if(this.plugin.chosen.get(player).getTypeName().equalsIgnoreCase("fighter")){
					event.setCancelled(true);
				}
				if(this.plugin.chosen.get(player).getTypeName().equalsIgnoreCase("*****")){
					int lvl = this.plugin.levels.get(player);
					if(getItemLevel(mat)>(lvl)){
						event.setCancelled(true);
						player.sendMessage("You Are Not High Enough Level To Use That");
					}else{
						this.plugin.blocks.put(player, this.plugin.blocks.get(player)+1);
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
						this.plugin.sqls.setStats(player);
					}
				}
				if(this.plugin.chosen.get(player).getTypeName().equalsIgnoreCase("gardener")){
					if(toolOfType(mat, "SPADE")||toolOfType(mat, "PICKAXE")||toolOfType(mat, "SWORD")||toolOfType(mat, "AXE")){
						event.setCancelled(true);
						return;
					}else{
						if(getItemLevel(mat)>(this.plugin.levels.get(player))){
							event.setCancelled(true);
							player.sendMessage("You Are Not High Enough Level To Use That");
						}else{
							this.plugin.blocks.put(player, this.plugin.blocks.get(player)+1);
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
							this.plugin.sqls.setStats(player);
						}
					}
				}
			}
		}
	}
	public boolean toolOfType(Material mat, String type){
		String[] stl = mat.toString().split("_");
		if(stl.length<2){
			return false;
		}
		if(stl[1].equalsIgnoreCase(type)){
			return true;
		}else{
			return false;
		}
	}
	public boolean toolOfType(Material mat, String type, String[] exempt){
		String[] stl = mat.name().split("_");
		if(stl.length<2){
			return false;
		}
		if(stl[1].equalsIgnoreCase(type)){
			for(int i = 0;i<exempt.length;i++){
				if(stl[0].equalsIgnoreCase(exempt[i])){
					return false;
				}
			}
			return true;
		}else{
			return false;
		}
	}
	public String[] getToolStat(Material mat){
		String[] stl = mat.name().split("_");
		return stl;
	}
	public int getItemLevel(Material mat){
		String[] stl = getToolStat(mat);
		if(stl.length<2){
			return 1;
		}
		if(!(stl[1].equalsIgnoreCase("spade")||stl[1].equalsIgnoreCase("axe")||stl[1].equalsIgnoreCase("hoe")||stl[1].equalsIgnoreCase("pickaxe")||stl[1].equalsIgnoreCase("sword"))){
			return 1;
		}else{
			if(stl[0].equalsIgnoreCase("wood")) return 1;
			if(stl[0].equalsIgnoreCase("stone")) return 2;
			if(stl[0].equalsIgnoreCase("gold")) return 3;
			if(stl[0].equalsIgnoreCase("iron")) return 4;
			if(stl[0].equalsIgnoreCase("diamond")) return 5;
			return 1;
		}
	}
}
