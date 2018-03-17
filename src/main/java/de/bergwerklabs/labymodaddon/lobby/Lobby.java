/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon.lobby;

import com.google.gson.JsonObject;

/**
 *
 * @author  Nico_ND1
 */
public class Lobby {
    
    private int coins;
    private String rang;
    
    public Lobby() {
        
    }
    
    public void handle(JsonObject obj) {
        if(obj.has("coins")) {
            coins = obj.get("coins").getAsInt();
        }
        if(obj.has("rang")) {
            rang = obj.get("rang").getAsString();
        }
    }

}
