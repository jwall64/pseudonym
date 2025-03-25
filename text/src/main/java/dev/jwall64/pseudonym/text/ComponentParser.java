package dev.jwall64.pseudonym.text;

import dev.jwall64.pseudonym.MessageConverter;
import dev.jwall64.pseudonym.PipelineContext;
import dev.jwall64.pseudonym.UnresolvedMessage;

public class ComponentParser implements MessageConverter<String, Component> {

    private final ConfigTextParser parser;

    public ComponentParser(ConfigTextParser parser) {
        this.parser = parser;
    }

    @Override
    public UnresolvedMessage<Component> apply(UnresolvedMessage<String> message, PipelineContext ctx) {
        return message.map(parser::parse);
    }
}
