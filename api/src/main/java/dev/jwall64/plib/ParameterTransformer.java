package dev.jwall64.plib;

public interface ParameterTransformer<T> {

    T transform(UnresolvedMessage<String> parameter);


    ParameterTransformer<UnresolvedMessage<String>> IDENTITY = parameter -> parameter;
    ParameterTransformer<String> RESOLVE_EARLY = parameter -> UnresolvedMessage.resolve(parameter, new PipelineContext());

}
