package piya.com.repay.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findBacklog_repaysByIdenEquals" })
public class Backlog_repay {

    private String iden;

    @NotNull
    @Size(min = 2)
    private String na_repay;

    @NotNull
    @Size(min = 2)
    private String na_admin;

    private String time_repay;

    private Integer amount;

    @NotNull
    @Size(min = 2)
    private String remasks;
}
