package com.example.pro_a.DBinterface;


import com.example.pro_a.Entity.Gall_coment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentRepository extends JpaRepository<Gall_coment,Long> {
}
