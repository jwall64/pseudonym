package dev.jwall64.pseudonym;


public interface MessageConverter<T, O> extends MessagePipeline.PipelineStage<UnresolvedMessage<T>, UnresolvedMessage<O>> { }
