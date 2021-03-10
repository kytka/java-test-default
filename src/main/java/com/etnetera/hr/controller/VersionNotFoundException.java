package com.etnetera.hr.controller;

public class VersionNotFoundException extends RuntimeException{

    VersionNotFoundException(Long id){
        super("Could not find version " + id);
    }
}
