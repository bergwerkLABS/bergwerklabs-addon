/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergwerklabs.labymodaddon.types.lobby;

import com.google.gson.JsonObject;
import de.bergwerklabs.labymodaddon.LabyBergwerk;
import de.bergwerklabs.labymodaddon.types.Info;

/**
 *
 * @author Nico_ND1
 */
public class Lobby extends Info {

    private int coins = -1;
    private String rang = "Spieler";

    public Lobby() {
    }

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

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    private LobbyModule lobbyModule;

    public LobbyModule getLobbyModule() {
        return lobbyModule;
    }

    public void setLobbyModule(LobbyModule lobbyModule) {
        this.lobbyModule = lobbyModule;
    }

    @Override
    public boolean isEnabled() {
        return isOnServer();
    }

}
