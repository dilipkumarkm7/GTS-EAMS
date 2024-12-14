package com.gorai.employment_agreement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gorai.employment_agreement.model.EmploymentAgreement;
import com.gorai.employment_agreement.repository.EmploymentAgreementRepository;

import java.util.List;

@Service
public class EmploymentAgreementService {

    private final EmploymentAgreementRepository repository;

    @Autowired
    public EmploymentAgreementService(EmploymentAgreementRepository repository) {
        this.repository = repository;
    }

    public EmploymentAgreement createAgreement(EmploymentAgreement agreement) {
        return repository.save(agreement);
    }

    public EmploymentAgreement getAgreementById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public EmploymentAgreement updateAgreement(Long id, EmploymentAgreement updatedAgreement) {
        if (repository.existsById(id)) {
            updatedAgreement.setId(id);
            return repository.save(updatedAgreement);
        }
        return null;
    }

    public void deleteAgreement(Long id) {
        repository.deleteById(id);
    }

    public List<EmploymentAgreement> getAllAgreements() {
        return repository.findAll();
    }

    public List<EmploymentAgreement> getAgreementsByDepartment(String department) {
        return repository.findByDepartment(department);
    }
}
