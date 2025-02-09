package com.aahar.pojos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "weekly_menus")
@AllArgsConstructor
@NoArgsConstructor
public class WeeklyMenu extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "mess_id", nullable = false)
    private Mess mess;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private DayOfWeek weekday ;

    // Enum for days of the week
  
}
