package com.nana.movies.adapter;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nana.movies.databinding.MovieItemViewBinding;
import com.nana.movies.model.MovieDTO;

import java.util.List;

public class NaverMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MovieDTO> movieDTOList;

    public NaverMovieAdapter(List<MovieDTO> movieDTOList) {
        this.movieDTOList = movieDTOList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        MovieItemViewBinding movieBiding = MovieItemViewBinding.inflate(layoutInflater,parent,false);
        return new MovieVeiwHolder(movieBiding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MovieVeiwHolder viewHolder = (MovieVeiwHolder) holder;
        MovieDTO movieDTO = movieDTOList.get(position);
        MovieItemViewBinding mBinding = viewHolder.movieBinding;

        Spanned stitle = Html.fromHtml(movieDTO.getTitle(), Html.FROM_HTML_MODE_LEGACY);
        mBinding.movieItemTitle.setText(stitle);

        String strDirect = String.format("<b>감독 : </b>%s", movieDTO.getDirector());
        Spanned sdirect = Html.fromHtml(movieDTO.getDirector(),Html.FROM_HTML_MODE_LEGACY);
        mBinding.movieItemDirect.setText(sdirect);

        String strActor = String.format("<b>출연 : </b>", movieDTO.getActor());
        Spanned sActor = Html.fromHtml(strActor, Html.FROM_HTML_MODE_LEGACY);
        mBinding.movieItemActor.setText(sActor);

        Double intRating = Double.valueOf(movieDTO.getUserRating());
        String strRating = String.format("<b>평점:</b> %3.2f", intRating);
        Spanned sRating = Html.fromHtml(strRating,Html.FROM_HTML_MODE_LEGACY);

        mBinding.movieItemRating.setText(sRating);

        /*
        glide를 사용하여 이미지 링크를 참조하여 이미지 표현하기기
        */
//        movieDTO.getImage
        if(!movieDTO.getImage().isEmpty()) {
            Glide.with(mBinding.movieItemImage.getContext())
                    .load(movieDTO.getImage())
                    .into(mBinding.movieItemImage);

        }

    }

    @Override
    public int getItemCount() {
        return movieDTOList == null ? 0 : movieDTOList.size();
    }

    public static class MovieVeiwHolder extends RecyclerView.ViewHolder{
        public MovieItemViewBinding movieBinding;


        public MovieVeiwHolder(@NonNull MovieItemViewBinding movieBinding) {
            super(movieBinding.getRoot());
            this.movieBinding = movieBinding;
        }
    }
}
