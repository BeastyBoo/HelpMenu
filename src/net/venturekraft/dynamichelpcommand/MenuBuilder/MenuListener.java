package net.venturekraft.dynamichelpcommand.MenuBuilder;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MenuListener implements Listener
{

    @EventHandler
    public void InventoryClick(InventoryClickEvent event)
    {
        Menu matchedMenu = MenuManager.getInstance().matchMenu(event.getWhoClicked().getUniqueId());

        if (matchedMenu != null)
        {
            matchedMenu.handleClick(event);
        }
    }

    @EventHandler
    public void InventoryClose(InventoryCloseEvent event)
    {
        Menu matchedMenu = MenuManager.getInstance().matchMenu(event.getPlayer().getUniqueId());

        if (matchedMenu != null)
        {
            matchedMenu.handleClose((Player) event.getPlayer());
        }

        // Unregister menu - it has been closed.
        MenuManager.getInstance().unregisterMenu(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void PlayerQuit(PlayerQuitEvent event)
    {
        Menu matchedMenu = MenuManager.getInstance().matchMenu(event.getPlayer().getUniqueId());

        if (matchedMenu != null)
        {
            matchedMenu.handleClose(event.getPlayer());
        }

        // Unregister menu - the player has quit.
        MenuManager.getInstance().unregisterMenu(event.getPlayer().getUniqueId());
    }

}
