package com.example.soumissionmvn.controller;

import com.example.soumissionmvn.model.InsurancePolicy;
import com.example.soumissionmvn.services.InsurancePolicyService;
import java.util.List;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InsurancePolicyControllerTest implements WithAssertions {

  @Mock
  InsurancePolicyService insurancePolicyService;
  @InjectMocks
  InsurancePolicyController insurancePolicyController;

  InsurancePolicy insurancePolicy;
  List<InsurancePolicy> insurancePolicies;

  @BeforeEach
  void setUp() {
    createInsurancePolicy();
  }

  @Test
  void givenAnInsurancePolicy_whenSaveInsurancePolicy_thenSaveInsurancePolicyIsCalled() {
    when(insurancePolicyService.saveInsurancePolicy(insurancePolicy)).thenReturn(insurancePolicy);

    InsurancePolicy result = insurancePolicyController.saveInsurancePolicy(insurancePolicy);

    verify(insurancePolicyService, times(1)).saveInsurancePolicy(insurancePolicy);
    assertThat(result).isEqualTo(insurancePolicy);
  }

  @Test
  void whenGetInsurancePolicies_thenGetInsurancePoliciesIsCalled() {
    when(insurancePolicyService.getInsurancePolicies()).thenReturn(insurancePolicies);

    List<InsurancePolicy> result = insurancePolicyController.getInsurancePolicies();

    verify(insurancePolicyService, times(1)).getInsurancePolicies();
    assertThat(result).isEqualTo(insurancePolicies);
  }

  public void createInsurancePolicy(){
    insurancePolicy = new InsurancePolicy(0, "customerName", "policyDate", "previousInsurer",
        List.of("String"), List.of("String"),
        List.of("String"));

    insurancePolicies = List.of(
        new InsurancePolicy(0, "customerName", "policyDate", "previousInsurer",
            List.of("String"), List.of("String"),
            List.of("String")));
  }
}