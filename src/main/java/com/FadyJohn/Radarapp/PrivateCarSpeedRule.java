public class PrivateCarSpeedRule implements Rule {
    @Override
    public Violation evaluate(Observation obs)
    {
        if (obs.carType == CarType.PRIVATE && obs.speed > 80) {
            return new Violation("speed of "+ obs.speed+ " exceede max allowed 80", 300, "Private Car Speed Rule" );
        }
        return null;
    }
    
}
