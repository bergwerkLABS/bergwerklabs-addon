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
public class RemainingLivesModule extends SimpleModule {
    
    public RemainingLivesModule() {
        LabyBergwerk.getInstance().getApi().registerModule(this);
    }

    @Override
    public String getDisplayName() {
        return "Verbleibende Leben";
    }

    @Override
    public String getDisplayValue() {
        return LabyBergwerk.getInstance().getTryJump().getLives() + "";
    }
    
    @Override
    public String getDefaultValue() {
        return "3";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.APPLE);
    }

    @Override
    public void loadSettings() {
    }

    @Override
    public String getSettingName() {
        return "Verbleibende Leben";
    }

    @Override
    public String getDescription() {
        return "Zeigt an wie viele Leben du noch hast";
    }

    @Override
    public int getSortingId() {
        return 0;
    }
    
    @Override
    public boolean isShown() {
        return LabyBergwerk.getInstance().getTryJump().getState() == TryJump.TryJumpState.FIGHT && LabyBergwerk.getInstance().getTryJump().isEnabled() &&
                getBooleanElement().getCurrentValue();
    }

    @Override
    public ModuleCategory getCategory() {
        return LabyBergwerk.getInstance().getCategory();
    }

}
