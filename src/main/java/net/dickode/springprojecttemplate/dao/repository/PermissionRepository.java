package net.dickode.springprojecttemplate.dao.repository;

import net.dickode.springprojecttemplate.dao.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}