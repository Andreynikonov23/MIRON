package model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private int id;
    @Column(name = "Title")
    @NonNull
    private String title;
    @Column(name = "Cost")
    @NonNull
    private int cost;
    @Column(name = "DurationInSecond")
    @NonNull
    private int durationInSecond;
    @Column(name = "Description")
    private String description;
    @Column (name = "Discount")
    private double discount;
    @Column (name = "MainImagePath")
    private String mainImagePath;
    @OneToMany(mappedBy = "service")
    Set<ClientService> services;

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", durationInSecond=" + durationInSecond +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", mainImagePath='" + mainImagePath + '\'' +
                '}';
    }
}
