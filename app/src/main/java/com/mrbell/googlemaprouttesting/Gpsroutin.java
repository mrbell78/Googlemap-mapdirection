package com.mrbell.googlemaprouttesting;

import android.content.IntentSender;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class Gpsroutin {

    AppCompatActivity ctx;
    final int RC_Settings = 101;
    LocationRequest mLocationreq;
    boolean canGetlocation=false;

    public Gpsroutin(AppCompatActivity context){
        ctx=context;
        lastLocationreq();
    }


    public LocationRequest getmLocationreq(){
        return this.mLocationreq;
    }



    protected void lastLocationreq() {

        this.mLocationreq= new LocationRequest();
        mLocationreq.setInterval(5000);
        mLocationreq.setFastestInterval(2500);
        mLocationreq.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder= new LocationSettingsRequest.Builder()
                .addLocationRequest(mLocationreq);
        SettingsClient client = LocationServices.getSettingsClient(ctx);
        Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());

        task.addOnSuccessListener(onSuccessListenerLocationsettings);
    }

    OnSuccessListener<LocationSettingsResponse> onSuccessListenerLocationsettings= new OnSuccessListener<LocationSettingsResponse>() {
        @Override
        public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
            canGetlocation=true;
        }
    };

    OnFailureListener onFailureListener= new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            if(e instanceof ResolvableApiException){
                try {
                    ((ResolvableApiException)e).startResolutionForResult(ctx,RC_Settings);
                }catch (IntentSender.SendIntentException sendEx){

                }
            }
        }
    };
}
