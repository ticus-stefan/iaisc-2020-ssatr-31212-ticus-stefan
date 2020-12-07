package capsule;

import port.Port2;
import port.Port3;
import statemachine.StateMachine2;

public class Capsule2 extends Capsule {
    public Port2 port2;
    public Port3 port3;
    public StateMachine2 stateMachine2;

    public Capsule2() {
        port2 = new Port2();
        port3 = new Port3();
        stateMachine2 = new StateMachine2();
    }
}
