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


import piya.com.repay.domain.Ad_user;
import java.util.Map;
import java.lang.Exception;
import static org.zkoss.zk.ui.select.Selectors.find;
import org.zkoss.zul.*;
import org.zkoss.zul.Window;
import org.zkoss.zk.ui.Executions;

@ZKComposer(zul = "register.zul")
public class RegisterComposer {
 @Wire
    Window wndlogin;
    private static final long serialVersionUID = 4749849086473989066L;

    public void afterCompose(Component comp) {
    }

 @Listen("onClick = #saveadd")
    public void saveadd_Clicked(Event event) {
    	Textbox wuser = (Textbox) find(getPage(), "hbox > #wuser").get(0);
    	Textbox wpass = (Textbox) find(getPage(), "hbox > #wpass").get(0);
    	Textbox wpass2 = (Textbox) find(getPage(), "hbox > #wpass2").get(0);

    	if(wuser.getText()!=""&&wpass.getText()!=""&&wpass2.getText()!=""){
    			// alert(wpass.getText()+"555"+wpass2.getText());
							if(wpass.getValue().equals(wpass2.getText())){
								    	try{
								TypedQuery<Ad_user> aa = Ad_user.findAd_usersByUsernameEquals(wuser.getText());
								 Ad_user check22 = aa.getSingleResult();
								alert("ชื่อผู้ใช้นี้มีผู้ใช้งานแล้ว");
								}
								 catch(Exception e){
								 Ad_user check2 = new Ad_user();
								check2.setUsername(wuser.getText());
								check2.setPass(wpass.getText());
								 check2.persist();
								 wuser.setValue("");
wpass.setValue("");
wpass2.setValue("");
alert("บันทึกข้อมูลเรียบร้อย");
								}

			 		       }
						else{
							alert("รหัสผ่านไม่ตรงกัน");
												}
 		}
		 else{
		 	alert("กรุณากรอกข้อมูลให้ถูกต้อง");
		 }

 }
@Listen("onClick = #login")
    public void login_Clicked(Event event) {
    	Textbox ruser = (Textbox) find(getPage(), "hbox > #ruser").get(0);
    	Textbox rpass = (Textbox) find(getPage(), "hbox > #rpass").get(0);
	try{
TypedQuery<Ad_user> bb = Ad_user.findAd_usersByUsernameEquals(ruser.getText());
 Ad_user check1 = bb.getSingleResult();
if(check1.getPass().equals(rpass.getText())){
	 wndlogin.detach();
Map<String, Object> arguments = new HashMap<String, Object>(); 
       arguments.put("value1", ruser.getText() );
        arguments.put("value2", rpass.getText());
	 Sessions.getCurrent().setAttribute("allmyvalues", arguments);

 Executions.sendRedirect("main.zul");
}
else{
		alert("รหัสผ่านไม่ถูกต้อง");
}
}
catch(Exception e){
	alert("ไม่มีข้อมูลผู้ใช้");
}
 }

}
