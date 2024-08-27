package net.kombopvp.pvp.kit;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.kombopvp.pvp.KomboPvP;
import net.kombopvp.pvp.kit.provider.Anchor;
import net.kombopvp.pvp.kit.provider.AntiStomper;
import net.kombopvp.pvp.kit.provider.AntiStomperReal;
import net.kombopvp.pvp.kit.provider.Archer;
import net.kombopvp.pvp.kit.provider.Boxer;
import net.kombopvp.pvp.kit.provider.Camel;
import net.kombopvp.pvp.kit.provider.EnderMageReal;
import net.kombopvp.pvp.kit.provider.Fireman;
import net.kombopvp.pvp.kit.provider.Fisherman;
import net.kombopvp.pvp.kit.provider.Flash;
import net.kombopvp.pvp.kit.provider.GladiatorListener2;
import net.kombopvp.pvp.kit.provider.Grandpa;
import net.kombopvp.pvp.kit.provider.Grappler;
import net.kombopvp.pvp.kit.provider.Hulk;
import net.kombopvp.pvp.kit.provider.Kangaroo;
import net.kombopvp.pvp.kit.provider.MeteorD;
import net.kombopvp.pvp.kit.provider.Milkman;
import net.kombopvp.pvp.kit.provider.Monk;
import net.kombopvp.pvp.kit.provider.Nenhum;
import net.kombopvp.pvp.kit.provider.Ninja;
import net.kombopvp.pvp.kit.provider.Phantom;
import net.kombopvp.pvp.kit.provider.Poseidon;
import net.kombopvp.pvp.kit.provider.PvP;
import net.kombopvp.pvp.kit.provider.Pyro2;
import net.kombopvp.pvp.kit.provider.QuickDropper;
import net.kombopvp.pvp.kit.provider.Reaper;
import net.kombopvp.pvp.kit.provider.Sight;
import net.kombopvp.pvp.kit.provider.Snail;
import net.kombopvp.pvp.kit.provider.Stomper;
import net.kombopvp.pvp.kit.provider.Switcher;
import net.kombopvp.pvp.kit.provider.Thor;
import net.kombopvp.pvp.kit.provider.Turtle;
import net.kombopvp.pvp.kit.provider.Viper;

public enum WaveKit {


