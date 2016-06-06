package exercises6chapter;

import java.util.Calendar;

public class HelpDesk {
    private TimeProvider timeProvider;

    public HelpDesk(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }
    public final static int EOB_HOUR = 17;

    public boolean willHandleIssue(int issue) {
        Calendar cal = timeProvider.getCalendar();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek) {
            return false;
        }
        if (Calendar.FRIDAY == dayOfWeek) {
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            if (hour > EOB_HOUR) {
                return false;
            }
        }
        return true;
    }
}

