/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergwerklabs.labymodaddon.types.tryjump;

import com.google.gson.annotations.Expose;

/**
 *
 * @author Nico_ND1
 */
public class Module {

    @Expose
    private final String name, schwierigkeit;
    @Expose
    private boolean lite;
    @Expose
    private int fails;

    public Module(String name, String schwierigkeit) {
        this.name = name;
        this.schwierigkeit = schwierigkeit;
        this.lite = false;
        this.fails = 0;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the schwierigkeit
     */
    public String getSchwierigkeit() {
        return schwierigkeit;
    }

    /**
     * @return the lite
     */
    public boolean isLite() {
        return lite;
    }

    /**
     * @param lite the lite to set
     */
    public void setLite(boolean lite) {
        this.lite = lite;
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
