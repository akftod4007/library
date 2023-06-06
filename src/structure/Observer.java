package structure;

import java.io.FileNotFoundException;

interface Observer  {
    void update() throws FileNotFoundException;
}