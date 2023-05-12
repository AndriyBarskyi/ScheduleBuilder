package ua.edu.lnu.schedulebuilder.service;

import ua.edu.lnu.schedulebuilder.model.User;

public interface UserService {

    User findUserByEmail(String email);
}