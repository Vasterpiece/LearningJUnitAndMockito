package exrcises6chapter;

import exercises6chapter.HelpDesk;
import exercises6chapter.TimeProvider;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JUnitParamsRunner.class)
public class HelpDeskTest {
    private static int testCount = 0;
    private static Object[] getDataForHandledIssues(){
        return new Object[]{
                new Object[]{Calendar.MONDAY,17},
                new Object[]{Calendar.TUESDAY,17},
                new Object[]{Calendar.WEDNESDAY,17},
                new Object[]{Calendar.THURSDAY,17},
                new Object[]{Calendar.FRIDAY,17}
        };
    }

    private static Object[] getDataForUnhandledIssues(){
        return new Object[]{
                new Object[]{Calendar.FRIDAY,18},
                new Object[]{Calendar.SATURDAY,17},
                new Object[]{Calendar.SUNDAY,17}
        };
    }

    private TimeProvider timeProvider = mock(TimeProvider.class);
    private HelpDesk helpDesk = new HelpDesk(timeProvider);
    private Calendar mockCalendar = mock(Calendar.class);

    private  void setUp(int dayOfWeek, int hour){
        when(timeProvider.getCalendar()).thenReturn(mockCalendar);
        when(mockCalendar.get(Calendar.DAY_OF_WEEK)).thenReturn(dayOfWeek);
        when(mockCalendar.get(Calendar.HOUR_OF_DAY)).thenReturn(hour);
        System.out.println("Test count: " + ++testCount);
        System.out.println("DayOfweek: " + dayOfWeek + " hour: " + hour);
    }

    @Test
    @Parameters(method = "getDataForHandledIssues")
    public void testThatTheIssueWillBeHandled(int dayOfWeek, int hour){
        setUp(dayOfWeek, hour);
        Assert.assertTrue(helpDesk.willHandleIssue(12));
    }

    @Test
    @Parameters(method = "getDataForUnhandledIssues")
    public void testThatTheIssueWillNotBeHandled(int dayOfWeek, int hour){
        setUp(dayOfWeek, hour);
        Assert.assertFalse(helpDesk.willHandleIssue(12));
    }
}
