package io.ferreyra.blinkist_code_challege.network;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * Created by carlos on 10/29/17.
 */

@GsonTypeAdapterFactory
public abstract class BlkAdapterAdapter implements TypeAdapterFactory {
    public static TypeAdapterFactory create() {
        return new AutoValueGson_BlkAdapterAdapter();
    }
}
