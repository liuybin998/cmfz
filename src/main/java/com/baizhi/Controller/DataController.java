package com.baizhi.Controller;

import com.baizhi.entity.Data;
import com.baizhi.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DataController {

    @Autowired
    private DataService dataService;

    @RequestMapping("/data")
    @ResponseBody
    private List<Data> data(){
        //List<Data> data = dataService.data();

        return dataService.data();
    }
    @RequestMapping("/data1")
    @ResponseBody
    private Map<String,Object> data1(){
        List<Data> data = dataService.data();
        Map<String, Object> map = new HashMap<String, Object>();
        for (Data datum : data) {
            map.put("name",map);
            map.put("value",map);
        }
        return map;
    }
}
