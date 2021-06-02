import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trafficlight.ctrl.TrafficLightCtrl;

import static org.junit.jupiter.api.Assertions.*;

public class TrafficLightCtrlTest {

    @Test
    @DisplayName("checkSingleton")
    public void Ctrl_SingletonCheck() {
        assertSame(TrafficLightCtrl.getInstance(), TrafficLightCtrl.getInstance());
    }

    @Test
    @DisplayName("checkStateBeginning")
    public void Ctrl_BeginningState() {
        assertSame(TrafficLightCtrl.getInstance().getCurrentState(),TrafficLightCtrl.getInstance().getGreenState());
    }

    @Test
    @DisplayName("checkStateYellowAfterGreen")
    public void Ctrl_YellowAfterGreen() {
        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        ctrl.nextState();
        assertSame(ctrl.getCurrentState(),ctrl.getYellowState());
    }

    @Test
    @DisplayName("checkStateRedAfterYellow")
    public void Ctrl_RedAfterYellow() {
        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        ctrl.resetStates();
        ctrl.nextState();
        ctrl.nextState();
        assertSame(ctrl.getCurrentState(),ctrl.getRedState());
    }

    @Test
    @DisplayName("checkStateYellowAfterRed")
    public void Ctrl_YellowAfterRed() {
        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        ctrl.resetStates();
        ctrl.nextState();
        ctrl.nextState();
        ctrl.nextState();
        assertSame(ctrl.getCurrentState(),ctrl.getYellowState());
    }

    @Test
    @DisplayName("checkStateGreenAfterYellow")
    public void Ctrl_GreenAfterYellow() {
        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        ctrl.resetStates();
        ctrl.nextState();
        ctrl.nextState();
        ctrl.nextState();
        ctrl.nextState();
        assertSame(ctrl.getCurrentState(),ctrl.getGreenState());
    }
}
