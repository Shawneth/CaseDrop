package pureplugins.getwrecked;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Cases{
	
	public Cases(){
		Cases.add(BasicCase);
		Cases.add(ArmorCase);
		Cases.add(WeaponsCase);
	}
	
	private static ArrayList<ItemStack> Cases = new ArrayList<ItemStack>();
	
	public static List<String> BasicCaseLore = new ArrayList<String>();
	
	static ItemStack BasicCase = Util.createItem(Material.CHEST, 1, ChatColor.AQUA+"Basic Case", ChatColor.YELLOW+"Status: "+ChatColor.RED+"Locked &x-------------&x"+ChatColor.YELLOW+"Potential Items:&x"+ChatColor.GREEN+"Iron Blocks&x"+ChatColor.GREEN+"Gold Blocks&x"+ChatColor.GREEN+"Emerald Blocks&x"+ChatColor.GREEN+"Diamond Blocks&x"+ChatColor.GREEN+"Hoppers&x"+ChatColor.GREEN+"Spawners&x"+ChatColor.GREEN+"Beacon&x"+ChatColor.GREEN+"God Apple&x"+ChatColor.GREEN+"Creeper Egg");	
	static ItemStack WeaponsCase = Util.createItem(Material.CHEST, 1, ChatColor.AQUA+"Weapons Case", ChatColor.YELLOW+"Status: "+ChatColor.RED+"Locked");	
	static ItemStack ArmorCase = Util.createItem(Material.CHEST, 1, ChatColor.AQUA+"Armor Case", ChatColor.YELLOW+"Status: "+ChatColor.RED+"Locked");
	
	public static void CaseMenu(Player user, PlayerInventory inv){
		Inventory CaseMenuInv = Bukkit.createInventory(null, 9, "Key Menu");
		CaseMenuInv.setItem(0, BasicCase);
		CaseMenuInv.setItem(1, WeaponsCase);
		CaseMenuInv.setItem(2, ArmorCase);
		user.openInventory(CaseMenuInv);
	}
	
	public static boolean isCase(ItemStack item){
		if(Cases.contains(item)){
			return true;
		}else{
			return false;
		}
	}
	
	public static void BasicCaseContents(Player user){
		List<ItemStack> BasicItems = new ArrayList<ItemStack>();
		ItemStack IronBlock = new ItemStack(Material.IRON_BLOCK);
		BasicItems.add(IronBlock);
		ItemStack GoldBlock = new ItemStack(Material.GOLD_BLOCK);
		BasicItems.add(GoldBlock);
		ItemStack EmeraldBlock = new ItemStack(Material.EMERALD_BLOCK);
		BasicItems.add(EmeraldBlock);
		ItemStack DiamondBlock= new ItemStack(Material.DIAMOND_BLOCK);
		BasicItems.add(DiamondBlock);
		ItemStack Hopper = new ItemStack(Material.HOPPER);
		BasicItems.add(Hopper);
		ItemStack Spawner = new ItemStack(Material.MOB_SPAWNER);
		BasicItems.add(Spawner);
		ItemStack Beacon = new ItemStack(Material.BEACON);
		BasicItems.add(Beacon);
		ItemStack GodApple = new ItemStack(Material.GOLDEN_APPLE);
		GodApple.setDurability((short) 1);
		BasicItems.add(GodApple);
		ItemStack CreeperEgg = new ItemStack(Material.MONSTER_EGG);
		CreeperEgg.setDurability((short) 50);
		BasicItems.add(CreeperEgg);
		user.getInventory().addItem(BasicItems.get(new Random().nextInt(BasicItems.size())));
	}
}
