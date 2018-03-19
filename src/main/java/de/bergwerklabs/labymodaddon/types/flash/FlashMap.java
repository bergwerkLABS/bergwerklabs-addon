/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon.types.flash;

/**
 *
 * @author  Nico_ND1
 */
public class FlashMap {
    
    private final String name, author;
    
    public FlashMap(String name, String author) {
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
