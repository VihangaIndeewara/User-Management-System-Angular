package lk.epic.Backend.service;
import java.util.ArrayList;
import lk.epic.Backend.dto.UserDTO;

public interface UserService {
     public void saveUser(UserDTO dto);

     public void updateUser(UserDTO dto);
     
     public void deleteUser(String id);
 
     public String checkUsernameAndPassword(String username,String password);
     
     public String getLastUserId();

     ArrayList<UserDTO> getAllUsers();

}
