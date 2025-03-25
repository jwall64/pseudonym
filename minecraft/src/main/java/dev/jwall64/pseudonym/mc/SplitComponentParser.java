package dev.jwall64.pseudonym.mc;

import net.minecraft.network.chat.Component;
import dev.jwall64.pseudonym.MessageConverter;
import dev.jwall64.pseudonym.PipelineContext;
import dev.jwall64.pseudonym.UnresolvedMessage;

import java.util.List;

public class SplitComponentParser implements MessageConverter<String, List<Component>> {

    private final ConfigTextParser parser;

    public SplitComponentParser(ConfigTextParser parser) {
        this.parser = parser;
    }

    @Override
    public UnresolvedMessage<List<Component>> apply(UnresolvedMessage<String> message, PipelineContext ctx) {
        return message.map(parser::parseSplit);
    }
}
