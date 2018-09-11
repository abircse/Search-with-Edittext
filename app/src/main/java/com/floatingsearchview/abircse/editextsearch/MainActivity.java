package com.floatingsearchview.abircse.editextsearch;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.SearchView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<String> list;
    ListView listView;
    ArrayAdapter adapter;
    SearchView search;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datasource();

        listView = findViewById(R.id.mylist);
        search = findViewById(R.id.searchedit);
        text = findViewById(R.id.tyr);

        //-------for search using Edit text------//
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {



            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                List<String> templist = new ArrayList<>();
                for (int i = 0; i <list.size(); i++)
                {

                    if (list.get(i).contains(s))
                    {
                        templist.add(list.get(i));
                    }

                    adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,templist);
                    listView.setAdapter(adapter);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        //-------for search using Serach View widget------//
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                List<String> templist = new ArrayList<>();

                for (int i = 0; i <list.size(); i++)
                {

                    if (list.get(i).contains(newText))
                    {
                        templist.add(list.get(i));
                    }

                    adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,templist);
                    listView.setAdapter(adapter);

                }

                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "You Clicked on "+adapter.getItem(position),Toast.LENGTH_LONG).show();
            }
        });

    }

    void datasource()
    {
        list = new ArrayList<>();
        list.add("Abir");
        list.add("Ramim");
        list.add("Saiful");
        list.add("Bappy");
        list.add("Imran");
        list.add("Shanta");
        list.add("Asrafa");
        list.add("Nasrin");

    }
}
