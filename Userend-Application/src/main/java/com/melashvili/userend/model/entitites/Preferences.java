package com.melashvili.userend.model.entitites;

import com.melashvili.userend.model.base.AppEntity;
import com.melashvili.userend.model.base.NotificationType;
import com.melashvili.userend.model.base.PreferenceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "preferences")
public class Preferences extends AppEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preference_id")
    private Long preferenceId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User customerId;

    @Column(name = "notification_type")
    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    @Column(name = "preference_status")
    @Enumerated(EnumType.STRING)
    private PreferenceStatus status;
}
