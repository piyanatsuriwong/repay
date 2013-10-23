package piya.com.repay.web;

import org.zkoss.*;
import org.zkoss.zk.roo.annotations.ZKComposer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import static org.zkoss.zk.ui.select.Selectors.find;
import org.zkoss.zk.ui.select.annotation.Listen;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import piya.com.repay.domain.Data_user_repay;
import piya.com.repay.domain.End_repay;
import piya.com.repay.domain.Status_user_repay;

import piya.com.repay.addon.DateDifference;
import piya.com.repay.addon.Calpay;

import org.zkoss.zk.ui.Executions;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

import java.util.HashMap;
import org.zkoss.zk.ui.Sessions;  
import org.zkoss.bind.annotation.Command; 
import java.lang.Exception;
// import java.lang.Object;
import java.text.DateFormat;
// import java.text.SimpleDateFormat;
// import java.util.Calendar;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.annotation.Wire;
// import org.zkoss.zul.Timer;
import java.lang.*;
import java.util.Map;
// import java.io.*;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.text.*;
// import javax.persistence.*;
import org.zkoss.zk.ui.*;
import org.zkoss.zul.*;
import java.util.List;
// import javax.persistence.PersistenceContext;
// import org.springframework.transaction.annotation.Transactional;
import java.security.MessageDigest;

@ZKComposer(zul = "main.zul")
public class MainComposer {
 @Wire
    Window wndlogin;
    private static final long serialVersionUID = -492265957313109230L;

