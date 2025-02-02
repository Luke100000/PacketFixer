package net.tonimatasdev.packetfixerforge.mixin;

import net.minecraft.nbt.NbtAccounter;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = NbtAccounter.class, priority = 9999)
public abstract class NbtAccounterMixin {
    // <= 1.18
    //@Redirect(method = "accountBits", at = @At(value = "FIELD", target = "Lnet/minecraft/nbt/NbtAccounter;quota:J", opcode = Opcodes.GETFIELD))
    //public long accountBits(NbtAccounter instance) {
    //    return Long.MAX_VALUE;
    //}

    // >= 1.19
    //@Redirect(method = "accountBytes", at = @At(value = "FIELD", target = "Lnet/minecraft/nbt/NbtAccounter;quota:J", opcode = Opcodes.GETFIELD))
    //public long accountBits(NbtAccounter instance) {
    //    return Long.MAX_VALUE;
    //}

    @Redirect(method = "accountBytes(J)V", at = @At(value = "FIELD", target = "Lnet/minecraft/nbt/NbtAccounter;quota:J", opcode = Opcodes.GETFIELD))
    public long accountBits(NbtAccounter instance) {
        return Long.MAX_VALUE;
    }
}
