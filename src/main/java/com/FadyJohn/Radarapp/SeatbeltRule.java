public class SeatbeltRule implements Rule {
    @Override
    public Violation evaluate(Observation obs)
    {
        if(!obs.seatbelt)
        {
            return new Violation("Seatbelt not fastned", 100, "Seatbelt Rule");
        }
        return null;
    }
    
}
