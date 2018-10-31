package parcelable.arivista.com.optisoltest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import parcelable.arivista.com.optisoltest.adapter.Adapter_List;
import parcelable.arivista.com.optisoltest.holder.List_Holder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Suresh on 28/06/2018
 */

public class ListViewClass extends Fragment {

    RecyclerView recyclerView;

    Adapter_List adapter_list;

    ArrayList<List_Holder> list_holders;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.tab1, container, false);

        list_holders=new ArrayList<>();

        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter_list=new Adapter_List(list_holders, R.layout.list_image,getContext());
        recyclerView.setAdapter(adapter_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        getGetLists();

        return view;
    }

    private void getGetLists() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<List_Holder>> call = api.getGetLists();

        call.enqueue(new Callback<List<List_Holder>>() {
            @Override
            public void onResponse(Call<List<List_Holder>> call, Response<List<List_Holder>> response) {
                List<List_Holder> heroList = response.body();

                String[] heroes = new String[heroList.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < heroList.size(); i++) {
                    heroes[i] = heroList.get(i).getTitle();
                    list_holders.add(new List_Holder(heroList.get(i).getAlbumId(),heroList.get(i).getId(),heroList.get(i).getUrl(),heroList.get(i).getTitle(),heroList.get(i).getThumbnailUrl()));
                }
               // Toast.makeText(getContext(),heroList.get(0).getTitle(),Toast.LENGTH_LONG).show();


                adapter_list.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<List_Holder>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
