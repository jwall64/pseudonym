import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dev.jwall64.plib.MessagePipeline;
import dev.jwall64.plib.PlaceholderContext;

public class TestPipeline {

    @Test
    public void testToString() {

        MessagePipeline<Object, String> pipeline = MessagePipeline.builder()
                .add(Object::toString)
                .build();

        String str = pipeline.accept(3, new PlaceholderContext());
        Assertions.assertEquals("3", str);
    }

}
