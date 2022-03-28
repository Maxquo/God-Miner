package maxquo.godminer;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class Check {
    public static boolean isOre(Block b){
        String m = b.getType().name();
        if(m.contains("ORE")){
            return true;
        }
        return false;
    }
}
