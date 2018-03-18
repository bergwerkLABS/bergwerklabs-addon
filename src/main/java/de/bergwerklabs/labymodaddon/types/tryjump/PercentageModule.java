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
public class PercentageModule extends SimpleModule {
    
    public PercentageModule() {
        LabyBergwerk.getInstance().getApi().registerModule(this);
    }

    @Override
    public String getDisplayName() {
        return "Prozent-Anzeige";
    }

    @Override
    public String getDisplayValue() {
        return LabyBergwerk.getInstance().getTryJump().getPercent() + "%";
    }

    private int defaultValue = 0;
    
    @Override
    public String getDefaultValue() {
        if(defaultValue > 100) {
            defaultValue = 0;
        }
        
        return defaultValue++ + "%";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.ACTIVATOR_RAIL);
    }

    @Override
    public void loadSettings() {
    }

    @Override
    public String getSettingName() {
        return "Prozent-Anzeige";
    }

    @Override
    public String getDescription() {
        return "Zeigt an wie weit du bist";
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
