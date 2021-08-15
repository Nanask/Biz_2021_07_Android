package com.callor.movie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.movie.databinding.MovieItemViewBinding;
import com.callor.movie.model.NaverMovieDTO;

import java.util.List;

public class MovieViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NaverMovieDTO> movieDTOList;

    public MovieViewAdapter(List<NaverMovieDTO> movieDTOList) {
        this.movieDTOList = movieDTOList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MovieItemViewBinding viewBinding = MovieItemViewBinding.inflate(layoutInflater,parent,false);

        return movieViewHolder(viewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return movieDTOList == null ? 0 : movieDTOList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        public MovieItemViewBinding viewBinding;

        public NewsViewHolder(@NonNull MovieItemViewBinding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;
        }
    }
}
