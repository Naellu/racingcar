package org.example;

import org.example.model.Car;
import org.example.model.RandomNumber;
import org.example.model.UserInput;
import org.example.service.RacingService;
import org.example.valid.InputValueExceptions;
import org.example.valid.Validation;
import org.example.view.OutputMessage;

import java.util.List;

public class GameConfig {

    private OutputMessage outputMessage = new OutputMessage();
    private RacingService racingService = new RacingService();
    private RandomNumber randomNumber = new RandomNumber();

    private String userInput;
    private Car car;
    List<String> nameList;
    private int inputTurn;
    public void gameRun() {

        restart:
        while (true) {
            try {
                outputMessage.toStart();
                reRunInput();
                Validation.isRightInput(nameList);
            } catch (InputValueExceptions e) {
                e.printStackTrace();
                continue restart;
            }
            break;
        }

        // 턴 수 입력 문구
        outputMessage.enterTurnNumber();
        int inputTurn = UserInput.number();

        racingService.defaultPlayerMap(nameList);

        // 실행 결과 문구
        outputMessage.runResult();

        for (int i = 0; i < inputTurn; i++) {
            racingService.makeRandomNumOfCarName(nameList, randomNumber, inputTurn);
            outputMessage.resultLoopPrint(racingService);
        }
        outputMessage.printWinner(racingService.isWinner());
    }

    public void reRunInput() {
        this.userInput = UserInput.hasString();
        this.car = new Car(userInput);
        this.nameList = car.isMoreName(car);
    }

}
