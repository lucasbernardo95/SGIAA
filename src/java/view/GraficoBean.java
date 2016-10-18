
package view;


 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean
public class GraficoBean implements Serializable {
 
    private LineChartModel grafico;
    
    @ManagedProperty(value = "#{bairroBean}")
    private BairroBean bbean;
   
     
    @PostConstruct
    public void init() {
        createLineModels();
    }
 
    public LineChartModel getGrafico() {
        return grafico;
    }
 
   
    private void createLineModels() {
        grafico = initLinearModel();
        grafico.setTitle("Grafico");
        grafico.setLegendPosition("e");
        Axis yAxis = grafico.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);       
       
        yAxis.setLabel("Births");
      
    }
     
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
 
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
 
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }
     
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        bbean.buscar();
        boys.set(bbean.getLista(), 1);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 90);
        girls.set("2008", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }

    public BairroBean getBbean() {
        return bbean;
    }

    public void setBbean(BairroBean bbean) {
        this.bbean = bbean;
    }
 
}