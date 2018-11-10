package com.example.news.results;

public class ErrorResult extends Result {

    public ErrorResult(String message){
        this.status=0;
        this.message=message;
        this.data=0;
    }

    public ErrorResult(){
        this.status=0;
        this.message="不用慌，问题很大，慌也没用,等死吧告辞";
        this.data=0;
    }
}