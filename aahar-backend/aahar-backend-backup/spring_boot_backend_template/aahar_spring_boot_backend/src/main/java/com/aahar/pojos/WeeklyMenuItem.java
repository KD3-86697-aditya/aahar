package com.aahar.pojos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "weekly_menu_items")
public class WeeklyMenuItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private WeeklyMenu weeklyMenu;

    @ManyToOne
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem;
}
