package com.zww.databing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

public class ObservableTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observable_test);
        ObservableInt ob = new ObservableInt(0);
        MutableLiveData<Integer> ob2 = new MutableLiveData<>();
        ob.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.d("Observable","value"+((ObservableInt) sender).get());
            }
        });
        ob2.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.d("onChanged","value"+integer);
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        ob.set(ob.get()+1);  //没有对生命周期进行监听
                        ob2.postValue(ob2.getValue()+1); //存在对生命周期的监听
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        ).start();
    }
}