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

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MovieItemViewBinding viewBinding = MovieItemViewBinding.inflate(layoutInflater,parent,false);

        return new MovieViewHolder(viewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MovieViewHolder viewHolder = (MovieViewHolder) holder;

        MovieItemViewBinding movieBinding = viewHolder.viewBinding;

        NaverMovieDTO movieDTO = movieDTOList.get(position);

//        viewHolder.viewBinding.movieItemTitle.setText(movieDTO.getTitle());

        Spanned movieTitle = Html.fromHtml(movieDTO.getTitle(), Html.FROM_HTML_MODE_LEGACY);
        movieBinding.movieItemTitle.setText(movieTitle);


//        Spannable.setSpan(new QuoteSpan(color), movieDTO.getActor())
        Spanned movieactor = Html.fromHtml(movieDTO.getActor(),Html.FROM_HTML_MODE_COMPACT);
        movieBinding.movieItemActor.setText(movieactor);
//        Spannable movieactor = QuoteSpan
//        movieBinding.movieItemActor.setText(movieactor);
//        Spanned movieactor = Html.fromHtml(movieDTO.getActor(),QuoteSpan);
//        movieBinding.movieItemActor.setText(movieactor);

        Spanned moviepubDate = Html.fromHtml(movieDTO.getPubDate(),Html.FROM_HTML_MODE_LEGACY);
        movieBinding.movieItemPubDate.setText(moviepubDate);


//        Spanned movieuserRating = Html.fromHtml(movieDTO.getUserRating(),Html.FROM_HTML_MODE_LEGACY);
//        movieBinding.movieItemUserRating.setText(movieuserRating);

        if (!movieDTO.getImage().isEmpty()) {
            Picasso.get().load(movieDTO.getImage()).into(movieBinding.movieItemImage);
        }
//        String userRating =

        movieBinding.ratingBar.setRating(movieDTO.getUserRating()/2);



    }

    @Override
    public int getItemCount() {
        return movieDTOList == null ? 0 : movieDTOList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        public MovieItemViewBinding viewBinding;
//        public ImageView item_image;


        public MovieViewHolder(@NonNull MovieItemViewBinding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;
        }
    }
}
