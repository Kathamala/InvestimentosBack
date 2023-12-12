package com.example.InvestimentosBack.service;

import com.example.InvestimentosBack.WalletInputDTO;
import com.example.InvestimentosBack.domain.Investment;
import com.example.InvestimentosBack.domain.Wallet;
import com.example.InvestimentosBack.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WalletService {
    public ArrayList<Wallet> getAll() {
        return WalletRepository.getAll();
    }
    public Wallet add(WalletInputDTO walletInputDTO) {
        Wallet newWallet = new Wallet(walletInputDTO.getId(), walletInputDTO.getGoal(), walletInputDTO.getFirstYearInvestments());
        return WalletRepository.add(newWallet);
    }
    public Wallet getOne(Integer id) {
        return WalletRepository.getOne(id);
    }
    public boolean delete(Integer id) {
        return WalletRepository.delete(id);
    }
    public Wallet update(Wallet updatedWallet) {
        //TODO: this method is incomplete, it needs to check the id and if the user changed the goal, honestly, don't even think this should exist, there should be only a updateGoal.
        if(updatedWallet.getId() == null) {
            return null;
        }
        return WalletRepository.update(updatedWallet);
    }

    public Wallet updateYearlyInvestments(Integer id, ArrayList<Investment> newYearlyInvestments, Integer year) {
        Wallet wallet = WalletRepository.getOne(id);
        wallet.setNewInvestment(newYearlyInvestments, year);
        return WalletRepository.update(wallet);
    }
}
