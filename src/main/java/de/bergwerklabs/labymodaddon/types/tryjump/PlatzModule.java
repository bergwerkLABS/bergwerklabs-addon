/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon.types.tryjump;

import de.bergwerklabs.labymodaddon.LabyBergwerk;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

/**
 *
 * @author  Nico_ND1
 */
public class PlatzModule extends SimpleModule {
    
    public PlatzModule() {
        LabyBergwerk.getInstance().getApi().registerModule(this);
        LabyBergwerk.getInstance().getTryJump().getModules().add(this);
        
        getBooleanElement().setVisible(false);
    }

    @Override
    public String getDisplayName() {
        return "Platz";
    }

    @Override
    public String getDisplayValue() {
        return LabyBergwerk.getInstance().getTryJump().getPlatz() + ".";
    }

    @Override
    public String getDefaultValue() {
        return "0.";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.GOLD_BLOCK);
    }

    @Override
    public void loadSettings() {
    }

    @Override
    public String getSettingName() {
        return "Platz";
    }

    @Override
    public String getDescription() {
        return "Zeigt an auf welchem Platz du bist";
    }

    @Override
    public int getSortingId() {
        return 0;
    }
    
    @Override
    public boolean isShown() {
        return LabyBergwerk.getInstance().getTryJump().getState() == TryJump.TryJumpState.INGAME && LabyBergwerk.getInstance().getTryJump().isEnabled() &&
                getBooleanElement().getCurrentValue();
    }

    @Override
    public ModuleCategory getCategory() {
        return LabyBergwerk.getInstance().getCategory();
    }

}
