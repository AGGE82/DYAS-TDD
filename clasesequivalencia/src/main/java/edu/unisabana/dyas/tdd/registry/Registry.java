package edu.unisabana.dyas.tdd.registry;

import java.util.HashSet;
import java.util.Set;

public class Registry { 
    private Set<Integer> registeredVoters = new HashSet<>();

    public RegisterResult registerVoter(Person p) {
        // TODO Validate person and return real result.
        if (p.getAge() < 0){
            return RegisterResult.INVALID_AGE;
        }
        if (p.getAge()<=17) {
            return RegisterResult.UNDERAGE;
        }
        if (p.isAlive()!= true){
            return RegisterResult.DEAD;
        }
        if (registeredVoters.contains(p.getId())) {
            return RegisterResult.DUPLICATED;
        }
        registeredVoters.add(p.getId());
        return RegisterResult.VALID;
    }
}