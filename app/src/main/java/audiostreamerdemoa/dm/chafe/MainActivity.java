package audiostreamerdemoa.dm.chafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.android.volley.Response;

import java.util.List;

import audiostreamerdemoa.dm.chafe.Adapters.BannerAdapter;
import audiostreamerdemoa.dm.chafe.Adapters.CategoryAdapter;
import audiostreamerdemoa.dm.chafe.Adapters.RecipeAdapter;
import audiostreamerdemoa.dm.chafe.data.Banner;
import audiostreamerdemoa.dm.chafe.data.Category;
import audiostreamerdemoa.dm.chafe.data.Recipe;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService=new ApiService(MainActivity.this);

        
        setupViews();
    }

    private void setupViews() {
        getBanners();
        getCategories();
        getRecipies();
    }
    private void getRecipies(){
        apiService.getRecipes(new Response.Listener<List<Recipe>>() {
            @Override
            public void onResponse(List<Recipe> recipes) {
                RecyclerView recyclerView=findViewById(R.id.rv_main_recipes);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                recyclerView.setAdapter(new RecipeAdapter(recipes));

//                SnapHelper snapHelper=new PagerSnapHelper();
//                snapHelper.attachToRecyclerView(recipRv);
            }
        });
    }
    private void getCategories(){
        apiService.getCategories(new Response.Listener<List<Category>>() {
            @Override
            public void onResponse(List<Category> categories) {
                RecyclerView categoriesRv=findViewById(R.id.rv_main_categories);
                categoriesRv.setLayoutManager(new LinearLayoutManager(
                        MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                categoriesRv.setAdapter(new CategoryAdapter(categories));
            }
        });
    }
    private void getBanners(){
        apiService.getBanners(new Response.Listener<List<Banner>>() {
            @Override
            public void onResponse(List<Banner> banners) {
                RecyclerView bannerRv=findViewById(R.id.rv_main_slider);
                bannerRv.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                bannerRv.setAdapter(new BannerAdapter(banners));

                SnapHelper snapHelper=new PagerSnapHelper();
                snapHelper.attachToRecyclerView(bannerRv);
            }
        });
    }
}
