package dev.jwall64.pseudonym.mc.impl;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import dev.jwall64.pseudonym.MessagePipeline;
import dev.jwall64.pseudonym.PipelineContext;
import dev.jwall64.pseudonym.PlaceholderParser;
import dev.jwall64.pseudonym.mc.api.ServerPlaceholders;


import java.util.function.Supplier;

public class MainCommand {

    public static LiteralArgumentBuilder<CommandSourceStack> builder(String id, LiteralArgumentBuilder<CommandSourceStack> builder, CommandBuildContext buildCtx, Supplier<Void> data) {
        return builder
            .then(Commands.argument("targets", EntityArgument.players())
                .then(Commands.argument("message", StringArgumentType.greedyString())
                    .executes(ctx -> {

                        MinecraftServer server = ctx.getSource().getServer();
                        MessagePipeline<String, Component> pipeline = MessagePipeline.<String>builder()
                                .add(new PlaceholderParser(ServerPlaceholders.getServerPlaceholders(server)))
                                .add(ServerPlaceholders.COMPONENT_RESOLVER)
                                .build();

                        PipelineContext context = PipelineContext.of(ctx.getSource().getEntity());
                        Component message = pipeline.accept(StringArgumentType.getString(ctx, "message"), context);

                        for(ServerPlayer pl : EntityArgument.getPlayers(ctx, "targets")) {
                            pl.sendSystemMessage(message);
                        }

                        return 1;
                    })
            )
        );
    }

}
