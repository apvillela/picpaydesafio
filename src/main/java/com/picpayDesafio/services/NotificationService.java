package com.picpayDesafio.services;

import com.picpayDesafio.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.picpayDesafio.dtos.NotificationDTO;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

@Autowired
    private RestTemplate restTemplate;

public void sendNotification(User user, String message) throws Exception{
    try {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("https://util.devi.tools/api/v1/notify", notificationRequest, String.class);

        if(notificationResponse.getStatusCode() == HttpStatus.OK){
            System.out.println("Notificação enviada com sucesso");
        } else {
            System.out.println("Erro ao enviar notificação - Status: " + notificationResponse.getStatusCode());
        }
    } catch (Exception e) {
        System.out.println("Erro ao enviar notificação: " + e.getMessage());
        
    }
}

}
