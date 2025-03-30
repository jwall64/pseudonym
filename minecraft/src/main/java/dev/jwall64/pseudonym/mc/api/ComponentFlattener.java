package dev.jwall64.pseudonym.mc.api;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.PlainTextContents;
import dev.jwall64.pseudonym.MessagePipeline;
import dev.jwall64.pseudonym.PipelineContext;
import dev.jwall64.pseudonym.PartialMessage;

public class ComponentFlattener<T> implements MessagePipeline.PipelineStage<PartialMessage<T>, PartialMessage<T>> {

    public static String flatten(Component component) {

        StringBuilder builder = new StringBuilder();
        if(component.getContents() instanceof PlainTextContents text) {
            builder.append(text.text());
        }

        for(Component c : component.getSiblings()) {
            builder.append(flatten(c));
        }

        return builder.toString();
    }

    @Override
    public PartialMessage<T> apply(PartialMessage<T> message, PipelineContext ctx) {
        return message.mapPlaceholders(Component.class, String.class, ComponentFlattener::flatten);
    }
}
