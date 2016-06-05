package chapter5;

public class Messenger {
    private TemplateEngine templateEngine;
    private MailServer mailServer;
    public Messenger(MailServer mailServer,
                     TemplateEngine templateEngine) {
        this.mailServer = mailServer;
        this.templateEngine = templateEngine;
    }
    public void sendMessage(Client client, Template template) {
        String msgContent =
                templateEngine.prepareMessage(template, client);
        mailServer.send(client.getEmail(), msgContent);
    }
    public interface TemplateEngine{
        String  prepareMessage(Template template, Client client);
    }
    public abstract class MailServer{
        abstract void send(String email, String message);
    }
    public abstract class Client{
        abstract String getEmail();
    }
    public interface Template{}
}
