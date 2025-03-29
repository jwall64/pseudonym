package dev.jwall64.pseudonym.text;

import java.util.List;

public record ImmutableComponent(Content content, Style style, List<Component> children) implements Component {

}
