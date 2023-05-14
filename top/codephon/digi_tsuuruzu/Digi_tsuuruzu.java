package top.codephon.digi_tsuuruzu;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.codephon.digi_tsuuruzu.keys.KeyboardManager;
import top.codephon.digi_tsuuruzu.network.NetworkRegHandler;

@Mod("digi_tsuuruzu")
@Mod.EventBusSubscriber(modid = "digi_tsuuruzu",bus = Mod.EventBusSubscriber.Bus.MOD)
public class Digi_tsuuruzu {
    public static final String MOD_ID;

    static {
        MOD_ID = "digi_tsuuruzu";
    }
    public Digi_tsuuruzu() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::onClientSetup);
        modEventBus.addListener(this::onCommonSetup);
    }


    @SubscribeEvent
    public void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(NetworkRegHandler::registerMessage);
    }


    public void onClientSetup(FMLClientSetupEvent event){
        KeyboardManager.init();
    }
}
