package net.agten.heatersimulator.domain.algorithm;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Fuzzy implements ControllerAlgorithm {
    String fileName = "tipper.fcl";
    FIS fis;
    FunctionBlock fb;
    public short targetAdc;

    public Fuzzy() {
        this.fis = FIS.load(fileName, true);
        if (this.fis == null) {
            System.err.println("Can't load file: '" + fileName + "'");
            System.exit(1);
        }
        this.fb = fis.getFunctionBlock(null);
    }

    @Override
    public short nextValue(short curAdc) {
        this.fb.setVariable("targetAdc", this.targetAdc);
        this.fb.setVariable("currentAdc", curAdc);
        this.fb.evaluate();
        return (short) fb.getVariable("result").defuzzify();
    }

    @Override
    public void setTargetAdc(short targetAdc) {
        this.targetAdc = targetAdc;
    }
}