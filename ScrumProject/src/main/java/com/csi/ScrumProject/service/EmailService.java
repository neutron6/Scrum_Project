package com.csi.ScrumProject.service;

import com.csi.ScrumProject.model.EmailDetails;


public interface EmailService {
    String sendMailWithAttachment(EmailDetails details);
}



