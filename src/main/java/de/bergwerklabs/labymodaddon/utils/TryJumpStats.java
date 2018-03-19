/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergwerklabs.labymodaddon.utils;

import com.google.gson.annotations.Expose;
import de.bergwerklabs.labymodaddon.types.tryjump.Module;
import de.bergwerklabs.labymodaddon.types.tryjump.TryJump;

/**
 *
 * @author Nico_ND1
 */
public class TryJumpStats {

    @Expose
    private Module module;
    @Expose
    private int fails, tokens, platz, percent, lives;
    @Expose
    private TryJump.TryJumpState state;

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

    /**
     * @return the state
     */
    public TryJump.TryJumpState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(TryJump.TryJumpState state) {
        this.state = state;
    }

}
