package me.justahuman.recently_connected.mixin;

import net.minecraft.client.option.ServerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(ServerList.class)
public class ServerListMixin {
    @Redirect(method = "add", at = @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z"))
    public <E> boolean addFirst(List<E> instance, E e) {
        instance.addFirst(e);
        return true;
    }
}
