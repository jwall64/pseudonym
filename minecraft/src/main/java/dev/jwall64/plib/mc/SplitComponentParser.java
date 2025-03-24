package dev.jwall64.plib.mc;

import net.minecraft.network.chat.Component;
import dev.jwall64.plib.MessageConverter;
import dev.jwall64.plib.PlaceholderContext;
import dev.jwall64.plib.UnresolvedMessage;

import java.util.List;

public class SplitComponentParser implements MessageConverter<String, List<Component>> {

    private final ConfigTextParser parser;

    public SplitComponentParser(ConfigTextParser parser) {
        this.parser = parser;
    }

    @Override
    public UnresolvedMessage<List<Component>> apply(UnresolvedMessage<String> message, PlaceholderContext ctx) {
        return message.map(parser::parseSplit);
    }
}
