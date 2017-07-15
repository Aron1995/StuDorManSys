package com.yc.ui;

import java.sql.SQLException;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.swtchart.Chart;
import org.swtchart.ISeries;
import org.swtchart.ISeries.SeriesType;
import com.yc.dao.DorDao;
import org.eclipse.wb.swt.SWTResourceManager;

public class ChartDept {
	private static DorDao dorDao = new DorDao();

    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
		try {
			ChartDept window = new ChartDept();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open(){
		Display display =Display.getDefault();
        Shell shell = new Shell(display);
        shell.setImage(SWTResourceManager.getImage(ChartDept.class, "/images/Applications.png"));
		createChart(shell);
		shell.open();
		shell.layout();
		shell.setText("学院宿舍信息图表");
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
     * @return The created chart
     */
    public static void createChart(Shell shell){

		try {
			 Map<String, Object> map_jixin = dorDao.countLivedStudentByStu_dept("计信学院");
			double jixin = Double.valueOf(map_jixin.get("COUNT(STU_ID)").toString());
	    	
	    	Map<String,Object> map_angong = dorDao.countLivedStudentByStu_dept("安工学院");
	    	double angong = Double.valueOf(map_angong.get("COUNT(STU_ID)").toString());
	    	
	    	Map<String,Object> map_jixie = dorDao.countLivedStudentByStu_dept("机械学院");
	    	double jixie = Double.valueOf(map_jixie.get("COUNT(STU_ID)").toString());
	    	
	    	Map<String,Object> map_jingguan = dorDao.countLivedStudentByStu_dept("经管学院");
	    	double jingguan = Double.valueOf(map_jingguan.get("COUNT(STU_ID)").toString());
	 
	        double[] ySeries = { jixin, angong, jixie, jingguan};

	        String[] cagetorySeries = { "计信学院", "安工学院",
	                "机械学院", "经管学院"};
	        // create a chart
	        Chart chart = new Chart(shell, SWT.NONE);
	        chart.setBounds(0, 0, 584, 411);
	        chart.getTitle().setText("学院人数图表");

	        // set category
	        chart.getAxisSet().getXAxis(0).enableCategory(true);
	        chart.getAxisSet().getXAxis(0).setCategorySeries(cagetorySeries);
	        chart.getAxisSet().getXAxis(0).getTick().setTickLabelAngle(45);
	        chart.getAxisSet().getXAxis(0).getTitle().setText("院系名称");
	        chart.getAxisSet().getYAxis(0).getTitle().setText("人数");

	        // add bar series
	        ISeries barSeries = chart.getSeriesSet().createSeries(SeriesType.BAR,"人数");
	        barSeries.setYSeries(ySeries);

	        chart.getAxisSet().adjustRange();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}