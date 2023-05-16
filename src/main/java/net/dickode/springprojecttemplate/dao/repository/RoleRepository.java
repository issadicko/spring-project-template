package net.dickode.springprojecttemplate.dao.repository;

import net.dickode.springprojecttemplate.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}