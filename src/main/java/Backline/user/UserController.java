package Backline.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(
            @RequestParam(required = false)
            Integer id,
            @RequestParam(required = false)
            String username,
            @RequestParam(required = false)
            String password,
            @RequestParam(required = false)
            String email,
            @RequestParam(required = false)
            String first_Name,
            @RequestParam(required = false)
            String last_Name,
            @RequestParam(required = false)
            String role,
            @RequestParam(required = false)
            Boolean active,
            @RequestParam(required = false)
            String created_at){
        if(id != null && email != null) {
            return userService.getActiveUsers();
        }else{
            return userService.getUsers();
        }
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        User createdUser = userService.addUserAccount(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User updatedUser){
        User resultUser = userService.updateUserAccount(updatedUser);
        if(resultUser != null){
            return new ResponseEntity<>(resultUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }


}