  int x=0;
int num1=0;
  DecimalFormat myFormatter = new DecimalFormat("###,###.###");
    public void afterCompose(Component comp) {
 Label showuser = (Label) find(getPage(), "#showuser").get(0);

  try{
      final HashMap<String, Object> map = (HashMap<String, Object>) Sessions.getCurrent().getAttribute("allmyvalues"); 
showuser.setValue(map.get("value1")+"");


   }

   catch(Exception e){

     Window window = (Window)Executions.createComponents(
                  "register.zul", null, null);
         window.doModal();

 }
   
if(showuser.getValue().equals("")){
 Window window = (Window)Executions.createComponents(
                  "register.zul", null, null);
         window.doModal();
}



// final HashMap<String, Object> map2 = new HashMap<String, Object>();
//        map2.put("value1", "" );
//         map2.put("value2", "")
//    Sessions.getCurrent().setAttribute("allmyvalues", map2);

// final HashMap<String, Object> map = (HashMap<String, Object>) Sessions.getCurrent().getAttribute("allmyvalues"); 
// alert(map.get("value1")+"");
//   if( map.get("value1").equals("")){                       
//   Window window = (Window)Executions.createComponents(
//                 "register.zul", null, null);
//        window.doModal();
// }
//         // alert(map.get("value1")+""); 
int summoney =0;

 DateDifference dat = new DateDifference();
 Calpay cal33 = new Calpay();
 Calendar cal1 = new GregorianCalendar();
 Calendar cal2 = new GregorianCalendar();

 cal1.set(2008, 5, 1); 
 cal2.set(2008, 9, 31);

// alert("Days= "+dat.daysBetween(cal1.getTime(),cal2.getTime()));
// alert("cal= "+cal33.increase(100000,31));

    Rows table_repay_date = (Rows) find(getPage(), "#table_repay_date").get(0);
      Rows befor_table_repay_date = (Rows) find(getPage(), "#befor_table_repay_date").get(0);
       Label w_iden = (Label) find(getPage(), "#w_iden").get(0);
         Label w_fname = (Label) find(getPage(), "#w_fname").get(0);
         Label w_lname = (Label) find(getPage(), "#w_lname").get(0);
         Label w_addr = (Label) find(getPage(), "#w_addr").get(0);
         Label w_bdate = (Label) find(getPage(), "#w_bdate").get(0);
         Label w_email = (Label) find(getPage(), "#w_email").get(0);
         Label w_na_repay = (Label) find(getPage(), "#w_na_repay").get(0);
         Label w_na_admin = (Label) find(getPage(), "#w_na_admin").get(0);
         Label w_time_repay = (Label) find(getPage(), "#w_time_repay").get(0);
         Label w_amout_repay = (Label) find(getPage(), "#w_amout_repay").get(0);
         Label w_remask = (Label) find(getPage(), "#w_remask").get(0);



          Label now_id = (Label) find(getPage(), "#now_id").get(0);
         Label num_save = (Label) find(getPage(), "#num_save").get(0);
         Label num_wait = (Label) find(getPage(), "#num_wait").get(0);
         Label show_balance = (Label) find(getPage(), "#show_balance").get(0);
        

 for(Data_user_repay e0: Data_user_repay.findAllData_user_repays()){
  num1++;
       Row row1 =new Row();
       Label lb11= new Label(e0.getIden()+"");
       Label lb12= new Label(e0.getTime_repay()+"");
            Label lb13= new Label(myFormatter.format(e0.getAmount())+"");
            row1.appendChild(lb11);
            row1.appendChild(lb12);
            row1.appendChild(lb13);
             Button bt1 =new Button("แก้ไข");
            bt1.setId(""+e0.getMain_id());
            bt1.setParent(row1);
            bt1.addEventListener("onClick", new EventListener(){
                public void onEvent(Event ee2) throws UiException {
                  
                   // Data_user_repay newbt = Data_user_repay.findData_user_repay(Long.parseLong(ee2.getTarget().getId()));
                      TypedQuery<Data_user_repay> eee3 = Data_user_repay.findData_user_repaysByMain_idEquals(Integer.parseInt(ee2.getTarget().getId()));
Data_user_repay newbt = eee3.getSingleResult();
                   Map<String, Object> arguments = new HashMap<String, Object>(); 
        
        arguments.put("setque",ee2.getTarget().getId() ); 
         arguments.put("setiden",newbt.getIden() ); 

          arguments.put("setamount",newbt.getAmount() );  
           arguments.put("settime",newbt.getTime_repay() ); 
           // Executions.sendRedirect("edit_repay.zul");  

          Window window = (Window)Executions.createComponents(
                "edit_repay.zul", null, arguments);
       window.doModal();

                   // alert(newbt.getId()+"");
                                 
                }});

             row1.appendChild(bt1);
            befor_table_repay_date.appendChild(row1);
  }


    for(End_repay e: End_repay.findAllEnd_repays()){
x++;
       Row row =new Row();
      Label lb1= new Label(e.getIden()+"");
       Label lb2= new Label(e.getTime_repay()+"");
            Label lb3= new Label(myFormatter.format(e.getAmount())+"");
            row.appendChild(lb1);
            row.appendChild(lb2);
            row.appendChild(lb3);
             Button bt =new Button("แก้ไข");
            bt.setId(""+e.getEnd_id());
            bt.setParent(row);
            bt.addEventListener("onClick", new EventListener(){
                public void onEvent(Event ee) throws UiException {
                   
                     TypedQuery<End_repay> eee = End_repay.findEnd_repaysByEnd_idEquals(Integer.parseInt(ee.getTarget().getId()));
      End_repay newbt = eee.getSingleResult();
                  Map<String, Object> arguments = new HashMap<String, Object>(); 
        
        arguments.put("setque",ee.getTarget().getId() ); 
         arguments.put("setiden",newbt.getIden() ); 

          arguments.put("setamount",newbt.getAmount() );  
           arguments.put("settime",newbt.getTime_repay() ); 
           // Executions.sendRedirect("edit_repay.zul");  

          Window window = (Window)Executions.createComponents(
                "edit_repay.zul", null, arguments);
       window.doModal();
                                 
                }});

             row.appendChild(bt);
            table_repay_date.appendChild(row);

          summoney+=e.getAmount();

  }
    show_balance.setValue(myFormatter.format(summoney)+"");
      num_wait.setValue(num1+"");
         num_save.setValue(x+"");         
                  //Data_user_repay eee = Data_user_repay.findData_user_repay(Long.parseLong(String.valueOf(x+1)));
 TypedQuery<Data_user_repay> eee3 = Data_user_repay.findData_user_repaysByMain_idEquals(x+1);
Data_user_repay eee = eee3.getSingleResult();
          
            w_iden.setValue(String.valueOf(eee.getIden()));
            w_fname.setValue(eee.getFname());
            w_lname.setValue(eee.getLname());
            w_addr.setValue(eee.getAddr());
            w_bdate.setValue(eee.getBdate());
            w_email.setValue(eee.getEmail());
            w_na_repay.setValue(String.valueOf(eee.getNa_repay()));
            w_na_admin.setValue(String.valueOf(eee.getNa_admin()));
            w_time_repay.setValue(eee.getTime_repay());
            w_amout_repay.setValue(String.valueOf(myFormatter.format(eee.getAmount())));
            w_remask.setValue(eee.getRemasks());
           
 now_id.setValue(eee.getMain_id()+"");
      
        
  
    }
    @Listen("onClick = #btn_submit")
    public void btnAdd_Clicked(Event event) {

      if(num1!=0){
Checkbox checktrue = (Checkbox)find(getPage(),"checkbox[label='Information is correct']").get(0);

 // for(Component cv : find(getPage(), "#checktrue")){

     if(checktrue.isChecked()==true){

      
      Rows befor_table_repay_date = (Rows) find(getPage(), "#befor_table_repay_date").get(0);     
      for(Component cv : find(getPage(), "#befor_table_repay_date > row")){
            cv.detach();
        }
 //Data_user_repay bt_submit = Data_user_repay.findData_user_repay(Long.parseLong(String.valueOf(x+1)));
  TypedQuery<Data_user_repay> eee3 = Data_user_repay.findData_user_repaysByMain_idEquals(x+1);
Data_user_repay bt_submit = eee3.getSingleResult(); 
  End_repay end = new End_repay();
  end.setIden(bt_submit.getIden());
 end.setEnd_id(x+1);
  end.setTime_repay(bt_submit.getTime_repay());
  end.setAmount(bt_submit.getAmount());
  end.setNa_repay(bt_submit.getNa_repay());
  end.setNa_admin(bt_submit.getNa_admin());
  end.setRemasks("no");
  end.persist();
 bt_submit.remove();   
Executions.sendRedirect("main.zul");

 }
else{
  alert("กรุณาตรวจสอบข้อมูลและยืนยันการตรวจสอบ");


}
}
else{alert("ไม่มีผู้แจ้ง");}
          }
@Listen("onClick = #btn_search_befor")
    public void btn_search_befor_Clicked(Event event) {

 Label chang = (Label) find(getPage(), "#chang").get(0);
 for(Component cv : find(getPage(), "#befor_table_repay_date > row")){
            cv.detach();
        }
  Textbox text_search_befor = (Textbox) find(getPage(), "#text_search_befor").get(0);

 Rows befor_table_repay_date = (Rows) find(getPage(), "#befor_table_repay_date").get(0); 
      String show ="";
  try{
  chang.setValue("");
      TypedQuery<Data_user_repay> aa = Data_user_repay.findData_user_repaysByIdenLike(text_search_befor.getValue());
       List<Data_user_repay> stdNow = aa.getResultList();
        for (Data_user_repay e0 : stdNow) {
          show=show+e0.getId();
 Row row1 =new Row();
       Label lb11= new Label(e0.getIden()+"");
       Label lb12= new Label(e0.getTime_repay()+"");
            Label lb13= new Label(myFormatter.format(e0.getAmount())+"");
            row1.appendChild(lb11);
            row1.appendChild(lb12);
            row1.appendChild(lb13);
             Button bt1 =new Button("แก้ไข");
            bt1.setId(""+e0.getId());
            bt1.setParent(row1);
            bt1.addEventListener("onClick", new EventListener(){
                public void onEvent(Event ee2) throws UiException {
                    TypedQuery<Data_user_repay> eee3 = Data_user_repay.findData_user_repaysByMain_idEquals(Integer.parseInt(ee2.getTarget().getId()));
Data_user_repay newbt = eee3.getSingleResult();
                   Map<String, Object> arguments = new HashMap<String, Object>(); 
        arguments.put("setque",ee2.getTarget().getId() ); 
         arguments.put("setiden",newbt.getIden() ); 
          arguments.put("setamount",newbt.getAmount() );  
           arguments.put("settime",newbt.getTime_repay() ); 
           // Executions.sendRedirect("edit_repay.zul");  
          Window window = (Window)Executions.createComponents(
                "edit_repay.zul", null, arguments);
       window.doModal();
                   // alert(newbt.getId()+"");                 
                }});
    row1.appendChild(bt1);
            befor_table_repay_date.appendChild(row1);
        }


   }
    catch(Exception e){
     chang.setValue("กรุณากรอกข้อมูล");
      for(Data_user_repay e0: Data_user_repay.findAllData_user_repays()){

       Row row1 =new Row();
       Label lb11= new Label(e0.getIden()+"");
       Label lb12= new Label(e0.getTime_repay()+"");
            Label lb13= new Label(myFormatter.format(e0.getAmount())+"");
            row1.appendChild(lb11);
            row1.appendChild(lb12);
            row1.appendChild(lb13);
             Button bt1 =new Button("แก้ไข");
            bt1.setId(""+e0.getMain_id());
            bt1.setParent(row1);
            bt1.addEventListener("onClick", new EventListener(){
                public void onEvent(Event ee2) throws UiException {
                  
                   // Data_user_repay newbt = Data_user_repay.findData_user_repay(Long.parseLong(ee2.getTarget().getId()));
                      TypedQuery<Data_user_repay> eee3 = Data_user_repay.findData_user_repaysByMain_idEquals(Integer.parseInt(ee2.getTarget().getId()));
Data_user_repay newbt = eee3.getSingleResult();
                   Map<String, Object> arguments = new HashMap<String, Object>(); 
        
        arguments.put("setque",ee2.getTarget().getId() ); 
         arguments.put("setiden",newbt.getIden() ); 

          arguments.put("setamount",newbt.getAmount() );  
           arguments.put("settime",newbt.getTime_repay() ); 
           // Executions.sendRedirect("edit_repay.zul");  

          Window window = (Window)Executions.createComponents(
                "edit_repay.zul", null, arguments);
       window.doModal();

                   // alert(newbt.getId()+"");
                                 
                }});

             row1.appendChild(bt1);
            befor_table_repay_date.appendChild(row1);
  }
   }

     
    }
    @Listen("onClick = #btn_search_after")
    public void btn_search_after_Clicked(Event event) {
Label chang2 = (Label) find(getPage(), "#chang2").get(0);
       for(Component cv : find(getPage(), "#table_repay_date > row")){
            cv.detach();
        }
  Textbox text_search_after = (Textbox) find(getPage(), "#text_search_after").get(0);
String gettext="defult";
gettext=text_search_after.getText();  
   Rows table_repay_date = (Rows) find(getPage(), "#table_repay_date").get(0);
      String show ="";

        try{
  chang2.setValue("");
      TypedQuery<End_repay> aa = End_repay.findEnd_repaysByIdenLike(gettext);
       List<End_repay> stdNow = aa.getResultList();
        for (End_repay e0 : stdNow) {
          show=show+e0.getId();
 Row row1 =new Row();
       Label lb11= new Label(e0.getIden()+"");
       Label lb12= new Label(e0.getTime_repay()+"");
            Label lb13= new Label(myFormatter.format(e0.getAmount())+"");
            row1.appendChild(lb11);
            row1.appendChild(lb12);
            row1.appendChild(lb13);
             Button bt1 =new Button("แก้ไข");
            bt1.setId(""+e0.getId());
            bt1.setParent(row1);
            bt1.addEventListener("onClick", new EventListener(){
                public void onEvent(Event ee2) throws UiException {

    TypedQuery<End_repay> eee = End_repay.findEnd_repaysByEnd_idEquals(Integer.parseInt(ee2.getTarget().getId()));
      End_repay newbt = eee.getSingleResult();    
                   Map<String, Object> arguments = new HashMap<String, Object>(); 
        arguments.put("setque",ee2.getTarget().getId() ); 
         arguments.put("setiden",newbt.getIden() ); 
          arguments.put("setamount",newbt.getAmount() );  
           arguments.put("settime",newbt.getTime_repay() ); 
           // Executions.sendRedirect("edit_repay.zul");  
          Window window = (Window)Executions.createComponents(
                "edit_repay.zul", null, arguments);
       window.doModal();
                   // alert(newbt.getId()+"");                 
                }});
    row1.appendChild(bt1);
           table_repay_date.appendChild(row1);
        }
  }
    catch(Exception e2){
     chang2.setValue("กรุณากรอกข้อมูล");
 for(End_repay e: End_repay.findAllEnd_repays()){
       Row row =new Row();
      Label lb1= new Label(e.getIden()+"");
       Label lb2= new Label(e.getTime_repay()+"");
            Label lb3= new Label(myFormatter.format(e.getAmount())+"");
            row.appendChild(lb1);
            row.appendChild(lb2);
            row.appendChild(lb3);
             Button bt =new Button("แก้ไข");
            bt.setId(""+e.getEnd_id());
            bt.setParent(row);
            bt.addEventListener("onClick", new EventListener(){
                public void onEvent(Event ee) throws UiException {
                   
                     TypedQuery<End_repay> eee = End_repay.findEnd_repaysByEnd_idEquals(Integer.parseInt(ee.getTarget().getId()));
      End_repay newbt = eee.getSingleResult();
                  Map<String, Object> arguments = new HashMap<String, Object>(); 
        
        arguments.put("setque",ee.getTarget().getId() ); 
         arguments.put("setiden",newbt.getIden() ); 

          arguments.put("setamount",newbt.getAmount() );  
           arguments.put("settime",newbt.getTime_repay() ); 
           // Executions.sendRedirect("edit_repay.zul");  

          Window window = (Window)Executions.createComponents(
                "edit_repay.zul", null, arguments);
       window.doModal();
                                 
                }});

             row.appendChild(bt);
            table_repay_date.appendChild(row);
  }
   }

     
    }

    @Listen("onClick = #btn_delet")
    public void btn_delet_Click(Event event) {
       if(num1!=0){

      int y = 0;
TypedQuery<Data_user_repay> eee3 = Data_user_repay.findData_user_repaysByMain_idEquals(x+1);
             Data_user_repay user2 = eee3.getSingleResult();
        user2.remove();
 for(Data_user_repay e0: Data_user_repay.findAllData_user_repays()){
 y = y + 1;
 }
y = y + x + 2;
         for(int i = x+2; i < y; i++){
   TypedQuery<Data_user_repay> eee = Data_user_repay.findData_user_repaysByMain_idEquals(i);

   Data_user_repay user = eee.getSingleResult();
 user.setMain_id(i-1);
 user.persist();
         }
           Executions.sendRedirect("main.zul");
}
else{alert("ไม่มีผู้แจ้ง");}
   
    }

 @Listen("onClick = #logout")
    public void logout_Clicked(Event event) {
       
Map<String, Object> arguments = new HashMap<String, Object>(); 
       arguments.put("value1", "");
        arguments.put("value2", "");
   Sessions.getCurrent().setAttribute("allmyvalues", arguments);

 Executions.sendRedirect("main.zul");
              
    }

    

        }