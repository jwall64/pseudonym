package dev.jwall64.plib;

import java.util.Optional;

public record PlaceholderInstance<T, P>(Placeholder<T, P> parent, P param) {

    public Optional<T> resolve(PlaceholderContext ctx) {
        return parent.resolve(new ResolveContext<>(ctx, this));
    }

}
