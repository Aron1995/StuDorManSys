package com.yc.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.yc.dao.DorDao;
import com.yc.dao.ManageDao;
import com.yc.dao.StudentDao;
import com.yc.util.AdminUtil;
import com.yc.util.DateUtil;
import com.yc.util.SwtUtil;

public class TeacherManUi {

	protected Shell shell;

	private StackLayout stackLayout;
	private Table table;
	private Table table2;
	private Text text;
	private Text text_0;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_updateUserPwd;
	private Text text_updateUserName;
	private Text text_updateUserTel;
	private Text text_updateUserAge;
	private Text text_updateUserSex;
	private Text text_updateUserSid;
	private Text text_updateUserRemark;
	private Text text_updateUserId;
	private ManageDao MAD = new ManageDao();
	private DorDao dorDao=new DorDao();
	private StudentDao studentDao = new StudentDao();
	private Combo combo_3;
	private Text text_amount;
	private Text text_lived;
	private Text text_id;
	private Text text_name;
	private Text text_age;
	private Text text_dept;
	private Text text_address;
	private Text text_class;
	private Text text_21;
	private Text text_22;
	private Text text_23;
	private Text text_24;
	private Text text_25;
	private Text text_27;
	private Text text_28;
	private Text text_29;
	private Text text_26;
	private Text text_31;
	private Text text_30;
	private Table table_1;
	private Table table_2;
	private Table table_3;
	private Text text_deleteId;
	private Text text_mailId;
	private Text text_mailPwd;
	private Text text_content;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TeacherManUi window = new TeacherManUi();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
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
	protected void createContents() {
		shell = new Shell(SWT.MIN);
		shell.setBackgroundImage(SWTResourceManager.getImage(DorManUi.class, "/images/bg_common.png"));
		shell.setImage(SWTResourceManager.getImage(DorManUi.class, "/images/yclogo.png"));
		shell.setSize(768, 480);
		shell.setText("学生宿舍管理系统");

		stackLayout = new StackLayout();
		shell.setLayout(stackLayout);//将窗体设置为堆栈式布局
		
		//设置控件背景透明
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		
		//主窗体居中
		//Dimension：标出尺寸 Toolkit：工具包
		Dimension dem = Toolkit.getDefaultToolkit().getScreenSize();
		//居中显示
		shell.setLocation((dem.width-shell.getSize().x)/2,(dem.height-shell.getSize().y)/2);
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntm_bullet = new MenuItem(menu, SWT.CASCADE);
		mntm_bullet.setText("发布公告");
		
		Menu menu_1 = new Menu(mntm_bullet);
		mntm_bullet.setMenu(menu_1);
		
		MenuItem mntm_dorManage = new MenuItem(menu, SWT.CASCADE);
		mntm_dorManage.setText("宿舍信息管理");
		
		Menu menu_2 = new Menu(mntm_dorManage);
		mntm_dorManage.setMenu(menu_2);
		
		Composite com_main = new Composite(shell, SWT.NONE);
		
		Label lbl_date1 = new Label(com_main, SWT.NONE);
		lbl_date1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_date1.setBounds(634, 404, 118, 17);
		DateUtil.Date(lbl_date1, com_main,shell);
		
		//主面板
		stackLayout.topControl = com_main;
		
		Label lblNewLabel_38 = new Label(com_main, SWT.NONE);
		lblNewLabel_38.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_38.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 30, SWT.NORMAL));
		lblNewLabel_38.setBounds(278, 113, 196, 62);
		lblNewLabel_38.setText("欢 迎 进 入");
		
		Label lblNewLabel_39 = new Label(com_main, SWT.NONE);
		lblNewLabel_39.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_39.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 30, SWT.NORMAL));
		lblNewLabel_39.setBounds(171, 198, 404, 62);
		lblNewLabel_39.setText("宿 舍 信 息 管 理 界 面");
		
		//composite面板
		Composite com_findDor = new Composite(shell, SWT.NONE);
		
		Label lbl_date2 = new Label(com_findDor, SWT.NONE);
		lbl_date2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_date2.setBounds(634, 404, 118, 17);
		DateUtil.Date(lbl_date2, com_findDor,shell);
		
		Composite com_updateDor = new Composite(shell, SWT.NONE);
		
		Label lbl_date3 = new Label(com_updateDor, SWT.NONE);
		lbl_date3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_date3.setBounds(634, 404, 118, 17);
		DateUtil.Date(lbl_date3, com_updateDor,shell);
		
		Composite com_addDor = new Composite(shell, SWT.NONE);
		
		Label lbl_date4 = new Label(com_addDor, SWT.NONE);
		lbl_date4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_date4.setBounds(634, 404, 118, 17);
		DateUtil.Date(lbl_date4, com_addDor,shell);
		
		MenuItem mntm_findDor = new MenuItem(menu_2, SWT.NONE);
		mntm_findDor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = com_findDor;
				shell.layout();
			}
		});
		mntm_findDor.setText("查询宿舍信息");

		MenuItem mntm_addDor = new MenuItem(menu_2, SWT.NONE);
		mntm_addDor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = com_addDor;
				shell.layout();
			}
		});
		mntm_addDor.setText("增加宿舍信息");
		
		MenuItem mntm_updateDor = new MenuItem(menu_2, SWT.NONE);
		mntm_updateDor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = com_updateDor;
				shell.layout();
			}
		});
		mntm_updateDor.setText("修改宿舍信息");
		
		Composite com_deleteDor = new Composite(shell, SWT.NONE);
		
		Label lbl_date5 = new Label(com_deleteDor, SWT.NONE);
		lbl_date5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_date5.setBounds(634, 404, 118, 17);
		DateUtil.Date(lbl_date5, com_deleteDor,shell);
		
		MenuItem menuItem_1 = new MenuItem(menu_2, SWT.CASCADE);
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = com_deleteDor;
				shell.layout();
			}
		});
		menuItem_1.setText("删除宿舍信息");
		
		MenuItem mntm_visiter = new MenuItem(menu, SWT.CASCADE);
		mntm_visiter.setText("来访登记");
		
		Menu menu_3 = new Menu(mntm_visiter);
		mntm_visiter.setMenu(menu_3);
		
		MenuItem mntm_stuManage = new MenuItem(menu, SWT.CASCADE);
		mntm_stuManage.setText("学生信息管理");
		
		Menu menu_4 = new Menu(mntm_stuManage);
		mntm_stuManage.setMenu(menu_4);

		Composite com_findStu = new Composite(shell, SWT.NONE);
		
		Label lbl_date6 = new Label(com_findStu, SWT.NONE);
		lbl_date6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_date6.setBounds(634, 404, 118, 17);
		DateUtil.Date(lbl_date6, com_findStu,shell);
		
		MenuItem mntm_findStu = new MenuItem(menu_4, SWT.NONE);
		mntm_findStu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = com_findStu;
				shell.layout();
			}
		});
		mntm_findStu.setText("查询学生信息");
		
		Composite com_addStu = new Composite(shell, SWT.NONE);
		
		Label lbl_date7 = new Label(com_addStu, SWT.NONE);
		lbl_date7.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_date7.setBounds(634, 404, 118, 17);
		DateUtil.Date(lbl_date7, com_addStu,shell);
		
		MenuItem mntm_addStu = new MenuItem(menu_4, SWT.NONE);
		mntm_addStu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = com_addStu;
				shell.layout();
			}
		});
		mntm_addStu.setText("增加学生信息");
		
		Composite com_updateStu = new Composite(shell, SWT.NONE);
		
		Label label_updateStu = new Label(com_updateStu, SWT.NONE);
		label_updateStu.setText("学 生 信 息 修 改 版 块");
		label_updateStu.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_updateStu.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_updateStu.setBounds(290, 33, 166, 23);
		
		Label lbl_date8 = new Label(com_updateStu, SWT.NONE);
		lbl_date8.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_date8.setBounds(634, 404, 118, 17);
		DateUtil.Date(lbl_date8, com_updateStu,shell);
		
		MenuItem mntm_updateStu = new MenuItem(menu_4, SWT.NONE);
		mntm_updateStu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = com_updateStu;
				shell.layout();
			}
		});
		mntm_updateStu.setText("修改学生信息");
		

		Composite com_deleteStu = new Composite(shell, SWT.NONE);
		
		MenuItem mntmNewSubmenu_2 = new MenuItem(menu_4, SWT.CASCADE);
		mntmNewSubmenu_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = com_deleteStu;
				shell.layout();
			}
		});
		mntmNewSubmenu_2.setText("删除学生信息");
		
		MenuItem mntm_userManage = new MenuItem(menu, SWT.CASCADE);
		mntm_userManage.setText("用户管理");
		
		Menu menu_5 = new Menu(mntm_userManage);
		mntm_userManage.setMenu(menu_5);
		
		Composite com_updateUser = new Composite(shell, SWT.NONE);
		
		MenuItem mntmNewSubmenu_1 = new MenuItem(menu_5, SWT.CASCADE);
		mntmNewSubmenu_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = com_updateUser;
				shell.layout();
			}
		});
		mntmNewSubmenu_1.setText("修改用户信息");
		
		MenuItem mntm_about = new MenuItem(menu, SWT.CASCADE);
		mntm_about.setText("关于我们");
		
		Menu menu_6 = new Menu(mntm_about);
		mntm_about.setMenu(menu_6);
		
