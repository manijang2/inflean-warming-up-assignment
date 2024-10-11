package cleancode.day07.studycafe.act;

import cleancode.day07.studycafe.io.InputHandler;
import cleancode.day07.studycafe.io.OutputHandler;
import cleancode.day07.studycafe.io.StudyCafeFileHandler;
import cleancode.day07.studycafe.model.StudyCafePass;
import cleancode.day07.studycafe.model.StudyCafePassList;
import cleancode.day07.studycafe.model.StudyCafePassType;

import java.util.List;

public class HourActor implements Actor {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

    public HourActor(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    @Override
    public void act() {
        List<StudyCafePass> hourlyPasses = getStudyCafePasses();
        StudyCafePass selectedPass = askHourlyPass(hourlyPasses);
        showPass(selectedPass);
    }

    private void showPass(StudyCafePass selectedPass) {
        outputHandler.showPassOrderSummary(selectedPass);
    }

    private StudyCafePass askHourlyPass(List<StudyCafePass> hourlyPasses) {
        outputHandler.showPassListForSelection(hourlyPasses);
        return inputHandler.getSelectPass(hourlyPasses);
    }

    private List<StudyCafePass> getStudyCafePasses() {
        StudyCafePassList studyCafePassList = studyCafeFileHandler.readStudyCafePasses();
        return studyCafePassList.extractCafePasses(StudyCafePassType.HOURLY);
    }
}
