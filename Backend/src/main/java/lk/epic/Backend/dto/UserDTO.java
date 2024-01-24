package lk.epic.Backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {
    private String user_id;
    private String user_name;
    private String password;
    private String full_name;
    private String mobile_no;
    private String nic;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy, hh:mm:ss a")
    private Date created_date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy, hh:mm:ss a")
    private Date updated_date;
  
}
