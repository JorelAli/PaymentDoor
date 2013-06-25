package com.droppages.Skepter;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class PaymentDoors extends JavaPlugin 
{

    Logger log;
    String pluginname = "PaymentDoors";
    
    public PaymentDoors()
    {
    }

    public void onEnable()
    {
    	PluginDescriptionFile description = this.getDescription();
        log = getLogger();
        new PaymentDoorsListener(this);
        log.info(pluginname + description.getVersion() + " activated!");

    }

    public void onDisable()
    {
    	PluginDescriptionFile description = this.getDescription();
        log.info(pluginname + description.getVersion() + " de-activated!");
    }
}
    



  
