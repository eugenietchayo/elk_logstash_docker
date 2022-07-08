package com.example.soumissionmvn.services;

import com.example.soumissionmvn.model.InsurancePolicy;
import com.example.soumissionmvn.repository.InsurancePolicyRepository;
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
class InsurancePolicyServiceTest implements WithAssertions {

  @Mock
  InsurancePolicyRepository insurancePolicyRepository;
  @InjectMocks
  InsurancePolicyService insurancePolicyService;

  InsurancePolicy insurancePolicy;
  List<InsurancePolicy> insurancePolicies;

  @BeforeEach
  void setUp() {
    createInsurancePolicy();
  }

  @Test
  void givenAnInsurancePolicy_whenSaveInsurancePolicy_thenSaveIsCalled() {

    when(insurancePolicyRepository.save(insurancePolicy)).thenReturn(insurancePolicy);

    InsurancePolicy result = insurancePolicyService.saveInsurancePolicy(insurancePolicy);

    verify(insurancePolicyRepository, times(1)).save(insurancePolicy);
    assertThat(result).isEqualTo(insurancePolicy);
  }

  @Test
  void whenGetInsurancePolicies_thenFindAllIsCalled() {
    when(insurancePolicyRepository.findAll()).thenReturn(insurancePolicies);

    List<InsurancePolicy> result = insurancePolicyService.getInsurancePolicies();

    verify(insurancePolicyRepository, times(1)).findAll();
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