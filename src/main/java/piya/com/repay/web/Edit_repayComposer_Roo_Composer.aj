// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package piya.com.repay.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import piya.com.repay.web.Edit_repayComposer;
import zk.roo.Composer;

privileged aspect Edit_repayComposer_Roo_Composer {
    
    declare parents: Edit_repayComposer extends Composer;
    
    declare @type: Edit_repayComposer: @Component;
    
    declare @type: Edit_repayComposer: @Scope("prototype");
    
    @Wire
    public Window Edit_repayComposer.wndMain;
    
    @Wire
    public Label Edit_repayComposer.setque;
    
    @Wire
    public Label Edit_repayComposer.setiden;
    
    @Wire
    public Textbox Edit_repayComposer.setamount;
    
    @Wire
    public Textbox Edit_repayComposer.settime;
    
    @Wire
    public Button Edit_repayComposer.btnsave;
    
    @Wire
    public Button Edit_repayComposer.btndelect;
    
    @Wire
    public Button Edit_repayComposer.btnclose;
    
}
