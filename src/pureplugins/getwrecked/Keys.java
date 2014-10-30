package pureplugins.getwrecked;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Keys{
	
	public Keys(){
		keys.add(ArmorCaseKey);
		keys.add(BasicCaseKey);
		keys.add(WeaponCaseKey);
		keys.add(MasterCaseKey);
	}
	
	private static ArrayList<ItemStack> keys = new ArrayList<ItemStack>();
	
	static ItemStack BasicCaseKey = Util.createItem(Material.TRIPWIRE_HOOK, 1, ChatColor.AQUA+"Basic Case Key", ChatColor.GREEN+"Unlocks the Basic Case");	
	static ItemStack WeaponCaseKey = Util.createItem(Material.TRIPWIRE_HOOK, 1, ChatColor.AQUA+"Weapons Case Key", ChatColor.GREEN+"Unlocks the Weapons Case");
	static ItemStack ArmorCaseKey = Util.createItem(Material.TRIPWIRE_HOOK, 1, ChatColor.AQUA+"Armor Case Key", ChatColor.GREEN+"Unlocks the Armor Case");
	static ItemStack MasterCaseKey = Util.createItem(Material.TRIPWIRE_HOOK, 1, ChatColor.AQUA+"Master Case Key", ChatColor.GREEN+"Unlocks all Cases");	

	public static void KeyMenu(Player user, PlayerInventory inv){
		Inventory KeyMenuInv = Bukkit.createInventory(null, 9, "Key Menu");
		KeyMenuInv.setItem(0, BasicCaseKey);
		KeyMenuInv.setItem(1, WeaponCaseKey);
		KeyMenuInv.setItem(2, ArmorCaseKey);
		KeyMenuInv.setItem(3, MasterCaseKey);
		user.openInventory(KeyMenuInv);
	}
	
	public static boolean isKey(ItemStack item){
		if(keys.contains(item)){
			return true;
		}else{
			return false;
		}
	}
}
