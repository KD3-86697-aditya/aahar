package com.aahar.service;

import com.aahar.daos.WeeklyMenuItemsDao;
import com.aahar.pojos.WeeklyMenuItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WeeklyMenuServiceImpl implements WeeklyMenuService {

    @Autowired
    private WeeklyMenuItemsDao weeklyMenuItemsDao;

    @Override
    public WeeklyMenuItem addMenuItem(WeeklyMenuItem menuItem) {
        return weeklyMenuItemsDao.save(menuItem);
    }

    @Override
    public List<WeeklyMenuItem> getMenuByMessOwner(Long messOwnerId) {
        return weeklyMenuItemsDao.findByMessOwnerId(messOwnerId);
    }
}
