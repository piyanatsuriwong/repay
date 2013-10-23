package piya.com.repay.web;

import java.util.HashMap;
import org.zkoss.*;
import org.zkoss.zk.roo.annotations.ZKComposer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.Selectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;

import piya.com.repay.domain.Data_user_repay;
import piya.com.repay.domain.End_repay;

import java.lang.Exception;
import static org.zkoss.zk.ui.select.Selectors.find;
import org.zkoss.zul.*;
import org.zkoss.zul.Window;
import org.zkoss.zk.ui.Executions;
@ZKComposer(zul = "edit_repay.zul")
public class Edit_repayComposer {

    private static final long serialVersionUID = -8299853287762141326L;
 @Wire
    Window modalDialog;

    public void afterCompose(Component comp) {

    }

  

    @Listen("onClick = #btnsave")
    public void btnsave_Clicked(Event event) {

  try{

        Label setque = (Label) find(getPage(), "grid > rows > row > #setque").get(0);
        Textbox setamount = (Textbox) find(getPage(), "grid > rows > row > #setamount").get(0);
     
         TypedQuery<Data_user_repay> eee3 = Data_user_repay.findData_user_repaysByMain_idEquals(Integer.parseInt(setque.getValue()));
Data_user_repay newbt = eee3.getSingleResult();
         // alert(newbt.getIden()+"");
         newbt.setAmount(Integer.parseInt(setamount.getValue()));
          newbt.persist();
             modalDialog.detach();
        Executions.sendRedirect("main.zul");
    }


    catch(Exception e){
   Label setque = (Label) find(getPage(), "grid > rows > row > #setque").get(0);
        Textbox setamount = (Textbox) find(getPage(), "grid > rows > row > #setamount").get(0);
     
        TypedQuery<End_repay> eee2 = End_repay.findEnd_repaysByEnd_idEquals(Integer.parseInt(setque.getValue()));
   End_repay newbt2 = eee2.getSingleResult();
         // alert(newbt.getIden()+"");
         newbt2.setAmount(Integer.parseInt(setamount.getValue()));
          newbt2.persist();
             modalDialog.detach();
        Executions.sendRedirect("main.zul");

    }


    }
    @Listen("onClick = #btndelect")
    public void btndelect_Clicked(Event event) {
      int set_num=0;
       int x=0;int y=0;
for(End_repay e: End_repay.findAllEnd_repays()){
    x++;
}
        try{



  TypedQuery<Data_user_repay> eee3 = Data_user_repay.findData_user_repaysByMain_idEquals(Integer.parseInt(setque.getValue()));
Data_user_repay newbt = eee3.getSingleResult();
 set_num=Integer.parseInt(setque.getValue());
 
        newbt.remove();
 for(Data_user_repay e0: Data_user_repay.findAllData_user_repays()){
 y = y + 1;
 }
y = y + x + 2;
         for(int i = set_num+1; i < y; i++){
   TypedQuery<Data_user_repay> eee = Data_user_repay.findData_user_repaysByMain_idEquals(i);

   Data_user_repay user = eee.getSingleResult();
 user.setMain_id(i-1);
 user.persist();
         } 
         modalDialog.detach();
  Executions.sendRedirect("main.zul");

    }


    catch(Exception e){
 
 for(Data_user_repay e0: Data_user_repay.findAllData_user_repays()){
 y = y + 1;
 }
y = y + x + 1;
         for(int i = x+1; i < y; i++){
   TypedQuery<Data_user_repay> eee = Data_user_repay.findData_user_repaysByMain_idEquals(i);

   Data_user_repay user = eee.getSingleResult();
 user.setMain_id(i-1);
 user.persist();
         }
      TypedQuery<End_repay> eee = End_repay.findEnd_repaysByEnd_idEquals(Integer.parseInt(setque.getValue()));
      End_repay newbt = eee.getSingleResult();
      set_num=Integer.parseInt(setque.getValue());
       newbt.remove();

    for(int j = set_num+1; j <= x; j++){
     
           TypedQuery<End_repay> eee2 = End_repay.findEnd_repaysByEnd_idEquals(j);
   End_repay newbt2 = eee2.getSingleResult();
newbt2.setEnd_id(j-1);
 newbt2.persist();
  }

             modalDialog.detach();
        Executions.sendRedirect("main.zul");

    }

    }


}