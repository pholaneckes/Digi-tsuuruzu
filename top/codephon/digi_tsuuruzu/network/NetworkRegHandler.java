package top.codephon.digi_tsuuruzu.network;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import top.codephon.digi_tsuuruzu.Digi_tsuuruzu;

public class NetworkRegHandler {
    public static SimpleChannel CHANNEL;
    private static final String VERSION = "0_PACK";
    private static int ID = 0;
    public static int nextID(){
        return ID++;
    }
    public static void registerMessage(){
        CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(Digi_tsuuruzu.MOD_ID, "dtr_pack"),
        ()->VERSION,
                (version)-> version.equals(VERSION),
                (version)-> version.equals(VERSION));
        CHANNEL.messageBuilder(SendPack.class, nextID())
                .encoder(SendPack::toBytes)
                .decoder(SendPack::new)
                .consumer(SendPack::handler)
                .add();
    }
}
