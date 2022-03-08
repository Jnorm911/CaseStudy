package perscholas.database.form;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import perscholas.database.dao.AdminDAO;
import perscholas.database.entity.User;
import perscholas.service.AdminService;
import perscholas.validation.EmailUnique;
import perscholas.validation.UsernameUnique;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AdminNewForm {
    // this is a hidden data value and is only needed to distinguish an edit from a create
    private Integer id;

    @UsernameUnique(message = "Username must be unique")
    private String username;

    @EmailUnique(message = "Email must be unique")
    private String email;

    // this list is populated by the controller with all error messages
    // in the binding result.
    private List<String> errorMessages = new ArrayList<>();

    public AdminNewForm() {
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
