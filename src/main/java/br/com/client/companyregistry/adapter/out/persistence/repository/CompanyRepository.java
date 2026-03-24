package br.com.client.companyregistry.adapter.out.persistence.repository;

import br.com.client.companyregistry.adapter.out.persistence.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    Optional<CompanyEntity> findByRegistrationNumberAndCountryCode(String registrationNumber, String countryCode);
}