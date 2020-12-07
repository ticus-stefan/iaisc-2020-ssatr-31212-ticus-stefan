import capsule.Capsule1;
import capsule.Capsule2;

public class main {
    public static void main(String[] args) {
        Capsule1 capsule1=new Capsule1();
        Capsule2 capsule2=new Capsule2();
        capsule1.stateMachine1.connect(capsule1.port1);
        capsule2.stateMachine2.connect(capsule2.port3);
        capsule1.port1.connect(capsule2.port2);
        capsule2.port2.connect(capsule2.port3);
        capsule1.stateMachine1.start();
        capsule2.stateMachine2.start();
        capsule1.port1.signal1();
        capsule1.port1.signal2();
        capsule2.port2.sendFordward2();
        capsule2.port2.sendFordward1();
        capsule2.port3.handle1();
        capsule2.port3.handel2();
    }
}
