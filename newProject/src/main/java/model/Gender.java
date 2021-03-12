package model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "gender")
public class Gender {
    @Id
    @NonNull
    private char code;
    @Column(name = "Name")
    private String name;
@OneToMany(mappedBy = "gender")
    Set<Client> clients;

    @Override
    public String toString() {
        return "Gender{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
