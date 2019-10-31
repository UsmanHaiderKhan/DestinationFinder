package com.example.destinationfinder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Resturant_View extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Gramercy Tavern", "Blue Hill", "Le Bernardin", "Jean-Georges", "Prostokąt 1 kopia 5", "Ninja New York", "Estiatorio Milos"};
    String mDescription[] = {"42 E 20th St", "75 Washington Pl", "155 W 51st St", "1 Central Park West", "Prostokąt 1 kopia 5", "25 Hudson St", "Prostokąt 1 kopia 5"};
    String mLikes[] = {"12", "234", "34", "435", "867", "87", "233"};
    int mImages[] = {R.drawable.r1, R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7};
//     int mheart[]={R.drawable.ic_favorite_black_24dp};
//     int mlocation[]={R.drawable.ic_location_on_black_24dp};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant__view);
        listView = findViewById(R.id.listview);

        //set up adapter class
        ListViewAdpter adpter = new ListViewAdpter(this, mTitle, mDescription, mLikes, mImages);
        listView.setAdapter(adpter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "Germarcey", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "Blue Hill", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "Le Barnard", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "Jean-Gorges    ", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "The Four Season", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "Ninja New York", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "Estaterioa Milos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    class ListViewAdpter extends ArrayAdapter<String> {

        Context context;
        String mTitle[];
        String mLikes[];
        int mImages[];
        int mheart[];
        int mlocation[];
        String mDescription[];


        public ListViewAdpter(@NonNull Context context, String mTitle[], String mDescription[], String mLikes[], int mImages[]) {
            super(context, R.layout.resturant_row, R.id.title_text, mTitle);
            this.context = context;
            this.mTitle = mTitle;
            this.mDescription = mDescription;
            this.mLikes = mLikes;
            this.mImages = mImages;


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.resturant_row, parent, false);
            ImageView imageView = row.findViewById(R.id.title_img);
            TextView title = row.findViewById(R.id.title_text);
//             ImageView location=row.findViewById(R.id.location);
            TextView location_text = row.findViewById(R.id.location_text);
//             ImageView heart=row.findViewById(R.id.heart);
            TextView heart_text = row.findViewById(R.id.heart_text);

            // Now Setting the Resources and its positions

            imageView.setImageResource(mImages[position]);
            title.setText(mTitle[position]);
            // location.setImageResource(mlocation[position]);
            location_text.setText(mDescription[position]);
            // heart.setImageResource(mheart[position]);
            heart_text.setText(mLikes[position]);

            return row;
        }
    }
}
