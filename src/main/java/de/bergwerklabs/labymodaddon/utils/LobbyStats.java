/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergwerklabs.labymodaddon.utils;

import com.google.gson.annotations.Expose;

/**
 *
 * @author Nico_ND1
 */
public class LobbyStats {

    @Expose
    private int coins;
    @Expose
    private String rang;

    /**
     * @return the coins
     */
    public int getCoins() {
        return coins;
    }

    /**
     * @param coins the coins to set
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }

    /**
     * @return the rang
     */
    public String getRang() {
        return rang;
    }

    /**
     * @param rang the rang to set
     */
    public void setRang(String rang) {
        this.rang = rang;
    }

}
