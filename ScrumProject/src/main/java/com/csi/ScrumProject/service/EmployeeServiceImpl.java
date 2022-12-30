package com.csi.ScrumProject.service;

import com.csi.ScrumProject.dao.EmployeeDaoImpl;
import com.csi.ScrumProject.exceptions.EmployeeRecordNotFoundException;
import com.csi.ScrumProject.exceptions.GetDataByNameException;
import com.csi.ScrumProject.exceptions.SignInException;
import com.csi.ScrumProject.model.EmailDetails;
import com.csi.ScrumProject.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.Email;
import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmailService {
    //****Scrum project by rushi Nichit

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    @Autowired
    private JavaMailSender javaMailSender;


    public Employee signUp(Employee employee) {
        return employeeDaoImpl.signUp(employee);
    }

    public Boolean signIn(String email, String password) throws SignInException {
        return employeeDaoImpl.signIn(email, password);
    }

    public Optional<Employee> getDataById(int id) {
        return employeeDaoImpl.getDataById(id);
    }

    public List<Employee> getDataByName(String name) throws GetDataByNameException {
        if (employeeDaoImpl.getDataByName(name).equals(null)) {
            throw new GetDataByNameException("Empty Credentials");
        } else {
            return employeeDaoImpl.getDataByName(name);
        }

    }

    public Employee getDataByEmail(String email) {
        return employeeDaoImpl.getDataByEmail(email);
    }

    public Employee getDataByContactNumber(long contactNumber) {
        return employeeDaoImpl.getDataByContactNumber(contactNumber);
    }

    public List<Employee> getDataByUsingAnyInput(String input) throws EmployeeRecordNotFoundException {
        return employeeDaoImpl.getDataByUsingAnyInput(input);
    }

    public List<Employee> getAllData() {
        return employeeDaoImpl.getAllData();
    }

    public List<Employee> sortByName() {
        return employeeDaoImpl.sortByName();
    }

    public List<Employee> sortById() {
        return employeeDaoImpl.sortById();
    }

    public List<Employee> sortBySalary() {
        return employeeDaoImpl.sortBySalary();
    }

    public List<Employee> sortByAge() {
        return employeeDaoImpl.sortByAge();
    }

    public List<Employee> sortByDOB() {
        return employeeDaoImpl.sortByDOB();
    }

    public List<Employee> filterDataBySalary() {
        return employeeDaoImpl.filterDataBySalary();
    }

    public String loanEligibility(int id) {
        return employeeDaoImpl.loanEligibility(id);
    }

    public Employee updateData(Employee employee) {
        return employeeDaoImpl.updateData(employee);
    }

    public void deleteData(int id) {
        employeeDaoImpl.deleteData(id);
    }

    public void deleteAll() {
        employeeDaoImpl.deleteAll();
    }

    public Optional<Employee> FetchSecondHighest() {
        return employeeDaoImpl.FetchSecondHighest();
    }


    @Value("${spring.mail.username}")
    private String sender;

    public String sendMailWithAttachment(EmailDetails details) {


        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {


            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                    details.getSubject());

            // Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }
}
