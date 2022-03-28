package maxquo.godminer;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Objects;

public class BlockBreak implements Listener {
    GodMiner plugin;
    public BlockBreak(GodMiner g){
        plugin = g;
    }

    @EventHandler
    public void blockBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode() == GameMode.CREATIVE){
            return;
        }
        if(p.getItemInHand().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "God Pickaxe")){
            return;
        }
        if(Check.isOre(e.getBlock())) {
            plugin.logic.logic(e.getBlock());
        }
    }

}
