package com.sarinsa.starvingtotem.common.network;

import com.sarinsa.starvingtotem.common.entity.AbstractAltarEntity;
import com.sarinsa.starvingtotem.common.network.message.S2CUpdateAltarOrientation;
import net.minecraftforge.fml.network.PacketDistributor;

public class NetworkHelper {

    public static void sendAltarRotationUpdate(AbstractAltarEntity altarEntity, float rotation) {
        PacketHandler.CHANNEL.send(PacketDistributor.ALL.noArg(), new S2CUpdateAltarOrientation(altarEntity.getId(), rotation));
    }
}
