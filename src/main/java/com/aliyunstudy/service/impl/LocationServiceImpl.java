package com.aliyunstudy.service.impl;

import com.aliyunstudy.entity.Location;
import com.aliyunstudy.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aliyunstudy.dao.LocationDao;

import java.util.List;
import java.util.Map;

/**
 * Created by lvyihang on 17/5/8.
 */
@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationDao locationDao;
    @Override
    public Location getLastLocation() {
        return locationDao.selectLastLocation();
    }

    @Override
    public int getTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public List<Location> list(Map<String,Object> map) {
        return locationDao.queryList(map);
    }

    @Override
    public void addLocation(Location location) {
        locationDao.insert(location);
    }
}
