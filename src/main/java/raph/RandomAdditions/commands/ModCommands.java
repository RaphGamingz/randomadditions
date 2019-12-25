package raph.RandomAdditions.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import raph.RandomAdditions.RandomAdditions;

public class ModCommands {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralCommandNode<CommandSource> cmdTut = dispatcher.register(
                Commands.literal(RandomAdditions.MODID)
                        .then(CommandSpawner.register(dispatcher))
                        .then(CommandTpDim.register(dispatcher))
        );
        dispatcher.register(Commands.literal("randomadditionsraph").redirect(cmdTut));
    }
}