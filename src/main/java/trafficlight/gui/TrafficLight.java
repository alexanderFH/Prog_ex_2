package trafficlight.gui;


import trafficlight.states.State;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TrafficLight extends Light implements Observer {

    TrafficLight(Color color) {
        super(color);
    }

    public void turnOn(boolean a) {
        isOn = a;
        repaint();
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.turnOn(!isOn);
    }

    //TODO implement a part of the pattern here
}