	NENHUM2("None", 0, 0 , new Nenhum(), new ItemStack(Material.BARRIER), "Sem habilidades" , 1 , 0),
	PVP("Nenhum", KomboPvP.getInstance().getConfig().getInt("PvPPrice"), 0, new PvP(), new ItemStack(Material.BARRIER), "Sem habilidades" , 1, 1),
	KANGAROO("Kangaroo", KomboPvP.getInstance().getConfig().getInt("KangarooPrice"), 0,  new Kangaroo(), new ItemStack( Material.FIREWORK), KomboPvP.getInstance().getConfig().getString("KangarooLore") ,1,2),
	THOR("Thor", KomboPvP.getInstance().getConfig().getInt("ThorPrice"), 0, new Thor(), new ItemStack(Material.GOLD_AXE), KomboPvP.getInstance().getConfig().getString("ThorLore") , 1,3),
	ARCHER("Archer",KomboPvP.getInstance().getConfig().getInt("ArcherPrice"), 0, new Archer(), new ItemStack(Material.BOW), KomboPvP.getInstance().getConfig().getString("ArcherLore") , 1,4),
    NEO("Neo", KomboPvP.getInstance().getConfig().getInt("NeoPrice"), 8000, new AntiStomper(), new ItemStack(Material.BARRIER), KomboPvP.getInstance().getConfig().getString("NeoLore"), 1,5),
    AUTOBOWL("AutoBowl", KomboPvP.getInstance().getConfig().getInt("QuickDropperPrice"), 0, new QuickDropper(), new ItemStack(Material.BOWL), "Estaque os potes automaticamente" ,1,6),
    ANTISTOMPER("AntiStomper", KomboPvP.getInstance().getConfig().getInt("AntiStomperPrice"), 8000, new AntiStomperReal(), new ItemStack(Material.DIAMOND_HELMET), KomboPvP.getInstance().getConfig().getString("AntiStomperLore") ,1,7),
    SIGHT("Sight", 10000, 0, new Sight(), new ItemStack(Material.RED_MUSHROOM), "De cegueira a cada hit!" , 1,8),
	FISHERMAN("Fisherman", KomboPvP.getInstance().getConfig().getInt("FishermanPrice"), 150, new Fisherman(), new ItemStack(Material.FISHING_ROD), KomboPvP.getInstance().getConfig().getString("FishermanLore"), 1,9),
	ANCHOR("Anchor", KomboPvP.getInstance().getConfig().getInt("AnchorPrice"), 250, new Anchor(), new ItemStack(Material.ANVIL), KomboPvP.getInstance().getConfig().getString("AnchorLore"), 1,10),
	VIPER("Viper", KomboPvP.getInstance().getConfig().getInt("ViperPrice"), 150, new Viper(), new ItemStack(Material.SPIDER_EYE), KomboPvP.getInstance().getConfig().getString("ViperLore"), 1,11),
	SNAIL("Snail", KomboPvP.getInstance().getConfig().getInt("SnailPrice"), 150, new Snail(), new ItemStack(Material.FERMENTED_SPIDER_EYE), KomboPvP.getInstance().getConfig().getString("SnailLore"), 1,12),
	POSEIDON("Poseidon", KomboPvP.getInstance().getConfig().getInt("PoseidonPrice"), 150, new Poseidon(), new ItemStack(Material.WATER_BUCKET), KomboPvP.getInstance().getConfig().getString("PoseidonLore"), 1,13),
	MAGMA("Magma", KomboPvP.getInstance().getConfig().getInt("FiremanPrice"), 150, new Fireman(), new ItemStack(Material.LAVA_BUCKET), KomboPvP.getInstance().getConfig().getString("FiremanLore"), 1,14),
	NINJA("Ninja", KomboPvP.getInstance().getConfig().getInt("NinjaPrice"), 200, new Ninja(), new ItemStack(Material.EMERALD), KomboPvP.getInstance().getConfig().getString("NinjaLore"), 1,15),
	MONK("Monk", KomboPvP.getInstance().getConfig().getInt("MonkPrice"), 200, new Monk(), new ItemStack(Material.BLAZE_ROD), KomboPvP.getInstance().getConfig().getString("MonkLore") , 1,18),
	STOMPER("Stomper", KomboPvP.getInstance().getConfig().getInt("StomperPrice"), 200, new Stomper(), new ItemStack(Material.IRON_BOOTS), KomboPvP.getInstance().getConfig().getString("StomperLore") , 1,19),
	GRANDPA("Grandpa", KomboPvP.getInstance().getConfig().getInt("GrandpaPrice"), 150, new Grandpa(), new ItemStack(Material.STICK), KomboPvP.getInstance().getConfig().getString("GrandpaLore"), 1,22),
	MILKMAN("Milkman", KomboPvP.getInstance().getConfig().getInt("MilkmanPrice"), 250, new Milkman(), new ItemStack(Material.MILK_BUCKET), KomboPvP.getInstance().getConfig().getString("MilkmanLore"), 2,25),
	TURTLE("Turtle", KomboPvP.getInstance().getConfig().getInt("TurtlePrice"), 200, new Turtle(), new ItemStack(Material.DIAMOND_CHESTPLATE), KomboPvP.getInstance().getConfig().getString("TurtleLore"), 2,26),
	PHANTOM("Phantom", KomboPvP.getInstance().getConfig().getInt("PhantomPrice"), 520, new Phantom(), new ItemStack(Material.FEATHER), KomboPvP.getInstance().getConfig().getString("PhantomLore"), 2,27),
	BOXER("Boxer", KomboPvP.getInstance().getConfig().getInt("BoxerPrice"), 1500, new Boxer(), new ItemStack(Material.QUARTZ), KomboPvP.getInstance().getConfig().getString("BoxerLore"), 2,28),
	HULK("Hulk", KomboPvP.getInstance().getConfig().getInt("HulkPrice"), 420, new Hulk(), new ItemStack(Material.DROPPER), KomboPvP.getInstance().getConfig().getString("HulkLore"), 2,29),
	SWITCHER("Switcher", KomboPvP.getInstance().getConfig().getInt("SwitcherPrice"), 0, new Switcher(), new ItemStack(Material.SNOW_BALL), KomboPvP.getInstance().getConfig().getString("SwitcherLore"), 2,30),
	FLASH("Flash", 15000, 500, new Flash(), new ItemStack(Material.REDSTONE_TORCH_ON), "Teleporte para onde você clicar", 2,36),
	REAPER("Reaper", 13000, 500, new Reaper(), new ItemStack(Material.WOOD_HOE), "De wither com sua foice!", 2,37),
	METEOR("Meteor", 12000, 0, new MeteorD(), new ItemStack(Material.FIREBALL), "Vire um meteoro!" , 1,39),
	PYRO("Pyro", 6000, 0, new Pyro2(), new ItemStack(Material.CHAINMAIL_CHESTPLATE), "Atire bolas de fogo!" , 1,40),
	
