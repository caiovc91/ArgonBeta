package caio.systems.argontest;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class MenuComponentAdapter extends BaseAdapter {

    private Activity activity;
    private List<MenuComponent> componentList;

    public MenuComponentAdapter(Activity activity, List<MenuComponent> componentList) {
        this.activity = activity;
        this.componentList = componentList;
    }

    @Override
    public int getCount() {
        return componentList.size();
    }

    @Override
    public Object getItem(int i) {
        return componentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = activity.getLayoutInflater().inflate(R.layout.menucell, viewGroup , false);
        MenuComponent mCompponent = componentList.get(i);

        ImageView iconView = view.findViewById(R.id.menuIcon);
        TextView menuText = view.findViewById(R.id.menuItem);

        iconView.setImageResource(mCompponent.getMenuIcon());
        menuText.setText(mCompponent.getMenuItem());


        return view;
    }
}
