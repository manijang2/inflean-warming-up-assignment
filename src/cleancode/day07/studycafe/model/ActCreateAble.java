package cleancode.day07.studycafe.model;

import cleancode.day07.studycafe.act.Actor;
import cleancode.day07.studycafe.io.InputHandler;
import cleancode.day07.studycafe.io.OutputHandler;

public interface ActCreateAble {

    Actor getStudyCafePassActor(InputHandler inputHandler, OutputHandler outputHandler);
}
