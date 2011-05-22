package org.styller.function;

public class StringFNI {
	public String[] stl;
	public String st;
	public StringFNI(String s){
		this.st=s;
	}
	public StringFNI(String[] sl){
		this.stl=sl;
	}
	public void removeIndex(int index){
		int len = this.stl.length;
		int dif = 0;
		String[] bl_stl = {};
		for(int i = 0; i<len;i++){
			if(!(i==index)){
				dif=-1;
			}else{
				bl_stl[i+dif]=this.stl[i];
			}
		}
	}
	public void removeItem(String item){
		int len = this.stl.length;
		int dif = 0;
		String[] bl_stl = {};
		for(int i = 0; i<len;i++){
			if(!(this.stl[i]==item)){
				dif=-1;
			}else{
				bl_stl[i+dif]=this.stl[i];
			}
		}
	}
	public String join(String[] strl, String sep){
		String st = "";
		int len = this.stl.length;
		for(int i=0;i<len;i++){
			st=st+this.stl[i]+sep;
		}
		return st;
	}
	public String join(String[] strl){
		String st = "";
		int len = this.stl.length;
		for(int i=0;i<len;i++){
			st=st+this.stl[i]+" ";
		}
		return st;
	}
	public String[] getContents(){
		return this.stl;
	}
}
