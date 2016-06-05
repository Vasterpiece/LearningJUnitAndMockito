package chapter5;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MessengerTest {
    private static final String CLIENT_EMAIL = "some@email.com";
    private static final String MSG_CONTENT = "Dear John! You are fired.";
    @Test
    public void shouldSendEmail() {
        Messenger.Template template = mock(Messenger.Template.class);
        Messenger.Client client = mock(Messenger.Client.class);
        Messenger.MailServer mailServer = mock(Messenger.MailServer.class);
        Messenger.TemplateEngine templateEngine = mock(Messenger.TemplateEngine.class);
        Messenger sut = new Messenger(mailServer, templateEngine);
        when(client.getEmail()).thenReturn(CLIENT_EMAIL);
        when(templateEngine.prepareMessage(template, client))
                .thenReturn(MSG_CONTENT);
        sut.sendMessage(client, template);
        verify(templateEngine).prepareMessage(template,client);
        verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
    }
}
