package edu.campnum.warriors.persona.monsters;

import edu.campnum.warriors.persona.Persona;

import javax.persistence.*;

@Entity
@Table(name = "monsters")
public class Monster extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public Monster(String name, int life, int strength, String type) {
        super(name, life, strength, type);
    }

    protected Monster() {}

}
