package com.melashvili.userend.repositories;

import com.melashvili.userend.model.entitites.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {

    Long countBySuccess(Boolean success);

    @Query("SELECT COUNT(m) FROM MessageLog m")
    Long countTotalMessages();

    @Query("SELECT m.recipient FROM MessageLog m WHERE m.success = false")
    List<String> findUndeliveredMessageRecipients();

    @Query("SELECT COUNT(m) FROM MessageLog m WHERE m.success = false")
    Long countUndeliveredMessages();

    @Query("SELECT (COUNT(m) * 100.0 / (SELECT COUNT(*) FROM MessageLog)) " +
            "FROM MessageLog m WHERE m.success = false")
    Double calculateUndeliveredMessagePercentage();
}
