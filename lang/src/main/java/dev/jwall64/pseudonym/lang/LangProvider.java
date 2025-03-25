package dev.jwall64.pseudonym.lang;

import dev.jwall64.mdcfg.ConfigObject;
import dev.jwall64.mdcfg.ConfigSection;
import dev.jwall64.mdcfg.codec.FileCodecRegistry;
import dev.jwall64.mdcfg.codec.FileWrapper;
import dev.jwall64.mdcfg.serializer.ConfigContext;
import dev.jwall64.pseudonym.PipelineContext;
import dev.jwall64.pseudonym.UnresolvedMessage;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface LangProvider {

    <T> Optional<LangRegistry> get(LangManager<T> manager, String language);

    static LangProvider forDirectory(Path directory, FileCodecRegistry codecRegistry) {
        return new Directory(directory, codecRegistry);
    }

    record Directory(Path searchDirectory, FileCodecRegistry registry) implements LangProvider {

        @Override
        public <T> Optional<LangRegistry> get(LangManager<T> manager, String language) {

            FileWrapper<ConfigObject> wrapper = registry.find(ConfigContext.INSTANCE, language, searchDirectory);
            if (wrapper == null) return Optional.empty();

            if(wrapper.getRoot() == null || !wrapper.getRoot().isSection()) return Optional.empty();

            ConfigSection sec = wrapper.getRoot().asSection();

            Map<String, UnresolvedMessage<String>> messages = new HashMap<>();
            for(String key : sec.getKeys()) {
                ConfigObject obj = sec.get(key);
                if(!obj.isString()) continue;
                messages.put(key, manager.parser.accept(obj.asString(), PipelineContext.of(manager)));
            }

            return Optional.of(new LangRegistry(Map.copyOf(messages)));
        }
    }

}
