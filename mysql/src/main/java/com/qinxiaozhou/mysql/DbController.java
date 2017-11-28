package com.qinxiaozhou.mysql;

/**
 * Create by qxz on 2017/11/28
 * Description:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

@RestController
@RequestMapping("/sql")
public class DbController {

    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/getUsers")
    public List<Map<String, Object>> getDbType(){
        String sql = "select * from t_s_user";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Entry<String, Object> entry =(Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }

    @RequestMapping("/user/{id}")
    public Map<String,Object> getUser(@PathVariable String id){
        Map<String,Object> map = null;

        List<Map<String, Object>> list = getDbType();

        for (Map<String, Object> dbmap : list) {

            Set<String> set = dbmap.keySet();

            for (String key : set) {
                if(key.equals("id")){
                    if(dbmap.get(key).equals(id)){
                        map = dbmap;
                    }
                }
            }
        }

        if(map==null)
            map = list.get(0);
        return map;
    }
    @RequestMapping("/user/add")
    public String addUser(@RequestParam("username") String username, @RequestParam("password")String password,@RequestParam("type")String type, String description){

        String sql = "INSERT INTO `t_s_user` (`id`, `user_name`, `password`,`type`, `description`) VALUES ('"+ UUID.randomUUID().toString().replace("-","")+"', '"+username+"', '"+password+"', '"+type+"', '"+description+"')";
        jdbcTemplate.execute(sql);
        return "success";
    }

//    @Scheduled(fixedRate = 3000)
    @Scheduled(cron = "0/3 * * * * ?")
    public void cronScheduled() {

        List<Map<String, Object>> dbType = getDbType();
    }


}