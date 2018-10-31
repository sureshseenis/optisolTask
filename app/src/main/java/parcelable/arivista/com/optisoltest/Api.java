package parcelable.arivista.com.optisoltest;



import java.util.List;

import parcelable.arivista.com.optisoltest.holder.List_Holder;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("photos")
    Call<List<List_Holder>> getGetLists();
}