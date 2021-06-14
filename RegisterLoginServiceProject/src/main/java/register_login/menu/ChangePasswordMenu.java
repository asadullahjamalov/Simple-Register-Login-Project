package register_login.menu;

import register_login.model.User;
import register_login.util.Encoder;
import register_login.util.JPAUtil;

import javax.persistence.EntityManager;

import static register_login.util.GeneralUtil.*;

public class ChangePasswordMenu {
    public static void changePassword(User user) {
        OUT:
        while (true) {
            System.out.println("-------------Password Change Menu-------------");
            String username = checkString("username", false);
            String email_primary = checkEmail("primary", false);
            if (!(username.equals(user.getUsername())&&email_primary.equals(user.getEmail_primary()))){
                System.out.println("You entered wrong username or primary email, please try again");
                break OUT;
            }
            String password1 = checkPassword("new password", false);
            String password2 = checkPassword("new password (again)", false);
            if (password1.equals(password2)){
                EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
                em.getTransaction().begin();
                User u = em.find(User.class, user.getId());
                String encoded_password = Encoder.encode(password1);
                u.setPassword(encoded_password);
                em.getTransaction().commit();
                em.close();
                System.out.println("You changed password, successfully");
                break OUT;
            }else{
                System.out.println("Entered passwords do not match, please try again");
                break OUT;
            }

        }
    }
}
