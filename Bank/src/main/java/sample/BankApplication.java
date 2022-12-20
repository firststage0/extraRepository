package sample;

import repository.DBHandler;
import ru.vsuet.bank.User;

public class BankApplication {

    private static BankApplication instance;
    private UserService userService;

    private User activeUser;
    public static BankApplication getInstance() {
        if (instance == null) {
            instance = new BankApplication();
        }
        return instance;
    }

    private BankApplication() {
        init();
    }

    public UserService getUserService() {
        return userService;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    private void init() {
        DBHandler dbHandler = new DBHandler();
        UserRepository repository = new UserRepository(dbHandler);
        userService = new UserService(repository);
    }
}