Composite com_help = new Composite(shell,SWT.NONE);
		
		Group group = new Group(com_help, SWT.NONE);
		group.setText("联系我们");
		group.setBounds(52, 278, 651, 143);
		
		Label lblNewLabel_1 = new Label(group, SWT.NONE);
		lblNewLabel_1.setBounds(48, 32, 61, 17);
		lblNewLabel_1.setText("邮箱名称：");
		
		text_mailId = new Text(group, SWT.BORDER);
		text_mailId.setBounds(110, 26, 134, 23);
		
		Label lblNewLabel_7 = new Label(group, SWT.NONE);
		lblNewLabel_7.setBounds(48, 69, 61, 17);
		lblNewLabel_7.setText("登录密码：");
		
		text_mailPwd = new Text(group, SWT.BORDER);
		text_mailPwd.setBounds(110, 66, 134, 23);
		
		Button btnNewButton_5 = new Button(group, SWT.NONE);
		btnNewButton_5.setBounds(90, 106, 80, 27);
		btnNewButton_5.setText("登录");
		
		text_content = new Text(group, SWT.BORDER| SWT.WRAP|SWT.V_SCROLL);
		text_content.setBounds(275, 26, 346, 64);
		
		Button btnNewButton_6 = new Button(group, SWT.NONE);
		btnNewButton_6.setBounds(405, 106, 80, 27);
		btnNewButton_6.setText("发送");
		
		MenuItem mntmNewItem_5 = new MenuItem(menu_6, SWT.NONE);
		mntmNewItem_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = com_help;
				shell.layout();
			}
		});
		mntmNewItem_5.setText("帮助");
		
		MenuItem mntmNewItem = new MenuItem(menu_6, SWT.NONE);
		mntmNewItem.setText("关于");
		
		MenuItem mntm_exit = new MenuItem(menu, SWT.CASCADE);
		mntm_exit.addSelectionListener(new SelectionAdapter() {
			//退出系统
			public void widgetSelected(SelectionEvent e) {
				boolean flag = MessageDialog.openConfirm(shell, "温馨提示", "您确定退出系统？");
				if(flag){
					shell.close();
				}
			}
		});
		mntm_exit.setText("退出系统");
		
		//查询宿舍
		Label lblNewLabel = new Label(com_findDor, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(27, 10, 42, 17);
		lblNewLabel.setText("欢迎：");
		
		Label lbl_role = new Label(com_findDor, SWT.NONE);
		lbl_role.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl_role.setBounds(74, 10, 92, 17);
		
		combo_3 = new Combo(com_findDor, SWT.NONE|SWT.READ_ONLY);
		combo_3.setItems(new String[] {"请选择","宿舍编号", "已住人数", "根据学院", "根据楼栋"});
		combo_3.select(0);
		combo_3.setBounds(222, 67, 88, 25);
		
		text = new Text(com_findDor, SWT.BORDER);
		text.setBounds(350, 67, 152, 23);
		
		Button btnNewButton = new Button(com_findDor, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if("宿舍编号".equals(combo_3.getText().trim())){
					table.removeAll();
					String dor_dornum = text.getText();
					try {
						Map<String,Object> map = dorDao.findDorByDor_dornum(dor_dornum);
						if(map!=null&&map.size()>0){
							TableItem tableItem = new TableItem(table,SWT.NONE);
							tableItem.setText(new String[]{map.get("DOR_DORNUM").toString(),
									map.get("DOR_BUILDING").toString(),map.get("DOR_FLOOR").toString(),
									map.get("DOR_AMOUNT").toString(),map.get("DOR_LIVED").toString()});
							SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无此宿舍信息！");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					text.setText("");
				}else if("根据楼栋".equals(combo_3.getText().trim())){
					table.removeAll();
					String dor_building = text.getText();
					try {
						List<Map<String,Object>> list = dorDao.findDornumByDor_building(dor_building);
						if(list!=null&&list.size()>0){
							for(int i=0;i<list.size();i++){
								TableItem tableItem = new TableItem(table,SWT.NONE);
								tableItem.setText(new String[] {list.get(i).get("DOR_DORNUM").toString(),
										list.get(i).get("DOR_BUILDING").toString(),list.get(i).get("DOR_FLOOR").toString(),
										list.get(i).get("DOR_AMOUNT").toString(),list.get(i).get("DOR_LIVED").toString()});
							}
							SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
						}
						else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无此楼栋信息！");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					text.setText("");
				}else if("根据学院".equals(combo_3.getText().trim())){
					table.removeAll();
					String Stu_dept = text.getText();
					try {
						List<Map<String,Object>> list = dorDao.findDornumByStu_dept(Stu_dept);
						if(list!=null&&list.size()>0){
							for(int i=0;i<list.size();i++){
								TableItem tableItem = new TableItem(table,SWT.NONE);
								tableItem.setText(new String[] {list.get(i).get("DOR_DORNUM").toString(),
										list.get(i).get("DOR_BUILDING").toString(),list.get(i).get("DOR_FLOOR").toString(),
										list.get(i).get("DOR_AMOUNT").toString(),list.get(i).get("DOR_LIVED").toString()});
							}
							SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
						}
						else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无此学院信息！");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					text.setText("");
				}else if("已住人数".equals(combo_3.getText().trim())){
					table.removeAll();
					int dor_lived = Integer.valueOf(text.getText());
					try {
						List<Map<String,Object>> list = dorDao.findDornumByLived(dor_lived);
						if(list!=null&&list.size()>0){
							for(int i=0;i<list.size();i++){
								TableItem tableItem = new TableItem(table,SWT.NONE);
								tableItem.setText(new String[] {list.get(i).get("DOR_DORNUM").toString(),
										list.get(i).get("DOR_BUILDING").toString(),list.get(i).get("DOR_FLOOR").toString(),
										list.get(i).get("DOR_AMOUNT").toString(),list.get(i).get("DOR_LIVED").toString()});
							}
							SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
						}
						else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无此宿舍信息！");
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
					text.setText("");
				}else{
					SwtUtil.showMessageBox(shell, "温馨提示", "查询失败，请重新选择！");
					text.setText("");
				}
			}
		});
		btnNewButton.setBounds(547, 65, 80, 27);
		btnNewButton.setText("查询");
		
		table = new Table(com_findDor, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(223, 113, 404, 277);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(80);
		tblclmnNewColumn.setText("  宿舍编号");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(80);
		tblclmnNewColumn_1.setText("     楼栋");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(80);
		tblclmnNewColumn_2.setText("     楼层");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(80);
		tblclmnNewColumn_3.setText("  可住人数");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(80);
		tblclmnNewColumn_4.setText("  已住人数");
		
		Button btnNewButton_7 = new Button(com_findDor, SWT.NONE);
		btnNewButton_7.setBounds(646, 144, 69, 27);
		btnNewButton_7.setText("导入");
		
		Button button_3 = new Button(com_findDor, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		button_3.setText("导出");
		button_3.setBounds(646, 201, 69, 27);
		
		Button btnNewButton_3 = new Button(com_findDor, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ChartBuilding chartBuilding = new ChartBuilding();
				chartBuilding.open();
			}
		});
		btnNewButton_3.setBounds(646, 262, 69, 27);
		btnNewButton_3.setText("楼栋图表");
		
		Button btnNewButton_4 = new Button(com_findDor, SWT.NONE);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ChartDept chartDept = new ChartDept();
				chartDept.open();
			}
		});
		btnNewButton_4.setBounds(646, 327, 69, 27);
		btnNewButton_4.setText("学院图表");
		
		Label lblNewLabel_2 = new Label(com_findDor, SWT.NONE);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_2.setBounds(38, 101, 72, 17);
		lblNewLabel_2.setText("查询总人数：");
		
		Combo combo_4 = new Combo(com_findDor, SWT.NONE|SWT.READ_ONLY);
		combo_4.setItems(new String[] {"请选择","已住总人数", "可住总人数"});
		combo_4.setBounds(116, 98, 88, 25);
		combo_4.select(0);
		
		Label lblNewLabel_20 = new Label(com_findDor, SWT.NONE);
		lblNewLabel_20.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_20.setBounds(56, 154, 36, 17);
		lblNewLabel_20.setText("根据：");
		
		Combo combo = new Combo(com_findDor, SWT.NONE|SWT.READ_ONLY);
		combo.setItems(new String[] {"请选择","根据楼栋", "根据学院"});
		combo.setBounds(116, 151, 88, 25);
		combo.select(0);
		
		Label lblNewLabel_3 = new Label(com_findDor, SWT.NONE);
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_3.setBounds(56, 206, 36, 17);
		lblNewLabel_3.setText("学院：");
		
		Combo combo_1 = new Combo(com_findDor, SWT.NONE|SWT.READ_ONLY);
		combo_1.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				try{
					combo_1.removeAll();
					combo_1.setItems(new String []{"请选择"});
					List<Map<String,Object>> list = dorDao.findAllDept();
					if(list.size()>0&&list!=null){
						for(int i=0;i<list.size();i++){
							combo_1.add(list.get(i).get("STU_DEPT").toString());
						}
					}else{
						SwtUtil.showMessageBox(shell, "温馨提示", "无此信息！");
					}
					combo_1.select(0);
				} catch (SQLException e1) {
					SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
				}
			}
		});
		combo_1.setItems(new String[] {"请选择"});
		combo_1.setBounds(116, 203, 88, 25);
		combo_1.select(0);
		
		Label lblNewLabel_4 = new Label(com_findDor, SWT.NONE);
		lblNewLabel_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_4.setBounds(56, 262, 36, 17);
		lblNewLabel_4.setText("楼栋：");
		
		Combo combo_2 = new Combo(com_findDor, SWT.NONE|SWT.READ_ONLY);
		combo_2.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				try {
					combo_2.removeAll();
					combo_2.setItems(new String [] {"请选择"});
					List<Map<String,Object>> list = dorDao.findAllDorbuilding();
					if(list.size()>0&&list!=null){
						for(int i=0;i<list.size();i++){
							combo_2.add(list.get(i).get("DOR_BUILDING").toString());
						}
					}else{
						SwtUtil.showMessageBox(shell, "温馨提示", "无此信息！");
					}
					combo_2.select(0);
				} catch (SQLException e1) {
					SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
				}
			}
		});
		combo_2.setItems(new String[] {"请选择"});
		combo_2.setBounds(117, 259, 87, 25);
		combo_2.select(0);
		
		Label lblNewLabel_5 = new Label(com_findDor, SWT.NONE);
		lblNewLabel_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_5.setBounds(56, 366, 48, 17);
		lblNewLabel_5.setText("总人数：");
		
		text_1 = new Text(com_findDor, SWT.BORDER|SWT.READ_ONLY);
		text_1.setBounds(113, 363, 73, 27);
		
		Button btnNewButton_1 = new Button(com_findDor, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if("根据学院".equals(combo.getText().trim())&&"已住总人数".equals(combo_4.getText().trim())){
					String stu_dept=combo_1.getText().trim();
					try {//根据学院查询各学院已住多少人
						Map<String,Object> map = dorDao.countLivedStudentByStu_dept(stu_dept);
						if(map!=null&&map.size()>0){
							text_1.setText(map.get("COUNT(STU_ID)").toString());
							SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else if("根据楼栋".equals(combo.getText().trim())&&"已住总人数".equals(combo_4.getText().trim())){
					String dor_building=combo_2.getText().trim();
					try {//根据楼栋查询每栋楼已住多少人
						Map<String,Object> map = dorDao.countLivedStudentByDor_Building(dor_building);
						if(map!=null&&map.size()>0){
							text_1.setText(map.get("COUNT(STU_ID)").toString());
							SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else if("根据楼栋".equals(combo.getText().trim())&&"可住总人数".equals(combo_4.getText().trim())){
					String dor_building=combo_2.getText().trim();
					try {//根据楼栋查询每栋楼能住多少人
						Map<String,Object> map = dorDao.countStudentByDor_Building(dor_building);
						if(map!=null&&map.size()>0){
							text_1.setText(map.get("SUM(DOR_AMOUNT)").toString());
							SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBounds(74, 310, 80, 27);
		btnNewButton_1.setText("查询总人数");
		
		//增加宿舍信息
		Label lblNewLabel_6 = new Label(com_addDor, SWT.NONE);
		lblNewLabel_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_6.setBounds(27, 10, 42, 17);
		lblNewLabel_6.setText("欢迎：");
		
		Label lbl_role3 = new Label(com_addDor, SWT.NONE);
		lbl_role3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl_role3.setBounds(72, 10, 94, 17);
		
		Label lblNewLabel_8 = new Label(com_addDor, SWT.NONE);
		lblNewLabel_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_8.setBounds(72, 101, 61, 17);
		lblNewLabel_8.setText("宿舍编号：");
		
		Label lblNewLabel_13 = new Label(com_addDor, SWT.NONE);
		lblNewLabel_13.setText("例：“D1-101”");
		lblNewLabel_13.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_13.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_13.setBounds(218, 101, 94, 17);
		
		Label lblNewLabel_14 = new Label(com_addDor, SWT.NONE);
		lblNewLabel_14.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_14.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_14.setBounds(218, 158, 125, 17);
		
		Label lblNewLabel_15 = new Label(com_addDor, SWT.NONE);
		lblNewLabel_15.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_15.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_15.setBounds(218, 214, 94, 17);
		
		Label lblNewLabel_16 = new Label(com_addDor, SWT.NONE);
		lblNewLabel_16.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_16.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_16.setBounds(218, 267, 94, 17);
		
		Label lblNewLabel_17 = new Label(com_addDor, SWT.NONE);
		lblNewLabel_17.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_17.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_17.setBounds(218, 319, 94, 17);
		
		Label lblNewLabel_9 = new Label(com_addDor, SWT.NONE);
		lblNewLabel_9.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_9.setBounds(72, 158, 61, 17);
		lblNewLabel_9.setText("  楼  栋：");
		
		text_3 = new Text(com_addDor, SWT.BORDER);
		text_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String dor_building = text_3.getText().trim();
				if(dor_building!=""){
					lblNewLabel_14.setText("*");
				}else{
					lblNewLabel_14.setText("例：“D1”或“第一栋”");
				}
			}
		});
		text_3.setBounds(139, 155, 73, 23);
		
		Label lblNewLabel_10 = new Label(com_addDor, SWT.NONE);
		lblNewLabel_10.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_10.setBounds(72, 214, 61, 17);
		lblNewLabel_10.setText("  楼  层：");
		
		text_4 = new Text(com_addDor, SWT.BORDER);
		text_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String dor_floor = text_4.getText().trim();
				if(dor_floor.matches("^[0-9]{1,2}$")){
					lblNewLabel_15.setText("*");
				}else{
					lblNewLabel_15.setText("楼层输入错误！");
				}
			}
		});
		text_4.setBounds(139, 211, 73, 23);
		
		text_2 = new Text(com_addDor, SWT.BORDER);
		text_2.addFocusListener(new FocusAdapter() {
			//文本框失去焦点时，触发事件，判断文本框中的数据格式是否正确
			public void focusLost(FocusEvent e){
				//获取文本框名字
				String dor_dornum = text_2.getText().trim();
				if(dor_dornum!=""){
					lblNewLabel_13.setText("*");
				}else{
					lblNewLabel_13.setText("例：“D1-101”");
				}
				String [] buil_floor = dor_dornum.split("-|01");
				text_3.setText(buil_floor[0]);
				text_4.setText(buil_floor[1]);
			}
		});
		text_2.setBounds(139, 98, 73, 23);
		
		Label lblNewLabel_11 = new Label(com_addDor, SWT.NONE);
		lblNewLabel_11.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_11.setBounds(72, 267, 61, 17);
		lblNewLabel_11.setText("可住人数：");
		
		text_5 = new Text(com_addDor, SWT.BORDER);
		text_5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String dor_acount = text_5.getText().trim();
				if(dor_acount.matches("^[0-9]{1,2}$")){
					lblNewLabel_16.setText("*");
				}else{
					lblNewLabel_16.setText("人数输入错误！");
				}
			}
		});
		text_5.setBounds(139, 264, 73, 23);
		
		Label lblNewLabel_12 = new Label(com_addDor, SWT.NONE);
		lblNewLabel_12.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_12.setBounds(72, 319, 61, 17);
		lblNewLabel_12.setText("已住人数：");
		
		text_6 = new Text(com_addDor, SWT.BORDER);
		text_6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String dor_lived = text_5.getText().trim();
				if(dor_lived.matches("^[0-9]{1,2}$")){
					lblNewLabel_17.setText("*");
				}else{
					lblNewLabel_17.setText("人数输入错误！");
				}
			}
		});
		text_6.setBounds(139, 316, 73, 23);
		
		Button btnNewButton_2 = new Button(com_addDor, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(text_2.getText()!=""&&text_3.getText()!=""&&text_4.getText()!=""&&text_5.getText()!=""&&text_6.getText()!=""){
					String dor_dornum,dor_building;
					int dor_floor,dor_amount,dor_lived;
					dor_dornum = text_2.getText().trim();
					dor_building = text_3.getText().trim();
					dor_floor = Integer.valueOf(text_4.getText().trim());
					dor_amount = Integer.valueOf(text_5.getText().trim());
					dor_lived = Integer.valueOf(text_6.getText().trim());
					try {
						boolean flag = dorDao.addSingleDornum(dor_dornum, dor_building, dor_floor, dor_amount, dor_lived);
						if(flag){
							Map<String,Object> map = dorDao.findDorByDor_dornum(dor_dornum);
							TableItem tableItem = new TableItem(table_1,SWT.NONE);
							tableItem.setText(new String[]{map.get("DOR_DORNUM").toString(),map.get("DOR_BUILDING").toString(),
									map.get("DOR_FLOOR").toString(),map.get("DOR_LIVED").toString(),
									map.get("DOR_AMOUNT").toString()});
							SwtUtil.showMessageBox(shell, "温馨提示", "添加成功！");
						}else{
							SwtUtil.showMessageBox(shell, "错误提示", "添加失败！");
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "错误提示", "该宿舍已经存在！");
					}
				}else{
					SwtUtil.showMessageBox(shell, "温馨提示", "请输入正确的信息！");
				}
				text_2.setText("");
				text_3.setText("");
				text_4.setText("");
				text_5.setText("");
				text_6.setText("");
			}
		});
		btnNewButton_2.setBounds(150, 369, 89, 27);
		btnNewButton_2.setText("添加");
		
		Label lblNewLabel_31 = new Label(com_addDor, SWT.NONE);
		lblNewLabel_31.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_31.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_31.setBounds(321, 48, 168, 23);
		lblNewLabel_31.setText("添 加 宿 舍 信 息 版 块");
		
		table_1 = new Table(com_addDor, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(349, 101, 363, 235);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_5.setWidth(80);
		tblclmnNewColumn_5.setText("  宿舍编号");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_6.setWidth(60);
		tblclmnNewColumn_6.setText("楼栋");
		
		TableColumn tblclmnNewColumn_7 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_7.setWidth(60);
		tblclmnNewColumn_7.setText("楼层");
		
		TableColumn tblclmnNewColumn_8 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_8.setWidth(80);
		tblclmnNewColumn_8.setText("已住人数");
		
		TableColumn tblclmnNewColumn_9 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_9.setWidth(80);
		tblclmnNewColumn_9.setText("可住人数");
		
		//删除宿舍信息
		Label label_3 = new Label(com_deleteDor, SWT.NONE);
		label_3.setText("删 除 宿 舍 信 息 版 块");
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_3.setBounds(262, 47, 168, 23);
		
		Label label_4 = new Label(com_deleteDor, SWT.NONE);
		label_4.setText("宿舍编号：");
		label_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_4.setBounds(56, 247, 61, 17);
		
		Label label_5 = new Label(com_deleteDor, SWT.NONE);
		label_5.setText("  楼  栋：");
		label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_5.setBounds(56, 101, 61, 17);
		
		Label label_6 = new Label(com_deleteDor, SWT.NONE);
		label_6.setText("  楼  层：");
		label_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_6.setBounds(56, 176, 61, 17);
		
		Label lblNewLabel_32 = new Label(com_deleteDor, SWT.NONE);
		lblNewLabel_32.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_32.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_32.setBounds(218, 101, 94, 17);
		
		Combo combo_8 = new Combo(com_deleteDor, SWT.NONE|SWT.READ_ONLY);
		combo_8.setItems(new String [] {"请选择"});
		combo_8.select(0);
		combo_8.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				try {
					combo_8.removeAll();
					combo_8.setItems(new String [] {"请选择"});
					List<Map<String,Object>> list = dorDao.findAllDorbuilding();
					if(list.size()>0&&list!=null){
						for(int i=0;i<list.size();i++){
							combo_8.add(list.get(i).get("DOR_BUILDING").toString());
						}
					}else{
						SwtUtil.showMessageBox(shell, "温馨提示", "无此信息！");
					}
					combo_8.select(0);
				} catch (SQLException e1) {
					SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
				}
			}
		});
		combo_8.setBounds(124, 98, 88, 25);
		
		Label lblNewLabel_33 = new Label(com_deleteDor, SWT.NONE);
		lblNewLabel_33.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_33.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_33.setBounds(218, 176, 94, 17);
		
		Combo combo_9 = new Combo(com_deleteDor, SWT.NONE|SWT.READ_ONLY);
		combo_9.setItems(new String [] {"请选择"});
		combo_9.select(0);
		combo_9.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				if("请选择".equals(combo_8.getText().trim())){
					lblNewLabel_32.setText("请重新选择楼栋！");
				}else{
					lblNewLabel_32.setText("*");
					String dor_building = combo_8.getText().trim();
					try {
						combo_9.removeAll();
						combo_9.setItems( new String []{"请选择"});
						List<Map<String,Object>> list = dorDao.findAllDorfloorByDorbuilding(dor_building);
						for(Map<String,Object> map:list){
							combo_9.add(map.get("DOR_FLOOR").toString());
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}
				combo_9.select(0);
			}
		});
		combo_9.setBounds(124, 173, 88, 25);
		
		Combo combo_10 = new Combo(com_deleteDor, SWT.NONE|SWT.READ_ONLY);
		combo_10.setItems(new String [] {"请选择"});
		combo_10.select(0);
		combo_10.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				if("请选择".equals(combo_9.getText().trim())){
					lblNewLabel_33.setText("请重新选择楼层！");
				}else{
					lblNewLabel_33.setText("*");
					String dor_building = combo_8.getText().trim();
					int dor_floor = Integer.valueOf(combo_9.getText().trim());
					try {
						combo_10.removeAll();
						combo_10.setItems( new String []{"请选择"});
						List<Map<String,Object>> list = dorDao.findDornumByDor_buildingDor_floor(dor_building, dor_floor);
						for(Map<String,Object> map:list){
							combo_10.add(map.get("DOR_DORNUM").toString());
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}
				combo_10.select(0);
			}
		});
		combo_10.setBounds(123, 244, 88, 25);
		
		Label lblNewLabel_34 = new Label(com_deleteDor, SWT.NONE);
		lblNewLabel_34.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_34.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_34.setBounds(217, 247, 125, 17);
		
		Button button = new Button(com_deleteDor, SWT.NONE);
		button.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				if("请选择".equals(combo_10.getText().trim())){
					lblNewLabel_34.setText("请重新选择宿舍编号！");
				}else{
					lblNewLabel_34.setText("*");
					String dor_dornum = combo_10.getText();
					try {
						//计算当前删除的宿舍是否有学生
						Map<String, Object> map = studentDao.countLivedStudentByDornum(dor_dornum);
						int a = Integer.valueOf(map.get("DOR_LIVED").toString());
						//查询删除的宿舍信息
						table_2.removeAll();
						Map<String,Object> map1 = dorDao.findDorByDor_dornum(dor_dornum);
						TableItem tableItem = new TableItem(table_2,SWT.NONE);
						tableItem.setText(new String[]{
								map1.get("DOR_DORNUM").toString(),map1.get("DOR_BUILDING").toString(),
								map1.get("DOR_FLOOR").toString(),map1.get("DOR_LIVED").toString(),map1.get("DOR_AMOUNT").toString()
						});
						if(a>0){
							combo_8.select(0);
							combo_9.select(0);
							combo_10.select(0);
							SwtUtil.showMessageBox(shell, "温馨提示", "该宿舍有学生，无法删除！");
						}else{
							button.addSelectionListener(new SelectionAdapter() {
								@Override
								public void widgetSelected(SelectionEvent e) {
									String dor_dornum = combo_10.getText().trim();
									try {
										boolean flag = dorDao.deleteDornum(dor_dornum);
										if(flag){
											SwtUtil.showMessageBox(shell, "温馨提示", "删除成功！");
										}
									} catch (SQLException e1) {
										SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
									}
									combo_8.select(0);
									combo_9.select(0);
									combo_10.select(0);
								}
							});
						}
					} catch (SQLException e2) {
						SwtUtil.showMessageBox(shell, "温馨提示", e2.getMessage());
					}
				}
			}
		});
		button.setText("删除");
		button.setBounds(123, 320, 89, 27);
		
		table_2 = new Table(com_deleteDor, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setBounds(379, 98, 323, 197);
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn_10 = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn_10.setWidth(80);
		tblclmnNewColumn_10.setText("宿舍编号");
		
		TableColumn tblclmnNewColumn_11 = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn_11.setWidth(60);
		tblclmnNewColumn_11.setText("楼栋");
		
		TableColumn tblclmnNewColumn_12 = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn_12.setWidth(60);
		tblclmnNewColumn_12.setText("楼层");
		
		TableColumn tblclmnNewColumn_13 = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn_13.setWidth(60);
		tblclmnNewColumn_13.setText("已住人数");
		
		TableColumn tableColumn = new TableColumn(table_2, SWT.NONE);
		tableColumn.setWidth(60);
		tableColumn.setText("可住人数");
		
		//修改宿舍信息
		Label lblNewLabel_18 = new Label(com_updateDor, SWT.NONE);
		lblNewLabel_18.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_18.setBounds(27, 10, 42, 17);
		lblNewLabel_18.setText("欢迎：");
		
		Label lbl_role2 = new Label(com_updateDor, SWT.NONE);
		lbl_role2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl_role2.setBounds(74, 10, 93, 17);
		
		Label lblNewLabel_25 = new Label(com_updateDor, SWT.NONE);
		lblNewLabel_25.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_25.setBounds(86, 81, 61, 17);
		lblNewLabel_25.setText("  楼  栋：");
		
		Label lblNewLabel_22 = new Label(com_updateDor, SWT.NONE);
		lblNewLabel_22.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_22.setBounds(86, 177, 61, 17);
		lblNewLabel_22.setText("  楼  层：");
		
		Label lblNewLabel_21 = new Label(com_updateDor, SWT.NONE);
		lblNewLabel_21.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_21.setBounds(86, 275, 61, 17);
		lblNewLabel_21.setText("宿舍编号：");
		
		Label lblNewLabel_23 = new Label(com_updateDor, SWT.NONE);
		lblNewLabel_23.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_23.setBounds(417, 235, 61, 17);
		lblNewLabel_23.setText("可住人数：");
		
		Label lblNewLabel_24 = new Label(com_updateDor, SWT.NONE);
		lblNewLabel_24.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_24.setBounds(417, 294, 61, 17);
		lblNewLabel_24.setText("已住人数：");
		
		Label lblNewLabel_26 = new Label(com_updateDor, SWT.NONE);
		lblNewLabel_26.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_26.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_26.setBounds(589, 55, 114, 17);
		
		Label lblNewLabel_27 = new Label(com_updateDor, SWT.NONE);
		lblNewLabel_27.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_27.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_27.setBounds(589, 119, 114, 17);
		
		Label lblNewLabel_28 = new Label(com_updateDor, SWT.NONE);
		lblNewLabel_28.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_28.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_28.setBounds(589, 177, 114, 17);
		
		Label lblNewLabel_29 = new Label(com_updateDor, SWT.NONE);
		lblNewLabel_29.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_29.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_29.setBounds(589, 235, 98, 17);
		
		Label lblNewLabel_30 = new Label(com_updateDor, SWT.NONE);
		lblNewLabel_30.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_30.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_30.setBounds(589, 294, 98, 17);
		
		Label lblNewLabel_35 = new Label(com_updateDor, SWT.NONE);
		lblNewLabel_35.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_35.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_35.setBounds(256, 81, 114, 17);
		
		Label lblNewLabel_36 = new Label(com_updateDor, SWT.NONE);
		lblNewLabel_36.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_36.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_36.setBounds(256, 177, 114, 17);
		
		Label lblNewLabel_37 = new Label(com_updateDor, SWT.NONE);
		lblNewLabel_37.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_37.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		lblNewLabel_37.setBounds(256, 275, 114, 17);
		
		Combo combo_5 = new Combo(com_updateDor, SWT.NONE|SWT.READ_ONLY);
		combo_5.setItems(new String [] {"请选择"});
		combo_5.select(0);
		combo_5.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				try {
					combo_5.removeAll();
					combo_5.setItems(new String [] {"请选择"});
					List<Map<String,Object>> list = dorDao.findAllDorbuilding();
					if(list.size()>0&&list!=null){
						for(int i=0;i<list.size();i++){
							combo_5.add(list.get(i).get("DOR_BUILDING").toString());
						}
					}else{
						SwtUtil.showMessageBox(shell, "温馨提示", "无此信息！");
					}
					combo_5.select(0);
				} catch (SQLException e1) {
					SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
				}
			}
		});
		combo_5.setBounds(153, 78, 88, 25);
		
		Combo combo_6 = new Combo(com_updateDor, SWT.NONE|SWT.READ_ONLY);
		combo_6.setItems( new String []{"请选择"});
		combo_6.select(0);
		combo_6.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				if("请选择".equals(combo_5.getText().trim())){
					lblNewLabel_35.setText("请重新选择楼栋！");
				}else{
					lblNewLabel_35.setText("*");
					String dor_building = combo_5.getText().trim();
					try {
						combo_6.removeAll();
						combo_6.setItems( new String []{"请选择"});
						List<Map<String,Object>> list = dorDao.findAllDorfloorByDorbuilding(dor_building);
						for(Map<String,Object> map:list){
							combo_6.add(map.get("DOR_FLOOR").toString());
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}
				combo_6.select(0);
			}
		});
		combo_6.setBounds(153, 174, 88, 25);
		
		Combo combo_7 = new Combo(com_updateDor, SWT.NONE|SWT.READ_ONLY);
		combo_7.setItems( new String []{"请选择"});
		combo_7.select(0);
		combo_7.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				if("请选择".equals(combo_6.getText().trim())){
					lblNewLabel_36.setText("请重新选择楼层！");
				}else{
					lblNewLabel_36.setText("*");
					String dor_building = combo_5.getText().trim();
					int dor_floor = Integer.valueOf(combo_6.getText().trim());
					try {
						combo_7.removeAll();
						combo_7.setItems( new String []{"请选择"});
						List<Map<String,Object>> list = dorDao.findDornumByDor_buildingDor_floor(dor_building, dor_floor);
						for(Map<String,Object> map:list){
							combo_7.add(map.get("DOR_DORNUM").toString());
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}
				combo_7.select(0);
			}
		});
		combo_7.setBounds(153, 272, 88, 25);
		
		Label label = new Label(com_updateDor, SWT.NONE);
		label.setText("  楼  栋：");
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(417, 55, 61, 17);
		
		text_9 = new Text(com_updateDor, SWT.BORDER);
		text_9.addFocusListener(new FocusAdapter() {
			//文本框失去焦点时，触发事件，判断文本框中的数据格式是否正确
			public void focusLost(FocusEvent e){
				if("请选择".equals(combo_7.getText().trim())){
					lblNewLabel_37.setText("请重新选择宿舍编号！");
				}else{
					lblNewLabel_37.setText("*");
				}
				//获取文本框名字
				String dor_building = text_9.getText().trim();
				lblNewLabel_26.setText("例：“D1”或“第一栋”！");
				if(dor_building!=""){
					lblNewLabel_13.setText("*");
				}
			}
		});
		text_9.setBounds(484, 52, 88, 25);
		
		Label label_1 = new Label(com_updateDor, SWT.NONE);
		label_1.setText("  楼  层：");
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setBounds(417, 119, 61, 17);
		
		text_8 = new Text(com_updateDor, SWT.BORDER);
		text_8.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String dor_floor = text_8.getText().trim();
				if(dor_floor.matches("^[0-9]{1,15}$")){
					lblNewLabel_27.setText("*");
				}else{
					lblNewLabel_27.setText("楼层输入错误！");
				}
			}
		});
		text_8.setBounds(484, 116, 88, 25);
		
		Label label_2 = new Label(com_updateDor, SWT.NONE);
		label_2.setText("宿舍编号：");
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setBounds(417, 177, 61, 17);
		
		text_7 = new Text(com_updateDor, SWT.BORDER);
		text_7.addFocusListener(new FocusAdapter() {
			//文本框失去焦点时，触发事件，判断文本框中的数据格式是否正确
			public void focusLost(FocusEvent e){
				//获取文本框名字
				String dor_dornum = text_7.getText().trim();
				lblNewLabel_28.setText("例：“D1-101”！");
				if(dor_dornum!=""){
					lblNewLabel_28.setText("*");
				}
			}
		});
		text_7.setBounds(484, 174, 88, 25);
		
		text_amount = new Text(com_updateDor, SWT.BORDER);
		text_amount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String dor_amount = text_amount.getText().trim();
				if(dor_amount.matches("^[0-9]{1,2}$")){
					lblNewLabel_29.setText("*");
				}else{
					lblNewLabel_29.setText("人数输入错误！");
				}
			}
		});
		text_amount.setBounds(484, 232, 88, 25);
		
		text_lived = new Text(com_updateDor, SWT.BORDER);
		text_lived.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String dor_lived = text_lived.getText().trim();
				if(dor_lived.matches("^[0-9]{1,2}$")){
					lblNewLabel_30.setText("*");
				}else{
					lblNewLabel_30.setText("人数输入错误！");
				}
			}
		});
		text_lived.setBounds(484, 291, 88, 25);
		
		Button btn_update = new Button(com_updateDor, SWT.NONE);
		btn_update.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(text_7.getText().trim()!=""&&text_8.getText().trim()!=""&&text_9.getText().trim()!=""
						&&text_amount.getText().trim()!=""&&text_lived.getText().trim()!=""){
					String dor_dornum1 = combo_7.getText().trim();
					String dor_building = text_9.getText().trim();
					String dor_dornum = text_7.getText().trim();
					int dor_floor = Integer.valueOf(text_8.getText().trim());
					int dor_amount = Integer.valueOf(text_amount.getText().trim());
					int dor_lived = Integer.valueOf(text_lived.getText().trim());
					try {
						boolean flag = dorDao.updateSingleDornumByDornum(dor_building, dor_floor, dor_dornum, dor_dornum1, dor_amount, dor_lived);
						if(flag){
							SwtUtil.showMessageBox(shell, "温馨提示", "修改成功！");
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}else{
					SwtUtil.showMessageBox(shell, "温馨提示", "请输入正确的信息！");
				}
				combo_5.select(0);
				combo_6.select(0);
				combo_7.select(0);
				text_7.setText("");
				text_8.setText("");
				text_9.setText("");
				text_amount.setText("");
				text_lived.setText("");
			}
		});
		btn_update.setBounds(484, 350, 88, 27);
		btn_update.setText("修改");
		
		//查找学生信息
		Combo combo_find = new Combo(com_findStu, SWT.NONE|SWT.READ_ONLY);
		combo_find.setItems(new String[] {"请选择", "查询所有", "根据学院", "根据班级", "宿舍编号", "根据学号", "根据状态"});
		combo_find.select(0);
		combo_find.setBounds(171, 70, 88, 25);
		
		text_0 = new Text(com_findStu, SWT.BORDER);
		text_0.setBounds(307, 70, 138, 23);
		
		Button btn_findStu1 = new Button(com_findStu, SWT.NONE);
		btn_findStu1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if("查询所有".equals(combo_find.getText().trim())){
					try {
						table2.removeAll();
						List<Map<String,Object>> list = studentDao.findAllStudent();
						if(list!=null&&list.size()>0){
							for(int i=0;i<list.size();i++){
								TableItem tableItem = new TableItem(table2,SWT.NONE);
								tableItem.setText(new String [] {
										list.get(i).get("STU_ID").toString(),list.get(i).get("STU_NAME").toString(),
										list.get(i).get("STU_SEX").toString(),list.get(i).get("STU_AGE").toString(),
										list.get(i).get("STU_DEPT").toString(),list.get(i).get("STU_DORNUM").toString(),
										list.get(i).get("STU_INDATE").toString(),list.get(i).get("STU_OUTDATE").toString(),
										list.get(i).get("STU_CLASS").toString(),list.get(i).get("STU_ADDRESS").toString(),
										list.get(i).get("STU_STATUS").toString()
								});
							}
							SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无学生信息！");
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
					combo_find.select(0);
				}else if("根据学院".equals(combo_find.getText().trim())){
					String stu_dept = text_0.getText().trim();
					try {
						table2.removeAll();
						List<Map<String,Object>> list = studentDao.findStudentByStu_dept(stu_dept);
						if(list!=null&&list.size()>0){
							for(int i=0;i<list.size();i++){
								TableItem tableItem = new TableItem(table2,SWT.NONE);
								tableItem.setText(new String [] {
										list.get(i).get("STU_ID").toString(),list.get(i).get("STU_NAME").toString(),
										list.get(i).get("STU_SEX").toString(),list.get(i).get("STU_AGE").toString(),
										list.get(i).get("STU_DEPT").toString(),list.get(i).get("STU_DORNUM").toString(),
										list.get(i).get("STU_INDATE").toString(),list.get(i).get("STU_OUTDATE").toString(),
										list.get(i).get("STU_CLASS").toString(),list.get(i).get("STU_ADDRESS").toString(),
										list.get(i).get("STU_STATUS").toString()
								});
							}
							SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无学生信息！");
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
					combo_find.select(0);
					text_0.setText("");
				}else if("根据班级".equals(combo_find.getText().trim())){
					String stu_class = text_0.getText().trim();
					try {
						table2.removeAll();
						List<Map<String,Object>> list = studentDao.findStudentByStu_class(stu_class);
						if(list!=null&&list.size()>0){
							for(int i=0;i<list.size();i++){
								TableItem tableItem = new TableItem(table2,SWT.NONE);
								tableItem.setText(new String [] {
										list.get(i).get("STU_ID").toString(),list.get(i).get("STU_NAME").toString(),
										list.get(i).get("STU_SEX").toString(),list.get(i).get("STU_AGE").toString(),
										list.get(i).get("STU_DEPT").toString(),list.get(i).get("STU_DORNUM").toString(),
										list.get(i).get("STU_INDATE").toString(),list.get(i).get("STU_OUTDATE").toString(),
										list.get(i).get("STU_CLASS").toString(),list.get(i).get("STU_ADDRESS").toString(),
										list.get(i).get("STU_STATUS").toString()
								});
							}
							SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无学生信息！");
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
					combo_find.select(0);
					text_0.setText("");
				}else if("宿舍编号".equals(combo_find.getText().trim())){
					String Stu_dornum = text_0.getText().trim();
					try {
						table2.removeAll();
						List<Map<String,Object>> list = studentDao.findStudentByStu_dornum(Stu_dornum);
						if(list!=null&&list.size()>0){
							for(int i=0;i<list.size();i++){
								TableItem tableItem = new TableItem(table2,SWT.NONE);
								tableItem.setText(new String [] {
										list.get(i).get("STU_ID").toString(),list.get(i).get("STU_NAME").toString(),
										list.get(i).get("STU_SEX").toString(),list.get(i).get("STU_AGE").toString(),
										list.get(i).get("STU_DEPT").toString(),list.get(i).get("STU_DORNUM").toString(),
										list.get(i).get("STU_INDATE").toString(),list.get(i).get("STU_OUTDATE").toString(),
										list.get(i).get("STU_CLASS").toString(),list.get(i).get("STU_ADDRESS").toString(),
										list.get(i).get("STU_STATUS").toString()
								});
							}
							SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无学生信息！");
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
					combo_find.select(0);
					text_0.setText("");
				}else if("根据学号".equals(combo_find.getText().trim())){
					int Stu_id = Integer.valueOf(text_0.getText().trim());
					try {
						table2.removeAll();
						Map<String,Object> map= studentDao.findStudentByStu_id(Stu_id);
						if(map!=null&&map.size()>0){
							TableItem tableItem = new TableItem(table2,SWT.NONE);
							tableItem.setText(new String [] {
									map.get("STU_ID").toString(),map.get("STU_NAME").toString(),
									map.get("STU_SEX").toString(),map.get("STU_AGE").toString(),
									map.get("STU_DEPT").toString(),map.get("STU_DORNUM").toString(),
									map.get("STU_INDATE").toString(),map.get("STU_OUTDATE").toString(),
									map.get("STU_CLASS").toString(),map.get("STU_ADDRESS").toString(),
									map.get("STU_STATUS").toString()
							});
							SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无学生信息！");
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
					combo_find.select(0);
					text_0.setText("");
				}else if("根据状态".equals(combo_find.getText().trim())){
					String stu_status = text_0.getText().trim();
					try {
						table2.removeAll();
						List<Map<String,Object>> list= studentDao.findStudentByStu_status(stu_status);
						if(list!=null&&list.size()>0){
							for(int i=0;i<list.size();i++){
								TableItem tableItem = new TableItem(table2,SWT.NONE);
								tableItem.setText(new String [] {
										list.get(i).get("STU_ID").toString(),list.get(i).get("STU_NAME").toString(),
										list.get(i).get("STU_SEX").toString(),list.get(i).get("STU_AGE").toString(),
										list.get(i).get("STU_DEPT").toString(),list.get(i).get("STU_DORNUM").toString(),
										list.get(i).get("STU_INDATE").toString(),list.get(i).get("STU_OUTDATE").toString(),
										list.get(i).get("STU_CLASS").toString(),list.get(i).get("STU_ADDRESS").toString(),
										list.get(i).get("STU_STATUS").toString()
								});
							}
							SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无学生信息！");
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
					combo_find.select(0);
					text_0.setText("");
				}
			}
		});
		btn_findStu1.setBounds(494, 68, 80, 27);
		btn_findStu1.setText("查询");
		
		table2 = new Table(com_findStu, SWT.BORDER | SWT.FULL_SELECTION);
		table2.setBounds(10, 122, 742, 195);
		table2.setHeaderVisible(true);
		table2.setLinesVisible(true);
		
		TableColumn tblclmn_id = new TableColumn(table2, SWT.NONE);
		tblclmn_id.setWidth(60);
		tblclmn_id.setText("  学号");
		
		TableColumn tblclmn_name = new TableColumn(table2, SWT.NONE);
		tblclmn_name.setWidth(60);
		tblclmn_name.setText("  姓名");
		
		TableColumn tblclmn_sex = new TableColumn(table2, SWT.NONE);
		tblclmn_sex.setWidth(40);
		tblclmn_sex.setText("性别");
		
		TableColumn tblclmn_age = new TableColumn(table2, SWT.NONE);
		tblclmn_age.setWidth(40);
		tblclmn_age.setText("年龄");
		
		TableColumn tblclmn_dept = new TableColumn(table2, SWT.NONE);
		tblclmn_dept.setWidth(80);
		tblclmn_dept.setText("  所在学院");
		
		TableColumn tblclmn_dornum = new TableColumn(table2, SWT.NONE);
		tblclmn_dornum.setWidth(60);
		tblclmn_dornum.setText("宿舍编号");
		
		TableColumn tblclmn_indate = new TableColumn(table2, SWT.NONE);
		tblclmn_indate.setWidth(80);
		tblclmn_indate.setText("  入住时间");
		
		TableColumn tblclmn_outdate = new TableColumn(table2, SWT.NONE);
		tblclmn_outdate.setWidth(80);
		tblclmn_outdate.setText("  离开时间");
		
		TableColumn tblclmn_class = new TableColumn(table2, SWT.NONE);
		tblclmn_class.setWidth(70);
		tblclmn_class.setText("   班级");
		
		TableColumn tblclmn_address = new TableColumn(table2, SWT.NONE);
		tblclmn_address.setWidth(130);
		tblclmn_address.setText("        家庭住址");
		
		TableColumn tblclmn_status = new TableColumn(table2, SWT.NONE);
		tblclmn_status.setWidth(40);
		tblclmn_status.setText("状态");
		
		Label lblNewLabel_all = new Label(com_findStu, SWT.NONE);
		lblNewLabel_all.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_all.setBounds(57, 358, 73, 17);
		lblNewLabel_all.setText("查询总人数：");
		
		Combo combo_find2 = new Combo(com_findStu, SWT.NONE|SWT.READ_ONLY);
		combo_find2.setItems(new String[] {"根据学院", "根据班级"});
		combo_find2.select(0);
		combo_find2.setBounds(136, 355, 88, 25);
		
		Label lblNewLabel_decl = new Label(com_findStu, SWT.NONE);
		lblNewLabel_decl.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_decl.setBounds(252, 358, 61, 17);
		lblNewLabel_decl.setText("学院班级：");
		
		Combo combo_find3 = new Combo(com_findStu, SWT.NONE|SWT.READ_ONLY);
		combo_find3.setItems(new String[] {"请选择"});
		combo_find3.select(0);
		combo_find3.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				if("请选择".equals(combo_find2.getText().trim())){
					SwtUtil.showMessageBox(shell, "温馨提示", "请选择根据学院或班级！");
				}else{
					if("根据学院".equals(combo_find2.getText().trim())){
						try {
							combo_find3.removeAll();
							combo_find3.setItems(new String[] {"请选择"});
							List<Map<String,Object>> list = dorDao.findAllDept();
							if(list!=null&&list.size()>0){
								for(int i=0;i<list.size();i++){
									combo_find3.add(list.get(i).get("STU_DEPT").toString());
								}
							}else{
								SwtUtil.showMessageBox(shell, "温馨提示", "无学院信息！");
							}
							combo_find3.select(0);
						} catch (SQLException e) {
							SwtUtil.showMessageBox(shell, "温馨提示", e.getMessage());
						}
					}else if("根据班级".equals(combo_find2.getText().trim())){
						try {
							combo_find3.removeAll();
							combo_find3.setItems(new String[] {"请选择"});
							List<Map<String,Object>> list = studentDao.findAllClasss();
							if(list!=null&&list.size()>0){
								for(int i=0;i<list.size();i++){
									combo_find3.add(list.get(i).get("STU_CLASS").toString());
								}
							}else{
								SwtUtil.showMessageBox(shell, "温馨提示", "无班级信息！");
							}
							combo_find3.select(0);
						} catch (SQLException e) {
							SwtUtil.showMessageBox(shell, "温馨提示", e.getMessage());
						}
					}
				}
			}
		});
		combo_find3.setBounds(319, 355, 88, 25);
		
		Button btn_findStu2 = new Button(com_findStu, SWT.NONE);
		btn_findStu2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if("根据学院".equals(combo_find2.getText().trim())){
					String stu_dept = combo_find3.getText().trim();
					try {
						Map<String,Object> map = studentDao.countStudentNumberByStu_dept(stu_dept);
						text_10.setText(map.get("COUNT(STU_ID)").toString());
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
					SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
				}else if("根据班级".equals(combo_find2.getText().trim())){
					String stu_class = combo_find3.getText().trim();
					try {
						Map<String,Object> map = studentDao.countStudentNumberByStu_class(stu_class);
						text_10.setText(map.get("COUNT(STU_ID)").toString());
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
					SwtUtil.showMessageBox(shell, "温馨提示", "查询成功！");
				}else{
					SwtUtil.showMessageBox(shell, "温馨提示", "请选择根据学院或班级！");
				}
			}
		});
		btn_findStu2.setBounds(451, 353, 80, 27);
		btn_findStu2.setText("查询");
		
		Label lblNewLabel_allnum = new Label(com_findStu, SWT.NONE);
		lblNewLabel_allnum.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_allnum.setBounds(573, 358, 48, 17);
		lblNewLabel_allnum.setText("总人数：");
		
		text_10 = new Text(com_findStu, SWT.BORDER);
		text_10.setBounds(627, 355, 73, 23);

		//增加学生信息
		Label lblNewLabel_addInfo = new Label(com_addStu, SWT.NONE);
		lblNewLabel_addInfo.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNewLabel_addInfo.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_addInfo.setBounds(269, 34, 163, 23);
		lblNewLabel_addInfo.setText("学 生 信 息 添 加 版 块");
		
		Label lblNewLabel_addId = new Label(com_addStu, SWT.NONE);
		lblNewLabel_addId.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_addId.setBounds(129, 74, 52, 17);
		lblNewLabel_addId.setText("  学  号：");
		
		text_id = new Text(com_addStu, SWT.BORDER);
		text_id.setBounds(187, 71, 89, 23);
		
		Label lblNewLabel_addName = new Label(com_addStu, SWT.NONE);
		lblNewLabel_addName.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_addName.setBounds(129, 129, 52, 17);
		lblNewLabel_addName.setText("  姓  名：");
		
		text_name = new Text(com_addStu, SWT.BORDER);
		text_name.setBounds(187, 126, 89, 23);
		
		Label lblNewLabel_addSex = new Label(com_addStu, SWT.NONE);
		lblNewLabel_addSex.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_addSex.setBounds(129, 183, 52, 17);
		lblNewLabel_addSex.setText("  性  别：");
		
		Button button_nan = new Button(com_addStu, SWT.RADIO);
		button_nan.setBounds(187, 183, 33, 17);
		button_nan.setText("男");
		
		Button button_nv = new Button(com_addStu, SWT.RADIO);
		button_nv.setBounds(243, 183, 33, 17);
		button_nv.setText("女");
		
		Label lblNewLabel_addAge = new Label(com_addStu, SWT.NONE);
		lblNewLabel_addAge.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_addAge.setBounds(129, 236, 52, 17);
		lblNewLabel_addAge.setText("  年  龄：");
		
		text_age = new Text(com_addStu, SWT.BORDER);
		text_age.setBounds(187, 233, 89, 23);
		
		Label lblNewLabel_addDept = new Label(com_addStu, SWT.NONE);
		lblNewLabel_addDept.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_addDept.setBounds(129, 282, 52, 17);
		lblNewLabel_addDept.setText("  学  院：");
		
		text_dept = new Text(com_addStu, SWT.BORDER);
		text_dept.setBounds(187, 279, 89, 23);
		
		Label lblNewLabel_addIndate = new Label(com_addStu, SWT.NONE);
		lblNewLabel_addIndate.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_addIndate.setBounds(391, 74, 61, 17);
		lblNewLabel_addIndate.setText("入住时间：");
		
		DateTime text_indate = new DateTime(com_addStu, SWT.BORDER | SWT.LONG);
		text_indate.setBounds(458, 71, 114, 24);
		int year_inAddStu = text_indate.getYear();
		int month_inAddStu = text_indate.getMonth();
		int day_inAddStu = text_indate.getDay();
		String indate_addStu =String.valueOf(year_inAddStu)+"-"+String.valueOf(month_inAddStu)+
				"-"+String.valueOf(day_inAddStu);
		
		DateTime text_outdate = new DateTime(com_addStu, SWT.BORDER | SWT.LONG);
		text_outdate.setBounds(458, 122, 114, 24);
		int year_outAddStu = text_outdate.getYear();
		int month_outAddStu = text_outdate.getMonth();
		int day_outAddStu = text_outdate.getDay();
		String outdate_addStu =String.valueOf(year_outAddStu)+"-"+String.valueOf(month_outAddStu)+
				"-"+String.valueOf(day_outAddStu);
		
		Label label_addOutdate = new Label(com_addStu, SWT.NONE);
		label_addOutdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_addOutdate.setText("离开时间：");
		label_addOutdate.setBounds(391, 126, 61, 17);
		
		Label label_addClass = new Label(com_addStu, SWT.NONE);
		label_addClass.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_addClass.setText("班级信息：");
		label_addClass.setBounds(391, 183, 61, 17);
		
		Label label_addStatus = new Label(com_addStu, SWT.NONE);
		label_addStatus.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_addStatus.setText("注册状态：");
		label_addStatus.setBounds(391, 236, 61, 17);
		
		Combo combo_addstatus = new Combo(com_addStu, SWT.NONE|SWT.READ_ONLY);
		combo_addstatus.setItems(new String []{"请选择","在读","毕业"});
		combo_addstatus.select(0);
		combo_addstatus.setBounds(458, 233, 95, 25);
		
		Label label_addDornum = new Label(com_addStu, SWT.NONE);
		label_addDornum.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_addDornum.setText("宿舍编号：");
		label_addDornum.setBounds(391, 282, 61, 17);
		
		Combo combo_addBuilding = new Combo(com_addStu, SWT.NONE|SWT.READ_ONLY);
		combo_addBuilding.setItems(new String[]{"楼栋"});
		combo_addBuilding.select(0);
		combo_addBuilding.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				try {
					combo_addBuilding.removeAll();
					combo_addBuilding.setItems(new String[]{"楼栋"});
					List<Map<String,Object>> list = dorDao.findAllDorbuilding();
					if(list!=null&&list.size()>0){
						for(int i=0;i<list.size();i++){
							combo_addBuilding.add(list.get(i).get("DOR_BUILDING").toString());
						}
					}else{
						SwtUtil.showMessageBox(shell, "温馨提示", "无楼栋信息！");
					}
					combo_addBuilding.select(0);
				} catch (SQLException e) {
					SwtUtil.showMessageBox(shell, "温馨提示", e.getMessage());
				}
			}
		});
		combo_addBuilding.setBounds(458, 279, 48, 23);
		
		Combo combo_addFloor = new Combo(com_addStu, SWT.NONE|SWT.READ_ONLY);
		combo_addFloor.setItems(new String[]{"楼层"});
		combo_addFloor.select(0);
		combo_addFloor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(combo_addBuilding.getText().trim()!="楼栋"){
					String dor_building = combo_addBuilding.getText();
					try {
						combo_addFloor.removeAll();
						combo_addFloor.setItems(new String[]{"楼层"});
						List<Map<String,Object>> list = dorDao.findAllDorfloorByDorbuilding(dor_building);
						if(list!=null&&list.size()>0){
							for(int i=0;i<list.size();i++){
								combo_addFloor.add(list.get(i).get("DOR_FLOOR").toString());;
							}
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无楼层信息！");
						}
						combo_addFloor.select(0);
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}
			}
		});
		combo_addFloor.setBounds(512, 279, 48, 25);
		
		Combo combo_addDornum = new Combo(com_addStu, SWT.NONE|SWT.READ_ONLY);
		combo_addDornum.setItems(new String[]{"宿舍编号"});
		combo_addDornum.select(0);
		combo_addDornum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if("楼层".equals(combo_addFloor.getText())){
					SwtUtil.showMessageBox(shell, "温馨提示", "请选择楼层！");
				}else{
					String dor_building = combo_addBuilding.getText();
					int dor_floor = Integer.valueOf(combo_addFloor.getText());
					try {
						combo_addDornum.removeAll();
						combo_addDornum.setItems(new String[]{"宿舍编号"});
						List<Map<String,Object>> list = dorDao.findDornumByDor_buildingDor_floor(dor_building, dor_floor);
						if(list!=null&&list.size()>0){
							for(int i=0;i<list.size();i++){
								combo_addDornum.add(list.get(i).get("DOR_DORNUM").toString());;
							}
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无宿舍信息！");
						}
						combo_addDornum.select(0);
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}
			}
		});
		combo_addDornum.setBounds(566, 279, 77, 25);
		
		Label label_addAdress = new Label(com_addStu, SWT.NONE);
		label_addAdress.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_addAdress.setText("  住  址：");
		label_addAdress.setBounds(129, 335, 52, 17);
		
		text_address = new Text(com_addStu, SWT.BORDER);
		text_address.setBounds(187, 332, 245, 23);
		
		text_class = new Text(com_addStu, SWT.BORDER);
		text_class.setBounds(458, 180, 95, 23);
		
		Button btnNewButton_add = new Button(com_addStu, SWT.NONE);
		btnNewButton_add.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(text_id.getText().trim()!=""&&text_name.getText().trim()!=""&&
						text_age.getText().trim()!=""&&text_address.getText().trim()!=""&&text_class.getText().trim()!=""
						&&text_dept.getText().trim()!=""&&combo_addDornum.getText()!="宿舍编号"&&
						combo_addstatus.getText()!="注册状态"&&(button_nan.getSelection()||button_nv.getSelection())){
					String dor_dornum = combo_addDornum.getText().trim();
					try {
						Map<String,Object> map_amount = studentDao.countAmountStudentByDornum(dor_dornum);
						Map<String,Object> map_lived = studentDao.countLivedStudentByDornum(dor_dornum);
						int lived = Integer.valueOf(map_lived.get("DOR_LIVED").toString());
						int amount = Integer.valueOf(map_amount.get("DOR_AMOUNT").toString());
						if(amount-lived>0){
							String stu_sex="";
							if(button_nan.getSelection()){
								stu_sex="男";
								int Stu_id = Integer.valueOf(text_id.getText().trim());
								String stu_name = text_name.getText().trim();
								int stu_age = Integer.valueOf(text_age.getText().trim());
								String stu_dept = text_dept.getText().trim();
								String stu_indate = indate_addStu;
								String stu_outdate = outdate_addStu;
								String stu_class = text_class.getText().trim();
								String stu_address = text_address.getText().trim();
								String stu_status = combo_addstatus.getText();
								boolean flag = studentDao.addSingleStudent(Stu_id, stu_name, stu_sex, stu_age, stu_dept, dor_dornum, 
										stu_indate, stu_outdate, stu_class, stu_address, stu_status, dor_dornum);
								if(flag){
									SwtUtil.showMessageBox(shell, "温馨提示", "添加成功！");
								}else{
									SwtUtil.showMessageBox(shell, "温馨提示", "添加失败！");
								}
							}else{
								stu_sex="女";
								int Stu_id = Integer.valueOf(text_id.getText().trim());
								String stu_name = text_name.getText().trim();
								int stu_age = Integer.valueOf(text_age.getText().trim());
								String stu_dept = text_dept.getText().trim();
								String stu_indate = indate_addStu;
								String stu_outdate = outdate_addStu;
								String stu_class = text_class.getText().trim();
								String stu_address = text_address.getText().trim();
								String stu_status = combo_addstatus.getText();
								boolean flag = studentDao.addSingleStudent(Stu_id, stu_name, stu_sex, stu_age, stu_dept, dor_dornum, 
										stu_indate, stu_outdate, stu_class, stu_address, stu_status, dor_dornum);
								if(flag){
									SwtUtil.showMessageBox(shell, "温馨提示", "添加成功！");
								}else{
									SwtUtil.showMessageBox(shell, "温馨提示", "添加失败！");
								}
							}
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "该宿舍已住满！");
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}else{
					SwtUtil.showMessageBox(shell, "温馨提示", "请输入正确的信息！");
				}
			}
		});
		btnNewButton_add.setBounds(320, 377, 80, 27);
		btnNewButton_add.setText("添加");
		
		//删除学生信息
		Label label_deleteInfo = new Label(com_deleteStu, SWT.NONE);
		label_deleteInfo.setText("学 生 信 息 删 除 版 块");
		label_deleteInfo.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_deleteInfo.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_deleteInfo.setBounds(290, 33, 166, 23);
		
		Label lblNewLabel_deleteDept = new Label(com_deleteStu, SWT.NONE);
		lblNewLabel_deleteDept.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_deleteDept.setBounds(25, 126, 36, 17);
		lblNewLabel_deleteDept.setText("学院：");
		
		Combo combo_deleteDept = new Combo(com_deleteStu, SWT.NONE|SWT.READ_ONLY);
		combo_deleteDept.setItems(new String[]{"请选择"});
		combo_deleteDept.select(0);
		combo_deleteDept.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				try{
					combo_deleteDept.removeAll();
					combo_deleteDept.setItems(new String []{"请选择"});
					List<Map<String,Object>> list = dorDao.findAllDept();
					if(list.size()>0&&list!=null){
						for(int i=0;i<list.size();i++){
							combo_deleteDept.add(list.get(i).get("STU_DEPT").toString());
						}
					}else{
						SwtUtil.showMessageBox(shell, "温馨提示", "无此信息！");
					}
					combo_deleteDept.select(0);
				} catch (SQLException e1) {
					SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
				}
			}
		});
		combo_deleteDept.setBounds(64, 123, 88, 25);
		
		Label lblNewLabel_deleteClass = new Label(com_deleteStu, SWT.NONE);
		lblNewLabel_deleteClass.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_deleteClass.setBounds(25, 188, 36, 17);
		lblNewLabel_deleteClass.setText("班级：");
		
		Combo combo_deleteClass = new Combo(com_deleteStu, SWT.NONE|SWT.READ_ONLY);
		combo_deleteClass.setItems(new String[]{"请选择"});
		combo_deleteClass.select(0);
		combo_deleteClass.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e){ 
				if(combo_deleteDept.getText()=="请选择"){
					SwtUtil.showMessageBox(shell, "温馨提示", "请选择学院！");
				}else{
					String stu_dept = combo_deleteDept.getText();
					try {
						combo_deleteClass.removeAll();
						combo_deleteClass.setItems(new String[]{"请选择"});
						List<Map<String,Object>> list = studentDao.findAllClasssByStu_dept(stu_dept);
						if(list!=null&&list.size()>0){
							for(int i=0;i<list.size();i++){
								combo_deleteClass.add(list.get(i).get("STU_CLASS").toString());
							}
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无班级信息！");
						}
						combo_deleteClass.select(0);
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}
			}
		});
		combo_deleteClass.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String stu_class = combo_deleteClass.getText();
				try {
					table_3.removeAll();
					List<Map<String,Object>> list = studentDao.findStudentByStu_class(stu_class);
					for(int i=0;i<list.size();i++){
						TableItem tableItem = new TableItem(table_3,SWT.NONE);
						tableItem.setText(new String [] {
								list.get(i).get("STU_ID").toString(),list.get(i).get("STU_NAME").toString(),
								list.get(i).get("STU_SEX").toString(),list.get(i).get("STU_AGE").toString(),
								list.get(i).get("STU_DEPT").toString(),list.get(i).get("STU_DORNUM").toString(),
								list.get(i).get("STU_INDATE").toString(),list.get(i).get("STU_OUTDATE").toString(),
								list.get(i).get("STU_CLASS").toString(),list.get(i).get("STU_ADDRESS").toString(),
								list.get(i).get("STU_STATUS").toString()
						});
					}
				} catch (SQLException e1) {
					SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
				}
			}
		});
		combo_deleteClass.setBounds(64, 185, 88, 25);
		
		Label lblNewLabel_deleteId = new Label(com_deleteStu, SWT.NONE);
		lblNewLabel_deleteId.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_deleteId.setBounds(25, 248, 36, 17);
		lblNewLabel_deleteId.setText("学号：");
		
		Label lblNewLabel_19 = new Label(com_deleteStu, SWT.NONE);
		lblNewLabel_19.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_19.setBounds(64, 274, 88, 17);
		
		text_deleteId = new Text(com_deleteStu, SWT.BORDER);
		text_deleteId.setBounds(64, 245, 88, 23);
		
		table_3 = new Table(com_deleteStu, SWT.BORDER | SWT.FULL_SELECTION);
		table_3.setBounds(158, 77, 594, 318);
		table_3.setHeaderVisible(true);
		table_3.setLinesVisible(true);
		
		TableColumn tblclmn_id_deleteStu = new TableColumn(table_3, SWT.NONE);
		tblclmn_id_deleteStu.setWidth(50);
		tblclmn_id_deleteStu.setText("  学号");
		
		TableColumn tblclmn_name_deleteStu = new TableColumn(table_3, SWT.NONE);
		tblclmn_name_deleteStu.setWidth(50);
		tblclmn_name_deleteStu.setText("  姓名");
		
		TableColumn tblclmn_sex_deleteStu = new TableColumn(table_3, SWT.NONE);
		tblclmn_sex_deleteStu.setText("性别");
		tblclmn_sex_deleteStu.setWidth(40);
		
		TableColumn tblclmn_age_deleteStu = new TableColumn(table_3, SWT.NONE);
		tblclmn_age_deleteStu.setText("年龄");
		tblclmn_age_deleteStu.setWidth(40);
		
		TableColumn tblclmn_dept_deleteStu = new TableColumn(table_3, SWT.NONE);
		tblclmn_dept_deleteStu.setText("所在学院");
		tblclmn_dept_deleteStu.setWidth(63);
		
		TableColumn tblclmn_dornum_deleteStu = new TableColumn(table_3, SWT.NONE);
		tblclmn_dornum_deleteStu.setText("宿舍编号");
		tblclmn_dornum_deleteStu.setWidth(65);
		
		TableColumn tblclmn_indate_deleteStu = new TableColumn(table_3, SWT.NONE);
		tblclmn_indate_deleteStu.setText("入住时间");
		tblclmn_indate_deleteStu.setWidth(65);
		
		TableColumn tblclmn_outdate_deleteStu = new TableColumn(table_3, SWT.NONE);
		tblclmn_outdate_deleteStu.setText("离开时间");
		tblclmn_outdate_deleteStu.setWidth(65);
		
		TableColumn tblclmn_class_deleteStu = new TableColumn(table_3, SWT.NONE);
		tblclmn_class_deleteStu.setText("班级");
		tblclmn_class_deleteStu.setWidth(60);
		
		TableColumn tblclmn_address_deleteStu = new TableColumn(table_3, SWT.NONE);
		tblclmn_address_deleteStu.setText("        家庭住址");
		tblclmn_address_deleteStu.setWidth(100);
		
		TableColumn tblclmn_status_deleteStu = new TableColumn(table_3, SWT.NONE);
		tblclmn_status_deleteStu.setText("状态");
		tblclmn_status_deleteStu.setWidth(50);
		
		Button btnNewButton_delete = new Button(com_deleteStu, SWT.NONE);
		btnNewButton_delete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(text_deleteId.getText()==""){
					boolean flag = MessageDialog.openConfirm(shell, "温馨提示", "学号为空，是否选择删除该班级？");
					if(flag){
						String stu_class = combo_deleteClass.getText();
						try {
							boolean flag_delete = studentDao.deleteStudentByClass(stu_class);
							if(flag_delete){
								SwtUtil.showMessageBox(shell, "温馨提示", "删除成功！");
							}else{
								SwtUtil.showMessageBox(shell, "温馨提示", "删除失败！");
							}
						} catch (SQLException e1) {
							SwtUtil.showMessageBox(shell, "温馨提示", "删除失败！");
						}
					}else{
						lblNewLabel_19.setText("请输入学号！");
					}
				}else{
					if(text_deleteId.getText().matches("^[0-9]{4,15}$")){
						int stu_id = Integer.parseInt(text_deleteId.getText());
						try {
							boolean flag = studentDao.deleteStudentByStu_id(stu_id);
							if(flag){
								SwtUtil.showMessageBox(shell, "温馨提示", "删除成功！");
							}else{
								SwtUtil.showMessageBox(shell, "温馨提示", "删除失败！");
							}
						} catch (SQLException e1) {
							SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
						}
					}else{
						SwtUtil.showMessageBox(shell, "温馨提示", "学号格式错误！");
					}
				}
				combo_deleteDept.select(0);
				combo_deleteClass.select(0);
				text_deleteId.setText("");
			}
		});
		btnNewButton_delete.setBounds(64, 318, 80, 27);
		btnNewButton_delete.setText("删除");
		
		//修改学生信息
		Label lblNewLabel_yorn = new Label(com_updateStu, SWT.NONE);
		lblNewLabel_yorn.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_yorn.setBounds(73, 254, 84, 17);
		lblNewLabel_yorn.setText("是否修改宿舍：");
		
		Label lblNewLabel_upId = new Label(com_updateStu, SWT.NONE);
		lblNewLabel_upId.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_upId.setBounds(295, 97, 61, 17);
		lblNewLabel_upId.setText("学号：");
		
		text_21 = new Text(com_updateStu, SWT.BORDER);
		text_21.setBounds(362, 94, 73, 23);
		
		Label lblNewLabel_upName = new Label(com_updateStu, SWT.NONE);
		lblNewLabel_upName.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_upName.setBounds(295, 140, 61, 17);
		lblNewLabel_upName.setText("姓名：");
		
		text_22 = new Text(com_updateStu, SWT.BORDER);
		text_22.setBounds(362, 137, 73, 23);
		
		Label lblNewLabel_upSex = new Label(com_updateStu, SWT.NONE);
		lblNewLabel_upSex.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_upSex.setBounds(295, 183, 61, 17);
		lblNewLabel_upSex.setText("性别：");
		
		text_23 = new Text(com_updateStu, SWT.BORDER);
		text_23.setBounds(362, 180, 73, 23);
		
		Label lblNewLabel_upAge = new Label(com_updateStu, SWT.NONE);
		lblNewLabel_upAge.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_upAge.setBounds(295, 233, 61, 17);
		lblNewLabel_upAge.setText("年龄：");
		
		text_24 = new Text(com_updateStu, SWT.BORDER);
		text_24.setBounds(362, 230, 73, 23);
		
		Label lblNewLabel_upDept = new Label(com_updateStu, SWT.NONE);
		lblNewLabel_upDept.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_upDept.setBounds(295, 280, 61, 17);
		lblNewLabel_upDept.setText("学院：");
		
		text_25 = new Text(com_updateStu, SWT.BORDER);
		text_25.setBounds(362, 277, 73, 23);
		
		Label lblNewLabel_upIndate = new Label(com_updateStu, SWT.NONE);
		lblNewLabel_upIndate.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_upIndate.setBounds(502, 97, 61, 17);
		lblNewLabel_upIndate.setText("入住时间：");
		
		text_27 = new Text(com_updateStu, SWT.BORDER);
		text_27.setBounds(569, 94, 73, 23);
		
		Label label_upOutdate = new Label(com_updateStu, SWT.NONE);
		label_upOutdate.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_upOutdate.setText("离开时间：");
		label_upOutdate.setBounds(502, 140, 61, 17);
		
		text_28 = new Text(com_updateStu, SWT.BORDER);
		text_28.setBounds(569, 137, 73, 23);
		
		Label label_upClass = new Label(com_updateStu, SWT.NONE);
		label_upClass.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_upClass.setText("班级信息：");
		label_upClass.setBounds(502, 183, 61, 17);
		
		text_29 = new Text(com_updateStu, SWT.BORDER);
		text_29.setBounds(569, 180, 73, 23);
		
		Label label_upDornum = new Label(com_updateStu, SWT.NONE);
		label_upDornum.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_upDornum.setText("宿舍编号：");
		label_upDornum.setBounds(502, 233, 61, 17);
		
		text_26 = new Text(com_updateStu, SWT.BORDER);
		text_26.setBounds(569, 230, 73, 23);
		
		Label lblNewLabel_upStatus = new Label(com_updateStu, SWT.NONE);
		lblNewLabel_upStatus.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_upStatus.setBounds(502, 280, 61, 17);
		lblNewLabel_upStatus.setText("注册状态：");
		
		text_31 = new Text(com_updateStu, SWT.BORDER);
		text_31.setBounds(569, 277, 73, 23);
		
		Label lblNewLabel_upAddress = new Label(com_updateStu, SWT.NONE);
		lblNewLabel_upAddress.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_upAddress.setBounds(282, 335, 61, 17);
		lblNewLabel_upAddress.setText("家庭住址：");
		
		text_30 = new Text(com_updateStu, SWT.BORDER);
		text_30.setBounds(362, 332, 202, 23);
		
		Label lblNewLabel_updateDept = new Label(com_updateStu, SWT.NONE);
		lblNewLabel_updateDept.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_updateDept.setBounds(76, 115, 61, 17);
		lblNewLabel_updateDept.setText("所在学院：");
		
		Combo combo_updateDept = new Combo(com_updateStu, SWT.NONE|SWT.READ_ONLY);
		combo_updateDept.setItems(new String []{"请选择"});
		combo_updateDept.select(0);
		combo_updateDept.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				try{
					combo_updateDept.removeAll();
					combo_updateDept.setItems(new String []{"请选择"});
					List<Map<String,Object>> list = dorDao.findAllDept();
					if(list.size()>0&&list!=null){
						for(int i=0;i<list.size();i++){
							combo_updateDept.add(list.get(i).get("STU_DEPT").toString());
						}
					}else{
						SwtUtil.showMessageBox(shell, "温馨提示", "无此信息！");
					}
					combo_updateDept.select(0);
				} catch (SQLException e1) {
					SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
				}
			}
		});
		combo_updateDept.setBounds(143, 112, 88, 25);
		
		Label lblNewLabel_updateClass = new Label(com_updateStu, SWT.NONE);
		lblNewLabel_updateClass.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_updateClass.setBounds(76, 158, 61, 17);
		lblNewLabel_updateClass.setText("所在班级：");
		
		Combo combo_updateClass = new Combo(com_updateStu, SWT.NONE|SWT.READ_ONLY);
		combo_updateClass.setItems(new String[]{"请选择"});
		combo_updateClass.select(0);
		combo_updateClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(combo_updateDept.getText()=="请选择"){
					SwtUtil.showMessageBox(shell, "温馨提示", "请选择学院！");
				}else{
					String stu_dept = combo_updateDept.getText();
					try {
						combo_updateClass.removeAll();
						combo_updateClass.setItems(new String[]{"请选择"});
						List<Map<String,Object>> list = studentDao.findAllClasssByStu_dept(stu_dept);
						if(list!=null&&list.size()>0){
							for(int i=0;i<list.size();i++){
								combo_updateClass.add(list.get(i).get("STU_CLASS").toString());
							}
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无班级信息！");
						}
						combo_updateClass.select(0);
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}
			}
		});
		combo_updateClass.setBounds(143, 155, 88, 25);
		
		Label lblNewLabel_updateId = new Label(com_updateStu, SWT.NONE);
		lblNewLabel_updateId.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_updateId.setBounds(76, 205, 61, 17);
		lblNewLabel_updateId.setText("选择学号：");
		
		Combo combo_updateId = new Combo(com_updateStu, SWT.NONE|SWT.READ_ONLY);
		combo_updateId.setItems(new String []{"请选择"});
		combo_updateId.select(0);
		combo_updateId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				text_21.setEditable(true);
				text_22.setEditable(true);
				text_23.setEditable(true);
				text_24.setEditable(true);
				text_26.setEditable(true);
				text_25.setEditable(true);
				text_27.setEditable(true);
				text_28.setEditable(true);
				text_29.setEditable(true);
				text_30.setEditable(true);
				text_31.setEditable(true);
				text_21.setText("");
				text_22.setText("");
				text_23.setText("");
				text_24.setText("");
				text_25.setText("");
				text_26.setText("");
				text_27.setText("");
				text_28.setText("");
				text_29.setText("");
				text_30.setText("");
				text_31.setText("");
				if(combo_updateClass.getText()=="请选择"){
					SwtUtil.showMessageBox(shell, "温馨提示", "请选择班级！");
				}else{
					String stu_class= combo_updateClass.getText();
					try {
						combo_updateId.removeAll();
						combo_updateId.setItems(new String []{"请选择"});
						List<Map<String,Object>> list = studentDao.findStu_idByStu_class(stu_class);
						if(list!=null&&list.size()>0){
							for(int i=0;i<list.size();i++){
								combo_updateId.add(list.get(i).get("STU_ID").toString());
							}
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "无学号信息！");
						}
						combo_updateId.select(0);
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}
			}
		});
		combo_updateId.setBounds(143, 202, 88, 25);
		
		Button button_yes = new Button(com_updateStu, SWT.RADIO);
		button_yes.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(combo_updateId.getText().matches("^[0-9]{4,15}$")){
					int Stu_id = Integer.valueOf(combo_updateId.getText());
					
					text_21.setEditable(false);
					text_22.setEditable(false);
					text_23.setEditable(false);
					text_24.setEditable(false);
					text_25.setEditable(false);
					text_27.setEditable(false);
					text_28.setEditable(false);
					text_29.setEditable(false);
					text_30.setEditable(false);
					text_31.setEditable(false);
					try {
						Map<String,Object> map = studentDao.findStudentByStu_id(Stu_id);
						text_21.setText(map.get("STU_ID").toString());
						text_22.setText(map.get("STU_NAME").toString());
						text_23.setText(map.get("STU_SEX").toString());
						text_24.setText(map.get("STU_AGE").toString());
						text_25.setText(map.get("STU_DEPT").toString());
						text_26.setText(map.get("STU_DORNUM").toString());
						text_27.setText(map.get("STU_INDATE").toString());
						text_28.setText(map.get("STU_OUTDATE").toString());
						text_29.setText(map.get("STU_CLASS").toString());
						text_30.setText(map.get("STU_ADDRESS").toString());
						text_31.setText(map.get("STU_STATUS").toString());
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}else{
					SwtUtil.showMessageBox(shell, "温馨提示", "学号输入错误！");
				}
			}
		});
		button_yes.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		button_yes.setBounds(159, 254, 33, 17);
		button_yes.setText("是");
		
		Button button_no = new Button(com_updateStu, SWT.RADIO);
		button_no.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(combo_updateId.getText().matches("^[0-9]{4,15}$")){
					int Stu_id = Integer.valueOf(combo_updateId.getText());
					text_26.setEditable(false);
					try {
						Map<String,Object> map = studentDao.findStudentByStu_id(Stu_id);
						text_21.setText(map.get("STU_ID").toString());
						text_22.setText(map.get("STU_NAME").toString());
						text_23.setText(map.get("STU_SEX").toString());
						text_24.setText(map.get("STU_AGE").toString());
						text_25.setText(map.get("STU_DEPT").toString());
						text_26.setText(map.get("STU_DORNUM").toString());
						text_27.setText(map.get("STU_INDATE").toString());
						text_28.setText(map.get("STU_OUTDATE").toString());
						text_29.setText(map.get("STU_CLASS").toString());
						text_30.setText(map.get("STU_ADDRESS").toString());
						text_31.setText(map.get("STU_STATUS").toString());
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}else{
					SwtUtil.showMessageBox(shell, "温馨提示", "学号输入错误！");
				}
			}
		});
		button_no.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		button_no.setBounds(198, 254, 33, 17);
		button_no.setText("否");
		
		Button btnNewButton_update = new Button(com_updateStu, SWT.NONE);
		btnNewButton_update.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(button_no.getSelection()){
					int stu_id1 = Integer.valueOf(text_21.getText().trim());
					String stu_name = text_22.getText().trim();
					String stu_sex = text_23.getText().trim();
					int stu_age =Integer.valueOf(text_24.getText().trim());
					String stu_dept = text_25.getText().trim();
					String stu_indate = text_27.getText().trim();
					String stu_outdate = text_28.getText().trim();
					String stu_class = text_29.getText().trim();
					String stu_address =text_30.getText().trim();
					String stu_status = text_31.getText().trim();
					int stu_id2 = Integer.valueOf(combo_updateId.getText().trim());
					try {
						boolean flag = studentDao.updateStudentByStu_dornum(stu_id1, stu_name, stu_sex, stu_age, 
								stu_dept, stu_indate, stu_outdate, stu_class, stu_address, stu_status,
								stu_id2);
						if(flag){
							SwtUtil.showMessageBox(shell, "温馨提示", "修改成功！");
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "修改失败！");
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}else if(button_yes.getSelection()){
					int stu_id = Integer.valueOf(text_21.getText().trim());
					String stu_dornum = text_26.getText().trim();
					try {
						boolean flag = studentDao.updateStudentByStu_dornum(stu_id, stu_dornum);
						if(flag){
							SwtUtil.showMessageBox(shell, "温馨提示", "修改成功！");
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "修改失败！");
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", e1.getMessage());
					}
				}
			}
		});
		btnNewButton_update.setBounds(333, 378, 80, 27);
		btnNewButton_update.setText("修改");
		
		//一般用户修改
		Label lbl_updateUserId = new Label(com_updateUser, SWT.NONE);
		lbl_updateUserId.setBounds(95, 154, 36, 17);
		lbl_updateUserId.setText("账号：");
		
		text_updateUserId = new Text(com_updateUser, SWT.BORDER);
		text_updateUserId.setBounds(137, 151, 73, 23);
		
		text_updateUserPwd = new Text(com_updateUser, SWT.BORDER);
		text_updateUserPwd.setBounds(328, 151, 73, 23);
		
		Label lb_updateUserPwd = new Label(com_updateUser, SWT.NONE);
		lb_updateUserPwd.setBounds(286, 154, 36, 17);
		lb_updateUserPwd.setText("密码：");
		
		Label lbl_updateUserName = new Label(com_updateUser, SWT.NONE);
		lbl_updateUserName.setBounds(481, 154, 36, 17);
		lbl_updateUserName.setText("姓名：");
		
		text_updateUserName = new Text(com_updateUser, SWT.BORDER);
		text_updateUserName.setBounds(523, 151, 73, 23);
		
		Label lbl_updateUserTel = new Label(com_updateUser, SWT.NONE);
		lbl_updateUserTel.setBounds(373, 256, 61, 17);
		lbl_updateUserTel.setText("手机号码：");
		
		text_updateUserTel = new Text(com_updateUser, SWT.BORDER);
		text_updateUserTel.setBounds(440, 253, 156, 23);
		
		Label lbl_updateUserAge = new Label(com_updateUser, SWT.NONE);
		lbl_updateUserAge.setBounds(95, 212, 36, 17);
		lbl_updateUserAge.setText("年龄：");
		
		text_updateUserAge = new Text(com_updateUser, SWT.BORDER);
		text_updateUserAge.setBounds(137, 209, 73, 23);
		
		Label lbl_updateUserSex = new Label(com_updateUser, SWT.NONE);
		lbl_updateUserSex.setBounds(286, 212, 36, 17);
		lbl_updateUserSex.setText("性别：");
		
		text_updateUserSex = new Text(com_updateUser, SWT.BORDER);
		text_updateUserSex.setBounds(328, 209, 73, 23);
		
		Label lbl_updateUserCard = new Label(com_updateUser, SWT.NONE);
		lbl_updateUserCard.setBounds(95, 256, 61, 17);
		lbl_updateUserCard.setText("身份证号：");
		
		text_updateUserSid = new Text(com_updateUser, SWT.BORDER);
		text_updateUserSid.setBounds(162, 253, 162, 23);
		
		Label lbl_updateUserRemark = new Label(com_updateUser, SWT.NONE);
		lbl_updateUserRemark.setBounds(481, 212, 36, 17);
		lbl_updateUserRemark.setText("备注：");
		
		text_updateUserRemark = new Text(com_updateUser, SWT.BORDER);
		text_updateUserRemark.setBounds(524, 209, 73, 23);
		
		Button button_updateUser = new Button(com_updateUser, SWT.NONE);
		button_updateUser.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(text_updateUserName.getText().trim()!=""&&text_updateUserPwd.getText().trim()!=""&&
						text_updateUserTel.getText().trim()!=""&&text_updateUserAge.getText().trim()!=""&&
						text_updateUserSex.getText().trim()!=""&&text_updateUserSid.getText().trim()!=""&&
						text_updateUserRemark.getText().trim()!=""){
					String user_name =text_updateUserName.getText().trim();
					String user_pwd = text_updateUserPwd.getText().trim();
					String user_tel = text_updateUserTel.getText().trim();
					int user_age = Integer.parseInt(text_updateUserAge.getText().trim());
					String user_sex = text_updateUserSex.getText().trim();
					String user_sid = text_updateUserSid.getText().trim();
					String user_remark = text_updateUserRemark.getText().trim();
					int user_id=Integer.valueOf(text_updateUserId.getText().trim());
					try {
						boolean flag = MAD.updateUsername(user_name, user_tel, user_age, user_sex, user_sid, 
								user_pwd, user_remark, user_id);
						if(flag){
							SwtUtil.showMessageBox(shell, "温馨提示", "修改成功！");
						}else{
							SwtUtil.showMessageBox(shell, "温馨提示", "修改失败！");
						}
					} catch (SQLException e1) {
						SwtUtil.showMessageBox(shell, "温馨提示", "修改失败！");
					}
				}else{
					SwtUtil.showMessageBox(shell, "温馨提示", "请输入正确的信息！");
				}
				text_updateUserPwd.setText("");
				text_updateUserName.setText("");
				text_updateUserTel.setText("");
				text_updateUserAge.setText("");
				text_updateUserSex.setText("");
				text_updateUserSid.setText("");
				text_updateUserRemark.setText("");
				text_updateUserId.setText("");
			}
		});
		button_updateUser.setText("修改信息");
		button_updateUser.setBounds(399, 341, 80, 27);
		
		Button btn_updateUserLoad = new Button(com_updateUser, SWT.NONE);
		btn_updateUserLoad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Map<String,Object> map = AdminUtil.adminObj;  
				text_updateUserPwd.setText(map.get("USER_PWD").toString());
				text_updateUserName.setText(map.get("USER_NAME").toString());
				text_updateUserTel.setText(map.get("USER_TEL").toString());
				text_updateUserAge.setText(map.get("USER_AGE").toString());
				text_updateUserSex.setText(map.get("USER_SEX").toString());
				text_updateUserSid.setText(map.get("USER_SID").toString());
				text_updateUserRemark.setText(map.get("USER_REMARK").toString());
				text_updateUserId.setText(map.get("USER_ID").toString());
				text_updateUserId.setEditable(false);
			}
		});
		btn_updateUserLoad.setBounds(220, 341, 80, 27);
		btn_updateUserLoad.setText("加载信息");
				
		Map<String,Object> map = AdminUtil.adminObj;
		if(null==map){
			shell.dispose();
			login login = new login();
			login.open();
		}else{
			lbl_role.setText(map.get("USER_ROLE")+"--"+map.get("USER_NAME"));
			lbl_role2.setText(map.get("USER_ROLE")+"--"+map.get("USER_NAME"));
			lbl_role3.setText(map.get("USER_ROLE")+"--"+map.get("USER_NAME"));
		}
	}

}
