/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon.types.bedwars;

import de.bergwerklabs.labymodaddon.LabyBergwerk;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

/**
 *
 * @author  Nico_ND1
 */
public class ShopModule extends SimpleModule {

    public ShopModule() {
        LabyBergwerk.getInstance().getApi().registerModule(this);
        LabyBergwerk.getInstance().getBedWars().getModules().add(this);

        getBooleanElement().setVisible(false);
    }

    @Override
    public String getDisplayName() {
        return "Shop";
    }

    @Override
    public String getDisplayValue() {
        return LabyBergwerk.getInstance().getBedWars().getShop();
    }

    @Override
    public String getDefaultValue() {
        return "0";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.CHEST);
    }

    @Override
    public void loadSettings() {
        //null
    }

    @Override
    public String getSettingName() {
        return "Shop";
    }

    @Override
    public String getDescription() {
        return "Zeigt deinen Shop an";
    }

    @Override
    public int getSortingId() {
        return 0;
    }

    @Override
    public ModuleCategory getCategory() {
        return LabyBergwerk.getInstance().getCategory();
    }

    @Override
    public boolean isShown() {
        return LabyBergwerk.getInstance().getBedWars().isEnabled() && getBooleanElement().getCurrentValue();
    }

}
