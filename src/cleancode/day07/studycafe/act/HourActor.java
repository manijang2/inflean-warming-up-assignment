package cleancode.day07.studycafe.act;

import cleancode.day07.studycafe.io.InputHandler;
import cleancode.day07.studycafe.io.OutputHandler;
import cleancode.day07.studycafe.io.StudyCafeFileHandler;
import cleancode.day07.studycafe.model.StudyCafePass;
import cleancode.day07.studycafe.model.StudyCafePassList;
import cleancode.day07.studycafe.model.StudyCafePassType;

import java.util.List;

public class HourActor implements Actor {

    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    private StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

    public HourActor(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    @Override
    public void act() {
        StudyCafePassList studyCafePassList = studyCafeFileHandler.readStudyCafePasses();
        List<StudyCafePass> hourlyPasses = studyCafePassList.extractCafePasses(StudyCafePassType.HOURLY);
        outputHandler.showPassListForSelection(hourlyPasses);
        StudyCafePass selectedPass = inputHandler.getSelectPass(hourlyPasses);
        outputHandler.showPassOrderSummary(selectedPass, null);
    }
}
