package fr.Dianox.Hawn.Utility.Server;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.Dianox.Hawn.Main;
import fr.Dianox.Hawn.Utility.MessageUtils;
import fr.Dianox.Hawn.Utility.Config.Messages.Adminstration.InfoServerOverviewC;

public class WarnTPS {
	
static final int[] warnSystem = new int[1];
	
		public static void runWarnSystemTask(Main plugin) {
			
			new BukkitRunnable() {
	
				public void run() {
					double ticks = Tps.getTPS();
					if (ticks <= 15.0D) {
						onPrevient();
					} else if (ticks <= 5.0D) {
						onCritique();
						Bukkit.getServer().savePlayers();
						for (World world : Bukkit.getWorlds()) {
				            world.save();
						}
					}
					
				}
				
			}.runTaskTimerAsynchronously(plugin, 40L, 60L);
			
		}
		
		public static void onPrevient() {
			for (Player player: Bukkit.getOnlinePlayers()) {
				if (player.hasPermission("hawn.event.warn.tps")) {
					for (String msg: InfoServerOverviewC.getConfig().getStringList("TPS.Check.15")) {
						MessageUtils.ReplaceCharMessagePlayer(msg, player);
					}
				}
			}
		}
		
		public static void onCritique() {
			for (Player player: Bukkit.getOnlinePlayers()) {
				if (player.hasPermission("hawn.event.warn.tps")) {
					for (String msg: InfoServerOverviewC.getConfig().getStringList("TPS.Check.5")) {
						MessageUtils.ReplaceCharMessagePlayer(msg, player);
					}
				}
			}
	}

}
