package dev.jwall64.pseudonym.lang;

import dev.jwall64.mdcfg.ConfigObject;
import dev.jwall64.mdcfg.codec.FileCodecRegistry;
import dev.jwall64.mdcfg.codec.FileWrapper;
import dev.jwall64.mdcfg.serializer.ConfigContext;
import dev.jwall64.pseudonym.MessagePipeline;

import java.nio.file.Path;
import java.util.Optional;

public interface LangProvider<P> {

    <R> Optional<LangRegistry<P>> get(LangManager<P, R> manager, String language);

    static <P> LangProvider<P> forDirectory(Path directory, FileCodecRegistry codecRegistry, MessagePipeline<String, P> parser) {
        return new Directory<P>(directory, codecRegistry, parser);
    }

    record Directory<P>(Path searchDirectory, FileCodecRegistry registry, MessagePipeline<String, P> parser) implements LangProvider<P> {

        @Override
        public <R> Optional<LangRegistry<P>> get(LangManager<P, R> manager, String language) {

            FileWrapper<ConfigObject> wrapper = registry.find(ConfigContext.INSTANCE, language, searchDirectory);
            if (wrapper == null || wrapper.getRoot() == null) return Optional.empty();

            return LangRegistry.serializer(parser).deserialize(ConfigContext.INSTANCE, wrapper.getRoot()).get();

        }
    }

}
