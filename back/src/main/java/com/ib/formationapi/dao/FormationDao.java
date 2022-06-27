package com.ib.formationapi.dao;

import com.ib.formationapi.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationDao extends JpaRepository<Long, Formation> {
}
