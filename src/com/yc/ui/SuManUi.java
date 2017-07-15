package com.yc.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
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

public class SuManUi {

	protected Shell shell;
	private StackLayout stackLayout;
	private Table table;
	private Table table2;
	private Text text;
	private Text text_0;
	private Text text_1;
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
	private Text text_mailId;
	private Text text_mailPwd;
	private Text text_content;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SuManUi window = new SuManUi();
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
		
		MenuItem mntm_findDor = new MenuItem(menu_2, SWT.NONE);
		mntm_findDor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				stackLayout.topControl = com_findDor;
				shell.layout();
			}
		});
		mntm_findDor.setText("查询宿舍信息");
		
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
		
		//查找学生信息
		Label lbl_findStu = new Label(com_findDor, SWT.NONE);
		lbl_findStu.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_findStu.setBounds(27, 10, 42, 17);
		lbl_findStu.setText("欢迎：");
		
		Label lbl_role2 = new Label(com_findDor, SWT.NONE);
		lbl_role2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl_role2.setBounds(74, 10, 92, 17);
		
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
		
		//一般用户修改
		Label lbl_updateUser = new Label(com_findDor, SWT.NONE);
		lbl_updateUser.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl_updateUser.setBounds(27, 10, 42, 17);
		lbl_updateUser.setText("欢迎：");
		
		Label lbl_role3 = new Label(com_findDor, SWT.NONE);
		lbl_role3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl_role3.setBounds(74, 10, 92, 17);
		
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
