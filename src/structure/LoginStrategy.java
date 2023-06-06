package structure;

import java.io.FileNotFoundException;

abstract public class LoginStrategy {
    public boolean login() throws FileNotFoundException {
        return false;
    }
}
