package com.etnetera.hr.controller;

public class FrameworkNotFoundException extends RuntimeException {

    FrameworkNotFoundException(Long id){
        super("Could not find framework " + id);
    }
}
