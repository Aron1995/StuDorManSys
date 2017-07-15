package com.yc.ui;

import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import com.yc.util.AdminUtil;
import com.yc.util.LogUtil;
import com.yc.util.MD5Encryption;
import com.yc.util.RegUtil;
import com.yc.util.SwtUtil;
import com.yc.dao.ManageDao;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class login {

	protected Shell shell;
	private Text text_id;
	private Text text_pwd;
	private ManageDao MAD = new ManageDao();
	private RegUtil regUtil = new RegUtil();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			login window = new login();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open(){
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(){
		shell = new Shell(SWT.MIN);
		shell.setImage(SWTResourceManager.getImage(login.class, "/images/yclogo.png"));
		shell.setBackgroundImage(SWTResourceManager.getImage(login.class, "/images/bg_common.png"));
		shell.setSize(426, 341);
		shell.setText("登录");
		
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		
		//主窗体居中
		Dimension dem=Toolkit.getDefaultToolkit().getScreenSize();
		shell.setLocation((dem.width-shell.getSize().x)/2,(dem.height-shell.getSize().y)/2);
		
		Label lbl_id = new Label(shell, SWT.NONE);
		lbl_id.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl_id.setBounds(266, 140, 97, 17);
		
		Combo combo = new Combo(shell,SWT.DROP_DOWN|SWT.READ_ONLY);
		combo.setItems(new String[] {"请选择角色", "管理员", "宿管", "教师"});
		combo.select(0);
		combo.setBounds(129, 86, 131, 25);
		
		text_id = new Text(shell, SWT.BORDER);
		text_id.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(text_id.getText().matches("^[0-9]{3,4}$")){
					lbl_id.setText("*");
				}else{
					lbl_id.setText("请重新输入账户！");
				}
			}
		});
		text_id.setBounds(129, 137, 131, 23);
		
		Label lbl_pwd = new Label(shell, SWT.NONE);
		lbl_pwd.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl_pwd.setBounds(266, 185, 97, 17);
		
		text_pwd = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_pwd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(text_pwd.getText().matches("^\\w{4,12}$")){
					lbl_pwd.setText("密码长度为12位！");
				}else{
					lbl_pwd.setText("*");
				}
			}
		});
		text_pwd.setBounds(129, 182, 131, 23);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(87, 140, 36, 17);
		lblNewLabel.setText("账号：");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setBounds(87, 185, 36, 17);
		lblNewLabel_1.setText("密码：");
		
		Label label = new Label(shell, SWT.CENTER);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.NORMAL));
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setAlignment(SWT.CENTER);
		label.setBounds(87, 30, 233, 28);
		label.setText("欢迎登录宿舍管理系统！");
		
		Button btn_remenberPwd = new Button(shell, SWT.CHECK);
		btn_remenberPwd.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btn_remenberPwd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String name = text_id.getText();
				String pwd = text_pwd.getText();
				//是否选择记住密码
				if(btn_remenberPwd.getSelection()){
					//把信息存入注册表
					Map<String,String> map = new HashMap<String,String>();
					map.put("User", name+"-"+pwd);
					regUtil.addRegester(map);
				}
			}
		});
		btn_remenberPwd.setBounds(165, 218, 69, 17);
		btn_remenberPwd.setText("记住密码");
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!btn_remenberPwd.getSelection()){
					regUtil.deleteRegester("User");
				}
				if(text_id.getText().matches("^[0-9]{3,4}$")&&combo.getText()!="请选择角色"){
					int user_id = Integer.valueOf(text_id.getText().trim());
					String user_pwd = MD5Encryption.createPassword(text_pwd.getText().trim());
					String user_role = combo.getText();
					try {
						Map<String,Object> map = MAD.loginAdmin(user_id, user_pwd, user_role);
						if(map!=null&&map.size()>0){
							LogUtil.logger.info(map.get("USER_ROLE").toString()+"-"+map.get("USER_NAME").toString()+"-登录成功！");
							AdminUtil.adminObj = map;//存储管理员对象
							if("管理员".equals(map.get("USER_ROLE").toString())){
								shell.dispose();
								DorManUi dorManUi = new DorManUi();
								dorManUi.open();
							}else if("教师".equals(map.get("USER_ROLE").toString())){
								shell.dispose();
								TeacherManUi dorManUi = new TeacherManUi();
								dorManUi.open();
							}else if("宿管".equals(map.get("USER_ROLE").toString())){
								shell.dispose();
								SuManUi dorManUi = new SuManUi();
								dorManUi.open();
							}
						}else{
							LogUtil.logger.error(combo.getText()+"-"+text_id.getText()+"登录失败！");
							SwtUtil.showMessageBox(shell, "温馨提示", "登录失败！角色或用户名或密码错误！");
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}else{
					SwtUtil.showMessageBox(shell, "温馨提示", "请重新输入登录id！");
				}
			}
		});
		button.setBounds(75, 257, 80, 27);
		button.setText("登录");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_2.setBounds(87, 89, 36, 17);
		lblNewLabel_2.setText("角色：");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(240, 257, 80, 27);
		btnNewButton.setText("取消");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				combo.select(0);
				text_id.setText("");
				text_pwd.setText("");
			}
		});
		btnNewButton_1.setBounds(288, 84, 80, 27);
		btnNewButton_1.setText("重置所有");

		//从注册表中获取值
		String info = regUtil.getRegester("User");
		if(null==info||"".equals(info)){
			return;
		}
		
		//打开窗口时，将注册表保存的用户信息读并显示在界面上
		String [] logininfo = info.split("-");
		if(null==logininfo||logininfo.length==2){
			text_id.setText(logininfo[0]);
			text_pwd.setText(logininfo[1]);
		}
		
	}
}
