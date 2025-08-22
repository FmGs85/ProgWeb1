package com.senac.projeto2.repository;

import com.senac.projeto2.entity.Premio;
import com.senac.projeto2.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremioRepository extends JpaRepository<Premio, Integer> {
}