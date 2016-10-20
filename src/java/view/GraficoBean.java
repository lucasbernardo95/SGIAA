package view;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import model.Bairro;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.MeterGaugeChartModel;
import util.MessageUtil;

@ManagedBean
@SessionScoped
public class GraficoBean implements Serializable {

    private MeterGaugeChartModel meterGaugeMode;

    @ManagedProperty(value = "#{bairroBean}")
    private BairroBean bbean;

    public void mostraBairroPorRisco(ActionEvent evento) {
        Bairro b = (Bairro) evento.getComponent().getAttributes().get("bairroEscolhido");

        createMeterGaugeModels(b);
    }

    private MeterGaugeChartModel initMeterGaugeModel(Bairro b) {
        List<Number> intervals = new ArrayList<Number>() {
            {//Aqui insere os gruas de risco no caso, será de 1 à 5 até que a rede fique pronta e mude de 1 à 3
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };
        //retorna um novo MeterGaugeChartModel passando o valor onde o ponteiro ficará getBairro_risco e o intervalo criado intervals
        return new MeterGaugeChartModel(b.getBairro_risco(), intervals);
    }

    private void createMeterGaugeModels(Bairro b) {

        meterGaugeMode = initMeterGaugeModel(b);
        meterGaugeMode.setTitle("Grau de risco de " + b.getNome());
        meterGaugeMode.setSeriesColors("FFA07A,FF6347,8B0000,CD0000, FF0000");//depois tem que diminuir para três cores
        meterGaugeMode.setGaugeLabelPosition("bottom");
        meterGaugeMode.setShowTickLabels(false);
        meterGaugeMode.setLabelHeightAdjust(110);
        meterGaugeMode.setIntervalOuterRadius(100);
        
    }

    public MeterGaugeChartModel getMeterGaugeMode() {
        return meterGaugeMode;
    }

    public void setMeterGaugeMode(MeterGaugeChartModel meterGaugeMode) {
        this.meterGaugeMode = meterGaugeMode;
    }

    public BairroBean getBbean() {
        return bbean;
    }

    public void setBbean(BairroBean bbean) {
        this.bbean = bbean;
    }

}
