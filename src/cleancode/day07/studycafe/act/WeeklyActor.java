package cleancode.day07.studycafe.act;

import cleancode.day07.studycafe.io.InputHandler;
import cleancode.day07.studycafe.io.OutputHandler;
import cleancode.day07.studycafe.io.StudyCafeFileHandler;
import cleancode.day07.studycafe.model.StudyCafePass;
import cleancode.day07.studycafe.model.StudyCafePassList;
import cleancode.day07.studycafe.model.StudyCafePassType;

import java.util.List;

public class WeeklyActor implements Actor {

    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    private StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

    public WeeklyActor(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    @Override
    public void act() {
        StudyCafePassList studyCafePassList = getWeeklyPasses();
        StudyCafePass selectedPass = askWeeklyPasses(studyCafePassList);
        showPass(selectedPass);
    }

    private void showPass(StudyCafePass selectedPass) {
        outputHandler.showPassOrderSummary(selectedPass, null);
    }

    private StudyCafePass askWeeklyPasses(StudyCafePassList studyCafePassList) {
        List<StudyCafePass> weeklyPasses = studyCafePassList.extractCafePasses(StudyCafePassType.WEEKLY);
        outputHandler.showPassListForSelection(weeklyPasses);
        StudyCafePass selectedPass = inputHandler.getSelectPass(weeklyPasses);
        return selectedPass;
    }

    private StudyCafePassList getWeeklyPasses() {
        StudyCafePassList studyCafePassList = studyCafeFileHandler.readStudyCafePasses();
        studyCafePassList.extractCafePasses(StudyCafePassType.WEEKLY);
        return studyCafePassList;
    }
}
