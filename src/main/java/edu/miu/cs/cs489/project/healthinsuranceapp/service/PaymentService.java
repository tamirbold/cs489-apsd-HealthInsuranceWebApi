package edu.miu.cs.cs489.project.healthinsuranceapp.service;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Payment;
import edu.miu.cs.cs489.project.healthinsuranceapp.model.Billing;

import java.util.List;

public interface PaymentService {
    public List<Payment> getAllPayments();
    public Payment getPaymentById(Long paymentId);
    public Payment updatePayment(Long paymentId, Payment payment);
    public void deletePaymentById(Long paymentId);
    public Payment addNewPayment(Payment payment);
}
