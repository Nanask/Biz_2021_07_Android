package com.nana.library.service;

import com.nana.library.config.Naver;

import java.net.URI;
import java.net.URLEncoder;

public class NaverAPIServiceV1 {

    public void getNaverBooks(String search) throws Exception {

        if(search == null) {
            search = "자바";
        }
        // 검색어 문자열을 UTF-8로 encoding하기
        String encSearch = URLEncoder.encode(search,"UTF-8");

        // Naver Open API에 요청할 queryString 만들기
        String queryString = Naver.NAVER_BOOK_URL;
        queryString += "?query=%s";
        queryString += "&display=%d";
        queryString += "&start=%d";

        queryString = String.format(queryString,encSearch,10,1);
        //  여기까지 검색하기 위한 코드 만들기

        // Network 코딩
        // 생성한 queryString 이용하여 Naver에 요청하기 위한 시작

        //URI 객체 만들기
        URI apiURI = new URI(queryString);

        Http
    }


}
