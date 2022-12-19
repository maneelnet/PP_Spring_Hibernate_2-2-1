package hiber.model;

import javax.persistence.*;

@Entity
@Table (name = "car")
public class Car {

    @Id
    private Long id;

    @Column
    private String model;

    @Column
    private int series;

    @OneToOne
    @MapsId
    private User user;

    public Car() {

    }

    public Car (String model, int series, User user) {
        this.model = model;
        this.series = series;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
