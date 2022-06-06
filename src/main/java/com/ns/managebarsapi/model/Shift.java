package com.ns.managebarsapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int total;
    private boolean finished;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "shift")
    private List<Order> orders;

    @Override
    public String toString() {
        return id +" "+user;
    }
}
