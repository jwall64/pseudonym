package dev.jwall64.plib.mc;

import net.minecraft.network.chat.Component;
import dev.jwall64.plib.MessageConverter;
import dev.jwall64.plib.PlaceholderContext;
import dev.jwall64.plib.UnresolvedMessage;

public class ComponentParser implements MessageConverter<String, Component> {

    private final ConfigTextParser parser;

    public ComponentParser(ConfigTextParser parser) {
        this.parser = parser;
    }

    @Override
    public UnresolvedMessage<Component> apply(UnresolvedMessage<String> message, PlaceholderContext ctx) {
        return message.map(parser::parse);
    }
}
