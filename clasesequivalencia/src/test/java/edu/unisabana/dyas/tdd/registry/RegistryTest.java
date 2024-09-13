package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person("Felipe", 852, 37, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
        System.out.println(person.toString()+"registered successfully");
    }
    @Test
    public void validateRegistryAges(){
        Person person = new Person("pepe", 152, -15, Gender.MALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
        System.out.println(person.toString()+"invalid age");
    }

    @Test
    public void validateRegistryAgesAdult(){
        Person person = new Person("Juana", 248, 17, Gender.FEMALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
        System.out.println(person.toString()+"underaged");
    }
    @Test
    public void validateRegistryIsAlive(){
        Person person = new Person("Carla", 951, 35, Gender.FEMALE , false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
        System.out.println(person.toString()+"dead");
    }
    @Test
    public void validateRegistry2(){
        Person person = new Person("Julian", 468, 26, Gender.UNIDENTIFIED , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);

        RegisterResult result2 = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result2);
        System.out.println(person.toString());
    }
    // TODO Complete with more test cases
}

