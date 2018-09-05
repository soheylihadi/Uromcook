package audiostreamerdemoa.dm.chafe.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import audiostreamerdemoa.dm.chafe.R;
import audiostreamerdemoa.dm.chafe.data.Banner;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    private List<Banner>banners;
    public BannerAdapter(List<Banner>banners) {
        this.banners=banners;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView imageView=new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        imageView.setAdjustViewBounds(true);
        return new BannerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        holder.bindBanner(banners.get(position));
    }

        @Override
        public int getItemCount() {
            return banners.size();
        }

        public class BannerViewHolder extends RecyclerView.ViewHolder{

            private ImageView bannerImageView;
            public BannerViewHolder(View itemView) {
                super(itemView);
                bannerImageView=(ImageView) itemView;
            }

        public void bindBanner(Banner banner){

            Picasso.get().load(banner.getImg()).into(bannerImageView);
        }
    }
}
