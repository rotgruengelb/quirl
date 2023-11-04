package net.rotgruengelb.quirl.internal.command;

import com.mojang.brigadier.arguments.FloatArgumentType;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;

public class CommandNodes {

    public static void registerModCommandNodes() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> {

            var floatArgType = FloatArgumentType.floatArg();

            var velocityNode = CommandManager.literal("velocity").requires(Permissions.require("quirl.command.velocity", 2)).build();

            var targetsArg = CommandManager.argument("targets", EntityArgumentType.entities()).build();

            var addNode = CommandManager.literal("add").build();

            var xAddArg = CommandManager.argument("x", floatArgType).build();
            var yAddArg = CommandManager.argument("y", floatArgType).build();
            var zAddArg = CommandManager.argument("z", floatArgType).executes(VelocityCommand::add).build();

            var setNode = CommandManager.literal("set").build();

            var xSetArg = CommandManager.argument("x", floatArgType).build();
            var ySetArg = CommandManager.argument("y", floatArgType).build();
            var zSetArg = CommandManager.argument("z", floatArgType).executes(VelocityCommand::set).build();

            dispatcher.getRoot().addChild(velocityNode);
            velocityNode.addChild(targetsArg);
            targetsArg.addChild(addNode);
            addNode.addChild(xAddArg);
            xAddArg.addChild(yAddArg);
            yAddArg.addChild(zAddArg);
            targetsArg.addChild(setNode);
            setNode.addChild(xSetArg);
            xSetArg.addChild(ySetArg);
            ySetArg.addChild(zSetArg);
        }));
    }
}
