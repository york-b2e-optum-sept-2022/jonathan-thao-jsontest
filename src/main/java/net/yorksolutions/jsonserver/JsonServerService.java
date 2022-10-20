package net.yorksolutions.jsonserver;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

//    public Date DateTime(){
//        Date date = new Date();
//
//        return date;
//        }
//
//        //unable to pull correct date and time format including milliseconds
//
//    public LocalDateTime DateTime1(){
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        return now;
//    }

    public HashMap newDate(){
        HashMap newDate1 = new HashMap();

        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime timeNow = LocalTime.now();

        DateTimeFormatter date = DateTimeFormatter.ofPattern("/MM/dd/uuuu");
        LocalDate dateNow = LocalDate.now();

        long milli = Instant.now().toEpochMilli();

        newDate1.put("time", timeNow);
        newDate1.put("date", dateNow);
        newDate1.put("milliseconds", milli);

        return newDate1;

    }

    public String arbAlert(){
        this.ipAdd();
        String alert = "alert('Your IP Address is: " + ipAdd() + "'')";
        return alert;
    }



    }




