package com.kszu.minibank.accounts.server.domain.model;

import com.kszu.minibank.accounts.server.api.enumeration.AccountCurrency;
import com.kszu.minibank.accounts.server.api.enumeration.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
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
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @NotNull
    private Long userId;

    @NotNull
    @Column(unique = true)
    private String accountNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AccountCurrency currency;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @NotNull
    @Setter
    private BigDecimal availableFunds;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Setter
    private BigDecimal reservedFunds;

    public void reserveFunds(BigDecimal value) {
        this.availableFunds = this.availableFunds.subtract(value);
        this.reservedFunds = this.reservedFunds.add(value);
    }

    public void chargeAccount(BigDecimal value) {
        this.reservedFunds = this.reservedFunds.subtract(value);
    }
}
