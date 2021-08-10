package com.nana.libary.service;

import com.nana.libary.model.NaverBookDTO;

public interface NaverBookService {

    public NaverBookDTO getBooks(String search);
}
