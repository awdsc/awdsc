package com.example.pro_a.DBinterface;

import com.example.pro_a.Entity.Gall_board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;



public interface BoardRepository extends JpaRepository<Gall_board, Long> {

}
