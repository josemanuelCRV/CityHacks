package com.labs.josemanuel.cityhacks.Utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.labs.josemanuel.cityhacks.Model.PropuestasPOJOModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by josem on 25/09/2016.
 */

public class PropuestasUtils {

    public static List<PropuestasPOJOModel> getDataSet(Context context){
        List<PropuestasPOJOModel> dataSet = new ArrayList<>();
        try {
            StringBuilder builder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open("information.json")));
            String line = "";
            //Se lee el archivo JSON
            while ((line=bufferedReader.readLine()) != null){
                builder.append(line);
            }
            bufferedReader.close();
            String json = builder.toString();
            // Se convierte a un JSONArray
            JSONArray jsonArray = new JSONArray(json);
            for (int index = 0; index < jsonArray.length(); index++) {
                PropuestasPOJOModel propuestasPOJO = new PropuestasPOJOModel();
                JSONObject jsonObject = jsonArray.getJSONObject(index);

                propuestasPOJO.setId(jsonObject.getInt("id"));
                propuestasPOJO.setTitulo(jsonObject.getString("titulo"));
                propuestasPOJO.setUbicacion(jsonObject.getString("ubicacion"));
                propuestasPOJO.setDescripcion(jsonObject.getString("descripcion"));
                propuestasPOJO.setFoto(jsonObject.getInt("foto"));
                propuestasPOJO.setFecha(jsonObject.getString("fecha"));
                propuestasPOJO.setCategoria(jsonObject.getString("categoria"));
                propuestasPOJO.setStatus(jsonObject.getString("status"));
                propuestasPOJO.setStatus_flag(jsonObject.getString("status_flag"));
                propuestasPOJO.setFollow(jsonObject.getInt("follow"));
                propuestasPOJO.setRepairit(jsonObject.getInt("repairit"));
                propuestasPOJO.setDetalle(jsonObject.getString("detalle"));
                propuestasPOJO.setImage_paralax(jsonObject.getString("image_paralax"));
                propuestasPOJO.setLat((float)jsonObject.getLong("lat"));
                propuestasPOJO.setLon((float)jsonObject.getLong("lon"));
                propuestasPOJO.setUsername(jsonObject.getString("username"));
                propuestasPOJO.setFotousercomm(jsonObject.getString("fotousercomm"));
                propuestasPOJO.setBodycomment(jsonObject.getString("bodycomment"));

                dataSet.add(propuestasPOJO);
            }
        } catch (IOException ex) {
            Toast.makeText(context, "I/O Error", Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            Log.e(PropuestasUtils.class.getName(), e.getMessage(), e);
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return dataSet;
    }



}
