package org.styllex.setting;

import org.bukkit.Material;
import org.styller.function.StringFNI;

public class ClassType {
	public String _content;
	public int _valve;
	public String[] _spec;
	public ClassType(int valve){
		String[] sl = {"Digger", "Miner", "Logger", "Gardener", "Builder", "Fighter", "*****", "Default"};
		this._valve=valve;
		if(valve>(sl.length-1)){
			valve=(sl.length-1);
		}
		if(valve<0){
			valve=0;
		}
		this._content=sl[valve];
	}
	public ClassType(String str){
		int sl = 7;
		this._content=str;
		if(str.equalsIgnoreCase("digger"))sl=0;//
		if(str.equalsIgnoreCase("miner"))sl=1;//
		if(str.equalsIgnoreCase("logger"))sl=2;//
		if(str.equalsIgnoreCase("gardener"))sl=3;
		if(str.equalsIgnoreCase("builder"))sl=4;//
		if(str.equalsIgnoreCase("fighter"))sl=5;
		if(str.equalsIgnoreCase("*****"))sl=6;
		if(sl==7){
			this._content="*****";
			sl=1;
		}
		this._valve=sl;
	}
	public void givePerm(String str){
		this._spec[this._spec.length]=str;
	}
	public void removePerm(String str){
		StringFNI sfni = new StringFNI(this._spec);
		sfni.removeItem(str);
		this._spec = sfni.getContents();
	}
	public String getTypeName(){
		return this._content;
	}
	public int getType(){
		return this._valve;
	}
	public boolean hasPermission(String perm){
		if(this._content==perm){
			return true;
		}
		int len = this._spec.length;
		for(int i = 0;i<len;i++){
			if(this._spec[i].equalsIgnoreCase(perm)){
				return true;
			}
		}
		return false;
	}
	public Material getClassReward(){
		if(this._content.equalsIgnoreCase("miner")){
			return Material.WOOD_PICKAXE;
		}
		if(this._content.equalsIgnoreCase("digger")){
			return Material.WOOD_SPADE;
		}
		if(this._content.equalsIgnoreCase("builder")){
			return Material.STONE;
		}
		if(this._content.equalsIgnoreCase("logger")){
			return Material.WOOD_AXE;
		}
		if(this._content.equalsIgnoreCase("gardener")){
			return Material.RED_ROSE;
		}
		if(this._content.equalsIgnoreCase("fighter")){
			return Material.WOOD_SWORD;
		}
		if(this._content.equalsIgnoreCase("*****")){
			return Material.TORCH;
		}
		return null;
	}
}
