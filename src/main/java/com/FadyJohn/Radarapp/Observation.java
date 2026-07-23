public class Observation {
    
    public String carNumber;
    public String date;
    public CarType carType;
    public int speed;
    public boolean seatbelt;

    public Observation(String carNumber, String date, CarType carType, int speed, boolean seatbelt) {
        this.carNumber = carNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbelt = seatbelt;
    }

}