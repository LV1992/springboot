package com.aliyunstudy.controller;

import com.aliyunstudy.entity.Location;
import com.aliyunstudy.service.LocationService;
import com.aliyunstudy.utils.Page;
import com.aliyunstudy.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvyihang on 17/5/6.
 */
@RestController
public class LocationController {

    @Autowired
    LocationService locationService;
    @GetMapping("/getLocation")
    public Map<String,Object> index(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",locationService.getLastLocation());
        return map;
    }

    @PostMapping("/addLocation")
    public void insert(@RequestBody Location location){
        locationService.addLocation(location);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R listTmp(Integer page, Integer limit, String key){
        Map<String, Object> map = new HashMap<>();
        map.put("offset", (page - 1) * limit);
        map.put("limit", limit);
        map.put("key", key);

        //查询列表数据
        List<Location> list = locationService.list(map);
        int total = locationService.getTotal(map);
        Page page1 = new Page(list,total,page,limit);
        return R.ok().put("page", page1);
    }

}
