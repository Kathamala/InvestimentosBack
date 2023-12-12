package com.example.InvestimentosBack.controller;

import com.example.InvestimentosBack.WalletInputDTO;
import com.example.InvestimentosBack.domain.Investment;
import com.example.InvestimentosBack.domain.Wallet;
import com.example.InvestimentosBack.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/wallet")
public class WalletController {
    @Autowired private WalletService service;

    @GetMapping("/getAll")
    public ResponseEntity<ArrayList<Wallet>> getAll() {
        ArrayList<Wallet> list = service.getAll();
        return new ResponseEntity<ArrayList<Wallet>>(list, null, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Wallet> newWallet(@RequestBody WalletInputDTO newData) {
        Wallet addedWallet = service.add(newData);
        if(addedWallet == null) {
            return new ResponseEntity<Wallet>(null, null, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<Wallet>(addedWallet, null, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Wallet> getOne(@PathVariable Integer id) {
        Wallet wallet = service.getOne(id);
        if(wallet == null) {
            return new ResponseEntity<Wallet>(null, null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Wallet>(wallet, null, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if(service.delete(id)) {
            return new ResponseEntity<Void>(null, null, HttpStatus.OK);
        }
        return new ResponseEntity<Void>(null, null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}/yearlyInvestments/{year}")
    public ResponseEntity<Wallet> updateYearlyInvestments(@PathVariable Integer id, @RequestBody ArrayList<Investment> newYearlyInvestments, @PathVariable Integer year) {
        Wallet wallet = service.updateYearlyInvestments(id, newYearlyInvestments, year);
        if(wallet == null) {
            return new ResponseEntity<Wallet>(null, null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Wallet>(wallet, null, HttpStatus.OK);
    }
    @PutMapping("/{id}/goal/{newGoal}")
    public ResponseEntity<Wallet> updateGoal(@PathVariable Integer id, @PathVariable Double newGoal) {
        Wallet wallet = service.updateGoal(id, newGoal);
        if(wallet == null) {
            return new ResponseEntity<Wallet>(null, null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Wallet>(wallet, null, HttpStatus.OK);
    }
    /*@PutMapping("/{id}")
    public ResponseEntity<Wallet> update(@PathVariable Integer id, @RequestBody Wallet updatedData) {
        return new ResponseEntity<Wallet>(new Wallet(), null, HttpStatus.OK);
    }*/
}
