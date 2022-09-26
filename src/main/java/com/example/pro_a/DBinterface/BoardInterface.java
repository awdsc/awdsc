package com.example.pro_a.DBinterface;

import com.example.pro_a.Entity.Gall_board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardInterface extends JpaRepository<Gall_board, Long> {

}
