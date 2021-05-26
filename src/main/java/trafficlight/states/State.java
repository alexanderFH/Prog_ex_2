package trafficlight.states;

//TODO implement a part of the pattern here

import java.util.Observable;

public abstract class State extends Observable {

    public abstract State getNextState();

    public abstract String getColor();

    public String getSting(){
        return getColor();
    }
}