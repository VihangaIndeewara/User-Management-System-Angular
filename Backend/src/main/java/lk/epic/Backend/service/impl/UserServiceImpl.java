package lk.epic.Backend.service.impl;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lk.epic.Backend.dto.UserDTO;
import lk.epic.Backend.entity.User;
import lk.epic.Backend.repo.UserRepo;
import lk.epic.Backend.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepo repo;
    @Autowired
    private ModelMapper mapper;

    BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(-1);

    @Override
    public void saveUser(UserDTO dto){
        String encryptPassword = bCrypt.encode(dto.getPassword());
        dto.setPassword(encryptPassword);

        if(repo.existsById(dto.getUser_id())){
            throw new RuntimeException("User Id "+dto.getUser_id()+" Already Exists");
        }else{
            User entity=mapper.map(dto, User.class);
            repo.save(entity);
        }
    }

    @Override
    public void updateUser(UserDTO dto) {
        String encryptPassword = bCrypt.encode(dto.getPassword());
        dto.setPassword(encryptPassword);

        if(!repo.existsById(dto.getUser_id())){
            throw new RuntimeException("User Id" +dto.getUser_id()+" Not Available");

        }

        User entity = mapper.map(dto, User.class);
        repo.save(entity);
    }

    @Override
    public void deleteUser(String id) {
        if(!repo.existsById(id)){
            throw new RuntimeException("User Id "+id+" Not Available");
        }
        repo.deleteById(id);
    }
    
    

    @Override
    public String getLastUserId() {
        String lastUserId = repo.getLastUserId();
        return lastUserId;
    }

      
    @Override
    public ArrayList<UserDTO> getAllUsers() {
        List<User> all= repo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<UserDTO>>(){}.getType());
    }


    @Override
    public String checkUsernameAndPassword(String username, String password) {

        String dbPassword = repo.getPassword(username);
        if (dbPassword != null) {

            boolean matches = bCrypt.matches(password,dbPassword);
        
            if(matches){
                return "Success";
            }else{
                return "Error";
            }
        }else{
            return "Error";
        }
    }
       
}
