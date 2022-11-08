package cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.repository;

import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.domain.FlorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface FlorRepository extends JpaRepository<FlorEntity, Integer> {

}