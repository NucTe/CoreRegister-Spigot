package me.nuclearteam.coreregisterspigot.models;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import me.nuclearteam.coreregisterspigot.CoreRegister_Spigot;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class Bungee implements PluginMessageListener {
    @Override
    public void onPluginMessageReceived(String s, Player player, byte[] bytes) {
        if(!s.equals("BungeeCord"))
            return;

        ByteArrayDataInput in = ByteStreams.newDataInput(bytes);
        String subchannel = in.readUTF();

        if (subchannel.equals("SomeSubChannel")) {
            String message = in.readUTF();
            CoreRegister_Spigot.GetInstance().getLogger().info("Received message on SomeSubChannel: " + message);
        }
    }
}
