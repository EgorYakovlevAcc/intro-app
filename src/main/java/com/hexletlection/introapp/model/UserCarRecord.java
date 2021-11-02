package com.hexletlection.introapp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users_cars")
public class UserCarRecord {
    @ManyToOne
    private User user;
    @ManyToOne
    private Car car;
}
