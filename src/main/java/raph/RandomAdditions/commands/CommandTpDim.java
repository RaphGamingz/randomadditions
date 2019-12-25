package raph.RandomAdditions.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;
import raph.RandomAdditions.init.ModDimensions;
import raph.RandomAdditions.tools.TeleportationTools;

public class CommandTpDim implements Command<CommandSource> {

    private static final CommandTpDim CMD = new CommandTpDim();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("dim")
                .requires(cs -> cs.hasPermissionLevel(0))
                .executes(CMD);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().asPlayer();
        if (player.dimension.equals(ModDimensions.MAGICAL_DIM_TYPE)) {
            TeleportationTools.teleportPlayer(player, DimensionType.OVERWORLD, new BlockPos(player.posX, player.posY, player.posZ));
        } else {
            TeleportationTools.teleportPlayer(player, ModDimensions.MAGICAL_DIM_TYPE, new BlockPos(player.posX, player.posY, player.posZ));
        }
        return 0;
    }
}