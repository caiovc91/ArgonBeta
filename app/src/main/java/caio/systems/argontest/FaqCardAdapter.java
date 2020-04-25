package caio.systems.argontest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FaqCardAdapter extends RecyclerView.Adapter<FaqCardAdapter.RecyclerViewHolder>   {
    private LayoutInflater mInflater;
    private Animation up, down;
    private Context context;
    private final int COUNTDOWN_RUNNING_TIME = 500;

    public FaqCardAdapter(LayoutInflater mInflater, Animation up, Animation down, Context context) {
        this.mInflater = mInflater;
        this.up = up;
        this.down = down;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item;
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private int icon;
        private TextView title;
        private TextView ansLayout;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
