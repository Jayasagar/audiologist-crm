package main.java.com.audiologist.crm.utils;

import com.audiologist.crm.utils.DateUtil;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void should_return_next_monday() {
        // Arrange and Act
        DateTime startOfTheWeek = DateUtil.getStartOfTheWeek();

        // Assert - Verify Day of the week is Monday!
        Assert.assertTrue(startOfTheWeek.getDayOfWeek() == 1);
    }
}
