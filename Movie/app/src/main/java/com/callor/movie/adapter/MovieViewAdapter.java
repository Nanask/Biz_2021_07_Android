package com.callor.movie.adapter;

import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.QuoteSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.movie.databinding.MovieItemViewBinding;
import com.callor.movie.model.NaverMovieDTO;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Spliterator;
import java.util.StringTokenizer;

public class MovieViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NaverMovieDTO> movieDTOList;
//    RatingBar ratingBar;

    public MovieViewAdapter(List<NaverMovieDTO> movieDTOList) {
        this.movieDTOList = movieDTOList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//    LayoutInflater : xml파일을 가져와서 보여주는것?
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MovieItemViewBinding viewBinding = MovieItemViewBinding.inflate(layoutInflater,parent,false);

        return new MovieViewHolder(viewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MovieViewHolder viewHolder = (MovieViewHolder) holder;

        MovieItemViewBinding movieBinding = viewHolder.viewBinding;

        NaverMovieDTO movieDTO = movieDTOList.get(position);



        Spanned movieTitle = Html.fromHtml(movieDTO.getTitle(), Html.FROM_HTML_MODE_LEGACY);
        movieBinding.movieItemTitle.setText(movieTitle);

        String actor = movieDTO.getActor();
        if(actor.length() != 0) {
            actor = String.format("배우 : %s", movieDTO.getActor());
            Spanned movieactor = Html.fromHtml(actor,Html.FROM_HTML_MODE_LEGACY);
            movieBinding.movieItemActor.setText(movieactor);
        }else {
            actor = "배우 없음";
        }

        String director = String.format("감독 : %s", movieDTO.getDirector());
        Spanned moviedirector = Html.fromHtml(director, Html.FROM_HTML_MODE_LEGACY);
        movieBinding.movieItemDirector.setText(moviedirector);

        String pubDate = String.format("제작년도 : %s", movieDTO.getPubDate());
        Spanned moviepubDate = Html.fromHtml(pubDate,Html.FROM_HTML_MODE_LEGACY);
        movieBinding.movieItemPubDate.setText(moviepubDate);


//        float Rating = movieDTO.getUserRating();
        String sRating = String.format("",movieDTO.getUserRating());
        if(sRating != null) {
            sRating = String.format("평점 : %s", movieDTO.getUserRating());
//            Spanned movieuserRating = Html.fromHtml(sRating,Html.FROM_HTML_MODE_LEGACY);
            movieBinding.movieItemUserRating.setText(sRating);
            movieBinding.ratingBar.setRating(movieDTO.getUserRating()/2);
        }else {
            sRating = "평점없음";
            movieBinding.ratingBar.setVisibility(View.GONE);
        }




        if (!movieDTO.getImage().isEmpty()) {
            Picasso.get().load(movieDTO.getImage()).into(movieBinding.movieItemImage);
        }



    }

    @Override
    public int getItemCount() {
        return movieDTOList == null ? 0 : movieDTOList.size();
    }

    // MovieViewHolder 통로 , xml아이디들을 가지고 와서 biding과 연결해주는 통로
    public static class MovieViewHolder extends RecyclerView.ViewHolder {

//        xml에 설정해 놓은 아이디들을 가지고 있음
        public MovieItemViewBinding viewBinding;
//        public ImageView item_image;


        public MovieViewHolder(@NonNull MovieItemViewBinding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;
        }
    }
}
