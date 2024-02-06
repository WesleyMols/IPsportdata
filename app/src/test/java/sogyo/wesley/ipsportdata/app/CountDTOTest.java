package sogyo.wesley.ipsportdata.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CountDTOTest {
    private int count;
    CountDTO test = new CountDTO();
    
    @Test
    void getCountTest() {
        assertEquals(count, test.getCount());
    }

    @Test
    void setCountTest() {
        count = 4;
        test.setCount(4);
        assertEquals(count, test.getCount());
    }
}
