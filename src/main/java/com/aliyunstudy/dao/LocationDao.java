package com.aliyunstudy.dao;

import com.aliyunstudy.entity.Location;

import java.util.List;
import java.util.Map;

public interface LocationDao {
    int deleteByPrimaryKey(Long id);

    int insert(Location record);

    int insertSelective(Location record);

    Location selectByPrimaryKey(Long id);

    Location selectLastLocation();

    List<Location> queryList(Map<String,Object> map);

    int queryTotal(Map<String,Object> map);

    int updateByPrimaryKeySelective(Location record);

    int updateByPrimaryKey(Location record);
}