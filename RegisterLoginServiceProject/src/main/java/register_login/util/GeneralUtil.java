package register_login.util;

import java.util.Scanner;

public class GeneralUtil {
    public static String checkString(String info, boolean successMessage) {
        System.out.println("Enter the " + info);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String data = scanner.nextLine();
            if (data.matches("[A-Za-z0-9_\\s]+")) {
                if (successMessage) {
                    System.out.println(info + " was added");
                }
                return data;
            } else {
                System.out.println("Please enter " + info + " in correct format");
            }
        }
    }

    public static String checkPassword(String info, boolean successMessage) {
        System.out.println("Enter the " + info);
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        if (successMessage) {
            System.out.println(info + " was added");
        }
        return data;
    }

    public static String checkEmail(String info, boolean successMessage) {
        System.out.println("Enter the " + info + " email");
        OUT:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String data = scanner.nextLine();
            if (data.matches("[A-Za-z[.]_0-9]+[@][A-Za-z[.]_0-9]+[.][a-z]{2,4}")) {
                if (successMessage) {
                    System.out.println("Email was added");
                }
                return data;
            } else {
                System.out.println("Please enter email in correct format");
            }
        }
    }

    public static String checkPhoneNumber(String info, boolean successMessage) {
        System.out.println("Enter the " + info + " phone number (+YYY-YY-YYY-YY-YY)");
        OUT:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String data = scanner.nextLine();
            if (data.matches("[+][0-9]{3}[-][0-9]{2}[-][0-9]{3}[-][0-9]{2}[-][0-9]{2}")) {
                if (successMessage) {
                    System.out.println("Phone number was added");
                }
                return data;
            } else {
                System.out.println("Please enter phone number in correct format (+YYY-YY-YYY-YY-YY)");
            }
        }
    }
}
