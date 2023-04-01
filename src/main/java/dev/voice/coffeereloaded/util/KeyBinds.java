package dev.voice.coffeereloaded.util;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBinds {
    public static final String KEY_CATEGORY_TABS = "key.category.coffeereloaded.tabs";

    public static final String KEY_OPEN_TAB = "key.coffeereloaded.open_tab";

    public static final KeyMapping OPEN_TAB_KEY = new KeyMapping(KEY_OPEN_TAB, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, 98, KEY_CATEGORY_TABS);
}