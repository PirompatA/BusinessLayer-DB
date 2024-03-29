package com.kbtg.apidesign01.user;

import com.kbtg.apidesign01.mail.GoogleMailService;
import com.kbtg.apidesign01.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
//    @Qualifier("googleMail")
    private MailService mailService;

//    public UserService(MailService mailService) {
//            this.mailService = mailService;
//
////        this.googleMailService = new GoogleMailService();
////        this.googleMailService.setUrl("mail.google.com");
////        this.googleMailService.setPort("42");
//    }

    List<User> users = new ArrayList<>(
            List.of(
                    new User(1, "John", 25, true),
                    new User(2, "Jane", 26, false),
                    new User(3, "Jack", 27, true)
            )
    );

    public List<User> getUsers(Optional<Boolean> active) {
        if (active.isPresent()){
            return users.stream().filter(u -> u.getActive() == active.get()).toList();
        }
        return users;
    }

    public User createUser(UserRequest request) {
        Optional<Integer> maxId = users.stream().map(User::getId).max(Integer::compareTo);
        int nextId = maxId.orElse(0) + 1;
        User user = new User(nextId, request.name(), request.age(), true);
        users.add(user);

        mailService.sendEmail("dev@gmail.com","created1");
        return user;
    }

    public Optional<User> editUser(int id, UserRequest request) {
        Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();
        if (user.isPresent()) {
            User u = user.get();
            u.setName(request.name());
            u.setAge(request.age());
        }
        return user;
    }

    public List<User> deleteUser(@PathVariable("id") int id){
        users.removeIf(u -> u.getId() == id);
        return users;
    }
}
