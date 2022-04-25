package project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import project.entity.MyUser;
import project.entity.Role;
import project.mapper.MyUserMapper;
import project.rest.model.MyUserDTO;
import project.service.user.UserService;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/register")
    public String registerForm(Model model) {
        MyUser user = new MyUser();
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        model.addAttribute("user", user);

        return "register";
    }

    @PostMapping(value = "/register")
    public String registerUser(@ModelAttribute("user") @RequestBody MyUserDTO myUserDTO) {
        if (myUserDTO.getPassword().equalsIgnoreCase(myUserDTO.getPasswordConfirm())) {
            myUserDTO.setRoles(Set.of(new Role("ROLE_USER")));
            MyUserMapper.fromEntityToDTO(userService.saveUser(MyUserMapper.fromDtoToEntity(myUserDTO)));
            return "register-success";
        } else {
            return "register";
        }
    }

}
