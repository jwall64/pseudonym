package dev.jwall64.plib;

public record ResolveContext<T, P>(PlaceholderContext context, PlaceholderInstance<T, P> placeholder) {
}
