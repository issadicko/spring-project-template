package net.dickode.springprojecttemplate.dao.repository;

import net.dickode.springprojecttemplate.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository()
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);

}