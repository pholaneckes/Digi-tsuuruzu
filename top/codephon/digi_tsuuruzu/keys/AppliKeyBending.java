package top.codephon.digi_tsuuruzu.keys;

import net.minecraft.client.settings.KeyBinding;
import top.codephon.digi_tsuuruzu.Digi_tsuuruzu;

public class AppliKeyBending extends KeyBinding {
    public AppliKeyBending(String description, int keyCode, String category) {
        super(String.format("key.%s.%s", Digi_tsuuruzu.MOD_ID, description), keyCode, category);
        KeyboardManager.KEY_BINDINGS.add(this);
    }
}
