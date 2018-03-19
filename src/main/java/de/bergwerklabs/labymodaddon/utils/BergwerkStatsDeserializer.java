/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import de.bergwerklabs.labymodaddon.types.bedwars.BedWars;
import de.bergwerklabs.labymodaddon.types.bedwars.BedWarsMap;
import de.bergwerklabs.labymodaddon.types.flash.Flash;
import de.bergwerklabs.labymodaddon.types.flash.FlashMap;
import de.bergwerklabs.labymodaddon.types.tryjump.Module;
import de.bergwerklabs.labymodaddon.types.tryjump.TryJump;
import java.lang.reflect.Type;

/**
 *
 * @author  Nico_ND1
 */
public class BergwerkStatsDeserializer implements JsonDeserializer<BergwerkStats> {

    @Override
    public BergwerkStats deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();
        BergwerkStats stats = new BergwerkStats();
        
        stats.setBedWarsStats(fromBJson(obj.get("bedWarsStats").getAsJsonObject()));
        stats.setFlashStats(fromFJson(obj.get("flashStats").getAsJsonObject()));
        stats.setLobbyStats(fromLJson(obj.get("lobbyStats").getAsJsonObject()));
        stats.setTryJumpStats(fromTJson(obj.get("tryJumpStats").getAsJsonObject()));
        
        return stats;
    }
    
    private BedWarsStats fromBJson(JsonObject obj) {
        BedWarsStats stats = new BedWarsStats();
        
        stats.setRank(obj.get("rank").getAsString());
        stats.setTeam(obj.get("team").getAsString());
        stats.setShop(obj.get("shop").getAsString());
        stats.setBedWarsMap(fromBWJson(obj.get("bedWarsMap").getAsJsonObject()));
        stats.setState(BedWars.BedWarsState.valueOf(obj.get("state").getAsString()));
        
        return stats;
    }
    
    private BedWarsMap fromBWJson(JsonObject obj) {
        return new BedWarsMap(obj.get("name").getAsString(), obj.get("author").getAsString());
    }
    
    private FlashStats fromFJson(JsonObject obj) {
        FlashStats stats = new FlashStats();
        
        stats.setCheckpoints(obj.get("checkpoints").getAsInt());
        stats.setFails(obj.get("checkpoints").getAsInt());
        stats.setEffekt(obj.get("effekt").getAsString());
        stats.setFlashMap(fromFMJson(obj.get("flashMap").getAsJsonObject()));
        stats.setState(Flash.FlashState.valueOf(obj.get("state").getAsString()));
        
        return stats;
    }
    
    private FlashMap fromFMJson(JsonObject obj) {
        return new FlashMap(obj.get("name").getAsString(), obj.get("author").getAsString());
    }
    
    private LobbyStats fromLJson(JsonObject obj) {
        LobbyStats stats = new LobbyStats();
        
        stats.setCoins(obj.get("coins").getAsInt());
        stats.setRang(obj.get("rang").getAsString());
        
        return stats;
    }
    
    private TryJumpStats fromTJson(JsonObject obj) {
        TryJumpStats stats = new TryJumpStats();
        
        stats.setModule(fromJson(obj.get("module").getAsJsonObject()));
        stats.setFails(obj.get("fails").getAsInt());
        stats.setPlatz(obj.get("platz").getAsInt());
        stats.setTokens(obj.get("tokens").getAsInt());
        stats.setPercent(obj.get("percent").getAsInt());
        stats.setLives(obj.get("lives").getAsInt());
        stats.setState(TryJump.TryJumpState.valueOf(obj.get("state").getAsString()));
        
        return stats;
    }
    
    private Module fromJson(JsonObject obj) {
        Module module = new Module(obj.get("name").getAsString(), obj.get("schwierigkeit").getAsString());
        
        module.setLite(obj.get("lite").getAsBoolean());
        module.setFails(obj.get("fails").getAsInt());
        
        return module;
    }

}
