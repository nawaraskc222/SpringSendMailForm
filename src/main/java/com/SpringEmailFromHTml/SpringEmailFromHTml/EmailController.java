package com.SpringEmailFromHTml.SpringEmailFromHTml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/Addmail")
    public String addMail() {
        return "Email.html";
    }

    @PostMapping("/send-email")
    public String sendEmail(
    		Model model,
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body) {

        emailService.sendEmail(to, subject, body);
        model.addAttribute("to", to);
        model.addAttribute("subject", subject);
        model.addAttribute("body", body);

        return "Done"; // Assuming "Done.jsp" is in the "src/main/resources/templates" directory
    }
}
