package calculator.methods;

public class StringValidator {

    // 빈 문자열 판별
    private boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    // 구분자 분리
    private String[] spliter(String text) {
        return text.split("[,:]");
    }

    // 분리된 문자열 병합
    private int attach(String[] text) {
        int result = 0;
        for (String s : text) {
            result += Integer.parseInt(s);
        }
        return result;
    }

    public void validate(String text) {
        if (isEmpty(text)) {
            new IllegalArgumentException("Empty String");
        }

        System.out.println(attach(spliter(text)));
    }
}