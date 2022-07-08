package com.example.soumissionmvn.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "insurancepolicy")
public class InsurancePolicy {
  @Id
  private int id;
  private String customerName;
  private String policyDate;
  private String previousInsurer;
  private List<String> vehicles;
  private List<String> drivers;
  private List<String> assignments;

}
