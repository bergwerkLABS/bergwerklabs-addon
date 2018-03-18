/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergwerklabs.labymodaddon.types.lobby;

import de.bergwerklabs.labymodaddon.LabyBergwerk;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.ingamegui.enums.EnumDisplayType;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

/**
 *
 * @author Nico_ND1
 */
public class RangModule extends SimpleModule {

    public RangModule() {
        LabyBergwerk.getInstance().getApi().registerModule(this);
    }

    @Override
    public String getDisplayName() {
        return "Dein Rang";
    }

    @Override
    public String getDisplayValue() {
        return LabyBergwerk.getInstance().getLobby().getRang();
    }

    @Override
    public String getDefaultValue() {
        return "Spieler";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.DIAMOND_CHESTPLATE);
    }

    @Override
    public void loadSettings() {
        //null
    }

    @Override
    public String getSettingName() {
        return "Rang";
    }

    @Override
    public String getDescription() {
        return "Zeigt deinen Rang an";
    }

    @Override
    public int getSortingId() {
        return 0;
    }

    @Override
    public ModuleCategory getCategory() {
        return LabyBergwerk.getInstance().getCategory();
    }
    
    private boolean shown = false;
    @Override
    public boolean isShown() {
        if(!shown) {
            shown = true;
            return LabyBergwerk.getInstance().getLobby().isEnabled();
        }
        
        return LabyBergwerk.getInstance().getLobby().isEnabled() && getBooleanElement().getCurrentValue();
    }

}
