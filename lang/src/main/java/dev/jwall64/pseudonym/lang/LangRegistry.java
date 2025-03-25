package dev.jwall64.pseudonym.lang;

import dev.jwall64.pseudonym.UnresolvedMessage;

import java.util.Collections;
import java.util.Map;

public record LangRegistry(Map<String, UnresolvedMessage<String>> registry) {

    public static LangRegistry EMPTY = new LangRegistry(Collections.emptyMap());

}
