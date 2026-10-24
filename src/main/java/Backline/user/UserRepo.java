package Backline.user;

import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    void deleteById(@NonNull Integer id);
    Optional<User> findById(@NonNull Integer id);
}
