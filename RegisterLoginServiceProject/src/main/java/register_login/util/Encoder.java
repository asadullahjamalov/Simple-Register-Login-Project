package register_login.util;


public class Encoder {
    public static String encode(String password) {
        char[] chars = password.toCharArray();
        StringBuilder encoded_password = new StringBuilder();
        encoded_password.append("$2a$10$wMxw2Gu0ZJejxetEh4mu");
        for (char c : chars) {
            char c1 = (char) (c + 2);
            encoded_password.append(c1);
        }
        encoded_password.append("Y.fLM7BkOKtzriM0.MZyEmxuGeMk4rEkq");
        return encoded_password.toString();
    }

}
