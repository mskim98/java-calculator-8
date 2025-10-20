package calculator.methods;

public class StringValidator {

    // 빈 문자열 판별
    private boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    // 구분자 분리
    private String[] spliter(String delimiter, String text) {
        String result = text;

        // 커스텀 구분자가 있으면 쉼표로 치환
        if (delimiter.length() > 2) {
            char customDelimiter = delimiter.charAt(2);
            result = result.replace(customDelimiter, ',');
        }

        // 기본 구분자로 분리
        return result.split("[,:]");
    }

    // 문자열 합산
    private int attach(String[] numbers) {
        int result = 0;
        for (String s : numbers) {
            String trimmed = s.trim();
            if (!trimmed.isEmpty()) {
                result += Integer.parseInt(trimmed);
            }
        }
        return result;
    }

    // 커스텀 구분자 여부 검사
    private boolean isCustom(String text) {
        int backslashIndex = text.indexOf('\\');
        int nIndex = text.indexOf('n');

        if (text.startsWith("//")) {
            if (backslashIndex != 3 || nIndex != 4) {
                throw new IllegalArgumentException("잘못된 입력");
            }

            char delimiter = text.charAt(2);
            if (Character.isWhitespace(delimiter) || Character.isDigit(delimiter)) {
                throw new IllegalArgumentException("잘못된 입력");
            }

            return true;
        }

        if (backslashIndex != -1 || nIndex != -1) {
            throw new IllegalArgumentException("잘못된 입력");
        }

        return false;
    }

    // 커스텀 구분자 처리
    private int check(String text) {
        String delimiter = ",:";

        if (isCustom(text)) {
            delimiter += text.charAt(2);
            text = text.substring(5);
        }

        String[] splited = spliter(delimiter, text);
        return attach(splited);
    }

    // 검증 로직
    public int validate(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        return check(text);
    }
}