/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergwerklabs.labymodaddon.types.tryjump;

import de.bergwerklabs.labymodaddon.LabyBergwerk;
import java.util.ArrayList;
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
public class InfoModule extends SimpleTextModule {

    public InfoModule() {
        LabyBergwerk.getInstance().getApi().registerModule(this);
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.BOAT);
    }

    @Override
    public void loadSettings() {
        List<SettingsElement> list = new ArrayList<SettingsElement>();

        list.add(new BooleanElement("Zeige Fails an", new ControlElement.IconData(Material.BARRIER), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean t) {
                System.out.println("Switched it, bitch");
            }
        }, true));

        fillSubSettings(list);
    }

    @Override
    public String getSettingName() {
        return "Module-Info";
    }

    @Override
    public String getDescription() {
        return "Zeigt dir Infos über dein aktuelles Module an";
    }

    @Override
    public int getSortingId() {
        return 0;
    }

    @Override
    public boolean isShown() {
        return LabyBergwerk.getInstance().getTryJump().isEnabled() && getBooleanElement().getCurrentValue();
    }

    @Override
    public String[] getValues() {
        if (showFails) {
            String builder = "";
            if (LabyBergwerk.getInstance().getTryJump().getModule() != null) {
                for (int i = 1; i < LabyBergwerk.getInstance().getTryJump().getFails(); i++) {
                    builder += "X";
                }
                while (builder.length() < 3) {
                    builder += "x";
                }
            } else {
                builder = "xxx";
            }

            return new String[]{LabyBergwerk.getInstance().getTryJump().getModule() == null ? "/"
                : LabyBergwerk.getInstance().getTryJump().getModule().getSchwierigkeit(), builder};
        } else {
            return new String[]{LabyBergwerk.getInstance().getTryJump().getModule() == null ? "/"
                : LabyBergwerk.getInstance().getTryJump().getModule().getSchwierigkeit()};
        }
    }

    private long nextX = System.currentTimeMillis();
    private int xS = 0;

    @Override
    public String[] getDefaultValues() {
        if (showFails) {
            String builder = "";
            for (int i = 0; i < xS; i++) {
                builder += "X";
            }
            if (nextX < System.currentTimeMillis()) {
                nextX = System.currentTimeMillis() + 1000;
                xS++;
            }
            while (builder.length() < 3) {
                builder += "x";
            }
            if (xS > 3) {
                xS = 0;
            }

            return new String[]{"/", builder};
        } else {
            return new String[]{"/"};
        }
    }

    @Override
    public String[] getKeys() {
        if (showFails) {
            return new String[]{"Schwierigkeit", "Fails"};
        } else {
            return new String[]{"Schwierigkeit"};
        }
    }

    @Override
    public String[] getDefaultKeys() {
        if (showFails) {
            return new String[]{"Schwierigkeit", "Fails"};
        } else {
            return new String[]{"Schwierigkeit"};
        }
    }

    @Override
    public ModuleCategory getCategory() {
        return LabyBergwerk.getInstance().getCategory();
    }

    @Override
    public void fillSubSettings(List<SettingsElement> settingsElements) {
        settingsElements.add(new BooleanElement("Zeige Fails an", new ControlElement.IconData(Material.BARRIER), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean t) {
                showFails = t;
            }
        }, true));
    }

    private boolean showFails = true;

    public boolean isShowFails() {
        return showFails;
    }

}
