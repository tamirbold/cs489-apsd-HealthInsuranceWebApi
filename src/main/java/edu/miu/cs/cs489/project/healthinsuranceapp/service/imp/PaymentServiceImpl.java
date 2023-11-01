package edu.miu.cs.cs489.project.healthinsuranceapp.service.imp;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Payment;
import edu.miu.cs.cs489.project.healthinsuranceapp.repository.PaymentRepository;
import edu.miu.cs.cs489.project.healthinsuranceapp.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;
    public PaymentServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElse(null);
    }

    @Override
    public Payment updatePayment(Long paymentId, Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePaymentById(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public Payment addNewPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
