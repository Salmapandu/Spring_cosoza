package com.example.COSOZA.Registration.Services;

import com.example.COSOZA.Registration.Entity.Payment;
import com.example.COSOZA.Registration.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment){
        return paymentRepository.save(payment);

    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deleteById(int payment_id) {
        paymentRepository.deleteById( payment_id);
    }
    public Optional<Payment> findById(int  payment_id) {
        return paymentRepository.findById( payment_id);
    }
}
