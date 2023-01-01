package com.csi.ScrumProject;

import com.csi.ScrumProject.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;
import java.util.Scanner;

@SpringBootApplication
public class ScrumProjectApplication {
    //****Scrum project by rushi Nichit


    public static void main(String[] args) {
        SpringApplication.run(ScrumProjectApplication.class, args);
    }


}
