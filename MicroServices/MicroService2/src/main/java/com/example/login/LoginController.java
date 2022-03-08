package com.example.login;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.GET;
import java.util.ArrayList;

@RestController
public class LoginController {

    RestTemplate restTemplate=new RestTemplate();

    @HystrixCommand(fallbackMethod = "error_calling_service1")
    @GET()
    @RequestMapping("/test1")
    public ResponseEntity test1()
    {
        System.out.println("calling  serive2");
        String url="http://localhost:1238/SERVICE1/test1";
        boolean b=true;
        if(b){
            throw new RuntimeException("exkdkdf");
        }
        String l = restTemplate.getForObject(url, String.class);
        System.out.println(("response from service2  : "+l));


        return new ResponseEntity(l,HttpStatus.OK);
    }

    @GET
    @RequestMapping("/test2")
    public ResponseEntity test2()
    {
        System.out.println("test is working in service2:");
        RegistartionBean registartionBean=new RegistartionBean();
        registartionBean.setEmail("shahrukh@gmil.com");
        ArrayList<RegistartionBean> l=new ArrayList<RegistartionBean>();
        l.add(registartionBean);

        return new ResponseEntity("this response form service2",HttpStatus.OK);
    }

    public ResponseEntity error_calling_service1()
    {
        return new ResponseEntity("error while calling service1 from service2",HttpStatus.OK);
    }

}