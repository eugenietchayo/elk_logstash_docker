package com.example.soumissionmvn.services;

import com.example.soumissionmvn.model.InsurancePolicy;
import com.example.soumissionmvn.repository.InsurancePolicyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsurancePolicyService {
  @Autowired
  InsurancePolicyRepository insurancePolicyRepository;

  public InsurancePolicy saveInsurancePolicy (InsurancePolicy insurancePolicy){
    return insurancePolicyRepository.save(insurancePolicy);
  }

  public List<InsurancePolicy> getInsurancePolicies (){
    return insurancePolicyRepository.findAll();
  }
}
