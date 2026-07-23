package com.FadyJohn.Radarapp;

public interface Rule {
    Violation evaluate(Observation obs);
    
}
