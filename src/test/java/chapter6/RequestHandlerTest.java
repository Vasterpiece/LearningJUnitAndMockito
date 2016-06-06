package chapter6;


import org.junit.Test;
import org.mockito.Mockito;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.mock;

public class RequestHandlerTest {
    @Test
    public void shouldThrowExceptions() throws InvalidRequestException {
        Request request = new Request();
        RequestProcessor requestProcessor = mock(RequestProcessor.class);
        RequestHandler sut = new RequestHandler(requestProcessor);
        try {
            sut.handle(request);
            fail("InvalidRequestException must be thrown!");
        }
        catch (InvalidRequestException ex){
            assertTrue("Should have thrown exception of InvalidRequestException class",
                    ex instanceof InvalidRequestException);
            Mockito.verifyZeroInteractions(requestProcessor);
        }
    }

}
