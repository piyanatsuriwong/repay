package piya.com.repay.domain;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findAd_usersByUsernameEquals", "findAd_usersByPassEquals" })
public class Ad_user {

    private String username;

    private String pass;
}
