package dev.jwall64.plib.lang;

import dev.jwall64.plib.UnresolvedMessage;

import java.util.Collections;
import java.util.Map;

public record LangRegistry(Map<String, UnresolvedMessage<String>> registry) {

    public static LangRegistry EMPTY = new LangRegistry(Collections.emptyMap());

}
