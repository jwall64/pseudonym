import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dev.jwall64.mdcfg.ConfigList;
import dev.jwall64.mdcfg.ConfigPrimitive;
import dev.jwall64.mdcfg.ConfigSection;
import dev.jwall64.mdcfg.serializer.ConfigContext;
import dev.jwall64.pseudonym.text.Component;
import dev.jwall64.pseudonym.text.Style;
import dev.jwall64.pseudonym.text.TextColor;

public class TestComponents {

    @Test
    public void canParseString() {

        String toParse = "Hello, World";
        Component cmp = Component.SERIALIZER.deserialize(ConfigContext.INSTANCE, new ConfigPrimitive(toParse)).getOrThrow();

        Assertions.assertEquals(Component.text("Hello, World"), cmp);
    }

    @Test
    public void canParseList() {

        ConfigList toParse = ConfigList.of("Hello, ", "World");
        Component cmp = Component.SERIALIZER.deserialize(ConfigContext.INSTANCE, toParse).getOrThrow();

        Assertions.assertEquals(Component.text("Hello, ").append("World"), cmp);
    }

    @Test
    public void canParseSection() {

        ConfigSection toParse = new ConfigSection().with("text", "Hello, World");
        Component cmp = Component.SERIALIZER.deserialize(ConfigContext.INSTANCE, toParse).getOrThrow();

        Assertions.assertEquals(Component.text("Hello, World"), cmp);
    }

    @Test
    public void canParseColored() {

        ConfigSection toParse = new ConfigSection().with("text", "Hello, World").with("color", "red");
        Component cmp = Component.SERIALIZER.deserialize(ConfigContext.INSTANCE, toParse).getOrThrow();

        Assertions.assertEquals(Component.text("Hello, World").withStyle(Style.EMPTY.withColor(TextColor.RED)), cmp);
    }

}
