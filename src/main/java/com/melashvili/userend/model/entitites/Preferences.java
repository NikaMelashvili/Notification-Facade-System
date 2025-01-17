package com.melashvili.userend.model.entitites;

import com.melashvili.userend.model.base.AppEntity;
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

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User customerId;

    @Column(name = "opted_email")
    private Boolean emailOpt;

    @Column(name = "opted_sms")
    private Boolean smsOpt;

    @Column(name = "opted_promo_messages")
    private Boolean promoOpt;
}
