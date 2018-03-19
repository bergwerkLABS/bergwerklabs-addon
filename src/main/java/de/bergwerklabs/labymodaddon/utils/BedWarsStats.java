/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon.utils;

import com.google.gson.annotations.Expose;
import de.bergwerklabs.labymodaddon.types.bedwars.BedWars;
import de.bergwerklabs.labymodaddon.types.bedwars.BedWarsMap;

/**
 *
 * @author  Nico_ND1
 */
public class BedWarsStats {
    
    @Expose
    private String rank, team, shop;
    @Expose
    private BedWarsMap bedWarsMap;
    @Expose
    private BedWars.BedWarsState state;

    /**
     * @return the bedWarsMap
     */
    public BedWarsMap getBedWarsMap() {
        return bedWarsMap;
    }

    /**
     * @param bedWarsMap the bedWarsMap to set
     */
    public void setBedWarsMap(BedWarsMap bedWarsMap) {
        this.bedWarsMap = bedWarsMap;
    }

    /**
     * @return the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * @return the team
     */
    public String getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * @return the shop
     */
    public String getShop() {
        return shop;
    }

    /**
     * @param shop the shop to set
     */
    public void setShop(String shop) {
        this.shop = shop;
    }

    /**
     * @return the state
     */
    public BedWars.BedWarsState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(BedWars.BedWarsState state) {
        this.state = state;
    }

}
