package structure;

import java.io.FileNotFoundException;

public class SearchMethod {
    private SearchStrategy strategy;

    public void setStrategy(SearchStrategy strategy){
        this.strategy = strategy;
    }

    public void dosearch() throws FileNotFoundException {
        strategy.search();
    }
}
