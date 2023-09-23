package com.epcafes.repository;

import com.epcafes.entity.CapitalFixo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapitalFixoRepository extends JpaRepository<CapitalFixo, Long>{

}