	GLADIATOR("Gladiator", 15000, 500, new GladiatorListener2(), new ItemStack(Material.IRON_FENCE), "Desafie seus inimigos para 1v1",2, 38);
  
	private final String name;
	private final String description;
	private final int price;
	private final int pricecash;
	private final KitHandler handler;
	private final ItemStack icon;
	private static String nl = System.getProperty("line.separator");
	private final int page;
	private final int id;
	static {
		getKits().forEach(kit -> 
			Bukkit.getPluginManager().registerEvents(kit.getHandler(), KomboPvP.getInstance())
		);
	}

	public static List<WaveKit> getKits() {
		return Arrays.asList(values());
	}
	
	public static Optional<WaveKit> findKit(String name) {
		return getKits().stream().filter(
				kit -> kit.toString().equalsIgnoreCase(name) 
					|| kit.getName().equalsIgnoreCase(name)
		).findFirst();
	}
	public static Optional<WaveKit> findKit(int ID) {
		return getKits().stream().filter(
				kit -> kit.getID() == ID
				
		).findFirst();
	}
	
	WaveKit(String name, int price, int pricecash, KitHandler handler, ItemStack icon, String description , int page, int id) {
		this.name = name;
		this.price = price;
		this.pricecash = pricecash;
		this.handler = handler;
		this.icon = icon;
		this.description = description;
		this.page = page;
		this.id = id;
	}
	
	

