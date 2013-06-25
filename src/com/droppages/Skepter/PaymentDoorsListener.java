package com.droppages.Skepter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


@SuppressWarnings("unused")
public class PaymentDoorsListener implements Listener{

	//private PaymentDoors plugin;
	
	public PaymentDoorsListener(PaymentDoors plugin) {
		//this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent event) throws InterruptedException
	{
		final Player player = event.getPlayer();
		ChatColor gold = ChatColor.GOLD;
		ChatColor white = ChatColor.WHITE;
		String msg = gold + "[PaymentDoors] " + white + "You do not have enough levels to open the door";
		int price = 0;
		//long time = 0;
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{
			if(event.getClickedBlock().getState() instanceof Sign)
			{
				Sign s = (Sign) event.getClickedBlock().getState();
				price = Integer.parseInt(s.getLine(1));
				Block sign = event.getClickedBlock();
				final Block x = sign.getRelative(1, 0, 0);
				Block xx = sign.getRelative(-1, 0, 0);
				Block z = sign.getRelative(0, 0, 1);
				Block zz = sign.getRelative(0, 0, -1);
				
				if(s.getLine(0).equalsIgnoreCase("[PaymentDoors]") && s.getLine(1).equalsIgnoreCase(String.valueOf(price)) && s.getLine(2).isEmpty())
				{
					
					if(x.getType() == Material.IRON_DOOR_BLOCK)
					{
						if(player.getWorld().getBlockAt(x.getLocation()).getData() == 0)
						{
							if(player.getLevel() < price)
							{
								player.sendMessage(msg);
								return;
							}
							player.setLevel(player.getLevel() - price);
							player.getWorld().getBlockAt(x.getLocation()).setData((byte) 1, false);
							return;
						}
						else if(player.getWorld().getBlockAt(x.getLocation()).getData() == 1)
						{
							player.getWorld().getBlockAt(x.getLocation()).setData((byte) 0, false);
							return;
						}
					}
					else if(z.getType() == Material.IRON_DOOR_BLOCK)
					{
						if(player.getWorld().getBlockAt(z.getLocation()).getData() == 0)
						{
							if(player.getLevel() < price)
							{
								player.sendMessage(msg);
								return;
							}
							player.setLevel(player.getLevel() - price);
							player.getWorld().getBlockAt(z.getLocation()).setData((byte) 16, false);
							return;
						}
						else if(player.getWorld().getBlockAt(z.getLocation()).getData() == 16)
						{
							player.getWorld().getBlockAt(z.getLocation()).setData((byte) 7, false);
							return;
						}
					}
					else if(xx.getType() == Material.IRON_DOOR_BLOCK)
					{
						if(player.getWorld().getBlockAt(xx.getLocation()).getData() == 0)
						{
							if(player.getLevel() < price)
							{
								player.sendMessage(msg);
								return;
							}
							player.setLevel(player.getLevel() - price);
							player.getWorld().getBlockAt(xx.getLocation()).setData((byte) 1, false);
							return;
						}
						else if(player.getWorld().getBlockAt(xx.getLocation()).getData() == 1)
						{
							player.getWorld().getBlockAt(xx.getLocation()).setData((byte) 0, false);
							return;
						}
					}
					else if(zz.getType() == Material.IRON_DOOR_BLOCK)
					{
						if(player.getWorld().getBlockAt(zz.getLocation()).getData() == 0)
						{
							if(player.getLevel() < price)
							{
								player.sendMessage(msg);
								return;
							}
							player.setLevel(player.getLevel() - price);
							player.getWorld().getBlockAt(zz.getLocation()).setData((byte) 4, false);
							return;
						}
						else if(player.getWorld().getBlockAt(zz.getLocation()).getData() == 1)
						{
							player.getWorld().getBlockAt(zz.getLocation()).setData((byte) 0, false);
							return;
						}
					}
				}
				/*else if(s.getLine(0).equalsIgnoreCase("[PaymentDoors]") && s.getLine(1).equalsIgnoreCase(String.valueOf(price)) && s.getLine(2).equalsIgnoreCase(String.valueOf(time)))
				time = Long.parseLong(s.getLine(2).toString());
				{
					if(x.getType() == Material.IRON_DOOR_BLOCK)
					{
						if(player.getWorld().getBlockAt(x.getLocation()).getData() == 0)
						{
							if(player.getLevel() < price)
							{
								player.sendMessage(msg);
								return;
							}
							else
							{
							player.setLevel(player.getLevel() - price);
							player.sendMessage("debug1");
							player.sendMessage("Time: " + time);
							player.getWorld().getBlockAt(x.getLocation()).setData((byte) 1, false);
							player.sendMessage("debug2");
							
							Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
							{	
								public void run() 
								{
									player.getWorld().getBlockAt(x.getLocation()).setData((byte) 0, false);
									player.sendMessage("debug3");
								}
	            				
	            			}, 40);
							//return;
							}
						}
						else if(player.getWorld().getBlockAt(x.getLocation()).getData() == 1)
						{
							player.getWorld().getBlockAt(x.getLocation()).setData((byte) 0, false);
							return;
						}
					}
					else if(z.getType() == Material.IRON_DOOR_BLOCK)
					{
						if(player.getWorld().getBlockAt(z.getLocation()).getData() == 0)
						{
							if(player.getLevel() < price)
							{
								player.sendMessage(msg);
								return;
							}
							player.setLevel(player.getLevel() - price);
							player.getWorld().getBlockAt(z.getLocation()).setData((byte) 1, false);
							try {
								Thread.sleep(time * 20);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							player.getWorld().getBlockAt(z.getLocation()).setData((byte) 0, false);
							return;
						}
						else if(player.getWorld().getBlockAt(z.getLocation()).getData() == 1)
						{
							player.getWorld().getBlockAt(z.getLocation()).setData((byte) 0, false);
							return;
						}
					}
					else if(xx.getType() == Material.IRON_DOOR_BLOCK)
					{
						if(player.getWorld().getBlockAt(xx.getLocation()).getData() == 0)
						{
							if(player.getLevel() < price)
							{
								player.sendMessage(msg);
								return;
							}
							player.setLevel(player.getLevel() - price);
							player.getWorld().getBlockAt(xx.getLocation()).setData((byte) 1, false);
							try {
								Thread.sleep(time * 20);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							player.getWorld().getBlockAt(xx.getLocation()).setData((byte) 0, false);
							return;
						}
						else if(player.getWorld().getBlockAt(xx.getLocation()).getData() == 1)
						{
							player.getWorld().getBlockAt(xx.getLocation()).setData((byte) 0, false);
							return;
						}
					}
					else if(zz.getType() == Material.IRON_DOOR_BLOCK)
					{
						if(player.getWorld().getBlockAt(zz.getLocation()).getData() == 0)
						{
							if(player.getLevel() < price)
							{
								player.sendMessage(msg);
								return;
							}
							player.setLevel(player.getLevel() - price);
							player.getWorld().getBlockAt(zz.getLocation()).setData((byte) 1, false);
							try {
								Thread.sleep(time * 20);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							player.getWorld().getBlockAt(zz.getLocation()).setData((byte) 0, false);
							return;
						}
						else if(player.getWorld().getBlockAt(zz.getLocation()).getData() == 1)
						{
							player.getWorld().getBlockAt(zz.getLocation()).setData((byte) 0, false);
							return;
						}
					}
					
				}*/
			}
		}
	}
}
