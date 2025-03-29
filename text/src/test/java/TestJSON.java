import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dev.jwall64.mdcfg.codec.JSONCodec;
import dev.jwall64.mdcfg.serializer.ConfigContext;
import dev.jwall64.pseudonym.text.Color;
import dev.jwall64.pseudonym.text.Component;

public class TestJSON {

    @Test
    public void canSerializeBasic() {

        Component cmp = Component.text("Hello");
        String json = JSONCodec.minified().encodeToString(ConfigContext.INSTANCE, Component.SERIALIZER.serialize(ConfigContext.INSTANCE, cmp).getOrThrow());

        Assertions.assertEquals("{\"text\":\"Hello\"}", json);

    }

    @Test
    public void canSerializeColored() {

        Component cmp = Component.text("Hello").withColor(new Color.RGB(0x123ABC));
        String json = JSONCodec.minified().encodeToString(ConfigContext.INSTANCE, Component.SERIALIZER.serialize(ConfigContext.INSTANCE, cmp).getOrThrow());

        Assertions.assertEquals("{\"text\":\"Hello\",\"color\":\"#123ABC\"}", json);

    }

    @Test
    public void canSerializeExtra() {

        Component cmp = Component.text("Hello, ").append("World");
        String json = JSONCodec.minified().encodeToString(ConfigContext.INSTANCE, Component.SERIALIZER.serialize(ConfigContext.INSTANCE, cmp).getOrThrow());

        Assertions.assertEquals("{\"text\":\"Hello, \",\"extra\":[{\"text\":\"World\"}]}", json);

    }
}
