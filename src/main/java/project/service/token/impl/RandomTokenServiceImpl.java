package project.service.token.impl;

import com.fasterxml.uuid.Generators;
import org.springframework.stereotype.Service;
import project.entity.MyUser;
import project.service.token.RandomTokenService;

import java.util.UUID;

@Service
public class RandomTokenServiceImpl implements RandomTokenService {

    public String randomToken(MyUser user) {
        UUID nameBasedUUID = Generators.nameBasedGenerator().generate(user.getUsername());
        return nameBasedUUID.toString();
    }
}
