package org.styllex.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.styllex.main.Base;
import org.styllex.setting.ClassType;

public class SQLServer {
	
	public Base plugin;
	
	public SQLServer(Base plugin){
		this.plugin=plugin;
	}
	
	public boolean setStats(Player player){
		int blocks = this.plugin.blocks.get(player);
		int level = this.plugin.levels.get(player);
		String job = this.plugin.chosen.get(player).getTypeName();
		
		String query1 ="SELECT name FROM prof";
		
		ResultSet rs=this.plugin.sql.sqlQuery(query1);
		
		boolean useix = true;
		try{
			while(rs.next()){
				if(rs.getString("name").equalsIgnoreCase(player.getDisplayName())){
					useix = false;
				}
			}
		}catch(SQLException e){
			return false;
		}
		
		if(useix){
			String query = "INSERT INTO prof (name, level, job, blocks) values ('"+player.getDisplayName()+"', '"+level+"', '"+job+"', '"+blocks+"');";
			this.plugin.sql.sqlQuery(query);
		}else{
			String query = "UPDATE prof SET blocks="+blocks+", level="+level+" WHERE name='"+player.getDisplayName()+"' ";
			this.plugin.sql.updateQuery(query);
		}
		return true;
	}
	public void loadStats(Player player){
		if(this.plugin.chosen.containsKey(player)){
			return;
		}
		String query = "SELECT blocks, level, job FROM prof WHERE name = '"+player.getDisplayName()+"'";
		
		ResultSet result = this.plugin.sql.sqlQuery(query);
		
		if(result==null){
			return;
		}
		String job="";
		int blocks=0;
		int level=0;
		try{
			job = result.getString("job");
			blocks = result.getInt("blocks");
			level = result.getInt("level");
		}catch (SQLException e){
			return;
		}
		this.plugin.chosen.put(player, new ClassType(job));
		this.plugin.levels.put(player, level);
		this.plugin.blocks.put(player, blocks);
	}
}
