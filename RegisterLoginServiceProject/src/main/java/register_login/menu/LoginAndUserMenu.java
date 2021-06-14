package register_login.menu;

import register_login.model.User;
import register_login.util.Encoder;
import register_login.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

import static register_login.menu.ChangePasswordMenu.changePassword;
import static register_login.util.GeneralUtil.*;

public class LoginAndUserMenu {
    public static void login() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        System.out.println("-------------Login Menu-------------");
        String username = checkString("username", false);
        String password = checkPassword("password", false);
        String encoded_password = Encoder.encode(password);


        List<User> users = em.createQuery("SELECT u FROM User u").getResultList();
        int count = 0;
        for (User user : users) {
            count++;
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(encoded_password)) {
                count--;
                OUT:
                while (true) {
                    System.out.println("-------------User Menu-------------");
                    System.out.println("Welcome, " + user.getName() + " " + user.getSurname());
                    System.out.println("Choose one of the choices: ");
                    System.out.println("1)Change password");
                    System.out.println("2)Log out");
                    System.out.println("Enter your choice: ");

                    Scanner scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();

                    if (choice.matches("[1-2]")) {
                        switch (choice) {
                            case "1":
                                changePassword(user);
                                break;
                            case "2":
                                break OUT;
                        }
                    } else  {
                        System.out.println("There is not such choice," +
                                " please enter between 1-2");
                        continue;
                    }

                }
                System.out.println("You logged out, successfully");
                break;
            } else if (count >= users.size()) {
                System.out.println("You entered email or password, incorrectly");
            }
        }


        em.close();
    }
}
