package com.xqx.xflow.core.impl.persistence.repo;

import com.xqx.xflow.core.impl.persistence.entity.Variable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariableRepo extends JpaRepository<Variable, String> {
}
