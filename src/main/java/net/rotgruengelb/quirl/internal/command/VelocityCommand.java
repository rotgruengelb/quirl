package net.rotgruengelb.quirl.internal.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.server.command.ServerCommandSource;

public class VelocityCommand implements Command<ServerCommandSource> {
    public static int add(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        var entities = EntityArgumentType.getEntities(context, "targets");

        float x = FloatArgumentType.getFloat(context, "x");
        float y = FloatArgumentType.getFloat(context, "y");
        float z = FloatArgumentType.getFloat(context, "z");

        for (Entity entity : entities) {
            entity.addVelocity(x, y, z);
            entity.velocityModified = true;
        }
        return 1;
    }

    public static int set(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        var entities = EntityArgumentType.getEntities(context, "targets");

        float x = FloatArgumentType.getFloat(context, "x");
        float y = FloatArgumentType.getFloat(context, "y");
        float z = FloatArgumentType.getFloat(context, "z");

        for (Entity entity : entities) {
            entity.setVelocity(x, y, z);
            entity.velocityModified = true;
        }
        return 1;
    }

    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        return 0;
    }
}
