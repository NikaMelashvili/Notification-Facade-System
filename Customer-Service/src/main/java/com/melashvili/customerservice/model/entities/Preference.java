package com.melashvili.customerservice.model.entities;

import com.melashvili.customerservice.model.base.AppEntity;
import com.melashvili.customerservice.model.base.NotificationType;
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
public class Preference extends AppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preference_id")
    private Long id;

    @Column(name = "notification_type")
    private NotificationType type;

    @Column(name = "opted_in")
    private boolean optedIn;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
