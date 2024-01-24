package lk.epic.Backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

import lk.epic.Backend.dto.UserDTO;
import lk.epic.Backend.service.UserService;
import lk.epic.Backend.util.ResponseUtil;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseUtil saveUser(@RequestBody UserDTO dto){
        service.saveUser(dto);
        return new ResponseUtil("200","Saved Successfully",null);
    }

    @GetMapping
    public ResponseUtil getAllUsers(){
        ArrayList<UserDTO> allUsers = service.getAllUsers();
        return new ResponseUtil("200","Success",allUsers);
    }

    @PutMapping
    public ResponseUtil updateUser(@RequestBody UserDTO dto){
        service.updateUser(dto);
        return new ResponseUtil("200","Updated Successfully",null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteUser(String id ){
        service.deleteUser(id);
        return new ResponseUtil("200","Deleted Successfully",null);
    }
    

    @GetMapping(path = "login")
    public ResponseUtil getPassword(String username,String password){
        String status = service.checkUsernameAndPassword(username,password);
        return new ResponseUtil("200",status,null);
    }

    
   

  

    @GetMapping(params="test")
    public ResponseUtil getLastUserId(){
        String lastUserId = service.getLastUserId();
        return  new ResponseUtil("200","Success",lastUserId);
    }

}
