package org.styllex.main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.styllex.setting.ClassType;


public class profession implements CommandExecutor{
	public Base plugin;
	public profession(Base plug){
		this.plugin=plug;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String other, String[] args){
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(args.length>0){//If Not No Parameters
				if(args[0].equalsIgnoreCase("enable")){
					if(player.isOp()){
						boolean current = this.plugin.enabled;
						if(current==true){
							this.plugin.enabled = false;
							this.plugin.globalMessage(ChatColor.RED+"Profession Disabled");
						}else{
							this.plugin.enabled = true;
							this.plugin.globalMessage(ChatColor.RED+"Profession Enabled");
						}
						return true;
					}
				}
				if(!(this.plugin.chosen.containsKey(player))){
					ClassType clt = new ClassType(args[0]);
					this.plugin.chosen.put(player, clt);
					this.plugin.levels.put(player, 1);
					this.plugin.blocks.put(player, this.plugin.lvl_1);
					ItemStack is = new ItemStack(clt.getClassReward());
					int amount = 1;
					if(clt.getClassReward()==Material.RED_ROSE||clt.getClassReward()==Material.TORCH||clt.getClassReward()==Material.STONE){
						amount = 64;
					}
					is.setAmount(amount);
					player.getInventory().addItem(is);
				}else{
					player.sendMessage("You have Already Chosen A Class");
					player.sendMessage("Classes Are Permenent Unless Changed");
					player.sendMessage("By Owner Through Console");
					return true;
				}
			}else{//If No Parameters
				if(this.plugin.chosen.containsKey(player)){
					int[] intlist ={this.plugin.lvl_1, this.plugin.lvl_2, this.plugin.lvl_3, this.plugin.lvl_4, this.plugin.lvl_5, this.plugin.lvl_6};
					int c_blocks = this.plugin.blocks.get(player);
					int n_blocks;
					if(!(this.plugin.levels.get(player)>5)){
						n_blocks = intlist[this.plugin.levels.get(player)];
					}else{
						n_blocks = c_blocks;
					}
					int needed = (n_blocks - c_blocks);
					player.sendMessage("Chosen Class : "+this.plugin.chosen.get(player).getTypeName());
					player.sendMessage("Current Level : "+this.plugin.levels.get(player));
					player.sendMessage("Blocks Placed : "+this.plugin.blocks.get(player));
					player.sendMessage("Blocks To Next Level : "+needed);
				}
				else{
					player.sendMessage("Can Not Collect Class Info");
					player.sendMessage("Make Sure You Join A Class First");
					player.sendMessage("/profession <profession_name>");
				}
				return true;
			}
		}
		else{//Sender Is Not Player (Console)
			if(args.length<2){
				System.out.println("The '/profession' command takes 2 Parameters");
				System.out.println("/profession <PlayerName> <ClassName>");
			}else{
				if(args[0].equalsIgnoreCase("enable")){
					boolean current = this.plugin.enabled;
					if(current==true){
						this.plugin.enabled = false;
						this.plugin.globalMessage(ChatColor.RED+"Profession Disabled");
					}else{
						this.plugin.enabled = true;
						this.plugin.globalMessage(ChatColor.RED+"Profession Enabled");
					}
					return true;
				}
				try{
					Player player = sender.getServer().getPlayer(args[0]);
					ClassType clt = new ClassType(args[0]);
					if(this.plugin.chosen.containsKey(player)){
						this.plugin.chosen.put(player, clt);
						this.plugin.print(player+" Class changed To "+args[0]);
					}else{
						this.plugin.chosen.put(player, clt);
						this.plugin.levels.put(player, 1);
						this.plugin.blocks.put(player, this.plugin.lvl_1);
						this.plugin.print(player+" Class changed To "+args[0]);
					}
					return true;
				}catch (Exception e){
					System.out.println("A Parimeter In Command :");
					System.out.println("'/profession {PlayerName} {ClassName}");
					System.out.println("Failed");
					return true;
				}
			}
		}
		return false;
	}
}
