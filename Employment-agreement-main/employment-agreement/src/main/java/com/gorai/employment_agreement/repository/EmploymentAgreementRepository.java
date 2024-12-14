package com.gorai.employment_agreement.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gorai.employment_agreement.model.EmploymentAgreement;

public interface EmploymentAgreementRepository extends JpaRepository<EmploymentAgreement, Long> {
    List<EmploymentAgreement> findByDepartment(String department);
}
