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
                        outputHandler.showPassOrderSummary(selectedPass, null);
                    } else {
                        outputHandler.showPassOrderSummary(selectedPass, null);
                    }
                }
        );
    }

    private List<StudyCafePass> getStudyCafePasses() {
        StudyCafePassList passList = studyCafeFileHandler.readStudyCafePasses();
        List<StudyCafePass> fixedPasses = passList.extractCafePasses(StudyCafePassType.FIXED);
        return fixedPasses;
    }

    private boolean askLockerUsage(StudyCafeLockerPass lockerPass) {
        outputHandler.showAskLockerPass(lockerPass);
        boolean lockerSelection = inputHandler.getLockerSelection();
        return lockerSelection;
    }

    private StudyCafePass askFixStudyCafePass(List<StudyCafePass> fixedPasses) {
        outputHandler.showPassListForSelection(fixedPasses);
        return inputHandler.getSelectPass(fixedPasses);
    }
}
