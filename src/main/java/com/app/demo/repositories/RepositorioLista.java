package com.app.demo.repositories;

import com.app.demo.entities.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioLista extends JpaRepository<Lista, Long> {

}
