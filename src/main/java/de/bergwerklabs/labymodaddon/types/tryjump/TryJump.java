/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon.types.tryjump;

import com.google.gson.JsonObject;
import de.bergwerklabs.labymodaddon.types.Info;

/**
 *
 * @author  Nico_ND1
 */
public class TryJump extends Info {

    @Override
    public String getName() {
        return "TryJump";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String[] getServerName() {
        return new String[]{"tryjump"};
    }

    /*@Override
    public void handle(JsonObject obj) {
        this.module = new Module(obj.get("module").getAsJsonObject().get("name").getAsString(),
                obj.get("module").getAsJsonObject().get("schwierigkeit").getAsString());
        this.fails = obj.get("fails").getAsInt();
        this.tokens = obj.get("tokens").getAsInt();
        this.platz = obj.get("platz").getAsInt();
        this.percent = obj.get("percent").getAsInt();
        this.lives = obj.get("lives").getAsInt();
    }*/
    
    private Module module;
    private int fails, tokens, platz, percent, lives;
    
    public TryJump() {
        this.fails = 0;
        this.tokens = 100;
        this.platz = -1;
        this.percent = 0;
        this.lives = 3;
    }

    /**
     * @return the module
     */
    public Module getModule() {
        return module;
    }

    /**
     * @param module the module to set
     */
    public void setModule(Module module) {
        this.module = module;
    }

    /**
     * @return the fails
     */
    public int getFails() {
        return fails;
    }

    /**
     * @param fails the fails to set
     */
    public void setFails(int fails) {
        this.fails = fails;
    }

    /**
     * @return the tokens
     */
    public int getTokens() {
        return tokens;
    }

    /**
     * @param tokens the tokens to set
     */
    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    /**
     * @return the platz
     */
    public int getPlatz() {
        return platz;
    }

    /**
     * @param platz the platz to set
     */
    public void setPlatz(int platz) {
        this.platz = platz;
    }

    /**
     * @return the percent
     */
    public int getPercent() {
        return percent;
    }

    /**
     * @param percent the percent to set
     */
    public void setPercent(int percent) {
        this.percent = percent;
    }

    /**
     * @return the lives
     */
    public int getLives() {
        return lives;
    }

    /**
     * @param lives the lives to set
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public boolean isEnabled() {
        return isOnServer();
    }
    
    public enum TryJumpState {
        
        LOBBY, INGAME, SHOP, FIGHT;
        
    }
    
    private TryJumpState state = TryJumpState.LOBBY;

    public TryJumpState getState() {
        return state;
    }

    public void setState(TryJumpState state) {
        this.state = state;
    }

    private TryJumpModule tryJumpModule;

    public TryJumpModule getTryJumpModule() {
        return tryJumpModule;
    }

    public void setTryJumpModule(TryJumpModule tryJumpModule) {
        this.tryJumpModule = tryJumpModule;
    }

}
