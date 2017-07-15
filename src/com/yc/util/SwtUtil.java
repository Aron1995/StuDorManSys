package com.yc.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class SwtUtil {
	public static void showMessageBox(Shell shell,String title,String message){
		MessageBox mg = new MessageBox(shell,SWT.NONE);
		mg.setText(title);
		mg.setMessage(message);
		mg.open();
	}
	
	//屏幕居中
	public static void centerShell(Display display,Shell shell){
		Rectangle displayBounds = display.getPrimaryMonitor().getBounds();
		Rectangle shellBounds = shell.getBounds();
		int x = displayBounds.x + (displayBounds.width - shellBounds.width)>>1;
		int y = displayBounds.y + (displayBounds.height - shellBounds.height)>>1;
		shell.setLocation(x,y);
	}
}
