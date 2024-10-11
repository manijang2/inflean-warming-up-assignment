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
        StudyCafePassList passList = studyCafeFileHandler.readStudyCafePasses();
        List<StudyCafePass> fixedPasses = passList.extractCafePasses(StudyCafePassType.FIXED);

        outputHandler.showPassListForSelection(fixedPasses);
        StudyCafePass selectedPass = inputHandler.getSelectPass(fixedPasses);

        StudyCafeLockerPassList lockerPassList = studyCafeFileHandler.readLockerPasses();
        lockerPassList.extract(selectedPass.getPassType(), selectedPass.getDuration()).ifPresent(
                lockerPass -> {
                    outputHandler.askLockerPass(lockerPass);
                    boolean lockerSelection = inputHandler.getLockerSelection();
                    if (lockerSelection) {
                        outputHandler.showPassOrderSummary(selectedPass, lockerPass);
                    } else {
                        outputHandler.showPassOrderSummary(selectedPass, null);
                    }
                }
        );
    }
}
