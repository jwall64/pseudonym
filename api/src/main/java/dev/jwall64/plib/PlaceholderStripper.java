package dev.jwall64.plib;

import dev.jwall64.mdcfg.Either;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderStripper<T> implements MessagePipeline.PipelineStage<UnresolvedMessage<T>, List<T>> {

    @Override
    public List<T> apply(UnresolvedMessage<T> message, PlaceholderContext ctx) {
        List<T> out = new ArrayList<>();
        for(Either<T, PlaceholderInstance<?, ?>> e : message.parts()) {
            if(e.hasLeft()) {
                out.add(e.leftOrThrow());
            }
        }
        return List.copyOf(out);
    }
}
