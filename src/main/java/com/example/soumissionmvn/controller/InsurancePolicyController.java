package com.example.soumissionmvn.controller;

import com.example.soumissionmvn.model.InsurancePolicy;
import com.example.soumissionmvn.services.InsurancePolicyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance")
public class InsurancePolicyController {
  @Autowired
  InsurancePolicyService insurancePolicyService;

  @PostMapping
  public InsurancePolicy saveInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy){
    return insurancePolicyService.saveInsurancePolicy(insurancePolicy);
  }

  @GetMapping
  public List<InsurancePolicy> getInsurancePolicies (){
    return insurancePolicyService.getInsurancePolicies();
  }
}
