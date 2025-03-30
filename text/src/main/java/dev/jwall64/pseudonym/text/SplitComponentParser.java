package dev.jwall64.pseudonym.text;

import dev.jwall64.pseudonym.MessageConverter;
import dev.jwall64.pseudonym.PipelineContext;
import dev.jwall64.pseudonym.PartialMessage;

import java.util.List;

public class SplitComponentParser implements MessageConverter<String, List<Component>> {

    private final ConfigTextParser parser;

    public SplitComponentParser(ConfigTextParser parser) {
        this.parser = parser;
    }

    @Override
    public PartialMessage<List<Component>> apply(PartialMessage<String> message, PipelineContext ctx) {
        return message.map(parser::parseSplit);
    }
}