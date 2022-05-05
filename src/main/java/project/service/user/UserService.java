package project.service.user;

import org.springframework.stereotype.Service;
import project.entity.MyUser;

@Service
public interface UserService {

    MyUser findUserByUserName(String username);

    MyUser findUserByRandomToken(String randomToken);

    MyUser saveUser(MyUser u);
}
