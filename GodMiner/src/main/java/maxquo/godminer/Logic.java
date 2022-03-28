package maxquo.godminer;

import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class Logic {
    GodMiner plugin;
    public Logic(GodMiner m){
        plugin = m;
    }
    public void logic(Block b){
        List<Block> toCheck= new ArrayList<>();
        List<Block> checked = new ArrayList<>();
        int i = 0;
        toCheck.add(b);
        while(toCheck.size() >= 1) {
            plugin.getLogger().info(String.valueOf(toCheck.size()));
            plugin.getLogger().info("checked" + String.valueOf(checked.size()));

            if(checked.size() > 100){
                toCheck.clear();
                break;
            }
                Block bb = toCheck.get(0);
            if (Check.isOre(bb)) {
                toCheck.remove(0);
                checked.add(bb);
                Location bloc = bb.getLocation();
                Location cloc = bloc.clone();
                while (i <= 5) {
                    switch (i) {
                        case 0:
                            cloc.setX(bloc.getBlockX() + 1);
                            break;
                        case 1:
                            cloc.setX(bloc.getBlockX() - 1);
                            break;
                        case 2:
                            cloc.setY(bloc.getBlockY() + 1);
                            break;
                        case 3:
                            cloc.setY(bloc.getBlockY() - 1);
                            break;
                        case 4:
                            cloc.setZ(bloc.getBlockZ() + 1);
                            break;
                        case 5:
                            cloc.setZ(bloc.getBlockZ() - 1);
                            break;
                    }
                    i++;
                    if (compare(bb, cloc.getBlock())) {
                        if (!checked.contains(cloc.getBlock())) {
                            toCheck.add(cloc.getBlock());
                        }
                    }
                    cloc = bloc.clone();
                }
                i = 0;
            } else {
                toCheck.remove(0);
            }
        }
        int g = 0;
        for(Block z : checked){
            z.breakNaturally();
            g++;
        }
    }
    private static boolean compare(Block bb, Block cloc){
        return bb.getType().equals(cloc.getType());
    }
}
