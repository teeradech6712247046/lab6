package com.example.lab6;

import java.util.List;

public class ChecklistNote extends Note{
    //Attribute
    private List<String> items;

    //getter method
    private List<String>getItems(){
        return items;
    }

    //setter method
    private void setItems(List<String> newItems){
        this.items = newItems;
    }
    public String  getSummary(){
        // String strItem = //loop for get data from List
        // return title+":"+textContent+"("+createdDate+")";
        return title+":"+"("+createdDate+")";
    }


}
