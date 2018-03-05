package zk.springboot.Repositry;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import zk.springboot.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositry extends MongoRepository<User,String> {
    List<User> getAllByUsername(String username , String password);
}
