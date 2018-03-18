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
public class TokensModule extends SimpleModule {
    
    public TokensModule() {
        LabyBergwerk.getInstance().getApi().registerModule(this);
    }

    @Override
    public String getDisplayName() {
        return "Tokens";
    }

    @Override
    public String getDisplayValue() {
        return LabyBergwerk.getInstance().getTryJump().getTokens() + "";
    }

    @Override
    public String getDefaultValue() {
        return "100";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.GOLD_NUGGET);
    }

    @Override
    public void loadSettings() {
    }

    @Override
    public String getSettingName() {
        return "Tokens";
    }

    @Override
    public String getDescription() {
        return "Zeigt an wie viele Tokens du hast";
    }

    @Override
    public int getSortingId() {
        return 0;
    }
    
    @Override
    public boolean isShown() {
        return (LabyBergwerk.getInstance().getTryJump().getState() == TryJump.TryJumpState.INGAME || LabyBergwerk.getInstance().getTryJump().getState() == TryJump.TryJumpState.SHOP)
                && LabyBergwerk.getInstance().getTryJump().isEnabled() && getBooleanElement().getCurrentValue();
    }

    @Override
    public ModuleCategory getCategory() {
        return LabyBergwerk.getInstance().getCategory();
    }

}
