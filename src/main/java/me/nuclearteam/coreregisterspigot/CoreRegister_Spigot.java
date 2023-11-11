package me.nuclearteam.coreregisterspigot;

import me.nuclearteam.coreregisterspigot.models.Bungee;
import org.bukkit.plugin.java.JavaPlugin;

public final class CoreRegister_Spigot extends JavaPlugin {

    public static CoreRegister_Spigot instance;

    @Override
    public void onEnable() {
        instance = this;
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new Bungee());

    }

    @Override
    public void onDisable() {
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
    }

    public static CoreRegister_Spigot GetInstance(){
        return instance;
    }
}
