package hiber.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Car user = (Car) o;
        return Objects.equals(id, user.id)
                && Objects.equals(model, user.model)
                && Objects.equals(series, user.series);
    }

    @Override
    public int hashCode() {
        int hash = 31;

        hash = hash * 31 + (int) (id ^ (id >>> 32));
        hash = hash * 31 + (model == null ? 0 : model.hashCode());
        hash = hash * 31 + series;

        return hash;
    }

    @Override
    public String toString() {
        String sb = "Car{" + "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
        return sb;
    }
}
