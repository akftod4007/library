package structure;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

abstract class Subject {
    private static final List<Observer> observers = new ArrayList<>();
    public static void attach(Observer observer) {//Observer 인터페이스를 구현한 객체를 observers 리스트에 추가, 통보 대상 추가
        observers.add(observer);
    }

    public static void detach(Observer observer) {//Observer 인터페이스를 구현한 객체를 observers 리스트에서 제거, 통보 대상 제거
        observers.remove(observer);
    }

    public static void notifyObservers() throws FileNotFoundException {
        for (Observer o : observers) o.update();
    }
}