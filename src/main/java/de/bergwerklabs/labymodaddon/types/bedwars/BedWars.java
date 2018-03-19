/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergwerklabs.labymodaddon.types.bedwars;

import com.google.gson.JsonObject;
import de.bergwerklabs.labymodaddon.types.Info;

/**
 *
 * @author Nico_ND1
 */
public class BedWars extends Info {

    @Override
    public String getName() {
        return "BedWars";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String[] getServerName() {
        return new String[]{"bedwars"};
    }

    @Override
    public boolean isEnabled() {
        return isOnServer();
    }
    
    private BedWarsModule bedWarsModule;

    public BedWarsModule getBedWarsModule() {
        return bedWarsModule;
    }

    public void setBedWarsModule(BedWarsModule bedWarsModule) {
        this.bedWarsModule = bedWarsModule;
    }
    
    private BedWarsMap map;

    public BedWarsMap getMap() {
        return map;
    }

    public void setMap(BedWarsMap map) {
        this.map = map;
    }
    
    private String rank;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    
    private String team;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    
    private String shop;

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }
    
    public enum BedWarsState {
        
        WAITING, INGAME;
        
    }
    
    private BedWarsState state;

    public BedWarsState getState() {
        return state;
    }

    public void setState(BedWarsState state) {
        this.state = state;
    }

}
