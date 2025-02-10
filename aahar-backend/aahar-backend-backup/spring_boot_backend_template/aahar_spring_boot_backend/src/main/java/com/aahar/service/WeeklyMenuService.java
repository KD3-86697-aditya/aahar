package com.aahar.service;

import java.util.List;

import com.aahar.pojos.WeeklyMenuItem;

public interface WeeklyMenuService {
    WeeklyMenuItem addMenuItem(WeeklyMenuItem menuItem);
    List<WeeklyMenuItem> getMenuByMessOwner(Long messOwnerId);
}
