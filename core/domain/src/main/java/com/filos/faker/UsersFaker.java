package com.filos.faker;

import com.github.javafaker.Faker;

public class UsersFaker extends Faker {

    public static Faker create(){
        return Faker.instance();
    }
}
