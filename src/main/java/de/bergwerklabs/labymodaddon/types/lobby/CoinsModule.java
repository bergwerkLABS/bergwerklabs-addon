/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergwerklabs.labymodaddon.types.lobby;

import de.bergwerklabs.labymodaddon.LabyBergwerk;
import java.util.Random;
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
public class CoinsModule extends SimpleModule {

    public CoinsModule() {
        LabyBergwerk.getInstance().getApi().registerModule(this);

        /*setKeyVisible(false);
        settingUpdated(false);
        getBooleanElement().setVisible(false);
        getBooleanElement().getButtonAdvanced().enabled = false;
        getBooleanElement().setSettingEnabled(false);
        getBooleanElement().setSelected(false);
        getBooleanElement().updateScreen();*/
    }

    @Override
    public String getDisplayName() {
        return "Coins";
    }

    @Override
    public String getDisplayValue() {
        return String.valueOf(LabyBergwerk.getInstance().getLobby().getCoins());
    }

    @Override
    public String getDefaultValue() {
        return "0";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.GOLD_INGOT);
    }

    @Override
    public void loadSettings() {
        //null
    }

    @Override
    public String getSettingName() {
        return "Coins";
    }

    @Override
    public String getDescription() {
        return "Zeigt deine Coins an";
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
