package sample;

import ru.vsuet.bank.User;

public class UserService implements Service<User> {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getById(Long id) {
        return repository.find(id);
    }

    public User login(String userName, String password) {
        User user = repository.find(userName);
        boolean isPasswordMatch = user.getPassword().equals(password);
        if (!isPasswordMatch) {
            throw new RuntimeException("Password is incorrect");
        }
        return user;
    }
}
