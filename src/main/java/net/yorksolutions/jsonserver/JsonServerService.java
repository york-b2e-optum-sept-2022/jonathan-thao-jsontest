package net.yorksolutions.jsonserver;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class JsonServerService {
    public String ipAdd(){
        InetAddress ipAdd = null;
        try {
            ipAdd = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        String ip = ipAdd.getHostAddress();
        return ip;
    }

    public HashMap echoTest(){
        HashMap echo = new HashMap();
        echo.put("key", "value");
        echo.put("one", "two");

        return echo;
    }

    public HashMap httpHeaders(@RequestHeader Map<String, String> headers){
        HashMap http = new HashMap();
        headers.forEach((key, value) -> {
            http.put(key,value);

        });
        return http;
    }

    public Date DateTime(){
        Date date = new Date();

        return date;
        }

        //unable to pull correct date and time format including milliseconds

    }


