package register_login.menu;

import register_login.util.Encoder;
import register_login.util.JPAUtil;
import register_login.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.List;

import static register_login.util.GeneralUtil.*;

public class RegistrationMenu {

    public static void register() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();

        System.out.println("-------------Registration Menu-------------");
        String name = checkString("name", true);
        String surname = checkString("surname", true);
        String username = checkString("username", false);

        List<User> users = em.createQuery("SELECT u FROM User u").getResultList();

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("This username is already registered");
                System.out.println("Please, try with other username");
                em.close();
                return;
            }
        }

        String password = checkPassword("password", true);
        String address = checkString("address", true);
        String email_primary = checkEmail("primary", false);

        for (User user : users) {
            if (user.getEmail_primary().equals(email_primary)) {
                System.out.println("This primary email is already registered");
                System.out.println("Please, try with other primary email");
                em.close();
                return;
            }
        }

        String email_secondary = checkEmail("secondary", true);
        String phone_number_one = checkPhoneNumber("first", true);
        String phone_number_two = checkPhoneNumber("second", true);
        String phone_number_three = checkPhoneNumber("third", true);
        LocalDate registration_date = LocalDate.now();

        String encoded_password = Encoder.encode(password);

        User user = User.builder().name(name).surname(surname)
                .address(address).username(username).password(encoded_password)
                .email_primary(email_primary).email_secondary(email_secondary)
                .phone_number_one(phone_number_one).phone_number_two(phone_number_two)
                .phone_number_three(phone_number_three).registration_date(registration_date).build();
        System.out.println("You registered, successfully");
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

}
