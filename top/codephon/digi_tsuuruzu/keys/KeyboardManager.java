package top.codephon.digi_tsuuruzu.keys;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import java.util.ArrayList;
import java.util.List;

public class KeyboardManager {
    public static final List<KeyBinding> KEY_BINDINGS = new ArrayList<>();
    public static final KeyBinding LOOK_DIGIMON_FULL_DATA = new DTrKeyBending(new TranslationTextComponent("open_fulldata").getString(),  72 ,new TranslationTextComponent("key.dtr").getString());

    @OnlyIn(Dist.CLIENT)
    public static void init() {
        for (KeyBinding key: KEY_BINDINGS) {
            ClientRegistry.registerKeyBinding(key);
        }
    }
}
