import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dev.jwall64.pseudonym.MessagePipeline;
import dev.jwall64.pseudonym.PipelineContext;

public class TestPipeline {

    @Test
    public void testToString() {

        MessagePipeline<Object, String> pipeline = MessagePipeline.builder()
                .add(Object::toString)
                .build();

        String str = pipeline.accept(3, new PipelineContext());
        Assertions.assertEquals("3", str);
    }

}
