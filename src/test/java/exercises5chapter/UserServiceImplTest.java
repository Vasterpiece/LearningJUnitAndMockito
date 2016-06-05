package exercises5chapter;

import exercises5chapter.helping.classes.SecurityService;
import exercises5chapter.helping.classes.User;
import exercises5chapter.helping.classes.UserDAO;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {
    private static final String PASSWORD = "Pass";
    private static final String PASSWORD_MD5 = "MD5";
    private SecurityService securityService = mock(SecurityService.class);
    private User user = mock(User.class);
    private UserDAO userDAO = mock(UserDAO.class);
    private UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);

    @Test
    public void verifyUserDAOUpdateMethodIsCalled() throws Exception {
        when(user.getPassword()).thenReturn(PASSWORD);
        when(securityService.md5(PASSWORD)).thenReturn(PASSWORD_MD5);
        userService.assignPassword(user);
        verify(user).setPassword(PASSWORD_MD5);
        verify(userDAO).updateUser(user);
    }
}
