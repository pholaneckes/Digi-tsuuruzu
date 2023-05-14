package top.codephon.digi_tsuuruzu.keys;

import net.minecraft.client.settings.KeyBinding;
import top.codephon.digi_tsuuruzu.Digi_tsuuruzu;

public class DTrKeyBending extends KeyBinding {
    public DTrKeyBending(String description, int keyCode, String category) {
        super(String.format("key.%s.%s", Digi_tsuuruzu.MOD_ID, description), keyCode, category);
        KeyboardManager.KEY_BINDINGS.add(this);
    }
}
