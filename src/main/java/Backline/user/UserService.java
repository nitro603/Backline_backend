package Backline.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    private final UserRepo userRepository;

    @Autowired
    public UserService(UserRepo repository){
        this.userRepository = repository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public List<User> getActiveUsers(){
        return userRepository.findAll().stream()
                .filter(User::getActive)
                .toList();
    }

    public List<User> getUsersbyName(String searchText){
        return userRepository.findAll().stream()
                .filter(user -> user.getFirst_Name().toLowerCase().contains(searchText.toLowerCase()))
                .toList();
    }

    public User addUserAccount(User newUser){
        userRepository.save(newUser);
        return newUser;
    }

    public User updateUserAccount(User updatedUser){
        Optional<User> existingUser = userRepository.findById(updatedUser.getId());

        if(existingUser.isPresent()){
            User userToUpdate = existingUser.get();
            userToUpdate.setId(updatedUser.getId());
            userToUpdate.setActive(true);
            userToUpdate.setEmail(updatedUser.getEmail());
            userToUpdate.setFirst_Name(updatedUser.getFirst_Name());
            userToUpdate.setLast_Name(updatedUser.getLast_Name());
            userToUpdate.setPassword(updatedUser.getPassword());
            userToUpdate.setRole(updatedUser.getRole());
            userToUpdate.setCreated_at(updatedUser.getCreated_at());

            userRepository.save(userToUpdate);
            return userToUpdate;
        }
        return null;
    }

    @Transactional
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }


}
