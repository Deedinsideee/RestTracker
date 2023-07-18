package com.example.resttracker.Repository;

import com.example.resttracker.Model.GenericModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends GenericModel>
        extends JpaRepository<T,Long> {
}
