package com.yc.ui;

import java.sql.SQLException;
import java.util.Map;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.swtchart.Chart;
import org.swtchart.IBarSeries;
import org.swtchart.ISeries.SeriesType;
import com.yc.dao.DorDao;
import org.eclipse.wb.swt.SWTResourceManager;


public class ChartBuilding {

    private static  DorDao dorDao = new DorDao();

    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
		try {
			ChartBuilding window = new ChartBuilding();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open(){
		Display display =Display.getDefault();
        Shell shell = new Shell(display);
        shell.setImage(SWTResourceManager.getImage(ChartBuilding.class, "/images/Applications.png"));
		createChart(shell);
		shell.open();
		shell.layout();
		shell.setText("楼栋宿舍信息图表");
        shell.setSize(600, 450);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
    
    
    /**
     * create the chart.
     * 
     * @param parent
     *            The parent composite
     */
    public static void createChart(Shell shell) {
		
    	try {
    		//D1宿舍人员信息
			Map<String,Object> mapD1Lived = dorDao.sumLivedNumberByBuilding("D1");
			Map<String,Object> mapD1Amount = dorDao.sumAmountNumberByBuilding("D1");
			
			double D1Lived = Double.valueOf(mapD1Lived.get("SUM(DOR_LIVED)").toString());
			double D1Amount = Double.valueOf(mapD1Amount.get("SUM(DOR_AMOUNT)").toString());
			
			//D2宿舍人员信息
			Map<String,Object> mapD2Lived = dorDao.sumLivedNumberByBuilding("D2");
			Map<String,Object> mapD2Amount = dorDao.sumAmountNumberByBuilding("D2");
			double D2Lived = Double.valueOf(mapD2Lived.get("SUM(DOR_LIVED)").toString());
			double D2Amount = Double.valueOf(mapD2Amount.get("SUM(DOR_AMOUNT)").toString());
			
			//D3宿舍人员信息
			Map<String,Object> mapD3Lived = dorDao.sumLivedNumberByBuilding("D3");
			Map<String,Object> mapD3Amount = dorDao.sumAmountNumberByBuilding("D3");
			double D3Lived = Double.valueOf(mapD3Lived.get("SUM(DOR_LIVED)").toString());
			double D3Amount = Double.valueOf(mapD3Amount.get("SUM(DOR_AMOUNT)").toString());
			
			//D4宿舍人员信息
			Map<String,Object> mapD4Lived = dorDao.sumLivedNumberByBuilding("D4");
			Map<String,Object> mapD4Amount = dorDao.sumAmountNumberByBuilding("D4");
			double D4Lived = Double.valueOf(mapD4Lived.get("SUM(DOR_LIVED)").toString());
			double D4Amount = Double.valueOf(mapD4Amount.get("SUM(DOR_AMOUNT)").toString());
			
			double[] ySeries1 ={D1Lived,D2Lived,D3Lived,D4Lived};
			double[] ySeries2 ={D1Amount,D2Amount,D3Amount,D4Amount};
			
			Chart chart = new Chart(shell, SWT.NONE);
			chart.setBounds(0, 0, 584, 411);

	        //设值标题
	        chart.getTitle().setText("楼栋人员分布表");
	        chart.getAxisSet().getXAxis(0).getTitle().setText("楼栋名称");
	        chart.getAxisSet().getYAxis(0).getTitle().setText("人数");

	        //横轴
	        chart.getAxisSet().getXAxis(0).enableCategory(true);
	        chart.getAxisSet().getXAxis(0).setCategorySeries(new String[] {"D1","D2","D3","D4"});

	        //创建柱状图
	        IBarSeries barSeries1 = (IBarSeries) chart.getSeriesSet().createSeries(
	                SeriesType.BAR, "已住人数");
	        barSeries1.setYSeries(ySeries1);
	        barSeries1.setBarColor(Display.getDefault().getSystemColor(
	                SWT.COLOR_GREEN));

	        IBarSeries barSeries2 = (IBarSeries) chart.getSeriesSet().createSeries(
	                SeriesType.BAR, "可住人数");
	        barSeries2.setYSeries(ySeries2);

	        //适应窗体
	        chart.getAxisSet().adjustRange();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}