package com.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    //JPA/Hibernate > Database -> UserDaoService > Static List

    private static List<User> users = new ArrayList<User>();
    private static int usersCount=0;

    static {
        users.add(new User(++usersCount,"Ioannis", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount,"Antonis", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount,"Lefteris", LocalDate.now().minusYears(20)));
    }

    //public List<User> findAll(){

    public List<User> findAll(){
        return users;
    }
    //public User save(User user) {
    //public User findOne(int id) {
    public User findOne(int id) {
        for(User users1 : users){
            if(users1.getId() == id)
                return users1;
        }
        return null;
    }

    public void deleteById(int id) {
        for(User users1 : users){
            if(users1.getId() == id)
                users.remove(users1);
        }
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
