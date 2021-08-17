package com.callor.movies.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.movies.databinding.MovieItemViewBinding;
import com.callor.movies.model.MoviesDTO;

import java.util.List;

public class NaverMoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // 리스트를 보이기 위한 데이터
    private List<MoviesDTO> moviesDTOList;

    public NaverMoviesAdapter(List<MoviesDTO> moviesDTOList) {
        this.moviesDTOList = moviesDTOList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        MovieItemViewBinding movieBinding =
                MovieItemViewBinding.inflate(layoutInflater,parent,false);

        return new NaverMoviesViewHolder(movieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        NaverMoviesViewHolder moviesViewHolder = (NaverMoviesViewHolder) holder;

        MoviesDTO moviesDTO = moviesDTOList.get(position);

        MovieItemViewBinding binding = moviesViewHolder.movieBinding;

        binding.movieItemTitle.setText(moviesDTO.getTitle());
        binding.movieItemDirect.setText(moviesDTO.getDirector());
        binding.movieItemActor.setText(moviesDTO.getActor());

    }

    @Override
    public int getItemCount() {
        return moviesDTOList == null ? 0 : moviesDTOList.size();
    }

    public static class NaverMoviesViewHolder extends RecyclerView.ViewHolder {
        public MovieItemViewBinding movieBinding;

        public NaverMoviesViewHolder(@NonNull MovieItemViewBinding movieBinding) {
            super(movieBinding.getRoot());
            this.movieBinding = movieBinding;

        }
    }
}
