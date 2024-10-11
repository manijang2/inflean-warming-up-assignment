package cleancode.day07.studycafe.act;

import cleancode.day07.studycafe.io.InputHandler;
import cleancode.day07.studycafe.io.OutputHandler;
import cleancode.day07.studycafe.io.StudyCafeFileHandler;
import cleancode.day07.studycafe.model.*;

import java.util.List;

public class FixActor implements Actor {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

    public FixActor(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    @Override
    public void act() {

        List<StudyCafePass> fixedPasses = getStudyCafePasses();

        StudyCafePass selectedPass = askFixStudyCafePass(fixedPasses);

        StudyCafeLockerPassList lockerPasses = studyCafeFileHandler.readLockerPasses();
        lockerPasses.get(selectedPass.getPassType(), selectedPass.getDuration()).ifPresent(
                lockerPass -> {
                    boolean lockerSelection = askLockerUsage(lockerPass);
                    if (lockerSelection) {
                        selectedPass.useLockerPass(lockerPass);
                    }
                    outputHandler.showPassOrderSummary(selectedPass);
                }
        );
    }

    private List<StudyCafePass> getStudyCafePasses() {
        StudyCafePassList passList = studyCafeFileHandler.readStudyCafePasses();
        return passList.extractCafePasses(StudyCafePassType.FIXED);
    }

    private boolean askLockerUsage(StudyCafeLockerPass lockerPass) {
        outputHandler.showAskLockerPass(lockerPass);
        return inputHandler.getLockerSelection();
    }

    private StudyCafePass askFixStudyCafePass(List<StudyCafePass> fixedPasses) {
        outputHandler.showPassListForSelection(fixedPasses);
        return inputHandler.getSelectPass(fixedPasses);
    }
}
