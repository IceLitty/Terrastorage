package me.timvinci.terrastorage.client.integration;

import me.timvinci.terrastorage.client.gui.TerrastorageOptionsScreen;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

/**
 * Integrates Mod Menu functionality.
 */
@Deprecated
public class ModMenuIntegration implements ModMenuApi {

    /**
     * Register the options screen to be used by Mod Menu.
     * @return A new instance of the Terrastorage options screen.
     */
    @Override
    public ConfigScreenFactory getModConfigScreenFactory() {
        return null;
//        return TerrastorageOptionsScreen::new;
    }
}
