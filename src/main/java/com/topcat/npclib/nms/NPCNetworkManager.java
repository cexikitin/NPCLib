package com.topcat.npclib.nms;

import java.io.IOException;
import java.lang.reflect.Field;
import net.minecraft.server.v1_6_R1.Connection;
import net.minecraft.server.v1_6_R1.NetworkManager;
import net.minecraft.server.v1_6_R1.Packet;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_6_R1.CraftServer;

/**
 *
 * @author martin
 */
public class NPCNetworkManager extends NetworkManager {

	public NPCNetworkManager() throws IOException {
		super(((CraftServer) Bukkit.getServer()).getServer().getLogger(), new NullSocket(), "NPC Manager", new Connection() {

			@Override
			public boolean a() {
				return true;
			}
		}, null);
		try {
			Field f = NetworkManager.class.getDeclaredField("n");
			f.setAccessible(true);
			f.set(this, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void a(Connection nethandler) {
	}

	@Override
	public void queue(Packet packet) {
	}

	@Override
	public void a(String s, Object... aobject) {
	}

	@Override
	public void a() {
	}
}