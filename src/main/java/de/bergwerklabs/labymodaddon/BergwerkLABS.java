/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergwerklabs.labymodaddon;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.List;
import net.labymod.api.events.TabListEvent;
import net.labymod.main.LabyMod;
import net.labymod.servermanager.ChatDisplayAction;
import net.labymod.servermanager.Server;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.network.PacketBuffer;
import scala.actors.threadpool.Arrays;

/**
 *
 * @author Nico_ND1
 */
public class BergwerkLABS extends Server {

    public BergwerkLABS(String... addressNames) {
        super("bergwerkLABS", addressNames);
    }

    @Override
    public void onJoin(ServerData sd) {
        JsonElement ele = new Gson().toJsonTree("test");

        LabyBergwerk.getInstance().getApi().sendJsonMessageToServer("LABYBERGWERK", ele);

        LabyBergwerk.getInstance().getApi().displayMessageInChat("Du bist auf bergwerkLABS!");
    }

    @Override
    public ChatDisplayAction handleChatMessage(String string, String string1) throws Exception {
        return ChatDisplayAction.NORMAL;
    }

    @Override
    public void handlePluginMessage(String string, PacketBuffer pb) throws Exception {
    }

    @Override
    public void handleTabInfoMessage(TabListEvent.Type type, String formattedText, String unformattedText) throws Exception {
        
    }

    @Override
    public void fillSubSettings(List<SettingsElement> list) {
        list.clear();
    }

}
