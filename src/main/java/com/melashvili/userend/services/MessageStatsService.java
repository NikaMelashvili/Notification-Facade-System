package com.melashvili.userend.services;

import com.melashvili.userend.repositories.MessageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageStatsService {

    private MessageLogRepository messageLogRepository;

    @Autowired
    public void setMessageLogRepository(MessageLogRepository messageLogRepository) {
        this.messageLogRepository = messageLogRepository;
    }

    public double calculateSuccessRate() {
        long totalMessages = messageLogRepository.count();
        long successfulMessages = messageLogRepository.countBySuccess(true);

        if (totalMessages == 0) {
            return 0.0;
        }

        return (double) successfulMessages / totalMessages * 100;
    }


    public double getUndeliveredMessagePercentage() {
        return messageLogRepository.calculateUndeliveredMessagePercentage();
    }

    public List<String> getUndeliveredMessageRecipients() {
        return messageLogRepository.findUndeliveredMessageRecipients();
    }

    public Long countUndeliveredMessages() {
        return messageLogRepository.countUndeliveredMessages();
    }

    public Long countTotalMessages() {
        return messageLogRepository.countTotalMessages();
    }
}
