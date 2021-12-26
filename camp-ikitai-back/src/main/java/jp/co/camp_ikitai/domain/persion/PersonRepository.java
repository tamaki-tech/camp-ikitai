package jp.co.camp_ikitai.domain.persion;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {

  List<PersonEntity> findByName(String name);
}