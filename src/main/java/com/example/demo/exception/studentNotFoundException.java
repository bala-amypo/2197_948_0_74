package com.example.demo.exception;
public class studentNotFoundException extends RuntimeException {
     public studentNotFoundException (String errMsg){
         super(errMsg);
     }
}