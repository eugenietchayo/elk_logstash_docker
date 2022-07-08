package com.example.soumissionmvn.repository;

import com.example.soumissionmvn.model.InsurancePolicy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InsurancePolicyRepository extends MongoRepository<InsurancePolicy, Integer> {

}
