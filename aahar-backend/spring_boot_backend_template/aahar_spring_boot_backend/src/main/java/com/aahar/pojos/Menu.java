package com.aahar.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "menus") // Mapping to the Menus table
@Getter
@Setter
@ToString
public class Menu extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY) // Each menu belongs to one mess
    @JoinColumn(name = "mess_id", nullable = false) // Foreign key column referencing Messes table
    private Mess mess;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "breakfast", columnDefinition = "TEXT")
    private String breakfast;

    @Column(name = "lunch", columnDefinition = "TEXT")
    private String lunch;

    @Column(name = "dinner", columnDefinition = "TEXT")
    private String dinner;
}
