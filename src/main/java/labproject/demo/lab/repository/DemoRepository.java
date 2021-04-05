package labproject.demo.lab.repository;

import labproject.demo.lab.entety.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DemoRepository extends JpaRepository<Item, Long> {

    @Query("select i from Item as i where i.name = :name")
    public List<Item> findByName(@Param("name") String name);
}
