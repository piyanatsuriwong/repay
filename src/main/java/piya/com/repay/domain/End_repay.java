package piya.com.repay.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findEnd_repaysByIdenLike", "findEnd_repaysByEnd_idEquals" })
public class End_repay {

    private Integer na_repay;

    private Integer na_admin;

    private Integer amount;

    @NotNull
    @Size(min = 2)
    private String remasks;

    private String time_repay;

    @NotNull
    @Size(min = 2)
    private String iden;

    private Integer end_id;
}
