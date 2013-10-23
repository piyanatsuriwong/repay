package piya.com.repay.web;

import org.zkoss.zk.roo.annotations.ZKComposer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;

import static org.zkoss.zk.ui.select.Selectors.find;
import org.zkoss.zul.*;
import piya.com.repay.domain.Data_user_repay;
import piya.com.repay.domain.End_repay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

@ZKComposer(zul = "insert.zul")
public class InsertComposer {

    private static final long serialVersionUID = 8649241300588393532L;

    public void afterCompose(Component comp) {
    }

    @Listen("onClick = #btnAdd")
    public void btnAdd_Clicked(Event event) {
    	  Data_user_repay t = new Data_user_repay();
//     	Repay t = new Repay();
// t.setName(w_iden.getValue());
// t.setAddr(w_fname.getValue());
          int x=0;int y=0;
for(End_repay e: End_repay.findAllEnd_repays()){
    x++;
}
for(Data_user_repay e0: Data_user_repay.findAllData_user_repays()){
    y++;
}
    y=y+x+1;
            t.setIden(w_iden.getValue());
             t.setFname(w_fname.getValue());
              t.setLname(w_lname.getValue());
               t.setAddr(w_addr.getValue());
                t.setBdate(w_bdate.getValue());
                 t.setEmail(w_email.getValue());
                  t.setNa_repay(Integer.parseInt(w_na_repay.getValue()));
                   t.setNa_admin(Integer.parseInt(w_na_admin.getValue()));
                    t.setTime_repay(w_time_repay.getValue());
                    t.setAmount(Integer.parseInt(w_amout_repay.getValue()));
                    t.setRemasks(w_remask.getValue());
                    t.setMain_id(y);


 // t.setIden("11");
 //             t.setFname("11");
 //              t.setLname("11");
 //               t.setAddr("11");
 //                t.setBdate("11");
 //                 t.setEmail("11");
 //                  t.setNa_repay("11");
 //                   t.setNa_admin("11");
 //                    t.setTime_repay("11");
 //                    t.setAmount("11");
 //                    t.setRemasks("11");

// alert(w_iden.getValue());


            t.persist();
           
         alert(w_iden.getValue());
    }
}
