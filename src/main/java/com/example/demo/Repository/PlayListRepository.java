package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.PlayList;


public interface PlayListRepository extends JpaRepository<PlayList, Integer>
{

}
