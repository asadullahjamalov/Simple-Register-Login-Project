package register_login.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String address;
    String username;
    String password;
    String email_primary;
    String email_secondary;
    String phone_number_one;
    String phone_number_two;
    String phone_number_three;
    LocalDate registration_date;
}
