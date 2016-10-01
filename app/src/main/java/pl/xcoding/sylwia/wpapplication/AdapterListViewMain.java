package pl.xcoding.sylwia.wpapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

public class AdapterListViewMain extends RecyclerView.Adapter<AdapterListViewMain.ViewHolder> {
    private ArrayList<RSSItem> data;
    private Context listContext;

    public AdapterListViewMain(Context context, ArrayList<RSSItem> data) {
        this.listContext = context;
        this.data = data;
    }


    @Override
    public AdapterListViewMain.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_activity, parent, false);
        return new AdapterListViewMain.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterListViewMain.ViewHolder holder, final int position) {
        holder.textView.setText(data.get(position).getTitle());

        holder.listview_image.setImageURI(data.get(position).getImage());

        holder.listview_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setTitle(data.get(position).getTitle());
                dialog.setContentView(R.layout.dialog_layout);
                TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
                text.setText(data.get(position).getDescription());

                Button buttonCancel = (Button) dialog.findViewById(R.id.dialogButtonCancel);

                buttonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                Button buttonReadMore = (Button) dialog.findViewById(R.id.dialogButtonReadMore);

                buttonReadMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {



                        Intent intent = new Intent(v.getContext(), WebActivity.class);
                       intent.putExtra("data", data.get(position).getLink());
                        v.getContext().startActivity(intent);

                    }
                });

                dialog.show();
            }
        });

    }


    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private SimpleDraweeView listview_image;


        public ViewHolder(View v) {
            super(v);

            textView = (TextView) v.findViewById(R.id.listview_item_title);
            listview_image = (SimpleDraweeView) v.findViewById(R.id.listview_image);
        }
    }

}

