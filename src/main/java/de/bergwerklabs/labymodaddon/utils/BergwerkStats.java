/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.annotations.Expose;
import de.bergwerklabs.labymodaddon.LabyBergwerk;

/**
 *
 * @author  Nico_ND1
 */
public class BergwerkStats {
    
    public BergwerkStats() {
    }
    
    public String toJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        
        return gson.toJson(new JsonParser().parse(gson.toJson(this)));
    }
    
    @Expose
    private BedWarsStats bedWarsStats;
    @Expose
    private FlashStats flashStats;
    @Expose
    private LobbyStats lobbyStats;
    @Expose
    private TryJumpStats tryJumpStats;

    /**
     * @return the bedWarsStats
     */
    public BedWarsStats getBedWarsStats() {
        return bedWarsStats;
    }

    /**
     * @param bedWarsStats the bedWarsStats to set
     */
    public void setBedWarsStats(BedWarsStats bedWarsStats) {
        this.bedWarsStats = bedWarsStats;
    }

    /**
     * @return the flashStats
     */
    public FlashStats getFlashStats() {
        return flashStats;
    }

    /**
     * @param flashStats the flashStats to set
     */
    public void setFlashStats(FlashStats flashStats) {
        this.flashStats = flashStats;
    }

    /**
     * @return the lobbyStats
     */
    public LobbyStats getLobbyStats() {
        return lobbyStats;
    }

    /**
     * @param lobbyStats the lobbyStats to set
     */
    public void setLobbyStats(LobbyStats lobbyStats) {
        this.lobbyStats = lobbyStats;
    }

    /**
     * @return the tryJumpStats
     */
    public TryJumpStats getTryJumpStats() {
        return tryJumpStats;
    }

    /**
     * @param tryJumpStats the tryJumpStats to set
     */
    public void setTryJumpStats(TryJumpStats tryJumpStats) {
        this.tryJumpStats = tryJumpStats;
    }

    public void apply() {
        if(getBedWarsStats() != null) {
            LabyBergwerk.getInstance().getBedWars().setMap(getBedWarsStats().getBedWarsMap());
            LabyBergwerk.getInstance().getBedWars().setRank(getBedWarsStats().getRank());
            LabyBergwerk.getInstance().getBedWars().setShop(getBedWarsStats().getShop());
            LabyBergwerk.getInstance().getBedWars().setTeam(getBedWarsStats().getTeam());
            LabyBergwerk.getInstance().getBedWars().setState(getBedWarsStats().getState());
        }
        if(getFlashStats() != null) {
            LabyBergwerk.getInstance().getFlash().setCheckpoint(getFlashStats().getCheckpoints());
            LabyBergwerk.getInstance().getFlash().setEffectName(getFlashStats().getEffekt());
            LabyBergwerk.getInstance().getFlash().setFails(getFlashStats().getFails());
            LabyBergwerk.getInstance().getFlash().setMap(getFlashStats().getFlashMap());
            LabyBergwerk.getInstance().getFlash().setState(getFlashStats().getState());
        }
        if(getLobbyStats() != null) {
            LabyBergwerk.getInstance().getLobby().setCoins(getLobbyStats().getCoins());
            LabyBergwerk.getInstance().getLobby().setRang(getLobbyStats().getRang());
        }
        if(getTryJumpStats() != null) {
            LabyBergwerk.getInstance().getTryJump().setFails(getTryJumpStats().getFails());
            LabyBergwerk.getInstance().getTryJump().setLives(getTryJumpStats().getLives());
            LabyBergwerk.getInstance().getTryJump().setPercent(getTryJumpStats().getPercent());
            LabyBergwerk.getInstance().getTryJump().setPlatz(getTryJumpStats().getPlatz());
            LabyBergwerk.getInstance().getTryJump().setState(getTryJumpStats().getState());
            LabyBergwerk.getInstance().getTryJump().setTokens(getTryJumpStats().getTokens());
            LabyBergwerk.getInstance().getTryJump().setModule(getTryJumpStats().getModule());
        }
    }

}
