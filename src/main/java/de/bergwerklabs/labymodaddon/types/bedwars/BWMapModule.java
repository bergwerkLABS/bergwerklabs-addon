/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergwerklabs.labymodaddon.types.bedwars;

import de.bergwerklabs.labymodaddon.LabyBergwerk;
import java.util.List;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleTextModule;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;

/**
 *
 * @author Nico_ND1
 */
public class BWMapModule extends SimpleTextModule {

    public BWMapModule() {
        LabyBergwerk.getInstance().getApi().registerModule(this);
        LabyBergwerk.getInstance().getBedWars().getModules().add(this);
        
        getBooleanElement().setVisible(false);
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.MAP);
    }

    @Override
    public void loadSettings() {
    }

    @Override
    public String getSettingName() {
        return "Map Info";
    }

    @Override
    public String getDescription() {
        return "Zeigt dir Infos über die aktuelle Map an";
    }

    @Override
    public int getSortingId() {
        return 0;
    }

    @Override
    public boolean isShown() {
        return LabyBergwerk.getInstance().getBedWars().isEnabled() && getBooleanElement().getCurrentValue() && (isAutor() || isName());
    }

    @Override
    public String[] getValues() {
        if (LabyBergwerk.getInstance().getBedWars().getMap() != null) {
            if (isAutor() && isName()) {
                return new String[]{LabyBergwerk.getInstance().getBedWars().getMap().getAuthor(), LabyBergwerk.getInstance().getBedWars().getMap().getName()};
            } else if (isAutor()) {
                return new String[]{LabyBergwerk.getInstance().getBedWars().getMap().getAuthor()};
            } else if (isName()) {
                return new String[]{LabyBergwerk.getInstance().getBedWars().getMap().getName()};
            }
        }
        return new String[]{};
    }

    @Override
    public String[] getDefaultValues() {
        if (isAutor() && isName()) {
            return new String[]{"/", "/"};
        } else if (isAutor()) {
            return new String[]{"/"};
        } else if (isName()) {
            return new String[]{"/"};
        }
        return new String[]{};
    }

    @Override
    public String[] getKeys() {
        if (isAutor() && isName()) {
            return new String[]{"Autor", "Name"};
        } else if (isAutor()) {
            return new String[]{"Autor"};
        } else if (isName()) {
            return new String[]{"Name"};
        }
        return new String[]{};
    }

    @Override
    public String[] getDefaultKeys() {
        if (isAutor() && isName()) {
            return new String[]{"Autor", "Name"};
        } else if (isAutor()) {
            return new String[]{"Autor"};
        } else if (isName()) {
            return new String[]{"Name"};
        }
        return new String[]{};
    }

    @Override
    public ModuleCategory getCategory() {
        return LabyBergwerk.getInstance().getCategory();
    }

    @Override
    public void fillSubSettings(List<SettingsElement> settingsElements) {
        settingsElements.add(new BooleanElement("Zeige Autor an.", new ControlElement.IconData(Material.BOOK_AND_QUILL), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean t) {
                autor = t;
            }
        }, true));

        settingsElements.add(new BooleanElement("Zeige Name an.", new ControlElement.IconData(Material.MAP), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean t) {
                name = t;
            }
        }, true));
    }

    private boolean autor = true, name = true;

    public boolean isAutor() {
        return autor;
    }

    public void setAutor(boolean autor) {
        this.autor = autor;
    }

    public boolean isName() {
        return name;
    }

    public void setName(boolean name) {
        this.name = name;
    }

}
