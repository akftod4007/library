package structure;

import java.io.FileNotFoundException;

public class LoginMethod {
    private LoginStrategy strategy;

    public void setStrategy(LoginStrategy strategy){
        this.strategy = strategy;
    }

    public boolean dologin() throws FileNotFoundException {
        return strategy.login();
    }
}
