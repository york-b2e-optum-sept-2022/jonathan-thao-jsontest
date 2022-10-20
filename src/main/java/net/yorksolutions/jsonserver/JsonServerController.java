package net.yorksolutions.jsonserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JsonServerController {

    private JsonServerService jsonServerService;

    public JsonServerController(JsonServerService jsonServerService) {
        this.jsonServerService = jsonServerService;
    }

    @GetMapping("/ipadd")
    public String getIpAdd() {
        return "Your IP Address: " + this.jsonServerService.ipAdd();
    }

    @GetMapping("/echo")
    public HashMap getEcho() {
        return this.jsonServerService.echoTest();
    }

    @GetMapping("headers")
    public HashMap getHeaders(@RequestHeader Map<String, String> headers){
        return this.jsonServerService.httpHeaders(headers);
    }

//    @GetMapping("date")
//    public Date currentDate() {
//        return this.jsonServerService.DateTime();
//    }
//
//    @GetMapping("date1")
//    public LocalDateTime currentDate1() {
//        return this.jsonServerService.DateTime1();
//    }

    @GetMapping("date2")
    public HashMap currentDate2() {
        return this.jsonServerService.newDate();
    }

    @GetMapping("alert")
    public String alert() {
        return this.jsonServerService.arbAlert();
    }
}





