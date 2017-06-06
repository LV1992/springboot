package com.aliyunstudy.service;

import com.aliyunstudy.entity.Location;

import java.util.List;
import java.util.Map;

/**
 * Created by lvyihang on 17/5/8.
 */
public interface LocationService {
    Location getLastLocation();
    int getTotal(Map<String,Object> map);
    List<Location> list(Map<String,Object> map);
    void addLocation(Location location);
}
