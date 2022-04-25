package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.Creator;

@Repository
public interface CreatorRepository extends JpaRepository<Creator, Long> {

    Creator findByName(String name);
}
