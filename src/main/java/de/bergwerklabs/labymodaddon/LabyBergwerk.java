/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.bergwerklabs.labymodaddon.types.lobby.CoinsModule;
import de.bergwerklabs.labymodaddon.types.lobby.Lobby;
import de.bergwerklabs.labymodaddon.types.lobby.RangModule;
import de.bergwerklabs.labymodaddon.types.tryjump.InfoModule;
import de.bergwerklabs.labymodaddon.types.tryjump.PercentageModule;
import de.bergwerklabs.labymodaddon.types.tryjump.PlatzModule;
import de.bergwerklabs.labymodaddon.types.tryjump.RemainingLivesModule;
import de.bergwerklabs.labymodaddon.types.tryjump.TokensModule;
import de.bergwerklabs.labymodaddon.types.tryjump.TryJump;
import java.util.List;
import net.labymod.api.LabyModAddon;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.api.events.ServerMessageEvent;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;

/**
 *
 * @author  Nico_ND1
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
        
        getApi().registerServerSupport(this, (server == null ? 
                (server = new BergwerkLABS("bergwerklabs.de", "devs.bergwerklabs.de", "grete.bergwerklabs.de")) : server));
        
        new CoinsModule();
        new RangModule();
        
        new InfoModule();
        new PercentageModule();
        new PlatzModule();
        new RemainingLivesModule();
        new TokensModule();
        
        getApi().getEventManager().register(new ServerMessageEvent() {
            @Override
            public void onServerMessage(String key, JsonElement je) {
                if(key.equalsIgnoreCase("serverInfo")) {
                    JsonObject obj = je.getAsJsonObject();
                    
                    if(obj.has("server")) {
                        setServerType(obj.get("server").getAsString());
                        LabyMod.getInstance().getChatClient().updatePlayingOnServerState(obj.get("server").getAsString());
                    }
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

}
