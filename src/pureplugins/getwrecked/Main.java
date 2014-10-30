package pureplugins.getwrecked;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class Main extends JavaPlugin{
	
	public static Main plugin;
	
	public static String prefix = ChatColor.GREEN+"["+ChatColor.DARK_PURPLE+"CaseDrop"+ChatColor.GREEN+"] ";
	public static String noPlace = ChatColor.RED+"You cannot place this item!";
	
	public String permissionReload = "casedrop.reload";
	public String permissionHelp = "casedrop.help";
	public String permissionSpawn = "casedrop.spawn.everything";
	
	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new EventChecks(this), this);
	    new Keys();
	    new Cases();
	    BukkitTask task = getServer().getScheduler().runTaskTimer(this, new SpawnCases(getServer().getWorld("world")), 20, 20);
		
	}
	
	@Override
	public void onDisable(){
		
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player user = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("casedrop")){
			if(args.length == 0){
				user.sendMessage("§a§m----------------§r§a[§5CaseDrop§a]§a§m----------------");
				user.sendMessage(ChatColor.RED+"Developers: "+ChatColor.YELLOW+"PurePlugins & ShawnGreene()");
				user.sendMessage(ChatColor.RED+"Version: "+ChatColor.YELLOW+"1.2");
				user.sendMessage(ChatColor.AQUA+"For a list of commands type /casedrop help!");
				user.sendMessage("§a§m-----------------------------------------");
			}else{
				if(args[0].equalsIgnoreCase("help")){
					if(user.hasPermission(plugin.permissionHelp)){
						user.sendMessage("§a§m----------------§r§a[§5CaseDrop§a]§a§m----------------");
						user.sendMessage(ChatColor.YELLOW+"/casedrop reload - Reloads the plugin.");
						user.sendMessage(ChatColor.YELLOW+"/casedrop basickey - Gives the player a Basic Key");
						user.sendMessage(ChatColor.YELLOW+"/casedrop basiccase - Gives the player a Basic Case");
						user.sendMessage(ChatColor.YELLOW+"/casedrop weaponskey - Gives the player a Weapons Key");
						user.sendMessage(ChatColor.YELLOW+"/casedrop weaponscase - Gives the player a Weapons Case");
						user.sendMessage(ChatColor.YELLOW+"/casedrop armorkey - Gives the player a Armor Key");
						user.sendMessage(ChatColor.YELLOW+"/casedrop armorcase - Gives the player a Armor Case");
						user.sendMessage("§a§m-----------------------------------------");
					}else{
						user.sendMessage(plugin.prefix+ChatColor.RED+"You do not have permission to use this command!");
					}
				}
				if(args[0].equalsIgnoreCase("reload")){
					if(user.hasPermission(plugin.permissionReload)){
						user.sendMessage(plugin.prefix+ChatColor.GREEN+"Reload Sucessful");
					}else{
						user.sendMessage(plugin.prefix+ChatColor.RED+"You do not have permission to use this command!");
					}
				}
				if(args[0].equalsIgnoreCase("basickey")){
					if(user.hasPermission(plugin.permissionSpawn)){
						user.getInventory().addItem(Keys.BasicCaseKey);
					}else{
						user.sendMessage(plugin.prefix+ChatColor.RED+"You do not have permission to use this command!");
					}
				}
				if(args[0].equalsIgnoreCase("basiccase")){
					if(user.hasPermission(plugin.permissionSpawn)){
						user.getInventory().addItem(Cases.BasicCase);
					}else{
						user.sendMessage(plugin.prefix+ChatColor.RED+"You do not have permission to use this command!");
					}
				}
				if(args[0].equalsIgnoreCase("weaponskey")){
					if(user.hasPermission(plugin.permissionSpawn)){
						user.getInventory().addItem(Keys.WeaponCaseKey);
					}else{
						user.sendMessage(plugin.prefix+ChatColor.RED+"You do not have permission to use this command!");
					}
				}
				if(args[0].equalsIgnoreCase("weaponsscase")){
					if(user.hasPermission(plugin.permissionSpawn)){
						user.getInventory().addItem(Cases.WeaponsCase);
					}else{
						user.sendMessage(plugin.prefix+ChatColor.RED+"You do not have permission to use this command!");
					}
				}
				if(args[0].equalsIgnoreCase("armorkey")){
					if(user.hasPermission(plugin.permissionSpawn)){
						user.getInventory().addItem(Keys.ArmorCaseKey);
					}else{
						user.sendMessage(plugin.prefix+ChatColor.RED+"You do not have permission to use this command!");
					}
				}
				if(args[0].equalsIgnoreCase("armorcase")){
					if(user.hasPermission(plugin.permissionSpawn)){
						user.getInventory().addItem(Cases.ArmorCase);
					}else{
						user.sendMessage(plugin.prefix+ChatColor.RED+"You do not have permission to use this command!");
					}
				}
			}
		}
		return false;
	}
	
}