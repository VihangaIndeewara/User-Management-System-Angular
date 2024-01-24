package lk.epic.Backend.entity;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class User {
    @Id
    private String user_id;
    private String user_name;
    private String password;
    private String full_name;
    private String mobile_no;
    private String nic;
    private Date created_date;
    private Date updated_date;
}
