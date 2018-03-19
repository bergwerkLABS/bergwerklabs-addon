/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergwerklabs.labymodaddon.utils;

import com.google.gson.annotations.Expose;
import de.bergwerklabs.labymodaddon.types.tryjump.Module;

/**
 *
 * @author Nico_ND1
 */
public class TryJumpStats {

    @Expose
    private Module module;
    @Expose
    private int checkpoint, fails;

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
     * @return the checkpoint
     */
    public int getCheckpoint() {
        return checkpoint;
    }

    /**
     * @param checkpoint the checkpoint to set
     */
    public void setCheckpoint(int checkpoint) {
        this.checkpoint = checkpoint;
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
