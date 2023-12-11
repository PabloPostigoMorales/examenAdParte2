package cesur.examen.domain.car;

import cesur.examen.domain.client.Client;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno:
 * Fecha:
 */


@Data
@Entity
@Table(name = "garaje")
public class Car implements Serializable {


    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Getter
    @Setter
    @Basic
    @Column(name = "matricula",nullable = false)
    private String plate;

    @Getter
    @Setter
    @Basic
    @Column(name = "modelo",nullable = false)
    private String model;

    @Getter
    @Setter
    @Basic
    @Column(name = "fabricante")
    private String manufacturer;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "cliente",referencedColumnName = "id")
    @Column(name = "cliente",nullable = false)
    private Client client;

    /**
     * Override inherited toString() method to prevent stackOverFlow exceptions
     * from relationship.
     * @return
     */
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", client=" + client.getName() +
                '}';
    }
}
