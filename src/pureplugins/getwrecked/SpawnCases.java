package pureplugins.getwrecked;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnCases extends BukkitRunnable{
	final World world;
	Random rand = new Random();
	public SpawnCases(World w){
		world = w;
	}

	@Override
	public void run() {
		world.dropItem(caseLocation(), Cases.BasicCase);
	}
	public Location caseLocation(){
		int x = rand.nextInt(20000)-10000;
		int z = rand.nextInt(20000)-10000;
		return new Location(world,x,world.getHighestBlockYAt(x, z)+5,z);
	}

}
