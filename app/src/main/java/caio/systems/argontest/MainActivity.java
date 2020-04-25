package caio.systems.argontest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;


/*
 * Ver mais em:
 * NavHostFragment
 * https://developer.android.com/guide/navigation/navigation-getting-started
 * https://code.tutsplus.com/articles/how-to-use-bottom-sheets-with-the-design-support-library--cms-26031
 * https://medium.com/@droidbyme/android-bottom-sheet-7e9cfcec6427
 * https://medium.com/android-bits/android-bottom-sheet-30284293f066
 * https://www.androidhive.info/2017/12/android-working-with-bottom-sheet/
 */

public class MainActivity extends AppCompatActivity {

    private ListView mList;
    private List<MenuComponent> mComponentList;
    private BottomSheetBehavior mBottomSheetBehavior;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private NavController navController;
    private ImageView listicon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View bottomsheet = findViewById(R.id.bottomSheet);
        listicon = findViewById(R.id.sheetIcon);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        mBottomSheetBehavior.setPeekHeight(60);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        setupNavHost();
        setUpMenu();
        //if(savedInstanceState == null) {
        //fm.beginTransaction().replace(R.id.nav_host_fragment, new HomeMainSlider()).commit();
        //navController.getCurrentDestination();
        //}

        navController.navigate(R.id.homeMainSlider);



        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            ImageView listicon = findViewById(R.id.sheetIcon);

            @Override
            public void onStateChanged(@NonNull View view, int i) {
                if (i == BottomSheetBehavior.STATE_COLLAPSED) {
                    listicon.setScaleY(1);
                    //mBottomSheetBehavior.setPeekHeight(30);
                }else{
                    listicon.setScaleY(-1);
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
    }

    private void setupNavHost(){
        navController = Navigation.findNavController(findViewById(R.id.nav_host_fragment));
    }

    private void setUpMenu(){
        ListActivity menuListActivity = new ListActivity();
        MenuComponentAdapter mAdapter;

        mComponentList = new ArrayList<MenuComponent>();
        //menuListActivity.setListAdapter(mAdapter);

        /*menuListActivity.getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });*/

        mComponentList.add(new MenuComponent(R.drawable.ic_menu_info_details, "Minhas Empresas"));
        mComponentList.add(new MenuComponent(R.drawable.ic_menu_info_details, "Faturas"));
        mComponentList.add(new MenuComponent(R.drawable.ic_menu_info_details, "Notificações"));
        mComponentList.add(new MenuComponent(R.drawable.ic_menu_info_details, "Perfil"));
        mComponentList.add(new MenuComponent(R.drawable.ic_menu_info_details, "Contato"));
        mComponentList.add(new MenuComponent(R.drawable.ic_menu_info_details, "FAQ"));
        mComponentList.add(new MenuComponent(R.drawable.ic_menu_info_details, "Sair")); //logout

        final MenuComponentAdapter menuAdapter = new MenuComponentAdapter(this, mComponentList);

        mList = findViewById(R.id.menuList);
        mList.setAdapter(menuAdapter);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Toast.makeText(MainActivity.this, "Posiçao menu: " + mComponentList.get(position).getMenuItem(), Toast.LENGTH_SHORT).show();
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    case 1:
                        Toast.makeText(MainActivity.this, "Posiçao menu: " + mComponentList.get(position).getMenuItem(), Toast.LENGTH_SHORT).show();
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    case 2:
                        Toast.makeText(MainActivity.this, "Posiçao menu: " + mComponentList.get(position).getMenuItem(), Toast.LENGTH_SHORT).show();
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    case 3:
                        if (navController.getCurrentDestination().getId() == R.id.homeMainSlider) {
                                navController.navigate(R.id.action_homeMainSlider_to_profileFragment);
                        }
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    case 4:
                        Toast.makeText(MainActivity.this, "Posiçao menu: " + mComponentList.get(position).getMenuItem(), Toast.LENGTH_SHORT).show();
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    case 5:
                        Toast.makeText(MainActivity.this, "Posiçao menu: " + mComponentList.get(position).getMenuItem(), Toast.LENGTH_SHORT).show();
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    case 6:
                        Toast.makeText(MainActivity.this, "Posiçao menu: " + mComponentList.get(position).getMenuItem(), Toast.LENGTH_SHORT).show();
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }


            }
        });
    }

}
