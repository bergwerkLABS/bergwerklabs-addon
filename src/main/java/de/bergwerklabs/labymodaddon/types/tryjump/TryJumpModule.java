/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bergwerklabs.labymodaddon.types.tryjump;

import de.bergwerklabs.labymodaddon.LabyBergwerk;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;

/**
 *
 * @author  Nico_ND1
 */
public class TryJumpModule extends SimpleModule {
    
    public TryJumpModule() {
        LabyBergwerk.getInstance().getApi().registerModule(this);
        LabyBergwerk.getInstance().getTryJump().setTryJumpModule(this);
    }

    @Override
    public void init() {
        getBooleanElement().addCallback(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean t) {
                for(net.labymod.ingamegui.Module module : LabyBergwerk.getInstance().getTryJump().getModules()) {
                    module.getBooleanElement().setVisible(t);
                }
            }
        });
        
        getBooleanElement().setSettingEnabled(true);
        getBooleanElement().updateScreen();
        
        setKeyVisible(false);
        this.bold = true;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public String getDisplayValue() {
        return null;
    }

    @Override
    public String getDefaultValue() {
        return null;
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.SLIME_BALL);
    }

    @Override
    public void loadSettings() {
        //null
    }
    
    @Override
    public void fillSubSettings(List<SettingsElement> list) {
        list.clear();
    }

    @Override
    public String getSettingName() {
        return "§bTryJump-Module";
    }

    @Override
    public String getDescription() {
        return "Zeige die Module für TryJump an";
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
        return false;
    }

}
