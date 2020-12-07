package capsule;

import port.Port1;
import statemachine.StateMachine1;

public class Capsule1 extends Capsule {
    public Port1 port1;
    public StateMachine1 stateMachine1;

    public Capsule1() {
        port1 = new Port1();
        stateMachine1 = new StateMachine1();
    }
}
