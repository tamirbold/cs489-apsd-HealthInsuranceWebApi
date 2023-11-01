package edu.miu.cs.cs489.project.healthinsuranceapp.controller;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Payment;
import edu.miu.cs.cs489.project.healthinsuranceapp.model.Coverage;
import edu.miu.cs.cs489.project.healthinsuranceapp.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/payments")
public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @GetMapping(value = "/list")
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }
    @GetMapping(value = "/get/{paymentId}")
    public  Payment getPaymentById(@PathVariable Long paymentId){
        return paymentService.getPaymentById(paymentId);
    }
    @PutMapping(value = "/update/{paymentId}")
    public Payment updatePayment(@PathVariable Long paymentId, @RequestBody Payment payment){
        return paymentService.updatePayment(paymentId, payment);
    }
    @DeleteMapping(value = "/delete/{paymentId}")
    public void deletePayment(@PathVariable Long paymentId){
        paymentService.deletePaymentById(paymentId);
    }
    @PostMapping(value = "/new")
    public Payment addNewPayment(Payment payment){
        return paymentService.addNewPayment(payment);
    }
}
