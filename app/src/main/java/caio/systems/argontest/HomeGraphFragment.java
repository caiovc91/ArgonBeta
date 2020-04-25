package caio.systems.argontest;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.matthewtamlin.sliding_intro_screen_library.indicators.DotIndicator;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Total acumulado até o período
 * Valor virá do servidor
 * Eixo X contando os meses
 */
public class HomeGraphFragment extends Fragment {
    private LineChart chart;

    public HomeGraphFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_graph, container, false);
        chart = v.findViewById(R.id.homeChart);
        gen_charts();
        return v;
    }

    public static HomeGraphFragment newInstance(String text) {

        HomeGraphFragment f = new HomeGraphFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    public void gen_charts(){

        chart.setTouchEnabled(false);
        chart.setPinchZoom(false);
        MyChartView mv = new MyChartView(getContext().getApplicationContext(), R.layout.custom_marker_view);
        mv.setChartView(chart);
        chart.setMarker(mv);
        ArrayList<Entry> yVal = new ArrayList<>();

        //clear grid
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        //clear borders
        chart.getXAxis().setDrawAxisLine(true);
        chart.getAxisLeft().setDrawAxisLine(false);
        chart.getAxisRight().setDrawAxisLine(false);
        chart.getAxisLeft().setEnabled(false);
        chart.getAxisRight().setEnabled(false);


        /*
         * TODO: implementar maneiras de reabsorver dados
         *
         */

        yVal.add(new Entry(0, 250.32f));
        yVal.add(new Entry(1, 375.65f));
        yVal.add(new Entry(2, 1375.57f));
        yVal.add(new Entry(3, 2394.87f));
        yVal.add(new Entry(4, 3219.47f));
        yVal.add(new Entry(5, 4219.43f));
        yVal.add(new Entry(6, 5230.20f));
        yVal.add(new Entry(7, 6198.22f));
        yVal.add(new Entry(8, 7192));
        yVal.add(new Entry(9, 8140));
        yVal.add(new Entry(10, 9410.32f));
        yVal.add(new Entry(11, 10130.32f));

        LineDataSet setOne = new LineDataSet(yVal, "Economia"); //legenda e criacao da linha
        setOne.setFillAlpha(200);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(setOne);
        LineData data = new LineData(dataSets);

        chart.setData(data);
    }


}
