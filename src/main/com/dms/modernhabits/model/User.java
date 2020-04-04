package com.dms.modernhabits.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;

    @OneToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
    mappedBy = "user")
    private com.dms.modernhabits.model.Stats stats;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "users_habits",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "habit_id") })
    private List<com.dms.modernhabits.model.Habit> habits = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.dms.modernhabits.model.Stats getStats() {
        return stats;
    }

    public void setStats(com.dms.modernhabits.model.Stats stats) {
        this.stats = stats;
    }

    public List<com.dms.modernhabits.model.Habit> getHabits() {
        return habits;
    }

    public void setHabits(List<com.dms.modernhabits.model.Habit> habits) {
        this.habits = habits;
    }
}
