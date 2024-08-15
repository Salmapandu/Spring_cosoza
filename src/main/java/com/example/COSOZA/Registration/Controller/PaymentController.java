package com.example.COSOZA.Registration.Controller;

import com.example.COSOZA.Registration.Entity.Application;
import com.example.COSOZA.Registration.Entity.Payment;
import com.example.COSOZA.Registration.Repository.ApplicationRepository;
import com.example.COSOZA.Registration.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/payment")

public class PaymentController {
    @Autowired
    public PaymentService paymentService;

    @Autowired
    public ApplicationRepository applicationRepository;

    @PostMapping("add/payment")
    public ResponseEntity<?> createPayment(@RequestBody Payment payment) {
        try {
            Payment payment1 = paymentService.save(payment);
            return new ResponseEntity<>("payment added successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("failed to add payment",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/controlnumber/{application_id}")
    public ResponseEntity<String> generatecontrolnumber(@PathVariable int application_id){
        Application application = applicationRepository.findById(application_id).orElseThrow();
        Payment payment = new Payment();
        payment.setApplication(application);
        payment.setAmount_paid("0");
        payment.setDate_paid("pay");
        paymentService.save(payment);
        return new ResponseEntity<>(payment.getControl_number(), HttpStatus.OK);

    }

    @GetMapping("get/payments")

    public ResponseEntity<?> getPayment(){
        try {
            List<Payment> PaymentList = paymentService.findAll();
            if (PaymentList.isEmpty()){
                return new ResponseEntity<>("no payment found",HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(PaymentList,HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(" failed to retrieve payment",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update/{payment_id}")
    public ResponseEntity<?>  updatePayment(@PathVariable int payment_id, @RequestBody Payment payment){
        try {
            Optional<Payment> existingPayment = paymentService.findById(payment_id);
            if (existingPayment.isPresent()) {
                Payment payment1 = paymentService.save(payment);
                return new ResponseEntity<>("payment updated successfully",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("payment not found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("failed to update payment",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("delete/{payment_id}")
    public ResponseEntity<?> deletePayment(@PathVariable int payment_id){
        try {
            paymentService.deleteById(payment_id);
            return new ResponseEntity<>("payment was deleted successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("failed to delete payment",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("getById/{payment_id}")
    public ResponseEntity<?> getPaymentById(@PathVariable int payment_id){
        try {
            Optional<Payment> optionalPayment = paymentService.findById(payment_id);
            if (optionalPayment.isPresent()){
                return new ResponseEntity<>(optionalPayment.get(),HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("payment not found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("failed to retrieve payment", HttpStatus.BAD_REQUEST);
        }
    }

}




