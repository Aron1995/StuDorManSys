package com.yc.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import com.ibm.icu.text.SimpleDateFormat;


public class DateUtil {
	public static void Date(final Label label,Composite composite,Shell shell){
		Timer timer = new Timer(0, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				label.getDisplay().syncExec(new Runnable() {
	                public void run() {
	                    // 设置时间 ，格式化输出时间
	                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                    String s = sdf.format(new Date());
	                    label.setText(s);//输出到Label上
	                }
	            });
			}
		});
		timer.start();
		if(shell.isDisposed()){
			timer.stop();
		}
	}
}
