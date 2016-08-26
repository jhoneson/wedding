package com.example.scxh.webviewapp;

import android.content.Context;
import android.test.AndroidTestCase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by scxh on 2016/7/25.
 */
public class weather extends AndroidTestCase {
    private Context context;
    @Override
    protected void setUp() throws Exception {
       context=getContext();
    }
    public void testGet() throws IOException, JSONException {
        File file=new File("d://weather.txt");
        FileInputStream fis=new FileInputStream(file);
        String text=getFile(fis);

        JSONObject object=new JSONObject(text);
        JSONObject json=object.getJSONObject("weatherinfo");
        String city=json.getString("city");
        int temp=json.getInt("temp");

    }
    public String getFile(FileInputStream is) throws IOException {
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader br=new BufferedReader(isr);
        String line=null;
        StringBuilder builder=null;
        while ((line=br.readLine())!=null){
            builder.append(line);
        }
        br.close();
        isr.close();
        return builder.toString();
    }
}
