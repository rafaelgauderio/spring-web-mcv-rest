package com.rafaeldeluca.spring.web.mvc.model;

import javax.validation.constraints.NotBlank;

public class Jedi {

    @NotBlank
    private String name;

    @NotBlank
    private String lasName;

    public Jedi() {

    }

    public Jedi(final String name, final String lasName) {
        this.name = name;
        this.lasName = lasName;
    }


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(final String lasName) {
        this.lasName = lasName;
    }
}
