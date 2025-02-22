package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // http://localhost:8080/api/users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // http://localhost:8080/api/users/1
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // http://localhost:8080/api/users/{sharini}
    @GetMapping("/username/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
    
    //http://localhost:8080/api/users/paged?page=0
    @GetMapping("/paged")
    public Page<User> getAllUsersPaged(
        @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return userService.getUsersPaged(pageable);
    }

    // http://localhost:8080/api/users
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // http://localhost:8080/api/users/1
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    // http://localhost:8080/api/users/1
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted ? "User deleted successfully!" : "User not found!";
    }
}






/*[
  {
    "username": "john_doe",
    "email": "john.doe@example.com",
    "password":"john#doe",
    "first_name": "John",
    "last_name": "Doe",
    "phone_number": "1234567890",
    "address": "123 Main St, New York, NY"
  },
  {
    "username": "jane_smith",
    "email": "jane.smith@example.com",
    "password":"jane@smith",
    "first_name": "Jane",
    "last_name": "Smith",
    "phone_number": "9876543210",
    "address": "456 Elm St, Los Angeles, CA"
  },
  {
    "username": "mike_jordan",
    "email": "mike.jordan@example.com",
    "password":"mike*jordan"
    "first_name": "Mike",
    "last_name": "Jordan",
    "phone_number": "1122334455",
    "address": "789 Oak St, Chicago, IL"
  },
  {
    "username": "emily_clark",
    "email": "emily.clark@example.com",
    "password":"emily%clark",
    "first_name": "Emily",
    "last_name": "Clark",
    "phone_number": "2233445566",
    "address": "321 Pine St, Miami, FL"
  },
  {
    "username": "david_wilson",
    "password":"david?wilson",
    "email": "david.wilson@example.com",
    "first_name": "David",
    "last_name": "Wilson",
    "phone_number": "3344556677",
    "address": "654 Cedar St, Houston, TX"
  },
  {
    "username": "sophia_miller",
    "password":"sophia#miller"
    "email": "sophia.miller@example.com",
    "first_name": "Sophia",
    "last_name": "Miller",
    "phone_number": "4455667788",
    "address": "987 Birch St, Seattle, WA"
  },
  {
    "username": "chris_evans",
    "email": "chris.evans@example.com",
    "password":"chris@evans"
    "first_name": "Chris",
    "last_name": "Evans",
    "phone_number": "5566778899",
    "address": "258 Maple St, Denver, CO"
  },
  {
    "username": "olivia_taylor",
    "email": "olivia.taylor@example.com",
    "password":"olivia&taylor",
    "first_name": "Olivia",
    "last_name": "Taylor",
    "phone_number": "6677889900",
    "address": "369 Redwood St, San Diego, CA"
  },
  {
    "username": "ryan_brown",
    "email": "ryan.brown@example.com",
    "password":"ryan&brown"
    "first_name": "Ryan",
    "last_name": "Brown",
    "phone_number": "7788990011",
    "address": "753 Walnut St, Dallas, TX"
  },
  {
    "username": "emma_harris",
    "email": "emma.harris@example.com",
    "password":"emma%harris",
    "first_name": "Emma",
    "last_name": "Harris",
    "phone_number": "8899001122",
    "address": "159 Cherry St, Boston, MA"
  }
]
 */