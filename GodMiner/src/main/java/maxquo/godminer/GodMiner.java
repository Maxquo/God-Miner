package maxquo.godminer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class GodMiner extends JavaPlugin {

    public Logic logic;
    @Override
    public void onEnable() {
        this.logic = new Logic(this);
        new BlockBreak(this);
        getServer().getPluginManager().registerEvents(new BlockBreak(this), this);

        getLogger().info("-------------------");
        getLogger().info("<GodMiner is working>");
        getLogger().info("-------------------");

        GodPickaxe();
    }
    private void GodPickaxe(){
        ItemStack Pick = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta itemMeta = Pick.getItemMeta();

        itemMeta.setDisplayName(ChatColor.GOLD + ""+ ChatColor.BOLD + "God Pickaxe");
        itemMeta.addEnchant(Enchantment.DURABILITY, 100, true);
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        Pick.setItemMeta(itemMeta);

        NamespacedKey key = new NamespacedKey(this, "godpixcka");
        ShapedRecipe recipe = new ShapedRecipe(key, Pick);
        recipe.shape("SSS", " E ", " E ");
        recipe.setIngredient('E', Material.STICK);
        recipe.setIngredient('S', Material.GOLD_BLOCK);

        Bukkit.addRecipe(recipe);
    }
}
