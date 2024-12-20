package me.justahuman.recently_connected.mixin;

import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerServerListWidget;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.option.ServerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(MultiplayerScreen.class)
public class MultiplayerScreenMixin {
    @Shadow private ServerList serverList;
    @Shadow protected MultiplayerServerListWidget serverListWidget;

    @Inject(at = @At("HEAD"), method = "connect(Lnet/minecraft/client/network/ServerInfo;)V")
    public void onConnect(ServerInfo entry, CallbackInfo ci) {
        if (entry.getServerType() == ServerInfo.ServerType.LAN) {
            return;
        }

        List<ServerInfo> servers = ((ServerListAccessor) serverList).getServers();
        servers.remove(entry);
        servers.addFirst(entry);
        serverListWidget.setServers(serverList);
        serverList.saveFile();
    }
}
