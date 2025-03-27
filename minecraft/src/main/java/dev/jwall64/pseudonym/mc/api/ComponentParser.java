package dev.jwall64.pseudonym.mc.api;

import net.minecraft.network.chat.Component;
import dev.jwall64.pseudonym.MessageConverter;
import dev.jwall64.pseudonym.PipelineContext;
import dev.jwall64.pseudonym.UnresolvedMessage;
import dev.jwall64.pseudonym.mc.impl.ConfigTextParserImpl;

public class ComponentParser implements MessageConverter<String, Component> {

    private final ConfigTextParserImpl parser;

    public ComponentParser(ConfigTextParserImpl parser) {
        this.parser = parser;
    }

    @Override
    public UnresolvedMessage<Component> apply(UnresolvedMessage<String> message, PipelineContext ctx) {
        return message.map(parser::parse);
    }
}
