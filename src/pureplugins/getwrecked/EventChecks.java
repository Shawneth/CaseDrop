package pureplugins.getwrecked;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventChecks implements Listener{
	
	private Main plugin;
    public EventChecks(Main plugin){
        this.plugin = plugin;
    }

    @SuppressWarnings({ "deprecation", "static-access" })
    @EventHandler
    public void CheckifPlaced(BlockPlaceEvent evt){
      if(Keys.isKey(evt.getItemInHand()) || Cases.isCase(evt.getItemInHand())){
       evt.setCancelled(true);
       evt.getPlayer().updateInventory();
       evt.getPlayer().sendMessage(plugin.prefix+plugin.noPlace);
      }
    }
    
    @SuppressWarnings({ "deprecation", "static-access" })
	@EventHandler
    public void CheckforBasicStoof(PlayerInteractEvent evt){
    	if(evt.getPlayer().getInventory().contains(Keys.BasicCaseKey) && evt.getPlayer().getInventory().contains(Cases.BasicCase)){
    		if(evt.getPlayer().getItemInHand().equals(Keys.BasicCaseKey)){
    			if(evt.getAction().equals(Action.RIGHT_CLICK_AIR) || evt.getAction().equals(Action.LEFT_CLICK_AIR)){
    				evt.getPlayer().getInventory().remove(Cases.BasicCase);
    				evt.getPlayer().getInventory().removeItem(Keys.BasicCaseKey);
    				Cases.BasicCaseContents(evt.getPlayer());
    				evt.getPlayer().updateInventory();
    				plugin.getServer().broadcastMessage(plugin.prefix+ChatColor.GREEN+"Congratulations "+evt.getPlayer().getName()+"! you unlocked a Basic Case.");
    			}
    		}
    	}
    }
}
