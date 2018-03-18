/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon.types.lobby;

import com.google.gson.JsonObject;
import de.bergwerklabs.labymodaddon.types.Info;

/**
 *
 * @author  Nico_ND1
 */
public class Lobby extends Info {

    @Override
    public String getName() {
        return "Lobby";
    }

    @Override
    public String getDescription() {
        return "Informationen über die Lobby";
    }

    @Override
    public String[] getServerName() {
        return new String[]{"lobby", "hub"};
    }
    
    private int coins = -1;
    private String rang = "Spieler";
    
    public Lobby() {
    }
    
    @Override
    public void handle(JsonObject obj) {
        if(obj.has("coins")) {
            coins = obj.get("coins").getAsInt();
        }
        if(obj.has("rang")) {
            rang = obj.get("rang").getAsString();
        }
    }

    public String getRang() {
        return rang;
    }

    public int getCoins() {
        return coins;
    }

}