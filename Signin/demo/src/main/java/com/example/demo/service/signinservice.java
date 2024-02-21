package com.example.signin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.signin.model.Signin;
import com.example.signin.repository.SigninRepo;

@Service
public class SigninService {
    @Autowired
    private final SigninRepo signinrepo;

    public SigninService(SigninRepo signinrepo) {
        this.signinrepo = signinrepo;
    }

    public  Signin createSignin (Signin signin){
        return signinrepo.save(signin);

    }
    public List<Signin> getAllSignin(){
        return signinrepo.findAll();
    
    }
    public Signin getSigninId(int signinId){
        return signinrepo.findById(signinId).orElse(null);

    }
    // public Signin update(int signinId, Signin j) {
    //     Signin p1 = signinrepo.findById(signinId).orElse(null);
    //     if (p1 != null) {
    //         p1.setNo(j.getNo());
    //         signinrepo.save(p1);
    //         return p1;
    //     } else {
    //         return j;
    //     }
    // }

    public Signin update(int id, Signin signin) {
        Signin pros = signinrepo.findById(id).orElse(null);
        if (pros != null) {
            pros.setNo(signin.getNo());
            pros.setEmailaddress(signin.getEmailaddress());
            pros.setPassword(signin.getPassword());
            return signinrepo.save(pros);
        }
        return signin;
    }
    public void delete(int clientId) {
        signinrepo.deleteById(clientId);

    }
}

