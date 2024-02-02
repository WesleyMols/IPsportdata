package sogyo.wesley.ipsportdata.domain;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

public class AnalysisFactoryTest {
    String name = "Julia";
    Analysor testObject = new Analysor(name);
    AnalysisFactory test = new AnalysisFactory();

    @Test
    void createNewAnalysisTest() {
        assertInstanceOf(Analysor.class, testObject);
       
    }
}
