package audiostreamerdemoa.dm.chafe.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import audiostreamerdemoa.dm.chafe.R;
import audiostreamerdemoa.dm.chafe.data.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecyclerViewHolder> {


    private List<Recipe> recipes;

    public RecipeAdapter(List<Recipe> recipes){

        this.recipes = recipes;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_recioe,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.bindRecipe(recipes.get(position));
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView titleTv;
        private TextView descriptionTv;
        private TextView autherTv;
        private RatingBar ratingBar;
        public RecyclerViewHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.iv_recipe);
            titleTv=itemView.findViewById(R.id.tv_recipe_title);
            descriptionTv=itemView.findViewById(R.id.tv_recipe_desc);
            autherTv=itemView.findViewById(R.id.tv_recipe_author);
            ratingBar=itemView.findViewById(R.id.ratingBar_recipe);
        }

        public void bindRecipe(Recipe recipe){
            Picasso.get().load(recipe.getImg()).into(imageView);
            titleTv.setText(recipe.getTitle());
            descriptionTv.setText(recipe.getDesc());
            autherTv.setText("By "+recipe.getBy());
            ratingBar.setRating(recipe.getRate());
        }
    }
}
