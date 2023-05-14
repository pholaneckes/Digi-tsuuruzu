package top.codephon.digi_tsuuruzu.events;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.codephon.digi_tsuuruzu.screens.DigimonFullDataScreen;
import top.codephon.digi_tsuuruzu.utils.Ways;

import static top.codephon.digi_tsuuruzu.keys.KeyboardManager.LOOK_DIGIMON_FULL_DATA;

@Mod.EventBusSubscriber(modid = "digi_tsuuruzu", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KeyListener {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onKeyPressed(InputEvent.KeyInputEvent event) {
        if (Minecraft.getInstance().screen == null) {
            if (event.getKey() == LOOK_DIGIMON_FULL_DATA.getKey().getValue()){
                if(event.getAction() == 0 && Minecraft.getInstance().getCameraEntity() instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) Minecraft.getInstance().getCameraEntity();
                    Entity digimon = Ways.getPointedEntity(player, 64.0);
                    if(digimon != null){
                        DigimonFullDataScreen.fz0 = "no";
                        OpenFullDataGui(digimon,(byte) 1);
                    }
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static void OpenFullDataGui(Entity entity, byte page) {
        if(entity != null) {
            Minecraft.getInstance().setScreen(new DigimonFullDataScreen(entity, page));
        }
    }
}
