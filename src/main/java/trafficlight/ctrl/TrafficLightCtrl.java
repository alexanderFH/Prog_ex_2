package trafficlight.ctrl;

import trafficlight.gui.TrafficLightGui;
import trafficlight.states.State;


public class TrafficLightCtrl {

    private static TrafficLightCtrl ctrl;
    private final TrafficLightGui gui;
    private State greenState;
    private State redState;
    private State yellowState;
    private State currentState;
    private State previousState;
    private boolean doRun = true;

    private TrafficLightCtrl() {
        super();
        initStates();
        gui = new TrafficLightGui(this);
        gui.setVisible(true);
        currentState.notifyObserver();
    }

    public static TrafficLightCtrl getInstance() {
        if (ctrl == null)
            ctrl = new TrafficLightCtrl();
        return ctrl;
    }

    private void initStates() {
        greenState = new State() {
            @Override
            public State getNextState() {
                previousState = currentState;
                currentState.notifyObserver();
                yellowState.notifyObserver();
                return yellowState;
            }

            @Override
            public String getColor() {
                return "green";
            }
        };

        redState = new State() {
            @Override
            public State getNextState() {
                previousState = currentState;
                currentState.notifyObserver();
                yellowState.notifyObserver();
                return yellowState;
            }

            @Override
            public String getColor() {
                return "red";
            }
        };

        yellowState = new State() {
            @Override
            public State getNextState() {
                currentState.notifyObserver();
                if (previousState.equals(greenState)) {
                    previousState = currentState;
                    redState.notifyObserver();
                    return redState;
                } else {
                    previousState = currentState;
                    greenState.notifyObserver();
                    return greenState;
                }
            }

            @Override
            public String getColor() {
                return "yellow";
            }
        };
        currentState = greenState;
        previousState = yellowState;
    }

    public State getGreenState() {
        return greenState;
    }

    public State getRedState() {
        return redState;
    }

    public State getYellowState() {
        return yellowState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void run() {
        int intervall = 1500;
        while (doRun) {
            try {
                Thread.sleep(intervall);
                nextState();
            } catch (InterruptedException e) {
                gui.showErrorMessage(e);
            }
        }
        System.out.println("Stopped");
        System.exit(0);
    }

    public void nextState() {
        currentState = currentState.getNextState();
    }

    public void resetStates() {
        currentState = greenState;
        previousState = yellowState;
    }

    public void stop() {
        doRun = false;
    }
}