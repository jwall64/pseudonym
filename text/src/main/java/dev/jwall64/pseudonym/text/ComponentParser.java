package dev.jwall64.pseudonym.text;

import dev.jwall64.pseudonym.MessageConverter;
import dev.jwall64.pseudonym.PipelineContext;
import dev.jwall64.pseudonym.PartialMessage;

public class ComponentParser implements MessageConverter<String, Component> {

    private final ConfigTextParser parser;

    public ComponentParser(ConfigTextParser parser) {
        this.parser = parser;
    }

    @Override
    public PartialMessage<Component> apply(PartialMessage<String> message, PipelineContext ctx) {
        return message.map(parser::parse);
    }
}
