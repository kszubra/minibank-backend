package com.kszu.minibank.transactions.server.domain.model;

import com.kszu.minibank.transactions.server.api.enumeration.TransactionCurrency;
import com.kszu.minibank.transactions.server.api.enumeration.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @NotNull
    private Long userId;

    @NotNull
    private String chargedAccount;

    @NotNull
    private String creditedAccount;

    @NotNull
    private String title;

    @NotNull
    private BigDecimal value;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TransactionCurrency currency;

    @Setter
    private String additionalInfo;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime lastStatusChangeAt;

    public void updateStatus(TransactionStatus newStatus) {
        this.status = newStatus;
        this.lastStatusChangeAt = LocalDateTime.now();
    }
}
