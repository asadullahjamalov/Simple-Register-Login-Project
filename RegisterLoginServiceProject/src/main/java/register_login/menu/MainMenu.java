package register_login.menu;

import register_login.util.JPAUtil;

import java.util.Scanner;

import static register_login.menu.LoginAndUserMenu.login;
import static register_login.menu.RegistrationMenu.register;

public class MainMenu {
    public static void showMainMenu() {

        OUT:
        while (true) {
            System.out.println("-------------Main Menu-------------");
            System.out.println("Choose one of the choices in the Main Menu: ");
            System.out.println("1)Login");
            System.out.println("2)Register");
            System.out.println("3)Exit");
            System.out.println("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.matches("[1-3]")) {
                switch (choice) {
                    case "1":
                        login();
                        break;
                    case "2":
                        register();
                        break;
                    case "3":
                        JPAUtil.shutdown();
                        break OUT;
                }
            } else {
                System.out.println("There is not such choice," +
                        " please enter between 1-3");
                continue;
            }


        }
    }
}
