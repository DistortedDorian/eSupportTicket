/*
 * eSupportTicket
 * Copyright (C) 2012-2013 Rony Tesch <chillupx@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/
package de.ronyzzn.supticket.TicketChat;

import java.util.Map.Entry;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.ronyzzn.supticket.eSupportTicket;

public class TicketChatBreakListener implements Listener {
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		if(eSupportTicket.ticketChat.containsKey(event.getPlayer()) || eSupportTicket.ticketChat.containsValue(event.getPlayer())) {
			for(Entry<Player, Player> et : eSupportTicket.ticketChat.entrySet()) {
				if(et.getKey() == event.getPlayer()) {
					eSupportTicket.ticketChat.remove(event.getPlayer());
					et.getValue().sendMessage("�9==== TicketChat Closed. �6Reason: Patner left the game.�9====");
				} else if(et.getValue() == event.getPlayer()){
					eSupportTicket.ticketChat.remove(et.getKey());
					et.getKey().sendMessage("�9==== TicketChat Closed. �6Reason: Patner left the game. �9====");
				}
			}
		}
	}
}