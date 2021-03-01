package mtj.example.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit=null;
    public static RestApiService getApiService(){
        if(retrofit ==null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl("https://androidwave.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RestApiService.class);
    }

}
