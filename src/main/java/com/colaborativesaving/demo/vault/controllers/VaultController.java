package com.colaborativesaving.demo.vault.controllers;

import com.colaborativesaving.demo.vault.model.MonthPayment;
import com.colaborativesaving.demo.vault.model.Vault;

public interface VaultController {
    public Vault startCollection();
    public Vault closeCollection();
    public Vault getVault();
    public MonthPayment getMonthPayment(String username);
}
