package com.niels.geofencing;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.aware.Aware;
import com.aware.Aware_Preferences;
import com.aware.ESM;
import com.google.android.gms.location.Geofence;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by niels on 20/10/15.
 */

public class GeofenceQuestion {

    public static JSONArray esm_queue;
    static boolean ESMOngoing = false;

    private static String location = "Oulu";

    public static JSONObject exampleQuestion() {
        JSONObject jsonObject = new JSONObject();
        try {
            JSONObject q1Body = new JSONObject();
            q1Body.put("esm_type", ESM.TYPE_ESM_QUICK_ANSWERS);
            q1Body.put("esm_title", "Why are you at " + location + "?");
            q1Body.put("esm_instructions", "Please choose below.");
            q1Body.put("esm_quick_answers", new JSONArray().put("One").put("Two"));
            q1Body.put("esm_submit", "Next");
            q1Body.put("esm_expiration_threshold", 300);
            q1Body.put("esm_trigger", "trigger");
            jsonObject.put("esm", q1Body);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static void setQuestion(Context context, Geofence geofence) {
        Log.d("Niels", geofence.toString());

        location = geofence.toString();

        location = geofence.getRequestId();

        if (ESMOngoing == false) {

            esm_queue = new JSONArray();
            esm_queue.put(exampleQuestion());

            Intent questionnaire = new Intent(ESM.ACTION_AWARE_QUEUE_ESM);
            questionnaire.putExtra(ESM.EXTRA_ESM, esm_queue.toString());
            context.sendBroadcast(questionnaire);
        }
    }
}
