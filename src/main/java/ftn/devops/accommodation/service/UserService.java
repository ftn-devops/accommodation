package ftn.devops.accommodation.service;

import org.springframework.stereotype.Service;

import ftn.devops.accommodation.entity.view.User;
import ftn.devops.accommodation.messaging.messages.UserCreatedMessage;
import ftn.devops.accommodation.messaging.messages.UserUpdatedMessage;
import ftn.devops.accommodation.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserCreatedMessage message) {
        User user = new User();
        user.setId(message.getId());
        user.setFirstName(message.getFirstName());
        user.setLastName(message.getLastName());
        user.setEmail(message.getEmail());
        user.setUsername(message.getUsername());
        user.setAddress(message.getAddress());
        user.setAverageGrade(message.getAverageGrade());
        userRepository.save(user);
    }

    public void updateUser(UserUpdatedMessage message) {
        User user = userRepository.findById(message.getId()).orElseThrow();
        user.setFirstName(message.getFirstName());
        user.setLastName(message.getLastName());
        user.setAddress(message.getAddress());
        user.setAverageGrade(message.getAverageGrade());
        userRepository.save(user);
    }
}
