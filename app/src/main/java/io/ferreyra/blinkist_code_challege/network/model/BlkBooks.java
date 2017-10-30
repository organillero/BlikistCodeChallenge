package io.ferreyra.blinkist_code_challege.network.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by carlos on 10/30/17.
 */
@AutoValue
public abstract class BlkBooks  implements Parcelable{

    public static TypeAdapter<BlkBooks> typeAdapter(Gson gson) {
        return new $AutoValue_BlkBooks.GsonTypeAdapter(gson);
    }

    public abstract List<BlkBook> books();



}
