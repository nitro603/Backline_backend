package Backline.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="accounts")
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id", unique = true)
    @Getter @Setter private Integer id;
    @Getter @Setter private String username;
    @Getter @Setter private String password;
    @Getter @Setter private String email;
    @Getter @Setter private String first_Name;
    @Getter @Setter private String last_Name;
    @Getter @Setter private String role;
    @Getter @Setter private Boolean active;
    @Getter @Setter private String created_at;

    public User(Integer id, String username, String password, String email, String first_Name, String last_Name, String role, Boolean active, String created_at) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.role = role;
        this.active = active;
        this.created_at = created_at;
    }




}
