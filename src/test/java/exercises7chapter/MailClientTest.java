package exercises7chapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "exercises7chapter.*")
public class MailClientTest {
    private final static String ADDRESS = "ADDRESS";
    private final static String TITLE = "TITLE";
    private final static String BODY = "BODY";
    private MailClient mailClient = new MailClient();

    @Test
    public  void testTheEmailSent() throws Exception {
        Email email = mock(Email.class);
        PowerMockito.whenNew(Email.class).withArguments(ADDRESS,TITLE,BODY).thenReturn(email);
        PowerMockito.mockStatic(EmailServer.class);
        mailClient.sendEmail(ADDRESS,TITLE,BODY);
        PowerMockito.verifyStatic(times(1));
        EmailServer.sendEmail(email);
    }
}
