package piya.com.repay.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findData_user_repaysByIdenLike", "findData_user_repaysByEmailLike", "findData_user_repaysByMain_idEquals" })
public class Data_user_repay {

    @NotNull
    @Size(min = 2)
    private String fname;

    @NotNull
    @Size(min = 2)
    private String lname;

    private String addr;

    @NotNull
    @Size(min = 2)
    private String bdate;

    private String email;

    private String remasks;

    private Integer na_repay;

    private Integer na_admin;

    private Integer amount;

    private String time_repay;

    @NotNull
    @Size(min = 2)
    private String iden;

    private Integer main_id;
}
