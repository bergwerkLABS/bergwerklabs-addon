/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon.types.flash;

import com.google.gson.JsonObject;
import de.bergwerklabs.labymodaddon.types.Info;

/**
 *
 * @author  Nico_ND1
 */
public class Flash extends Info {

    @Override
    public String getName() {
        return "Flash";
    }

    @Override
    public String getDescription() {
        return "Informationen über Flash";
    }

    @Override
    public String[] getServerName() {
        return new String[]{"flash"};
    }

    @Override
    public void handle(JsonObject obj) {
        
    }
    
    private String effectName;
    private int checkpoint, fails;
    private FlashMap map;

    public String getEffectName() {
        return effectName;
    }

    public void setEffectName(String effectName) {
        this.effectName = effectName;
    }

    public int getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(int checkpoint) {
        this.checkpoint = checkpoint;
    }

    public int getFails() {
        return fails;
    }

    public void setFails(int fails) {
        this.fails = fails;
    }

    public FlashMap getMap() {
        return map;
    }

    public void setMap(FlashMap map) {
        this.map = map;
    }

    @Override
    public boolean isEnabled() {
        return isOnServer();
    }
    
    private FlashModule flashModule;

    public FlashModule getFlashModule() {
        return flashModule;
    }

    public void setFlashModule(FlashModule flashModule) {
        this.flashModule = flashModule;
    }
    
    public enum FlashState {
        
        WAITING, INGAME;
        
    }
    
    private FlashState state;

    public FlashState getState() {
        return state;
    }

    public void setState(FlashState state) {
        this.state = state;
    }

}
