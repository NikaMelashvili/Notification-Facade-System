package com.melashvili.userend.scheduler;

import com.melashvili.userend.model.entitites.User;
import com.melashvili.userend.repositories.UserRepository;
import com.melashvili.userend.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdvertisementScheduler {
    private final AdvertisementService advertisementService;
    private final UserRepository userRepository;

    @Autowired
    public AdvertisementScheduler(AdvertisementService advertisementService, UserRepository userRepository) {
        this.advertisementService = advertisementService;
        this.userRepository = userRepository;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void sendDailyAdvertisements() {
        List<User> users = (List<User>) userRepository.findAll();
        advertisementService.sendAllContent(users);
    }
}
