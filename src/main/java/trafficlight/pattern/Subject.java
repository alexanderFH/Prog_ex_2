package trafficlight.pattern;

import java.util.ArrayList;

public class Subject {
    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObserver() {
        for (Observer o : observers)
            o.update();
    }
}
