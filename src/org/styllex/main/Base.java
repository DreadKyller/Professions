package org.styllex.main;

import java.io.File;
import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.event.Event;

import org.bukkit.entity.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.styllex.config.SQLServer;
import org.styllex.setting.*;

import com.alta189.sqllitelib.*;

public class Base extends JavaPlugin{
	
	public boolean enabled;
	public int insi;
	
	public int lvl_1=0;
	public int lvl_2=100;
	public int lvl_3=300;
	public int lvl_4=700;
	public int lvl_5=1400;
	public int lvl_6=3000;
	
	public sqlCore sql;
	
	public Logger log = Logger.getLogger("Minecraft");
	
	public profession prof = new profession(this);
	public Listener_Move pml = new Listener_Move(this);
	public Listener_Break_Block lbb = new Listener_Break_Block(this);
	public Listener_Place_Block lpb = new Listener_Place_Block(this);
	public AntiHackKick kl = new AntiHackKick(this);
	public JoinListener jl = new JoinListener(this);
	
	public HashMap<Player, ClassType> chosen = new HashMap<Player, ClassType>();
	public HashMap<Player, Integer> levels = new HashMap<Player, Integer>();
	public HashMap<Player, Integer> blocks = new HashMap<Player, Integer>();
	
	public SQLServer sqls = new SQLServer(this);
	
	public File pFolder = new File("plugins/Professions");
	
	public Base(){
		this.insi=1;
	}
	/**
	 * Print a Line of Text To Console
	 * @param st : Text to print
	 */
	public void print(String st){
		System.out.println(st);
	}
	public void onDisable(){
		if(!(sql==null)){
			sql.close();
		}
		System.out.println("Professions 1.0 Disabled");
		globalMessage(ChatColor.RED+"Professions has been disabled!");
	}
	public void onEnable(){
		this.enabled=true;
		
		if(!this.pFolder.exists()){
			pFolder.mkdir();
		}
		
		sql = new sqlCore(this.log, "[Profession] ", "professions", pFolder.getPath());
		sql.initialize();
		
		System.out.println("SQL Interface Initalizing - Professions");
		
		if (!sql.checkTable("prof")) {
			String query = "CREATE  TABLE prof (  'id' INTEGER PRIMARY KEY,  'name' VARCHAR(80) NOT NULL ,  'job' VARCHAR(80) NOT NULL ,  'level' INT NOT NULL DEFAULT 1,  'blocks' INT NOT NULL DEFAULT 0);";
			sql.createTable(query);
		}
		
		System.out.println("SQL Interface Sucessfully Initalized - Professions");
		
		System.out.println("Professions 1.0 Enabled");
		
		PluginManager pm = getServer().getPluginManager();
		
		getCommand("profession").setExecutor(prof);
		
		pm.registerEvent(Event.Type.PLAYER_MOVE, pml, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_BREAK, lbb, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_KICK, kl, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_PLACE, lpb, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, jl, Event.Priority.Normal, this);
	}
	/**
	 * Send a Message To All Players
	 * @param message : message to send
	 */
	public void globalMessage(String message){
		Player[] pl = getServer().getOnlinePlayers();
		int len = pl.length;
		for(int i = 0; i < len; i++){
			pl[i].sendMessage(message);
		}
	}
}