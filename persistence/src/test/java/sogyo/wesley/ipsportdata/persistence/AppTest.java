package sogyo.wesley.ipsportdata.persistence;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        App2 classUnderTest = new App2();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
