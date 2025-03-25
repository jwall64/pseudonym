package dev.jwall64.plib;


public interface MessageConverter<T, O> extends MessagePipeline.PipelineStage<UnresolvedMessage<T>, UnresolvedMessage<O>> { }
