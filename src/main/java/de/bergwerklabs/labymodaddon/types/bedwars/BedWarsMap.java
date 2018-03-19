/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon.types.bedwars;

import com.google.gson.annotations.Expose;

/**
 *
 * @author  Nico_ND1
 */
public class BedWarsMap {
    
    @Expose
    private final String name, author;
    
    public BedWarsMap(String name, String author) {
        this.name = name;
        this.author = author;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

}
