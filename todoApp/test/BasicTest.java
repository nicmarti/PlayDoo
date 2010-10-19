import controllers.Application;
import org.junit.*;

import java.util.*;

import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void shouldReturnOnePageIfTotalIsLowerThanPageSize() {
        assertEquals("Should return 1 if page size is 5 and total is 3", 1,
                Application.computeTotalPage(5, 3));
    }

    @Test
    public void shouldReturnOnePageIfTotalIsEqualsToPageSize() {
        assertEquals("Should return 1 if page size is 10 and total is 10", 1,
                Application.computeTotalPage(10, 10));
    }

    @Test
    public void shouldReturnTwoPagesIfTotalIsGreaterThanPageSize() {
        assertEquals("Should return 2 if page size is 10 and total is 12", 2,
                Application.computeTotalPage(10, 12));
    }

    @Test
    public void shouldReturnThreePagesIfTotalIsGreaterThanPageSize() {
        assertEquals("Should return 3 if page size is 5 and total is 12", 3,
                Application.computeTotalPage(5, 12));
    }


}

