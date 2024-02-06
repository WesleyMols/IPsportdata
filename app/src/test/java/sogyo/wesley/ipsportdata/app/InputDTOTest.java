package sogyo.wesley.ipsportdata.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InputDTOTest {
    private String name;
    InputDTO test = new InputDTO();

    @Test
    void getUsernameTest() {
        assertEquals(name, test.getUsername());
    }

    @Test
    void setUsernameTest() {
        name = "Miss Swann";
        test.setUsername(name);
        assertEquals(name, test.getUsername());
    }
}
