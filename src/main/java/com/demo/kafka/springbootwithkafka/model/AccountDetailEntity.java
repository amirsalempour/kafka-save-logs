package com.demo.kafka.springbootwithkafka.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "accountdetail109")

@EqualsAndHashCode
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetailEntity implements Serializable {
    private static final long serialVersionUID = 3621120742673442811L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acc_detail_gen")
    @SequenceGenerator(name = "acc_detail_gen", sequenceName = "acc_detail_seq", initialValue = 100, allocationSize = 1)
    @Column(name = "id109")
    private BigInteger id;

    @Column(name = "phonenumber109")
    private String phoneNumber;

    @Column(name = "iban109")
    private String iban;

    @Column(name = "inviteruserid109")
    private BigInteger inviterUserId;

    @Column(name = "createdate109")
    private LocalDateTime createDate;


}
