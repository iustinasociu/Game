package project.service.token;

import project.entity.MyUser;

public interface RandomTokenService {

    String randomToken(MyUser user);
}
