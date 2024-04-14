package com.demo.example;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

class Main {
    public static void main(String[] arg){
        String myname = "Something";

        System.out.println(getReversStr(myname));

        TextView De = null;
        int i = (De.getVisibility()  == View.GONE)?View.VISIBLE:View.GONE;
    }


    private static String getReversStr(String Myname) {
        if(Myname==null){
            throw new IllegalArgumentException("Name is Null");
        }
        char[] arrayMyname = Myname.toCharArray();
        StringBuilder stringBuilder =new StringBuilder();
        for (int i = arrayMyname.length-1; i>=0; i--){
            stringBuilder.append(arrayMyname[i]+"");
        }
        return arrayMyname.toString();
    }
}
//
//public class Main extends AppCompatActivity {
//    private final String TAG = "Main";
//    private final Context mContext = this;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Log.e("MTAG", "onCreate");
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.e("MTAG", "onStart");
//    }
//
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.e("MTAG", "onResume");
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.e("MTAG", "onDestroy");
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.e("MTAG", "onPause");
//
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.e("MTAG", "onStop");
//
//    }
//
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.e("MTAG", "onRestart");
//
//    }
//}