/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergwerklabs.labymodaddon;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.bergwerklabs.labymodaddon.types.bedwars.BWMapModule;
import de.bergwerklabs.labymodaddon.types.bedwars.BedWars;
import de.bergwerklabs.labymodaddon.types.bedwars.BedWarsModule;
import de.bergwerklabs.labymodaddon.types.bedwars.RankModule;
import de.bergwerklabs.labymodaddon.types.bedwars.ShopModule;
import de.bergwerklabs.labymodaddon.types.bedwars.TeamModule;
import de.bergwerklabs.labymodaddon.types.flash.CheckpointModule;
import de.bergwerklabs.labymodaddon.types.flash.EffektModule;
import de.bergwerklabs.labymodaddon.types.flash.FailsModule;
import de.bergwerklabs.labymodaddon.types.flash.Flash;
import de.bergwerklabs.labymodaddon.types.flash.FlashModule;
import de.bergwerklabs.labymodaddon.types.flash.MapModule;
import de.bergwerklabs.labymodaddon.types.lobby.CoinsModule;
import de.bergwerklabs.labymodaddon.types.lobby.Lobby;
import de.bergwerklabs.labymodaddon.types.lobby.LobbyModule;
import de.bergwerklabs.labymodaddon.types.lobby.RangModule;
import de.bergwerklabs.labymodaddon.types.tryjump.InfoModule;
import de.bergwerklabs.labymodaddon.types.tryjump.PercentageModule;
import de.bergwerklabs.labymodaddon.types.tryjump.PlatzModule;
import de.bergwerklabs.labymodaddon.types.tryjump.RemainingLivesModule;
import de.bergwerklabs.labymodaddon.types.tryjump.TokensModule;
import de.bergwerklabs.labymodaddon.types.tryjump.TryJump;
import de.bergwerklabs.labymodaddon.types.tryjump.TryJumpModule;
import de.bergwerklabs.labymodaddon.utils.BergwerkStats;
import de.bergwerklabs.labymodaddon.utils.BergwerkStatsDeserializer;
import java.util.List;
import net.labymod.api.LabyModAddon;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.api.events.PluginMessageEvent;
import net.labymod.api.events.ServerMessageEvent;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import net.minecraft.network.PacketBuffer;

/**
 *
 * @author Nico_ND1
 */
public class LabyBergwerk extends LabyModAddon {

    private static LabyBergwerk instance;

    public static LabyBergwerk getInstance() {
        return instance;
    }

    private String serverType;

    private final Lobby lobby = new Lobby();

    public Lobby getLobby() {
        return lobby;
    }

    private final TryJump tryJump = new TryJump();

    public TryJump getTryJump() {
        return tryJump;
    }
    
    private final BedWars bedWars = new BedWars();

    public BedWars getBedWars() {
        return bedWars;
    }

    private bergwerkCategory category;

    public bergwerkCategory getCategory() {
        return category;
    }

    private BergwerkLABS server;

    public BergwerkLABS getServer() {
        return server;
    }

    @Override
    public void onEnable() {
        instance = this;
        category = new bergwerkCategory("bergwerkLABS", true, new ControlElement.IconData("bergwerklabs/icons/icon.png"));
        ModuleCategoryRegistry.loadCategory(category);

        getApi().registerServerSupport(this, (server == null
                ? (server = new BergwerkLABS("bergwerklabs.de", "devs.bergwerklabs.de", "grete.bergwerklabs.de")) : server));

        new LobbyModule();
        new CoinsModule();
        new RangModule();

        new TryJumpModule();
        new InfoModule();
        new PercentageModule();
        new PlatzModule();
        new RemainingLivesModule();
        new TokensModule();
        
        new FlashModule();
        new MapModule();
        new CheckpointModule();
        new EffektModule();
        new FailsModule();
        
        new BedWarsModule();
        new ShopModule();
        new BWMapModule();
        new RankModule();
        new TeamModule();
        
        getApi().getEventManager().register(new ServerMessageEvent() {
            @Override
            public void onServerMessage(String key, JsonElement je) {
                if (key.equalsIgnoreCase("serverInfo")) {
                    JsonObject obj = je.getAsJsonObject();

                    if (obj.has("server")) {
                        setServerType(obj.get("server").getAsString());
                        LabyMod.getInstance().getChatClient().updatePlayingOnServerState(obj.get("server").getAsString());
                    }
                } else if(key.equalsIgnoreCase("statsUpdate")) {
                    JsonObject obj = je.getAsJsonObject();
                    
                    BergwerkStats stats = new GsonBuilder().registerTypeAdapter(BergwerkStats.class, new BergwerkStatsDeserializer()).create()
                            .fromJson(obj, BergwerkStats.class);
                }
            }
        });
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void loadConfig() {
    }

    @Override
    protected void fillSettings(List<SettingsElement> list) {
        BooleanElement bool = new BooleanElement("Mehr Informationen", this, new ControlElement.IconData(Material.COMMAND), "Mehr Informationen", false);
        bool.setDescriptionText("Sende Informationen über deinen Client um dein Spielerlebnis zu verbessern");

        list.add(bool);
    }

    /**
     * @return the serverType
     */
    public String getServerType() {
        return serverType;
    }

    /**
     * @param serverType the serverType to set
     */
    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    private final Flash flash = new Flash();

    public Flash getFlash() {
        return flash;
    }

}
