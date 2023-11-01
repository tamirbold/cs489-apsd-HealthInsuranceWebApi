package edu.miu.cs.cs489.project.healthinsuranceapp.service.imp;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Billing;
import edu.miu.cs.cs489.project.healthinsuranceapp.repository.BillingRepository;
import edu.miu.cs.cs489.project.healthinsuranceapp.service.BillingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {
    private BillingRepository billingRepository;
    public BillingServiceImpl(BillingRepository billingRepository){
        this.billingRepository = billingRepository;
    }
    @Override
    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

    @Override
    public Billing getBillingById(Long paymentId) {
        return billingRepository.findById(paymentId)
                .orElse(null);
    }

    @Override
    public Billing updateBilling(Long paymentId, Billing billing) {
        return billingRepository.save(billing);
    }

    @Override
    public void deleteBillingById(Long paymentId) {
        billingRepository.deleteById(paymentId);

    }

    @Override
    public Billing addNewBilling(Billing billing) {
        return billingRepository.save(billing);
    }
}
