package com.rafaeldeluca.spring.web.mvc.repository;

import com.rafaeldeluca.spring.web.mvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {

    private List<Jedi> jedi;

    //construtor sem argumentos, apenas setando um uma nova lista de Jedy e adicionando
    public JediRepository() {
        jedi = new ArrayList<>();
        jedi.add(new Jedi("Obi","Obi Wan Kenobi"));
    }

    public List<Jedi> getAllJedi() {
        return this.jedi;
    }

    public void add(final Jedi jedi) {
        this.jedi.add(jedi);

    }
}
