package calculator;

import calculator.methods.StringValidator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        StringValidator validator = new StringValidator();

        validator.validate(input);
    }
}
