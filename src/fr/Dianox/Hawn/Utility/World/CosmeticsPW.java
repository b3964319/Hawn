package fr.Dianox.Hawn.Utility.World;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import fr.Dianox.Hawn.Utility.Config.CosmeticsFun.ConfigGCos;
import fr.Dianox.Hawn.Utility.Config.CosmeticsFun.ConfigGLP;

public class CosmeticsPW {
	
	public static List<String> worlds_firework = new ArrayList<String>();
	
	public static void setWGetWorldFirework() {
		if (ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Enable")) {
	        if (!ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.World.All_World")) {
	            for (String world : ConfigGCos.getConfig().getStringList("Cosmetics.Firework.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Cosmetics/OnJoin.yml, Cosmetics.Firework.World: "+world);
	            	} else {
	            		worlds_firework.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static List<String> getWFirework() {
		return worlds_firework;
	}
	
	public static List<String> worlds_jumppads = new ArrayList<String>();
	
	public static void setWGetWorldJumpPads() {
		if (ConfigGLP.getConfig().getBoolean("JumpPads.Enable")) {
	        if (!ConfigGLP.getConfig().getBoolean("JumpPads.World.All_World")) {
	            for (String world : ConfigGLP.getConfig().getStringList("JumpPads.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Cosmetics-Fun/JumpPads.yml, JumpPads.World: "+world);
	            	} else {
	            		worlds_jumppads.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static List<String> getWJumpPads() {
		return worlds_jumppads;
	}

}
