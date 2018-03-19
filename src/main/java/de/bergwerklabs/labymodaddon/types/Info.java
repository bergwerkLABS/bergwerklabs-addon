/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon.types;

import com.google.gson.JsonObject;
import de.bergwerklabs.labymodaddon.LabyBergwerk;
import java.util.ArrayList;
import java.util.List;
import net.labymod.ingamegui.Module;

/**
 *
 * @author  Nico_ND1
 */
public abstract class Info {
    
    public abstract String getName();
    public abstract String getDescription();
    public abstract String[] getServerName();
    //public abstract boolean isEnabled();
    public abstract void handle(JsonObject obj);

    public abstract boolean isEnabled();
    
    public boolean isOnServer() {
        for(String s : getServerName()) {
            if(LabyBergwerk.getInstance().getApi().getCurrentServer() != null && 
                    LabyBergwerk.getInstance().getApi().getCurrentServer().getIp().contains("bergwerklabs.de") &&
                    LabyBergwerk.getInstance().getServerType() != null && LabyBergwerk.getInstance().getServerType().contains(s)) {
                return true;
            }
        }
        
        return false;
    }
    
    private final List<Module> modules = new ArrayList<Module>();

    public List<Module> getModules() {
        return modules;
    }
    
}
