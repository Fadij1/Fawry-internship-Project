public class TruckSpeedRule implements Rule {
    @Override
    public Violation evaluate(Observation obs)
    {
        if (obs.carType == CarType.TRUCK && obs.speed > 60) {
            return new Violation("speed of "+ obs.speed+ " exceede max allowed 60", 300, "Truck Speed Rule" );
        }
        return null;
    }
}
