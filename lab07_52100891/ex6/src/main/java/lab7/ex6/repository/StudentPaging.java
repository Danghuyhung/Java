package lab7.ex6.repository;

import lab7.ex6.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPaging extends PagingAndSortingRepository<Student,Integer> {

}
