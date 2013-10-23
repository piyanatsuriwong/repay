package piya.com.repay.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findStatus_user_repaysByIdenEquals" })
public class Status_user_repay {

    @NotNull
    @Size(min = 2)
    private String iden;

    @NotNull
    @Size(min = 2)
    private String period;

    @NotNull
    @Size(min = 2)
    private String remain;

    @NotNull
    @Size(min = 2)
    private String num_day;

    @NotNull
    @Size(min = 2)
    private String principle;

    @NotNull
    @Size(min = 2)
    private String pay;
}
