package pureplugins.getwrecked;
 
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Util {
 
public static ItemStack createItem(Material material, String displayname, String lore) {
ItemStack item = new ItemStack(material);
ItemMeta meta = item.getItemMeta();
meta.setDisplayName(displayname);
String[] llore = lore.split("&x");
List<String> FinalLore = Arrays.asList(llore);
meta.setLore(FinalLore);
item.setItemMeta(meta);
return item;
}
 
public static ItemStack createItem(Material material, int amount, String displayname, String lore) {
ItemStack item = new ItemStack(material, amount);
ItemMeta meta = item.getItemMeta();
meta.setDisplayName(displayname);
String[] llore = lore.split("&x");
List<String> FinalLore = Arrays.asList(llore);
meta.setLore(FinalLore);
item.setItemMeta(meta);
return item;
}
 
public static ItemStack createItem(Material material, String displayname) {
ItemStack item = new ItemStack(material);
ItemMeta meta = item.getItemMeta();
meta.setDisplayName(displayname);
item.setItemMeta(meta);
return item;
	}
}