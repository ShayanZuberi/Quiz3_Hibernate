import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {

    @Id @GeneratedValue
    private int CarID;

    @OneToOne
    private Person Owner;
    private String LicensePlate;
    private String Make;
    private int Model;

    public int getCarID() {
        return CarID;
    }

    public void setCarID(int carID) {
        CarID = carID;
    }


    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public int getModel() {
        return Model;
    }

    public void setModel(int model) {
        Model = model;
    }

    public Person getOwner() {
        return Owner;
    }

    public void setOwner(Person owner) {
        Owner = owner;
    }
}
