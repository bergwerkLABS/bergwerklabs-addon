/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergwerklabs.labymodaddon.types.flash;

import de.bergwerklabs.labymodaddon.LabyBergwerk;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

/**
 *
 * @author Nico_ND1
 */
public class CheckpointModule extends SimpleModule {

    public CheckpointModule() {
        LabyBergwerk.getInstance().getApi().registerModule(this);
        LabyBergwerk.getInstance().getFlash().getModules().add(this);

        getBooleanElement().setVisible(false);
    }

    @Override
    public String getDisplayName() {
        return "Checkpoints";
    }

    @Override
    public String getDisplayValue() {
        return String.valueOf(LabyBergwerk.getInstance().getFlash().getCheckpoint());
    }

    @Override
    public String getDefaultValue() {
        return "0";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.GOLD_PLATE);
    }

    @Override
    public void loadSettings() {
        //null
    }

    @Override
    public String getSettingName() {
        return "Checkpoints";
    }

    @Override
    public String getDescription() {
        return "Zeigt deine Checkpoints an";
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
        return LabyBergwerk.getInstance().getFlash().getState() == Flash.FlashState.INGAME
                && LabyBergwerk.getInstance().getFlash().isEnabled() && getBooleanElement().getCurrentValue();
    }

}
