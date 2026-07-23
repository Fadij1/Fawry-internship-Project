public interface Rule {
    Violation evaluate(Observation obs);
    
}
