package cleancode.day07.studycafe;

import cleancode.day07.studycafe.act.Actor;
import cleancode.day07.studycafe.exception.AppException;
import cleancode.day07.studycafe.io.InputHandler;
import cleancode.day07.studycafe.io.OutputHandler;
import cleancode.day07.studycafe.model.StudyCafePassType;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {
        try {

            showTitle();
            StudyCafePassType studyCafePassType = inputSelectedStudyPassType();
            act(studyCafePassType);

        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafePassType inputSelectedStudyPassType() {
        outputHandler.showAskPassTypeSelection();
        return inputHandler.getPassTypeSelectingUserAction();
    }

    private void showTitle() {
        outputHandler.showWelcomeMessage();
        outputHandler.showAnnouncement();
    }

    private void act(StudyCafePassType studyCafePassType) {

        Actor actor = studyCafePassType.getStudyCafePassActor(inputHandler, outputHandler);
        actor.act();
    }
}
