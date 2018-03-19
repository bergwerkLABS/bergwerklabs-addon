/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon.utils;

import com.google.gson.annotations.Expose;
import de.bergwerklabs.labymodaddon.types.flash.FlashMap;

/**
 *
 * @author  Nico_ND1
 */
public class FlashStats {
    
    @Expose
    private FlashMap flashMap;
    @Expose
    private String effekt;
    @Expose
    private int checkpoints, fails;

    /**
     * @return the flashMap
     */
    public FlashMap getFlashMap() {
        return flashMap;
    }

    /**
     * @param flashMap the flashMap to set
     */
    public void setFlashMap(FlashMap flashMap) {
        this.flashMap = flashMap;
    }

    /**
     * @return the effekt
     */
    public String getEffekt() {
        return effekt;
    }

    /**
     * @param effekt the effekt to set
     */
    public void setEffekt(String effekt) {
        this.effekt = effekt;
    }

    /**
     * @return the checkpoints
     */
    public int getCheckpoints() {
        return checkpoints;
    }

    /**
     * @param checkpoints the checkpoints to set
     */
    public void setCheckpoints(int checkpoints) {
        this.checkpoints = checkpoints;
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

}
