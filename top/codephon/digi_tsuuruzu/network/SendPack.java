package top.codephon.digi_tsuuruzu.network;

import mod.cyan.digimobs.entities.DigimonEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public class SendPack {

    private final UUID uuid;
    private final int anInt;
    private final short type;
    private final byte numB;
    private final String text;

    public SendPack(PacketBuffer buffer) {
        uuid = buffer.readUUID();
        anInt = buffer.readInt();
        type = buffer.readShort();
        text = buffer.readUtf();
        numB = buffer.readByte();
    }

    public SendPack(UUID uuid, String text, Byte numB, Integer anInt, short type) {
        this.uuid = uuid;
        this.anInt = anInt;
        this.type = type;
        this.text = text;
        this.numB = numB;
    }


    public void toBytes(PacketBuffer buf) {
        buf.writeUUID(this.uuid);
        buf.writeInt(this.anInt);
        buf.writeShort(this.type);
        buf.writeUtf(this.text);
        buf.writeByte(this.numB);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player = ctx.get().getSender();
            if(type == 1) {
                editEvoLine(player, uuid, text, numB, (byte) anInt);
            }
        });
        ctx.get().setPacketHandled(true);
    }

    public static void editEvoLine (ServerPlayerEntity playerEntity, UUID uuid, String lj, Byte num, Byte id){
        DigimonEntity digimob = (DigimonEntity) ((ServerWorld)(playerEntity.level)).getEntity(uuid);
        String to = lj.substring(0, lj.indexOf(","));
        String now = lj.substring(to.length()+1);
        if(digimob != null) {
            switch (id) {
                case 0:
                    digimob.digivolutions.setBabyForm(to);
                case 1:
                    digimob.digivolutions.setInTrainingForm(to);
                case 2:
                    digimob.digivolutions.setRookieForm(to);
                case 3:
                    digimob.digivolutions.getChampionForms().put(to, new CompoundNBT());
                    digimob.getEvolutions().getCompound(now).putString("ChampionForm" + num, to);
                case 4:
                    digimob.digivolutions.getUltimateForms().put(to, new CompoundNBT());
                    digimob.digivolutions.getChampionForms().getCompound(now).putString("UltimateForm" + num, to);
                case 5:
                    digimob.digivolutions.getMegaForms().put(to, new CompoundNBT());
                    digimob.digivolutions.getUltimateForms().getCompound(now).putString("MegaForm" + num, to);
            }
        }
    }


}
