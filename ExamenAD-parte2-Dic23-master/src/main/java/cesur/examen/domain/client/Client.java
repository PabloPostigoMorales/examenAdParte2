package cesur.examen.domain.client;

import cesur.examen.domain.car.Car;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno:
 * Fecha:
 */


@Data
@Entity
@Table(name = "cliente")
public class Client implements Serializable {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Getter
    @Setter
    @Column(name = "nombre")
    private String name;

    @Basic
    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @OneToMany
    @JoinColumn(referencedColumnName = "id")
    private List<Car> cars = new ArrayList<Car>(0);

    /**
     * Utility to add a car to a client.
     * This allows to maintain bidirectional consistency over the relationship,
     * providing client information to the car added.
     *
     * @param c Car to be added to the client.
     */
    public void addCar(Car c){
        c.setClient(this);
        cars.add(c);
    }

}