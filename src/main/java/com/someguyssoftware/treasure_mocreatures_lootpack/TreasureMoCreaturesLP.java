/**
 * 
 */
package com.someguyssoftware.treasure_mocreatures_lootpack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.someguyssoftware.gottschcore.annotation.Credits;
import com.someguyssoftware.gottschcore.config.IConfig;
import com.someguyssoftware.gottschcore.mod.AbstractMod;
import com.someguyssoftware.gottschcore.mod.IMod;
import com.someguyssoftware.gottschcore.version.BuildVersion;
import com.someguyssoftware.treasure2.api.TreasureApi;
import com.someguyssoftware.treasure_mocreatures_lootpack.config.ModConfig;
import com.someguyssoftware.treasure_mocreatures_lootpack.eventhandler.WorldEventHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * 
 * @author Mark Gottschling on Dec 11, 2020
 *
 */
@Mod(modid = TreasureMoCreaturesLP.MODID, 
name = TreasureMoCreaturesLP.NAME, 
version = TreasureMoCreaturesLP.VERSION, 
dependencies = "required-after:gottschcore@[1.14.0,);required-after:treasure2@[2.0.0,);required-after:mocreatures@[12.0.3,)", 
acceptedMinecraftVersions = "[1.12.2]", 
updateJSON = TreasureMoCreaturesLP.UPDATE_JSON_URL)
@Credits(values = { "Treasure2: Mo'Creatures Loot Pack was first developed by Mark Gottschling on Dec 11, 2020."})
public class TreasureMoCreaturesLP extends AbstractMod {
	// constants
	public static final String MODID = "treasure2_mocreatures_lp";
	protected static final String NAME = "Treasure2MoCreaturesLP";
	protected static final String VERSION = "2.0.0";

	public static final String UPDATE_JSON_URL = "https://raw.githubusercontent.com/gottsch/gottsch-minecraft-Treasure-MoCreatures-Loot-Pack/1.12.2-master/update.json";

	private static final BuildVersion MINECRAFT_VERSION = new BuildVersion(1, 12, 2);

	// latest version
	private static BuildVersion latestVersion;

	// logger
	public static Logger LOGGER = LogManager.getLogger(TreasureMoCreaturesLP.NAME);

	@Instance(value = TreasureMoCreaturesLP.MODID)
	public static TreasureMoCreaturesLP instance;

	/**
	 * 
	 */
	public TreasureMoCreaturesLP() {

	}

	/**
	 * 
	 * @param event
	 */
	@Override
	@EventHandler
	public void preInt(FMLPreInitializationEvent event) {
		super.preInt(event);

		// register additional events
		MinecraftForge.EVENT_BUS.register(new WorldEventHandler(getInstance()));
		// create the treasure registries
		TreasureApi.registerLootTables(MODID);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (!getConfig().isModEnabled()) {
			return;
		}

		// perform any post init
		super.postInit(event);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getConfig()
	 */
	@Override
	public IConfig getConfig() {
		return ModConfig.instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getMinecraftVersion()
	 */
	@Override
	public BuildVersion getMinecraftVersion() {
		return TreasureMoCreaturesLP.MINECRAFT_VERSION;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getVerisionURL()
	 */
	@Override
	public String getVerisionURL() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getName()
	 */
	@Override
	public String getName() {
		return TreasureMoCreaturesLP.NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getId()
	 */
	@Override
	public String getId() {
		return TreasureMoCreaturesLP.MODID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.AbstractMod#getInstance()
	 */
	@Override
	public IMod getInstance() {
		return TreasureMoCreaturesLP.instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.AbstractMod#getVersion()
	 */
	@Override
	public String getVersion() {
		return TreasureMoCreaturesLP.VERSION;
	}

	@Override
	public BuildVersion getModLatestVersion() {
		return latestVersion;
	}

	@Override
	public void setModLatestVersion(BuildVersion version) {
		TreasureMoCreaturesLP.latestVersion = version;
	}

	@Override
	public String getUpdateURL() {
		return TreasureMoCreaturesLP.UPDATE_JSON_URL;
	}
}