	public void send(Player player) {
		if (KitManager2.getPlayer(player.getName()).haskit2(WaveKit2.STOMPER) && name.equalsIgnoreCase("Kangaroo")) {
			player.sendMessage("§cO Kit STOMPER é incompatível com Kit KANGAROO");
	      	player.closeInventory();	
	      	return;
		}
		if (KitManager2.getPlayer(player.getName()).haskit2(WaveKit2.STOMPER) && name.equalsIgnoreCase("Grappler")) {
			player.sendMessage("§cO Kit STOMPER é incompatível com Kit GRAPPLER");
	      	player.closeInventory();	
	      	return;
		}
		if (KitManager2.getPlayer(player.getName()).haskit2(WaveKit2.NINJA) && name.equalsIgnoreCase("Gladiator")) {
			player.sendMessage("§cO Kit NINJA é incompatível com Kit GLADIATOR");
	      	player.closeInventory();	
	      	return;
		}
		if (KitManager2.getPlayer(player.getName()).haskit2(WaveKit2.GLADIATOR) && name.equalsIgnoreCase("Ninja")) {
			player.sendMessage("§cO Kit NINJA é incompatível com Kit GLADIATOR");
	      	player.closeInventory();	
	      	return;
		}
		if (KitManager2.getPlayer(player.getName()).haskit2(WaveKit2.STOMPER) && name.equalsIgnoreCase("Meteor")) {
			player.sendMessage("§cO Kit METEOR é incompatível com Kit STOMPER");
	      	player.closeInventory();	
	      	return;
		}
		if (KitManager2.getPlayer(player.getName()).haskit2(WaveKit2.PHANTOM) && name.equalsIgnoreCase("Meteor")) {
			player.sendMessage("§cO Kit PHANTOM é incompatível com Kit METEOR");
	      	player.closeInventory();	
	      	return;
		}
		if (KitManager2.getPlayer(player.getName()).haskit2(WaveKit2.GLADIATOR) && name.equalsIgnoreCase("Hulk")) {
			player.sendMessage("§cO Kit HULK é incompatível com Kit GLADIATOR");
	      	player.closeInventory();	
	      	return;
		}
		
		if (KitManager2.getPlayer(player.getName()).haskit2(WaveKit2.KANGAROO) && name.equalsIgnoreCase("Stomper")) {
			player.sendMessage("§cO Kit KANGAROO é incompatível com Kit STOMPER");
	      	player.closeInventory();	
	      	return;
		}
		if (KitManager2.getPlayer(player.getName()).haskit2(WaveKit2.ANTISTOMPER) && name.equalsIgnoreCase("Stomper")) {
			player.sendMessage("§cO Kit AntiStomper é incompatível com Kit STOMPER");
	      	player.closeInventory();	
	      	return;
		}
		if (KitManager2.getPlayer(player.getName()).haskit2(WaveKit2.PHANTOM) && name.equalsIgnoreCase("Stomper")) {
			player.sendMessage("§cO Kit PHANTOM é incompatível com Kit STOMPER");
	      	player.closeInventory();	
	      	return;
		}
		if (KitManager2.getPlayer(player.getName()).haskit2(WaveKit2.STOMPER) && name.equalsIgnoreCase("Phantom")) {
			player.sendMessage("§cO Kit STOMPER é incompatível com Kit PHANTOM");
	      	player.closeInventory();	
	      	return;
		}
		if (KitManager2.getPlayer(player.getName()).haskit2(WaveKit2.STOMPER) && name.equalsIgnoreCase("AntiStomper")) {
			player.sendMessage("§cO Kit ANTISTOMPER é incompatível com Kit STOMPER");
	      	player.closeInventory();	
	      	return;
		}
		if (KitManager2.getPlayer(player.getName()).haskit2(WaveKit2.STOMPER) && name.equalsIgnoreCase("Ninja")) {
			player.sendMessage("§cO Kit NINJA é incompatível com Kit STOMPER");
	      	player.closeInventory();	
	      	return;
		}
		if (!(player.getLocation().getY() > KomboPvP.getInstance().getConfig().getInt("SpawnAltura") && EnderMageReal.isSpawn(player.getLocation()))) {
			player.sendMessage("§cVocê deve estar na área de spawn para escolher kits");
	      	player.closeInventory();
	  		return;
		}	  
		
		KitManager.getPlayer(player.getName()).setKit(this);
		player.sendMessage("§b" + name + " selecionado!");
		}
	
	
	public KitHandler getHandler() {
		return handler;
	}
	 public static WaveKit getKitTypeByName(String kitname) {
		 WaveKit[] values;
	        for (int length = (values = values()).length, i = 0; i < length; ++i) {
	            final WaveKit kitType = values[i];
	            if (kitType.name().equalsIgnoreCase(kitname)) {
	                return kitType;
	            }
	        }
	        return null;
	    }

	public boolean isFree() {
		return price == 0;
	}
	
	public String getName() {
		return name;
	}
	public int getID() {
		return id;
	}
	public int getPage() {
		return page;
	}
	
	public int getPrice() {
		return price;
	}
	public int getPriceCash() {
		return pricecash;
	}
	
	public ItemStack getIcon() {
		return icon;
	}
	public String getDescription() {
		return description.replace("&", "§");
	}
}
